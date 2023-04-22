package com.virtualpairprogrammers.domain;

public class Outcome {
    private int id;
    private String name;
    private String description;
    private Currency currency;
    private Importance importance;
    private double amount;

	public Outcome(int id, String name, String description, Currency currency, Importance importance, double amount) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.importance = importance;
		this.currency = currency;
		this.amount = amount;
	}

	public Outcome() {
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

	public Importance getCategory() {
		return importance;
	}

	public void setCategory(Importance importance) {
		this.importance = importance;
	}

	public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Importance getImportance() {
        return importance;
    }

    public void setImportance(Importance importance) {
        this.importance = importance;
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
