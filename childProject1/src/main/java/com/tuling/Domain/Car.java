package com.tuling.Domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Car implements Serializable {
    private String colour;
    private String brand;

    public Car(String colour, String brand) {
        this.colour = colour;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "colour='" + colour + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
