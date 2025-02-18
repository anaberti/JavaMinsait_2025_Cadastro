package br.anaberti.cadastro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {
	@Bean
    public OpenAPI customOpenAPI() {        
        return new OpenAPI()
                .components(new Components().addSecuritySchemes("basicScheme",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
                .info(new Info()
                        .title("Cadastro de Contatos")
                        .description("App para cadastro de contatos de pessoas físicas, desenvolvido para o treinamento de Java da Minsait")
                        .contact(new Contact().name("Ana Paula Esteves Berti").email("anapaulaeberti@gmail.com").url("https://github.com/anaberti"))
                        .version("Versão 1.0_2025"));
    }
}