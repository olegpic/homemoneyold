package com.virtualpairprogrammers.data;

import com.virtualpairprogrammers.domain.Currency;
import com.virtualpairprogrammers.domain.Importance;
import com.virtualpairprogrammers.domain.Income;
import com.virtualpairprogrammers.domain.Outcome;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultDAO {

    private static final String JDBC_URL = "jdbc:h2:~/homemoneyold";
    private static final String JDBC_USER = "";
    private static final String JDBC_PASSWORD = "";
    public DefaultDAO() {
        DatabaseBootstrap bootstrap = new DatabaseBootstrap();
        bootstrap.initializeDatabase();
    }

    public List<Income> getIncomes() {
        List<Income> incomes = null;
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet results = statement.executeQuery("SELECT * FROM incomes");
        ) {
            incomes = buildIncomes(results);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return incomes;
    }

    public List<Outcome> getOutcomes() {
        List<Outcome> outcomes = null;
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet results = statement.executeQuery("SELECT * FROM outcomes");
        ) {
            outcomes = buildOutcomes(results);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return outcomes;
    }

    public void addIncome(Income income){
        DatabaseBootstrap bootstrap = new DatabaseBootstrap();
        bootstrap.addIncome(income);
    }

    private List<Income> buildIncomes(ResultSet results) throws SQLException {
        List<Income> incomes = new ArrayList<>();
        while (results.next()) {
            Income income = new Income();
            income.setId(results.getInt("id"));
            income.setName(results.getString("name"));
            income.setDescription(results.getString("description"));
            income.setCurrency(Currency.valueOf(results.getString("currency")));
            income.setAmount(results.getDouble("amount"));
            incomes.add(income);
        }
        return incomes;
    }

    private List<Outcome> buildOutcomes(ResultSet results) throws SQLException {
        List<Outcome> outcomes = new ArrayList<>();
        while (results.next()) {
            Outcome outcome = new Outcome();
            outcome.setId(results.getInt("id"));
            outcome.setName(results.getString("name"));
            outcome.setDescription(results.getString("description"));
            outcome.setCurrency(Currency.valueOf(results.getString("currency")));
            outcome.setImportance(Importance.valueOf(results.getString("importance")));
            outcome.setAmount(results.getDouble("amount"));
            outcomes.add(outcome);
        }
        return outcomes;
    }
}
