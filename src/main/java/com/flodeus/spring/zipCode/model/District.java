package com.flodeus.spring.zipCode.model;

public class District {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "District{" +
                "name='" + name + '\'' +
                '}';
    }
}
