package org.example.testjavaee.dao.implementation;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class DataSourceContainer {
    private final DataSource dataSource;

    public static DataSourceContainer INSTANCE = new DataSourceContainer();


    public DataSourceContainer()  {

        String url = "jdbc:postgresql://localhost:5432/bank";
        String user = "postgres";
        String password = "";

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(password);
        config.setDriverClassName("org.postgresql.Driver");
        config.setMinimumIdle(2);
        config.setMaximumPoolSize(5);

        dataSource = new HikariDataSource(config);
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}
