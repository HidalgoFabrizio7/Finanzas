package pe.edu.upc.finanzasv3;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinanzasV3Application {
    public static void main(String[] args) {
        SpringApplication.run(FinanzasV3Application.class, args);
    }

}
