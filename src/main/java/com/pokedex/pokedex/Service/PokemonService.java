package com.pokedex.pokedex.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokedex.pokedex.Model.PokemonDTO;
import com.pokedex.pokedex.Model.PokemonDetailDto;
import com.pokedex.pokedex.Model.Resource.FlavorText;
import com.pokedex.pokedex.Model.Resource.pokemon.Pokemon;
import com.pokedex.pokedex.Model.Resource.pokemon.PokemonAbility;
import com.pokedex.pokedex.Model.Resource.pokemon.PokemonMove;
import com.pokedex.pokedex.Model.Resource.pokemon.PokemonType;
import com.pokedex.pokedex.Model.Resource.pokemonspecies.PokemonSpecies;
import com.pokedex.pokedex.Model.ResponsePagePokedex;
import com.pokedex.pokedex.Model.ResponsePokedexPokemon;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {


    public List<PokemonDTO> getPokemonsDtoForResponsePokedex (ResponsePagePokedex responsePagePokedex) throws JsonProcessingException {
        //obtengo los pokemons a listar
        List<ResponsePokedexPokemon> responsePokedexPokemons = responsePagePokedex.getResults();
        RestTemplate response = new RestTemplate();
        //creo el arreglo donde se va a devolver el listado
        List<PokemonDTO> pokemonDTOS = new ArrayList<>();
        //recorro el listado de pokemon y los voy volviendo agregando al listado
        for (ResponsePokedexPokemon pokedexPokemon : responsePokedexPokemons) {
            Pokemon pokemon = response.getForEntity(pokedexPokemon.getUrl(), Pokemon.class).getBody();
            // no me gusta obtener la url de la imagen asi, pero si no me lo trae en null en la Pokemon.class
            //creo el pokemon DTO y lo agrego al listado de pokemons a devolver
            pokemonDTOS.add(getPokemonDTO(pokemon,getUrlImage(pokedexPokemon.getUrl())));
        }
        return pokemonDTOS;
    }


    //Se le pasa un Pokemon,una URL de imagen para formar el PokemonDTO que va a ser lo que se muestre
    public PokemonDTO getPokemonDTO(Pokemon pokemon,String urlImage){
        PokemonDTO pokemonDto = PokemonDTO.builder()
                .id(pokemon.getId())
                .name(pokemon.getName())
                .imageUrl(urlImage)
                .type(getTypesName(pokemon))
                .weight(pokemon.getWeight())
                .abilities(getAbilities(pokemon))
                .build();
        return pokemonDto;
    }

    //se le pasa un Pokemon y devuelve en una lista de string sus tipos
    public List<String> getTypesName(Pokemon pokemon) {
        List<PokemonType> pokemonTypes = pokemon.getTypes();
        List<String> nameTypes = new ArrayList<>();
        for (PokemonType tipo : pokemonTypes) {
            nameTypes.add(tipo.getType().getName());
        }
        return nameTypes;
    }

    //se le pasa un Pokemon y devuelve en una lista de string cpm el nombre de sus habilidades
    public List<String> getAbilities(Pokemon pokemon) {
        List<PokemonAbility> pokemonAbilities = pokemon.getAbilities();
        List<String> nameAbilities = new ArrayList<>();
        for (PokemonAbility ability : pokemonAbilities) {
            nameAbilities.add(ability.getAbility().getName());
        }
        return nameAbilities;
    }


    /*se le pasa una url y obtiene la imagen de frente del pokemon.
    se hace de esta manera ya que cuando obtengo el pokemon deberia
    estar en la clase sprites pero al no definir las subclases no me lo toma
    refactorizar en un futuro!!
    */
    public String getUrlImage(String url) throws JsonProcessingException {
        RestTemplate response = new RestTemplate();
        String jsonResponse = response.getForObject(url, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonResponse);
        return rootNode.path("sprites").path("front_default").asText();
    }


    public PokemonDetailDto getPokemonDtoDetail(PokemonDTO pokemonDto) throws JsonProcessingException {
        //PokemonDetailDto hereda de PokemonDTO osea que tiene sus datos.
        //solamente se va a a agregar Detalle en espaniol y sus movimiento
        RestTemplate response = new RestTemplate();

        PokemonDetailDto pokemonDetailDto = PokemonDetailDto.builder()
                .name(pokemonDto.getName())
                .id(pokemonDto.getId())
                .abilities(pokemonDto.getAbilities())
                .imageUrl(pokemonDto.getImageUrl())
                .type(pokemonDto.getType())
                .weight(pokemonDto.getWeight())
                .description(getDescriptionPokemon(response,pokemonDto.getId()))
                .moves(getPokemonMove(response,pokemonDto.getId()))
                .build();

        return pokemonDetailDto;
    }


    private List<String> getPokemonMove(RestTemplate response,Integer id){
        Pokemon pokemon = response.getForEntity("https://pokeapi.co/api/v2/pokemon/" + id, Pokemon.class).getBody();
        List<PokemonMove> pokemonMoves = pokemon.getMoves();
        List<String> pokemonMove = new ArrayList<>();
        for (PokemonMove move : pokemonMoves) {
            pokemonMove.add(move.getMove().getName());
        }
        return pokemonMove;
    }

    private String getDescriptionPokemon(RestTemplate response,Integer id) throws JsonProcessingException {
        String jsonResponse = response.getForObject("https://pokeapi.co/api/v2/pokemon-species/" + id, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonResponse);
        JsonNode flavorTextEntries = jsonNode.get("flavor_text_entries");
        return findFlavorTextInSpanish(flavorTextEntries);
    }

    private static String findFlavorTextInSpanish(JsonNode flavorTextEntries) {
        for (JsonNode entry : flavorTextEntries) {
            JsonNode language = entry.path("language");
            if (language.isObject() && "es".equals(language.path("name").asText())) {
                return entry.path("flavor_text").asText();
            }
        }
        return null; // Si no se encuentra ningún flavor_text en español
    }
}

