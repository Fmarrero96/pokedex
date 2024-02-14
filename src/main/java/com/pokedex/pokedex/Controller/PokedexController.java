package com.pokedex.pokedex.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pokedex.pokedex.Exception.PokemonDataNotFoundException;
import com.pokedex.pokedex.Model.PokedexDto;
import com.pokedex.pokedex.Model.PokemonDetailDto;
import com.pokedex.pokedex.Service.PokedexService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador que gestiona las operaciones relacionadas con la Pokedex.
 * Permite listar los Pokemons según un offset y un límite especificados.
 */
@RestController
@RequestMapping("/pokedex")
public class PokedexController {

    @Autowired
    private PokedexService pokedexService;

    /**
     * Recupera un objeto PokedexDto que contiene la lista de Pokemons
     * según el offset y el límite especificados.
     *
     * @param offset Valor que indica la posición inicial de la lista.
     * @param limit Valor que determina la cantidad máxima de Pokemons a recuperar.
     * @return Objeto PokedexDto con la lista de Pokemons.
     * @throws JsonProcessingException Excepción lanzada en caso de error al procesar JSON.
     */
    @Operation(summary = "Lista los Pokemons según un offset y un limit que se especifican")
    @GetMapping("/listOf")
    public ResponseEntity<?> getPokedexDTO(@RequestParam(name = "offset") String offset,
                                    @RequestParam(name = "limit") String limit) throws JsonProcessingException {
        try {
            PokedexDto pokedexDto = pokedexService.getPokedexDto(offset, limit);
            return new ResponseEntity<>(pokedexDto, HttpStatus.OK);
        } catch (PokemonDataNotFoundException e) {
            // Manejar la excepción específica de datos no encontrados
            return new ResponseEntity<>("No se encontraron datos de Pokémon", HttpStatus.NOT_FOUND);
        } catch (JsonProcessingException e) {
            // Manejar la excepción de procesamiento JSON
            return new ResponseEntity<>("Error al procesar JSON", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            // Manejar otras excepciones no previstas
            e.printStackTrace();
            return new ResponseEntity<>("Error interno del servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}




