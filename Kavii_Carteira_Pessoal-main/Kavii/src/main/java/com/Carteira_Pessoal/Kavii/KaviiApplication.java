package com.Carteira_Pessoal.Kavii;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan(basePackages =  "com.Carteira_Pessoal.Kavii")
@EntityScan(basePackages = {"com.Carteira_Pessoal.Kavii.domains", "com.Carteira_Pessoal.Kavii.domains.enums"})
@EnableJpaRepositories(basePackages =  "com.Carteira_Pessoal.Kavii.repositories")
@SpringBootApplication
public class KaviiApplication {

    public static void main(String[] args) {
        SpringApplication.run(KaviiApplication.class, args);
    }

}
