package com.virtualpairprogrammers.model;

import javax.persistence.*;

@Entity
@Table(name = "Income")
public class IncomeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "income_id")
    private int id;

    @Column(name = "category_id")
    private String category;

    @Column(name = "amount")
    private double amount;

    @Column(name = "currency_id")
    private Currency currency;

    @Column(name = "active")
    private boolean active;

    public IncomeEntity() {
    }

    public IncomeEntity(String category, double amount, Currency currency, boolean active) {
        this.category = category;
        this.amount = amount;
        this.currency = currency;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
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
