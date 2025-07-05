# Relatório Individual - Interface Gráfica com JavaFX

Durante o desenvolvimento do projeto, minha principal responsabilidade foi a construção da interface gráfica utilizando a biblioteca **JavaFX**. Utilizei o **SceneBuilder** para criar visualmente as telas da aplicação, definindo os elementos gráficos necessários como `TableView`, `TableColumn`, `Label`, `Spinner`, entre outros.

Configurei estilos visuais e organizei o layout das telas para que fossem visualmente agradáveis e intuitivas para o usuário. Abaixo, um exemplo de definição da tabela no FXML:

```xml
<TableView fx:id="tabela" layoutX="28.0" layoutY="164.0" prefHeight="211.0" prefWidth="545.0">
  <columns>
    <TableColumn fx:id="nome" prefWidth="75.0" text="Nome" />
    <TableColumn fx:id="profissao" prefWidth="202.0" text="Profissão" />
    <TableColumn fx:id="avaliacao" prefWidth="196.0" text="Avaliação" />
  </columns>
</TableView>
```

Além da parte gráfica, integrei a interface com o back-end Java. Para isso, conectei os elementos FXML com o controlador da classe usando `@FXML`. Um exemplo da inicialização da tabela com dados do banco:

```java
@FXML
private TableView<Profissionais> tabela;
@FXML
private TableColumn<Profissionais, String> nome;
@FXML
private TableColumn<Profissionais, String> profissao;
@FXML
private TableColumn<Profissionais, Float> avaliacao;

@Override
public void initialize(URL url, ResourceBundle resourceBundle) {
    nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    profissao.setCellValueFactory(new PropertyValueFactory<>("categoria"));
    avaliacao.setCellValueFactory(new PropertyValueFactory<>("avaliacao"));

    try {
        List<Maquiadores> maquiadores = maquiadoresDao.queryForAll();
        List<Cabeleleiros> cabeleleiros = cabeleleirosDao.queryForAll();

        List<Profissionais> profissionais = new ArrayList<>();
        profissionais.addAll(maquiadores);
        profissionais.addAll(cabeleleiros);

        tabela.getItems().addAll(profissionais);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
```

No back-end, trabalhei com o framework **ORMLite** para mapear classes Java em tabelas do banco de dados SQLite. Um exemplo de anotação:

```java
@DatabaseTable(tableName = "Maquiadores")
public class Maquiadores extends Profissionais {

    @DatabaseField
    protected double valor;

    public Maquiadores(String nome, String dataNasc, String cpf, String senha, float avaliacao, double valor) {
        super(nome, dataNasc, cpf, "Maquiador(a)", senha, avaliacao);
        this.valor = valor;
    }

    public Maquiadores() {
        super();
    }
}
```

Com isso, foi possível carregar os dados diretamente do banco e exibi-los em tempo real na tabela da interface gráfica. Também configurei o estilo visual com cores, fontes e alinhamento para criar uma identidade visual agradável ao sistema.

Acredito que essa integração entre a interface gráfica e a lógica dos dados foi essencial para tornar o sistema funcional e apresentável ao usuário final.

