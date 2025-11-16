package pe.edu.upc.vitalia.vitalia_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class VitaliaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(VitaliaBackendApplication.class, args);
	}

}
