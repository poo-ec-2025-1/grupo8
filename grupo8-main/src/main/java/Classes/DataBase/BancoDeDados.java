package Classes.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

    public class BancoDeDados {

        private static final String URL = "jdbc:sqlite:banco.db";

        public static void criarTabelaUsuarios() throws SQLException {
            try (Connection conn = DriverManager.getConnection(URL)) {
                String sql = """
                CREATE TABLE IF NOT EXISTS usuarios (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nome TEXT NOT NULL,
                    cpf TEXT NOT NULL,
                    senha TEXT NOT NULL,
                    nascimento TEXT
                );
            """;
                conn.createStatement().execute(sql);
            }
        }

        public static void salvarUsuario(String nome, String cpf, String senha, String nascimento) throws SQLException {
            try (Connection conn = DriverManager.getConnection(URL)) {
                String sql = "INSERT INTO usuarios (nome, cpf, senha, nascimento) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, nome);
                pstmt.setString(2, cpf);
                pstmt.setString(3, senha);
                pstmt.setString(4, nascimento);
                pstmt.executeUpdate();
            }
        }
    }

