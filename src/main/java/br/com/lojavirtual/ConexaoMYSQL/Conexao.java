package br.com.lojavirtual.ConexaoMYSQL;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Conexao {

    private static Conexao instance;
    private final HikariDataSource dataSource;

    private Conexao() throws SQLException {
        String url = "jdbc:postgresql://172.18.150.143:5432/ecommerce";
        String user = "postgres";
        String password = "123456";

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(password);
        config.setDriverClassName("org.postgresql.Driver");

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(30000);

        dataSource = new HikariDataSource(config);
    }

    public static synchronized Conexao getInstance() throws SQLException {
        if (instance == null) {
            instance = new Conexao();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void closeDataSource() throws SQLException {
        if (instance != null) {
            instance.dataSource.close();
        }
    }
}
