package com.pokedex.pokedex.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pokedex.pokedex.Exception.PokemonDataNotFoundException;
import com.pokedex.pokedex.Model.PokemonDTO;
import com.pokedex.pokedex.Model.PokemonDetailDto;
import com.pokedex.pokedex.Service.PokemonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador que gestiona las operaciones relacionadas con los Pokemons.
 * Proporciona detalles sobre los Pokemons, incluyendo su descripción y movimientos.
 */
@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    /**
     * Obtiene y retorna detalles mejorados de un Pokemon mediante un objeto PokemonDTO.
     *
     * @param pokemonDto Objeto PokemonDTO que contiene los datos del Pokemon.
     * @return Objeto PokemonDetailDto con información detallada del Pokemon, incluyendo descripción y movimientos.
     * @throws JsonProcessingException Excepción lanzada en caso de error al procesar JSON.
     */
    @Operation(summary = "Retorna detalles mejorados de un Pokemon a partir de un PokemonDTO")
    @PostMapping("/pokemonDetail")
    @ApiResponse(responseCode = "200", description = "Éxito", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PokemonDetailDto.class)))
    @ApiResponse(responseCode = "404", description = "No encontrado")
    @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    public ResponseEntity<?> getPokemonDetailDTO(@RequestBody PokemonDTO pokemonDto) throws JsonProcessingException {
        try {
            PokemonDetailDto pokemonDetailDto = pokemonService.getPokemonDtoDetail(pokemonDto);
            return new ResponseEntity<>(pokemonDetailDto, HttpStatus.OK);
        } catch (PokemonDataNotFoundException e) {
            // Manejar la excepción específica de datos no encontrados
            return new ResponseEntity<>("No se encontraron detalles del Pokémon", HttpStatus.NOT_FOUND);
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

