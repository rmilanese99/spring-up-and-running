package it.unimol.spring.up;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car {

    private String make;
    private String model;

    private String trim;

    private Fuel fuel;

    private int displacement;
    private int hp;
}
