package Classes;

import Classes.DataBase.BancoDeDados;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;

import javafx.scene.control.TextField;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Dados {

    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoSenha;
    @FXML
    private TextField campoCpf;
    @FXML
    private DatePicker campoDatanasc;

    @FXML
    public void ConferirDados(){

        String nome = campoNome.getText();
        String senha = campoSenha.getText();
        String cpf = campoCpf.getText();
        LocalDate data = campoDatanasc.getValue();

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

            // Converte CPF
            int NumCpf = Integer.parseInt(campoCpf.getText());

            Clientes cliente = new Clientes(nome, datanasc, NumCpf, "Cliente", senha);
            cliente.cadastrarCliente();

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao processar a data: " + e.getMessage());
        }

        //Banco de dados

        try {
            BancoDeDados.criarTabelaUsuarios();
            BancoDeDados.salvarUsuario(
                    campoNome.getText(),
                    campoCpf.getText(),
                    campoSenha.getText(),
                    campoDatanasc.getValue().toString()
            );
            System.out.println("Usuário salvo com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @FXML
    public void conferirAcesso(){

        String senha = campoSenha.getText();
        String cpf = campoCpf.getText();

        try{


            if (senha.isEmpty() || cpf.isEmpty()) {
                throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
            }
            if(senha.length() < 8) {
                throw new IllegalArgumentException("Formato da senha incorreto");
            }


            // Converte CPF
            int NumCpf = Integer.parseInt(campoCpf.getText());


        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao processar: " + e.getMessage());
        }

        String url = "jdbc:sqlite:banco.db";
        String sql = "SELECT * FROM usuarios WHERE cpf = ? AND senha = ?";

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

        } catch (SQLException e) {
            System.out.println("Erro ao verificar login: " + e.getMessage());
        }


    }




}




