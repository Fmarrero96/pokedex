package com.pokedex.pokedex.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        List<Server> servers = new ArrayList<Server>();
        servers.add(new Server().url("https://pokedexchallengee.fly.dev/").description("Produccion Server"));
        servers.add(new Server().url("http://localhost:8080").description("Local Development Server"));
        return new OpenAPI()
                .servers(
                        servers
                );
    }
}