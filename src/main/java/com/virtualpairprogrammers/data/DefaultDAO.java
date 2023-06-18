package com.virtualpairprogrammers.data;

import com.virtualpairprogrammers.model.Currency;
import com.virtualpairprogrammers.model.Importance;
import com.virtualpairprogrammers.model.Income;
import com.virtualpairprogrammers.model.Outcome;

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

    public List<Income> findAllIncomes() {
        List<Income> incomes = null;
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet results = statement.executeQuery("SELECT * FROM incomes");
        ) {
            incomes = buildIncomesFromResulSet(results);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return incomes;
    }

    public List<Outcome> findAllOutcomes() {
        List<Outcome> outcomes = null;
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet results = statement.executeQuery("SELECT * FROM outcomes");
        ) {
            outcomes = buildOutcomesFromResultSet(results);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return outcomes;
    }

    public void saveIncome(Income income) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "" +
                    "INSERT INTO incomes (id, name, description, currency, amount) " +
                    "VALUES (?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, income.getId());
            preparedStatement.setString(2, income.getName());
            preparedStatement.setString(3, income.getDescription());
            preparedStatement.setString(4, income.getCurrency().toString());
            preparedStatement.setDouble(5, income.getAmount());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveOutcome(Outcome outcome) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "" +
                    "INSERT INTO outcomes (id, name, description, currency, importance, amount) " +
                    "VALUES (?,?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, outcome.getId());
            preparedStatement.setString(2, outcome.getName());
            preparedStatement.setString(3, outcome.getDescription());
            preparedStatement.setString(4, outcome.getCurrency().toString());
            preparedStatement.setString(5, outcome.getImportance().toString());
            preparedStatement.setDouble(6, outcome.getAmount());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateIncome(Income income) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "" +
                    "UPDATE incomes " +
                    "SET name = ?, description = ?, currency = ?, amount = ? " +
                    "WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, income.getName());
            preparedStatement.setString(2, income.getDescription());
            preparedStatement.setString(3, income.getCurrency().name());
            preparedStatement.setDouble(4, income.getAmount());
            preparedStatement.setInt(5, income.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateOutcome(Outcome outcome) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "" +
                    "UPDATE outcomes " +
                    "SET name = ?, description = ?, currency = ?, importance = ?, amount = ? " +
                    "WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, outcome.getName());
            preparedStatement.setString(2, outcome.getDescription());
            preparedStatement.setString(3, outcome.getCurrency().name());
            preparedStatement.setString(4, outcome.getImportance().name());
            preparedStatement.setDouble(5, outcome.getAmount());
            preparedStatement.setInt(6, outcome.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Income> buildIncomesFromResulSet(ResultSet results) throws SQLException {
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

    private List<Outcome> buildOutcomesFromResultSet(ResultSet results) throws SQLException {
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
