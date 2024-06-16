package pe.edu.upc.finanzasv3;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SecurityScheme(name = "Bearer Authentication", type = SecuritySchemeType.APIKEY, bearerFormat = "JWT", scheme = "bearer")
public class FinanzasV3Application {

    public static void main(String[] args) {
        SpringApplication.run(FinanzasV3Application.class, args);
    }

}
