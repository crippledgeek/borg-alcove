package se.disabledsecurity.borg.alcove;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BorgAlcoveApplication {

    public static void main(String[] args) {
        SpringApplication.run(BorgAlcoveApplication.class, args);
    }

}
