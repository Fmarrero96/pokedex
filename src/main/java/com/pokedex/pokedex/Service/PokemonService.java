package com.pokedex.pokedex.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokedex.pokedex.Component.PokemonRestClient;
import com.pokedex.pokedex.Model.PokemonDTO;
import com.pokedex.pokedex.Model.PokemonDetailDto;
import com.pokedex.pokedex.Model.Resource.pokemon.Pokemon;
import com.pokedex.pokedex.Model.Resource.pokemon.PokemonAbility;
import com.pokedex.pokedex.Model.Resource.pokemon.PokemonMove;
import com.pokedex.pokedex.Model.Resource.pokemon.PokemonType;
import com.pokedex.pokedex.Model.ResponsePagePokedex;
import com.pokedex.pokedex.Model.ResponsePokedexPokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {
    private static final String POKEMON_API_URL = "https://pokeapi.co/api/v2/pokemon/";
    private static final String POKEMON_SPECIES_API_URL = "https://pokeapi.co/api/v2/pokemon-species/";

    @Autowired
    private final PokemonRestClient pokemonRestClient;

    @Autowired
    public PokemonService(PokemonRestClient pokemonRestClient) {
        this.pokemonRestClient = pokemonRestClient;
    }

    public List<PokemonDTO> getPokemonsDtoForResponsePokedex(ResponsePagePokedex responsePagePokedex) {
        List<PokemonDTO> pokemonDTOS = new ArrayList<>();

        try {
            List<ResponsePokedexPokemon> responsePokedexPokemons = responsePagePokedex.getResults();

            for (ResponsePokedexPokemon pokedexPokemon : responsePokedexPokemons) {
                Pokemon pokemon = pokemonRestClient.fetchDataPokemon(pokedexPokemon.getUrl());
                pokemonDTOS.add(getPokemonDTO(pokemon, getUrlImage(pokedexPokemon.getUrl())));
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
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
    private List<String> getTypesName(Pokemon pokemon) {
        List<PokemonType> pokemonTypes = pokemon.getTypes();
        List<String> nameTypes = new ArrayList<>();
        for (PokemonType tipo : pokemonTypes) {
            nameTypes.add(tipo.getType().getName());
        }
        return nameTypes;
    }

    //se le pasa un Pokemon y devuelve en una lista de string cpm el nombre de sus habilidades
    private List<String> getAbilities(Pokemon pokemon) {
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
    private String getUrlImage(String url) throws JsonProcessingException {
        try {
        String jsonResponse = pokemonRestClient.fetchData(url);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonResponse);
        return rootNode.path("sprites").path("front_default").asText();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw e;
        }
    }


    public PokemonDetailDto getPokemonDtoDetail(PokemonDTO pokemonDto) throws JsonProcessingException {
        //PokemonDetailDto hereda de PokemonDTO osea que tiene sus datos.
        //solamente se va a a agregar Detalle en espaniol y sus movimiento

        PokemonDetailDto pokemonDetailDto = PokemonDetailDto.builder()
                .name(pokemonDto.getName())
                .id(pokemonDto.getId())
                .abilities(pokemonDto.getAbilities())
                .imageUrl(pokemonDto.getImageUrl())
                .type(pokemonDto.getType())
                .weight(pokemonDto.getWeight())
                .description(getDescriptionPokemon(pokemonDto.getId()))
                .moves(getPokemonMove(pokemonDto.getId()))
                .build();

        return pokemonDetailDto;
    }


    private List<String> getPokemonMove(Integer id){
        Pokemon pokemon = pokemonRestClient.fetchDataPokemon(POKEMON_API_URL + id);
        List<PokemonMove> pokemonMoves = pokemon.getMoves();
        List<String> pokemonMove = new ArrayList<>();
        for (PokemonMove move : pokemonMoves) {
            pokemonMove.add(move.getMove().getName());
        }
        return pokemonMove;
    }

    private String getDescriptionPokemon(Integer id) throws JsonProcessingException {
        try {
        String jsonResponse =  pokemonRestClient.fetchData(POKEMON_SPECIES_API_URL + id);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonResponse);
        JsonNode flavorTextEntries = jsonNode.get("flavor_text_entries");
        return findFlavorTextInSpanish(flavorTextEntries);
        } catch (JsonProcessingException e) {
            // Log or handle the exception as needed
            e.printStackTrace();
            return null; // Return a default value or handle the error accordingly
        }
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

