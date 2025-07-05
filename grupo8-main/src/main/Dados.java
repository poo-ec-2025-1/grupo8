//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Classes;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Dados {
    @FXML
    private TextField CampoNome;
    @FXML
    private TextField CampoSenha;
    @FXML
    private TextField CampoCpf;
    @FXML
    private DatePicker CampoDatanasc;

    @FXML
    public void ConferirDados() {
        String nome = this.CampoNome.getText();
        String senha = this.CampoSenha.getText();
        String cpf = this.CampoCpf.getText();
        LocalDate data = (LocalDate)this.CampoDatanasc.getValue();

        try {
            if (nome.isEmpty() || senha.isEmpty() || cpf.isEmpty() || data == null) {
                throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
            }

            if (senha.length() < 8) {
                throw new IllegalArgumentException("Digite uma senha de ao menos 8 caracteres.");
            }

            LocalDate dataMinima = LocalDate.now().minusYears(18L);
            LocalDate dataMaxima = LocalDate.of(1925, 6, 30);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String datanasc = data.format(formatter);
            Clientes cliente = new Clientes(nome, datanasc, cpf, "Cliente", senha);
            String url = "jdbc:sqlite:BancoDeDados.db";
            ConnectionSource connectionSource = new JdbcConnectionSource(url);
            Dao<Clientes, String> clienteDao = DaoManager.createDao(connectionSource, Clientes.class);
            clienteDao.create(cliente);
            connectionSource.close();
            cliente.cadastrarCliente();
            Stage janelaAtual = (Stage)this.CampoNome.getScene().getWindow();
            janelaAtual.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/view/TelaPrincipal.fxml"));
            Parent logar = (Parent)fxmlLoader.load();
            Stage novaJanela = new Stage();
            novaJanela.setTitle("SpaFy");
            novaJanela.setScene(new Scene(logar));
            novaJanela.show();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao processar: " + e.getMessage());
        }

    }

    @FXML
    public void conferirAcesso() {
        String senha = this.CampoSenha.getText();
        String cpf = this.CampoCpf.getText();

        try {
            if (senha.isEmpty() || cpf.isEmpty()) {
                throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
            }

            if (senha.length() < 8) {
                throw new IllegalArgumentException("Formato da senha incorreto");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao processar: " + e.getMessage());
        }

        String url = "jdbc:sqlite:BancoDeDados.db";
        String sql = "SELECT * FROM Clientes WHERE cpf = ? AND senha = ?";

        try (
            Connection conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, cpf);
            pstmt.setString(2, senha);
            ResultSet rs = pstmt.executeQuery();
            Alert alerta = new Alert(AlertType.INFORMATION);
            alerta.setTitle("Login");
            alerta.setHeaderText((String)null);
            alerta.setContentText("Login bem-sucedido!");
            alerta.showAndWait();
            System.out.println("Acessando Conta...");
            Stage janelaAtual = (Stage)this.CampoCpf.getScene().getWindow();
            janelaAtual.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/view/App.fxml"));
            Parent logar = (Parent)fxmlLoader.load();
            Stage novaJanela = new Stage();
            novaJanela.setTitle("SpaFy");
            novaJanela.setScene(new Scene(logar));
            novaJanela.show();
        } catch (SQLException e) {
            System.out.println("Erro ao verificar login: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
