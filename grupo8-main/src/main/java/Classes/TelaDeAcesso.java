package Classes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class TelaDeAcesso{

    @FXML
    private Button cadastrar;

    @FXML
    private void CadastrarUsuario(ActionEvent event) throws IOException {
        System.out.println("Realizando cadastrado...");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/CadastrarUsuario.fxml")); //Cria um novo objeto que acessa o arquivo fxml, no nosso caso: CadastrarUsuario.fxml
        Parent preencherDados = fxmlLoader.load(); //guarda nessa variável

        Stage novaJanela = (Stage) ((Node) event.getSource()).getScene().getWindow();
        novaJanela.setTitle("SpaFy");
        novaJanela.setScene(new Scene(preencherDados));
        novaJanela.show();
    }

    @FXML
    private void acessarConta(ActionEvent event) throws IOException {

        System.out.println("Acessando Conta...");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Acessar.fxml"));
        Parent Acesso = fxmlLoader.load();

        Stage novaJanela = (Stage) ((Node) event.getSource()).getScene().getWindow();
        novaJanela.setTitle("SpaFy");
        novaJanela.setScene(new Scene(Acesso));
        novaJanela.show();
    }

}