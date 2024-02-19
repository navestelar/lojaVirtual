package br.com.lojavirtual.ConexaoMYSQL;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:postgresql://172.18.150.143:5432/ecommerce";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "123456";

    private static final HikariConfig config;
    private static final HikariDataSource dataSource;

    static {
        config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USUARIO);
        config.setPassword(SENHA);
        config.setDriverClassName("org.postgresql.Driver");

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(30000);

        dataSource = new HikariDataSource(config);
    }

    public static Connection conectar() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }

    public static void fecharConexao(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao fechar conexão com o banco de dados", e);
            }
        }
    }
}
