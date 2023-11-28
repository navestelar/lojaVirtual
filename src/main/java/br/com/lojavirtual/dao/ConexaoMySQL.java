package br.com.lojavirtual.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConexaoMySQL {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/lojavirtual";
    private static final String USUARIO = "root";
    private static final String SENHA = "123456";

    private static final HikariConfig config;
    private static final HikariDataSource dataSource;

    static {
        config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USUARIO);
        config.setPassword(SENHA);
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");

        // Configurações do HikariCP
        config.setMaximumPoolSize(10); // Número máximo de conexões no pool
        config.setMinimumIdle(5); // Número mínimo de conexões ociosas no pool
        config.setIdleTimeout(30000); // Tempo máximo de inatividade em milissegundos

        // Configurações adicionais do HikariCP, se necessário
        // config.addDataSourceProperty("cachePrepStmts", "true");
        // config.addDataSourceProperty("prepStmtCacheSize", "250");
        // ...

        dataSource = new HikariDataSource(config);
    }

    public static Connection conectar() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            // Trate a exceção de forma adequada, como imprimir um log ou relançar uma exceção personalizada.
            e.printStackTrace();
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }
}
