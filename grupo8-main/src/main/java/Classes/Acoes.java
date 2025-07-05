package Classes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Acoes {

    @FXML
    public void pesquisar() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/profissionaisDisponiveis.fxml"));
        Parent logar = fxmlLoader.load();

        Stage novaJanela = new Stage();
        novaJanela.setTitle("SpaFy");
        novaJanela.setScene(new Scene(logar));
        novaJanela.show();
    }

}
