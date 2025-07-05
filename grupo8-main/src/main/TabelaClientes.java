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
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.Main;

public class TabelaClientes {
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
            this.listaFiltrada.setAll(this.todosProfissionais);
        } else {
            this.listaFiltrada.setAll(this.todosProfissionais.stream().filter((p) -> p.getCategoria().equalsIgnoreCase(profissao)).toList());
        }

    }

    @FXML
    public void initialize() {
        try {
            String url = "jdbc:sqlite:BancoDeDados.db";
            ConnectionSource cs = new JdbcConnectionSource(url);
            this.maquiadoresDao = DaoManager.createDao(cs, Maquiadores.class);
            Main.cabeleleirosDao = DaoManager.createDao(cs, Cabeleleiros.class);
            this.todosProfissionais.addAll(this.maquiadoresDao.queryForAll());
            this.todosProfissionais.addAll(Main.cabeleleirosDao.queryForAll());
            this.listaFiltrada.setAll(this.todosProfissionais);
            this.tabela.setItems(this.listaFiltrada);
            this.nome.setCellValueFactory(new PropertyValueFactory("nome"));
            this.profissao.setCellValueFactory(new PropertyValueFactory("categoria"));
            this.avaliacao.setCellValueFactory(new PropertyValueFactory("avaliacao"));
            TableColumn<Profissionais, Void> agendamentos = new TableColumn("Agendar");
            agendamentos.setCellFactory((coluna) -> new TableCell<Profissionais, Void>() {
                    private final Button botao = new Button("Escolher a data");

                    {
                        this.botao.setOnAction((event) -> {
                            Profissionais var10000 = (Profissionais)this.getTableView().getItems().get(this.getIndex());
                            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/view/datas.fxml"));
                            Parent escolher = null;

                            try {
                                escolher = (Parent)fxmlLoader.load();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            Stage novaJanela = new Stage();
                            novaJanela.setTitle("SpaFy");
                            novaJanela.setScene(new Scene(escolher));
                            novaJanela.show();
                        });
                    }

                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            this.setGraphic((Node)null);
                        } else {
                            this.setGraphic(this.botao);
                        }

                    }
                });
            this.tabela.getColumns().add(agendamentos);
            SpinnerValueFactory<String> profissaoFactory = new SpinnerValueFactory.ListSpinnerValueFactory(FXCollections.observableArrayList(new String[]{"Todos", "Maquiador", "Cabeleleiro"}));
            this.spinnerProfissao.setValueFactory(profissaoFactory);
            this.spinnerProfissao.valueProperty().addListener((obs, oldVal, newVal) -> {
                this.filtrarProfissionais(newVal);
                this.tabela.setItems(this.listaFiltrada);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void criarProfissionais() throws SQLException, IOException {
        Maquiadores profissional1 = new Maquiadores("Sônia Morais da Silva", "10/23/2004", "08645614523", "123456789", 4.8, (double)50.0F);
        Maquiadores profissional2 = new Maquiadores("Maria Vitória Ferreira", "10/23/1952", "08645614520", "123456789", 1.9, (double)30.0F);
        Cabeleleiros profissonal3 = new Cabeleleiros("Davi Henrique Ramalho", "10/23/2000", "0864698769", "123456789", (double)5.0F, (double)100.0F);
        String url = "jdbc:sqlite:BancoDeDados.db";
        ConnectionSource connectionSource = new JdbcConnectionSource(url);
        Dao<Maquiadores, String> maquiadoresDao = DaoManager.createDao(connectionSource, Maquiadores.class);
        Dao<Cabeleleiros, String> cabeleleirosDao = DaoManager.createDao(connectionSource, Cabeleleiros.class);
        maquiadoresDao.create(profissional1);
        maquiadoresDao.create(profissional2);
        cabeleleirosDao.create(profissonal3);
        connectionSource.close();
    }

    public void marcarDia() {
        LocalDate data = (LocalDate)this.dataDisponivel.getValue();

        try {
            if (data == null) {
                throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String dataEscolhida = data.format(formatter);
            Agendamento agendamento = new Agendamento(dataEscolhida, "Unhas", "Davi");
            String url = "jdbc:sqlite:BancoDeDados.db";
            ConnectionSource connectionSource = new JdbcConnectionSource(url);
            Dao<Agendamento, ?> clienteDao = DaoManager.createDao(connectionSource, Agendamento.class);
            Main.agendamentosDao.create(agendamento);
            connectionSource.close();
            Stage janelaAtual = (Stage)this.dataDisponivel.getScene().getWindow();
            janelaAtual.close();
            Alert alerta = new Alert(AlertType.INFORMATION);
            alerta.setTitle("Login");
            alerta.setHeaderText((String)null);
            alerta.setContentText("Horário Agendado");
            alerta.showAndWait();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao processar: " + e.getMessage());
        }

    }
}
