package com.virtualpairprogrammers.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "Outcome")
public class Outcome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "outcome_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "importance_id")
    private Importance importance;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "outcome_amount")
    private double amount;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @Column
    private boolean active;

    public Outcome() {
    }

    public Outcome(Importance importance, Category category, double amount, Currency currency, boolean active) {
        this.importance = importance;
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


    public long getId() {
        return id;
    }

    public Importance getImportance() {
        return importance;
    }

    public void setImportance(Importance importance) {
        this.importance = importance;
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
