//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Classes;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TelaDeAcesso {
    @FXML
    private Button cadastrar;

    @FXML
    private void CadastrarUsuario(ActionEvent event) throws IOException {
        System.out.println("Realizando cadastrado...");
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/view/CadastrarUsuario.fxml"));
        Parent preencherDados = (Parent)fxmlLoader.load();
        Stage novaJanela = (Stage)((Node)event.getSource()).getScene().getWindow();
        novaJanela.setTitle("SpaFy");
        novaJanela.setScene(new Scene(preencherDados));
        novaJanela.show();
    }

    @FXML
    private void acessarConta(ActionEvent event) throws IOException {
        System.out.println("Acessando Conta...");
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/view/Acessar.fxml"));
        Parent Acesso = (Parent)fxmlLoader.load();
        Stage novaJanela = (Stage)((Node)event.getSource()).getScene().getWindow();
        novaJanela.setTitle("SpaFy");
        novaJanela.setScene(new Scene(Acesso));
        novaJanela.show();
    }
}
