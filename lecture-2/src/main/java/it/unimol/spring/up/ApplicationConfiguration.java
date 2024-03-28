package it.unimol.spring.up;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public Parrot polly() {
        Parrot p = new Parrot();

        p.setName("Polly");

        return p;
    }

    @Bean
    public Parrot pelly() {
        Parrot p = new Parrot();

        p.setName("Pelly");

        return p;
    }

    @Bean
    public Person yanni(@Qualifier("polly") Parrot parrot) {
        Person p = new Person();

        p.setName("Yanni");
        p.setParrot(parrot);

        return p;
    }
}
