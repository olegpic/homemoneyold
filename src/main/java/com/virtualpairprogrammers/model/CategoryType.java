package com.virtualpairprogrammers.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "CategoryType")
public class CategoryType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_type_id")
    private long id;

    @Column(name = "category_type_name")
    private String name;

    @Column
    private boolean active;

    public CategoryType() {
    }

    public CategoryType(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    //////////////////////////////
    //
    // Getters and Setters
    //
    //////////////////////////////


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
