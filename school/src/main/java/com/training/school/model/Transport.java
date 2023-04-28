package com.training.school.model;

import javax.persistence.Entity;

@Entity
public class Transport {
    private  long id;
    private String name;

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Transport(){

    }

    public Transport(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
