package org.example.badminton.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile({"default"})
@RequiredArgsConstructor
public class OpenAPIConfig {
    @Value("${openapi.url.local-url}")
    private String localUrl;

    @Value("${openapi.info.title}")
    private String infoTitle;

    @Value("${openapi.info.version}")
    private String infoVersion;

    @Value("${openapi.info.description}")
    private String infoDescription;

    @Value("${openapi.license.name}")
    private String licenseName;

    @Value("${openapi.license.url}")
    private String licenseUrl;

    @Bean
    public OpenAPI swaggerOpenAPI() {
        Server localServer = new Server();
        localServer.setUrl(localUrl);
        localServer.setDescription(" Local environment");

        return new OpenAPI()
                .info(new Info().title(infoTitle)
                        .description(infoDescription)
                        .version(infoVersion)
                        .license(new License().name(licenseName).url(licenseUrl)))
                .externalDocs(new ExternalDocumentation()
                        .description("Developer Portal Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"))
                .servers(List.of(localServer));
    }
}