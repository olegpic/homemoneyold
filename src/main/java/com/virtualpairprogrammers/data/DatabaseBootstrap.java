package com.virtualpairprogrammers.data;

import com.virtualpairprogrammers.domain.Importance;
import com.virtualpairprogrammers.domain.Currency;
import com.virtualpairprogrammers.domain.Income;
import com.virtualpairprogrammers.domain.Outcome;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseBootstrap {

    private List<Income> getIncomes() {
        int id = 1;

        List<Income> incomes = new ArrayList<>();
        incomes.add(new Income(id++, "Salary", "", Currency.USD, 1200));
        incomes.add(new Income(id, "Advance", "", Currency.USD, 300));
        return incomes;
    }

    private List<Outcome> getOutcomes() {
        int id = 1;

        List<Outcome> outcomes = new ArrayList<>();
        outcomes.add(new Outcome(id++, "Medical", "", Currency.USD, Importance.HIGH, 8.01));
        outcomes.add(new Outcome(id++, "Services", "", Currency.USD, Importance.HIGH, 0.0));
        outcomes.add(new Outcome(id++, "Education", "", Currency.USD, Importance.HIGH, 38.96));
        outcomes.add(new Outcome(id++, "Transport", "", Currency.USD, Importance.HIGH, 0.0));
        outcomes.add(new Outcome(id++, "Trust", "", Currency.USD, Importance.HIGH, 2.54));
        outcomes.add(new Outcome(id++, "Fee", "", Currency.USD, Importance.HIGH, 6));

        outcomes.add(new Outcome(id++, "Groceries", "", Currency.USD, Importance.NORMAL, 312.95));
        outcomes.add(new Outcome(id++, "Home", "", Currency.USD, Importance.NORMAL, 6.32));
        outcomes.add(new Outcome(id++, "Sport", "", Currency.USD, Importance.NORMAL, 62.96));
        outcomes.add(new Outcome(id++, "Shopping", "", Currency.USD, Importance.NORMAL, 22.09));
        outcomes.add(new Outcome(id++, "Presents", "", Currency.USD, Importance.NORMAL, 102.04));
        outcomes.add(new Outcome(id++, "Taxi", "", Currency.USD, Importance.NORMAL, 3.57));

        outcomes.add(new Outcome(id++, "Entertaimant", "", Currency.USD, Importance.LOW, 12.32));
        outcomes.add(new Outcome(id++, "Eating out", "", Currency.USD, Importance.LOW, 210.68));
        outcomes.add(new Outcome(id++, "Delivery", "", Currency.USD, Importance.LOW, 291.69));
        outcomes.add(new Outcome(id, "Travel", "", Currency.USD, Importance.LOW, 71.94));
        return outcomes;
    }

    public void initializeDatabase() {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/homemoneyold", "", "")) {

            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "DROP TABLE IF EXISTS incomes;"
            )) {
                preparedStatement.execute();
            }

            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "DROP TABLE IF EXISTS outcomes;"
            )) {
                preparedStatement.execute();
            }

            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "CREATE TABLE incomes (id int primary key, name varchar(30), description varchar(150), currency varchar(30), amount float);"
            )) {
                preparedStatement.execute();
            }

            List<Income> incomes = getIncomes();
            for (Income income : incomes) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO incomes (id, name, description, currency, amount) values (?,?,?,?,?);"
                )) {
                    preparedStatement.setInt(1, income.getId());
                    preparedStatement.setString(2, income.getName());
                    preparedStatement.setString(3, income.getDescription());
                    preparedStatement.setString(4, income.getCurrency().toString());
                    preparedStatement.setDouble(5, income.getAmount());
                    preparedStatement.execute();
                }
            }

            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "CREATE TABLE outcomes (id int primary key, name varchar(30), description varchar(150), currency varchar(30), importance varchar(30), amount float);"
            )) {
                preparedStatement.execute();
            }

            List<Outcome> outcomes = getOutcomes();
            for (Outcome outcome : outcomes) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO outcomes (id, name, description, currency, importance, amount) values (?,?,?,?,?,?);"
                )) {
                    preparedStatement.setInt(1, outcome.getId());
                    preparedStatement.setString(2, outcome.getName());
                    preparedStatement.setString(3, outcome.getDescription());
                    preparedStatement.setString(4, outcome.getCurrency().toString());
                    preparedStatement.setString(5, outcome.getImportance().toString());
                    preparedStatement.setDouble(6, outcome.getAmount());
                    preparedStatement.execute();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
