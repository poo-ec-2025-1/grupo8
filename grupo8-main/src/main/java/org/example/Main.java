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

    private static Dao<Clientes, String> clientesDao;
    public static Dao<Maquiadores, String> maquiadoresDao;
    public static Dao<Cabeleleiros, String> cabeleleirosDao;
    public static Dao<Agendamento, String> agendamentosDao;


    private static Dao<Clientes, ?> dao;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Inicializar o banco de dados
        initDatabase();

        // Carregar a interface
        Parent root = FXMLLoader.load(getClass().getResource("/view/TelaPrincipal.fxml"));
        primaryStage.setTitle("Spafy");
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();
    }

    private void initDatabase() {
        try {

            ConnectionSource conn = new JdbcConnectionSource("jdbc:sqlite:BancoDeDados.db");
            TableUtils.createTableIfNotExists(conn, Clientes.class);
            TableUtils.createTableIfNotExists(conn, Maquiadores.class);
            TableUtils.createTableIfNotExists(conn, Cabeleleiros.class);
            TableUtils.createTableIfNotExists(conn, Agendamento.class);

            clientesDao = DaoManager.createDao(conn, Clientes.class);
            maquiadoresDao = DaoManager.createDao(conn, Maquiadores.class);
            cabeleleirosDao = DaoManager.createDao(conn, Cabeleleiros.class);
            agendamentosDao = DaoManager.createDao(conn, Agendamento.class);

            System.out.println("Banco de dados inicializado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Dao<Clientes, String> getDaoClientes() {
        return clientesDao;
    }

    public static Dao<Maquiadores, String> getDaoMaquiadores() {
        return maquiadoresDao;
    }

    public static Dao<Cabeleleiros, String> getDaoCabeleleiros() {
        return cabeleleirosDao;
    }

    public static Dao<Agendamento, String> getDaoAgendamentos() {
        return agendamentosDao;
    }

    public static void main(String[] args) throws SQLException, IOException {
        launch(args);
        TabelaClientes novosProfissionais = new TabelaClientes();
        novosProfissionais.criarProfissionais();
    }
}
