package br.com.lojavirtual.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class HikariCPConfig {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/?user=root";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    private static final HikariConfig config;
    private static final HikariDataSource dataSource;

    static {
        config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USERNAME);
        config.setPassword(PASSWORD);
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");

        dataSource = new HikariDataSource(config);
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
