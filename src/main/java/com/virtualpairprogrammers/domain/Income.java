package com.virtualpairprogrammers.domain;

public class Income {
    private int id;
    private String name;
    private String description;
    private Currency currency;
    private double amount;

	public Income(int id, String name, String description, Currency currency, double amount) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.currency = currency;
		this.amount = amount;
	}

	public Income() {
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String toString() {
        return (this.name + " (" + this.amount + ")");
    }
}
