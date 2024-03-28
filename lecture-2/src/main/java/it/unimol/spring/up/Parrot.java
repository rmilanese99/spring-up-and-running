package it.unimol.spring.up;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Parrot {

    private String name;

    public void speak() {
        System.out.println("Hello, my name is " + name + " !");
    }
}
