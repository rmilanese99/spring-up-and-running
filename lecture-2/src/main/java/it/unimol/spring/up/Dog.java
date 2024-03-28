package it.unimol.spring.up;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Dog {

    // @Autowired here is optional, as there is only one constructor
    public Dog(@Qualifier("pelly") Parrot friend) {
        this.friend = friend;
    }

    private String name;

    private Parrot friend;

    public void bark() {
        System.out.println("Woof woof!");
    }

    @PostConstruct
    public void init() {
        this.name = "Link";

        System.out.println(this.name + " is ready to bark!");
    }
}
