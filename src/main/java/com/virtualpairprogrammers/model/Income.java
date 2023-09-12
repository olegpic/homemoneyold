package com.virtualpairprogrammers.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Income")
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "income_id")
    private int id;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "income_amount")
    private double amount;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @Column
    private boolean active;

    public Income() {
    }

    public Income(Category category, double amount, Currency currency, boolean active) {
        this.category = category;
        this.amount = amount;
        this.currency = currency;
        this.active = active;
    }

    //////////////////////////////
    //
    // Getters and Setters
    //
    //////////////////////////////

    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}