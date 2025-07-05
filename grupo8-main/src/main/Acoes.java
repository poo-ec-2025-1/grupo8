//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Classes;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Acoes {
    @FXML
    public void pesquisar() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/view/profissionaisDisponiveis.fxml"));
        Parent logar = (Parent)fxmlLoader.load();
        Stage novaJanela = new Stage();
        novaJanela.setTitle("SpaFy");
        novaJanela.setScene(new Scene(logar));
        novaJanela.show();
    }
}
