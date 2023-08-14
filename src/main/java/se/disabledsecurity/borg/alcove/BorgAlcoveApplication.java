package se.disabledsecurity.borg.alcove;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.blockhound.BlockHound;

@SpringBootApplication
public class BorgAlcoveApplication {

    public static void main(String[] args) {
        BlockHound.install();
        SpringApplication.run(BorgAlcoveApplication.class, args);
    }

}
