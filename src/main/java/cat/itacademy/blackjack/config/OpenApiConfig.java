package cat.itacademy.blackjack.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI blackjackOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Blackjack API")
                        .description("API to manage Blackjack games using MongoDB and MySQL")
                        .version("1.0.0"));
    }
}
