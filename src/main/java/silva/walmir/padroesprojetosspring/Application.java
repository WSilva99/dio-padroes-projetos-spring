package silva.walmir.padroesprojetosspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Projeto Spring Boot gerado com Spring Initializr
 * Dependencias:
 * - Spring Wed
 * - Spring Data JPA
 * - H2
 * - OpenFeign
 *
 * @author Walmir Silva
 */

@EnableFeignClients
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
