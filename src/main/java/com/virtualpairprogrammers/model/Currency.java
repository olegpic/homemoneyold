package com.virtualpairprogrammers.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Currency")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "currency_id")
    private long id;

    @Column(name = "currency_name")
    private String name;

    @Column(name = "currency_symbol")
    private String symbol;

    private boolean active;

    public Currency() {
    }

    public Currency(String name, String symbol, boolean active) {
        this.name = name;
        this.symbol = symbol;
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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
