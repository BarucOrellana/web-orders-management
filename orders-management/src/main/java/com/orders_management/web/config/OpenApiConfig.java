package com.orders_management.web.config;

/*import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {
        @Bean
        GroupedOpenApi publicApi(){
                return GroupedOpenApi.builder().group("public-apis").pathsToMatch("/**").build();
        }

        @Bean
        OpenAPI customOpenApi(){
                return new OpenAPI().info(new Info().title("Orders-Management").version("1.0.0"))
                        .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                        .components(new Components().addSecuritySchemes("bearerAuth", new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
        }
}*/
