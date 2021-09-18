package org.example.testjavaee.dao.implementation;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

public class DataSourceContainer {
    private final DataSource dataSource;

    public static DataSourceContainer INSTANCE = new DataSourceContainer();


    public DataSourceContainer() {
        //"C:/Users/Admin/Desktop/projects/org.example.testjavaee/1.properties"




        Properties sprop = new Properties();

        try {
            sprop.load((DataSourceContainer.class.getClassLoader()
                    .getResourceAsStream("1.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(sprop.getProperty("url"));
        config.setUsername(sprop.getProperty("user"));
        config.setPassword(sprop.getProperty("password"));
        config.setDriverClassName(sprop.getProperty("driver"));
        config.setMinimumIdle(2);
        config.setMaximumPoolSize(5);

        dataSource = new HikariDataSource(config);
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}
