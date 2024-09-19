package com.example.demo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Stanislav Chernev",
                        email = "maskata1994@gmail.com",
                        url = "https://github.com/sanito94"
                ),
                description = "User Management Application",
                title = "User Management Application",
                version = "1.0.0"
        ),
        servers = @Server(
                description = "Localhost",
                url = "http://localhost:9090"
        )
)
public class OpenApiConfig {
}
