package com.flodeus.spring.zipCode.model;

public class State {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                '}';
    }
}
