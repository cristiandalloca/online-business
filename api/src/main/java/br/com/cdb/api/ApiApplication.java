package br.com.cdb.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.TimeZone;

@SpringBootApplication(scanBasePackages = "br.com.cdb")
@EnableJpaRepositories(basePackages = "br.com.cdb")
@EntityScan(basePackages = "br.com.cdb")
@EnableJpaAuditing
public class ApiApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(ApiApplication.class, args);
    }

}
