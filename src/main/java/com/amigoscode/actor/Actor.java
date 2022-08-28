package com.amigoscode.actor;

public record Actor(Integer id, String name) {
    public Actor(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Integer id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }
}
