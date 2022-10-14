package itmo.soa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication //exclude = {DataSourceAutoConfiguration.class }
@EnableJpaRepositories
public class SoaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SoaApplication.class, args);

    }



}
