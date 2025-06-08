//Usuários gerais do app
public abstract class Usuarios{
    public String classificacao;
    public String nome;
    public String cidade;
    public int telefone;
    public int qtdAtendimentos = 0;
    public double avaliacao;
    public double saldo;

    public Usuarios(String nome, String cidade, int telefone){
        this.nome = nome;
        this.cidade = cidade;
        this.telefone = telefone;
    }

    // Classe abstrata
    public abstract void agendar(int diaAgendamento, int mesAgendamento, double horario, String procedimento, String pessoa);

    //Nome
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return (nome);
    }

    //cidade
    public void setCidade(String nome){
        this.cidade = nome;
    }

    public String getCidade(){
        return (this.cidade);
    }

    //Telefone
    public void setTelefone(int numero){
        this.telefone = numero;
    }

    public int getTelefone(){
        return (this.telefone);
    }

    //Avaliações e atendimentos
    public void adicionarAtendimentos(){
        this.qtdAtendimentos++;
    }

    public double getAvaliacao(){
        return (avaliacao);
    }

    public void setAvaliacao(double nota){
        this.avaliacao += nota;
    }

    //Calcular a média das avaliações

    public double mediaAvaliacao(){
        return this.avaliacao/this.qtdAtendimentos;
    }

    //método para retornar o valor disponível para saque/estorno na carteira do app
    public double getSaldoDisponivel(){
        return (this.saldo - (this.saldo *0.03)); //3% de taxa para saque ou estornos no app
    }
}
