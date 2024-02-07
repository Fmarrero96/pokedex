package com.pokedex.pokedex.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class PokedexService {

    public String getPokemonPaginator(){
        RestTemplate plantilla = new RestTemplate();
        String nextUrl = new String();
        ResponseEntity<String> response= plantilla.getForEntity("https://pokeapi.co/api/v2/pokemon/?offset=0&limit=10", String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                JsonNode jsonResponse = objectMapper.readTree(response.getBody());

                // Acceder a la propiedad 'next' en el objeto JsonNode
                nextUrl = jsonResponse.get("next").asText();
                return(nextUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            return("Error al llamar a la API. Código de estado: " + response.getStatusCodeValue());
        }
        return nextUrl;
    }
}
