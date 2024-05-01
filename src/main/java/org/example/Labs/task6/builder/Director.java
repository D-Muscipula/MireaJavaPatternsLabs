package org.example.Labs.task6.builder;

public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product construct() {
        return builder.getResult();
    }
}
