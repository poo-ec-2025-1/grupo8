package org.example;

import Classes.*;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {

    public static Dao<Cabeleleiros, String> cabeleleirosDao;
    public static Dao<Maquiadores, String> maquiadoresDao;
    public static Dao<Clientes, String> clientesDao;
    public static Dao<Agendamento, String> agendamentosDao;

    @Override
    public void start(Stage primaryStage) throws Exception {
        criarTabelasSeNecessario();

        Parent root = FXMLLoader.load(getClass().getResource("/view/TelaPrincipal.fxml"));
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();
    }

    private void criarTabelasSeNecessario() throws SQLException, IOException {
        String url = "jdbc:sqlite:BancoDeDados.db";

        try (ConnectionSource connectionSource = new JdbcConnectionSource(url)) {
            maquiadoresDao = DaoManager.createDao(connectionSource, Maquiadores.class);
            cabeleleirosDao = DaoManager.createDao(connectionSource, Cabeleleiros.class);
            clientesDao = DaoManager.createDao(connectionSource, Clientes.class);
            agendamentosDao = DaoManager.createDao(connectionSource, Agendamento.class);

            TableUtils.createTableIfNotExists(connectionSource, Maquiadores.class);
            TableUtils.createTableIfNotExists(connectionSource, Cabeleleiros.class);
            TableUtils.createTableIfNotExists(connectionSource, Clientes.class);
            TableUtils.createTableIfNotExists(connectionSource, Agendamento.class);

        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
