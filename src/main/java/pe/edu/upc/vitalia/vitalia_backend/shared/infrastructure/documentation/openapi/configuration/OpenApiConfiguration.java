package pe.edu.upc.vitalia.vitalia_backend.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI vitaliaOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Vitalia API")
                        .description("""
                                Plataforma open source orientada al cuidado integral 
                                de adultos mayores y la comunicación con sus familias.
                                
                                Proyecto académico desarrollado por estudiantes UPC.
                                """)
                        .version("v1.0.0")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("""
                               
                                [Repositorio del reporte](https://github.com/EternaCare-OpenSource/report.git)

                                """)
                        .url("https://github.com/EternaCare-OpenSource"));
    }
}
