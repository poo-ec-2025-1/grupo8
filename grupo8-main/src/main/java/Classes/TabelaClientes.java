package Classes;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.example.Main.*;

public class TabelaClientes {

    //Usado para marcar a data escolhida
    @FXML
    private DatePicker dataDisponivel;

    @FXML
    private TableView<Profissionais> tabela;

    @FXML
    private Spinner<String> spinnerProfissao;

    @FXML
    private TableColumn<Profissionais, String> nome;

    @FXML
    private TableColumn<Profissionais, String> profissao;

    @FXML
    private TableColumn<Profissionais, Double> avaliacao;

    private Dao<Maquiadores, String> maquiadoresDao;

    ObservableList<Profissionais> todosProfissionais = FXCollections.observableArrayList();
    ObservableList<Profissionais> listaFiltrada = FXCollections.observableArrayList();

    private void filtrarProfissionais(String profissao) {
        if (profissao.equals("Todos")) {
            listaFiltrada.setAll(todosProfissionais);
        } else {
            listaFiltrada.setAll(
                    todosProfissionais.stream()
                            .filter(p -> p.getCategoria().equalsIgnoreCase(profissao))
                            .toList()
            );
        }
    }

    @FXML
    public void initialize() {
        try {
            String url = "jdbc:sqlite:BancoDeDados.db";
            ConnectionSource cs = new JdbcConnectionSource(url);

            maquiadoresDao = DaoManager.createDao(cs, Maquiadores.class);
            cabeleleirosDao = DaoManager.createDao(cs, Cabeleleiros.class);

            todosProfissionais.addAll(maquiadoresDao.queryForAll());
            todosProfissionais.addAll(cabeleleirosDao.queryForAll());

            listaFiltrada.setAll(todosProfissionais);
            tabela.setItems(listaFiltrada);

            nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            profissao.setCellValueFactory(new PropertyValueFactory<>("categoria"));
            avaliacao.setCellValueFactory(new PropertyValueFactory<>("avaliacao"));

            // Cria a coluna de botões
            TableColumn<Profissionais, Void> agendamentos = new TableColumn<>("Agendar");

            agendamentos.setCellFactory(coluna -> new TableCell<>() {
                private final Button  botao = new Button("Escolher a data");
                {
                    botao.setOnAction(event -> {
                        Profissionais p = getTableView().getItems().get(getIndex());

                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/datas.fxml"));
                        Parent escolher = null;
                        try {
                            escolher = fxmlLoader.load();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        Stage novaJanela = new Stage();
                        novaJanela.setTitle("SpaFy");
                        novaJanela.setScene(new Scene(escolher));
                        novaJanela.show();
                    });
                }

                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(botao);
                    }
                }
            });

            tabela.getColumns().add(agendamentos);

            SpinnerValueFactory<String> profissaoFactory = new SpinnerValueFactory.ListSpinnerValueFactory<>(
                    FXCollections.observableArrayList("Todos", "Maquiador", "Cabeleleiro")
            );
            spinnerProfissao.setValueFactory(profissaoFactory);

            spinnerProfissao.valueProperty().addListener((obs, oldVal, newVal) -> {
                filtrarProfissionais(newVal);
                tabela.setItems(listaFiltrada);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void criarProfissionais() throws SQLException, IOException {
        Maquiadores profissional1 = new Maquiadores("Sônia Morais da Silva", "10/23/2004", "08645614523", "123456789", 4.8, 50.0);
        Maquiadores profissional2 = new Maquiadores("Maria Vitória Ferreira", "10/23/1952", "08645614520", "123456789", 1.9, 30.0);
        Cabeleleiros profissonal3 = new Cabeleleiros("Davi Henrique Ramalho", "10/23/2000", "0864698769", "123456789", 5.0, 100.0);

        String url = "jdbc:sqlite:BancoDeDados.db";
        ConnectionSource connectionSource = new JdbcConnectionSource(url);
        Dao<Maquiadores, String> maquiadoresDao = DaoManager.createDao(connectionSource, Maquiadores.class);
        Dao<Cabeleleiros, String> cabeleleirosDao = DaoManager.createDao(connectionSource, Cabeleleiros.class);

        maquiadoresDao.create(profissional1);
        maquiadoresDao.create(profissional2);
        cabeleleirosDao.create(profissonal3);

        connectionSource.close();
    }
    public void marcarDia(){

        LocalDate data = dataDisponivel.getValue();

        try{


            if (data == null) {
                throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
            }

            //Converter a data para string
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String dataEscolhida = data.format(formatter);


            Agendamento agendamento = new Agendamento(dataEscolhida, "Unhas", "Davi");

            // SALVAR NO BANCO COM ORMlite
            String url = "jdbc:sqlite:BancoDeDados.db";
            ConnectionSource connectionSource = new JdbcConnectionSource(url);
            Dao<Agendamento, ?> clienteDao = DaoManager.createDao(connectionSource, Agendamento.class);

            //persiste no BAnco de Dados
            agendamentosDao.create(agendamento);

            // fecha conexão
            connectionSource.close();

            Stage janelaAtual = (Stage) dataDisponivel.getScene().getWindow();
            janelaAtual.close();

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Login");
            alerta.setHeaderText(null); // se não quiser um título secundário
            alerta.setContentText("Horário Agendado");
            alerta.showAndWait();



        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao processar: " + e.getMessage());
        }


    }

}

