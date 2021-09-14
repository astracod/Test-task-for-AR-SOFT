package org.example.testjavaee.dao.implementation;

import org.example.testjavaee.entities.Payment;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Date;
import java.util.Optional;

public class PaymentsDaoImpl {
    private DataSource dataSource = DataSourceContainer.INSTANCE.getDataSource();

    public void add(Payment p) {

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO payments (name , supply_date , state , part , value) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1, p.getName());
            preparedStatement.setTimestamp(2, Optional.of(p)
                    .map(Payment::getSupplyDate)
                    .map(Date::getTime)
                    .map(Timestamp::new)
                    .orElse(null)
            );
            preparedStatement.setBoolean(3, p.getState());
            preparedStatement.setString(4, p.getPart().toString());
            preparedStatement.setLong(5, p.getValue());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Long getBalance() {
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT " +
                    "SUM(CASE part WHEN 'к' THEN  -\"value\" ELSE \"value\" END )" +
                    "FROM payments");
            if (rs.next()) return rs.getLong(1);
            return 0L;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0L;
        }
    }

    public Long getSumNalog() {
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT SUM(value) FROM payments WHERE state");
            if (rs.next()) return rs.getLong(1);
            return 0L;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0L;
        }
    }

}















