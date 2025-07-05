package Classes;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.Main;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.EventObject;

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
    public void ConferirDados(){

        String nome = CampoNome.getText();
        String senha = CampoSenha.getText();
        String cpf = CampoCpf.getText();
        LocalDate data = CampoDatanasc.getValue();

        try{


            if (nome.isEmpty() || senha.isEmpty() || cpf.isEmpty() || data == null) {
                throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
            }
            if(senha.length() < 8) {
                throw new IllegalArgumentException("Digite uma senha de ao menos 8 caracteres.");
            }


            LocalDate dataMinima = LocalDate.now().minusYears(18);  //Parte para conferir se o usuário terá ao menos 18 anos
            LocalDate dataMaxima = LocalDate.of(1925, 6, 30); //Idade máxima

            //Converter a data para string
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String datanasc = data.format(formatter);


            Clientes cliente = new Clientes(nome, datanasc, cpf, "Cliente", senha);

            // SALVAR NO BANCO COM ORMlite
            String url = "jdbc:sqlite:BancoDeDados.db";
            ConnectionSource connectionSource = new JdbcConnectionSource(url);
            Dao<Clientes, String> clienteDao = DaoManager.createDao(connectionSource, Clientes.class);

            //persiste no BAnco de Dados
            clienteDao.create(cliente);

            // fecha conexão
            connectionSource.close();
            cliente.cadastrarCliente();

            Stage janelaAtual = (Stage) CampoNome.getScene().getWindow();
            janelaAtual.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/TelaPrincipal.fxml"));
            Parent logar = fxmlLoader.load();

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
    public void conferirAcesso(){

        String senha = CampoSenha.getText();
        String cpf = CampoCpf.getText();

        try{


            if (senha.isEmpty() || cpf.isEmpty()) {
                throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
            }
            if(senha.length() < 8) {
                throw new IllegalArgumentException("Formato da senha incorreto");
            }


        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao processar: " + e.getMessage());
        }

        String url = "jdbc:sqlite:BancoDeDados.db";
        String sql = "SELECT * FROM Clientes WHERE cpf = ? AND senha = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cpf);
            pstmt.setString(2, senha);
            ResultSet rs = pstmt.executeQuery();

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Login");
            alerta.setHeaderText(null); // se não quiser um título secundário
            alerta.setContentText("Login bem-sucedido!");
            alerta.showAndWait();

            System.out.println("Acessando Conta...");

            Stage janelaAtual = (Stage) CampoCpf.getScene().getWindow();
            janelaAtual.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/App.fxml"));
            Parent logar = fxmlLoader.load();

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




