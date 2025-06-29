package Classes;

public class Profissionais extends Usuarios{
    protected String nome;
    protected String dataNasc; //data de nascimento
    protected int cpf;
    protected String categoria;
    protected String usuario; //cpf
    protected String senha;
    protected String cidadeAtend;
    protected float saldo;
    protected float avaliacao;
    public String servicos;
    public float valor;
    public String endereco;
    public String biografia;
    public String datasDispon; //datas disponiveis
    public String horariosDispon; //horarios disponiveis
    public String datasAgend; //datas não disponíveis
    public String horariosAgend;//horarios não disponíveis
    public int qntAtend;

    public Profissionais (String nome, String dataNasc, int cpf, String categoria, String senha){
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.categoria = categoria;
        this.senha = senha;
    }
    public void cadastrarProfissional(){
        System.out.println("PROFISSIONAL CADASTRADO!");
        System.out.println("NOME: "+getNome());
        System.out.println("DATA DE NASCIMENTO: "+getDataNasc());
        System.out.println("CPF/USUÁRIO: "+getCpf());
    }
    //implementando os métodos da interface
    /*@Override
    public void cadastrarUsuario(){
        System.out.println("NOME: "+getNome());
        System.out.println("SERVIÇOS: "+getServicos());
        System.out.println("AGENDA:"+getDatasDispon()+getHorariosDispon());}*/
    public void cadastrarServicos(String s){
        this.servicos = s;
        System.out.println("Servico cadastrado com sucesso!");

    }
    public void verificarAgenda(){
        System.out.println("Agendamento para o dia: "+getDatasAgend()+"Às "+getHorariosAgend()+"horas");

    }
    public void editarPerfil(){}
    public class cancelarAtendimento{
        public Agendamento ag;

        public cancelarAtendimento(Agendamento ag){
            this.ag = ag;
            System.out.println(getAg()+"Agendamento cancelado");
        }
        public Agendamento getAg(){
            return this.ag;
        }
        public void setAg(Agendamento ag){
            this.ag = ag;
        }
    }

    //criar uma classe public void cancelarAtendimento(){}
    public void realizarCheckIn(){
        System.out.println("Check-in realizado com sucesso!");
    }
    public void realizarCheckOut(){
        System.out.println("Check-out realizado com sucesso!");
        setQntAtend(getQntAtend()+1);
    }
    public void verificarCarteira(){
        System.out.println("SALDO: "+getSaldo());
    }
    public void sacar(float f){
        if (getSaldo()>=f){
            setSaldo(getSaldo()-f);
            System.out.println("Saque realizado com sucesso");
        }
        else if(getSaldo()<f){
            System.out.println("Valor insuficiente, o saque não pode ser realizado!");
        }
    }
    //criar classe public void avaliarCliente(){}
    public class AvaliarCliente{
        public Profissionais profissional;
        public Clientes cliente;
        public float nota;

        public AvaliarCliente(Profissionais p, Clientes c, float n){
            this.profissional = p;
            this.cliente = c;
            this.nota = n;
            float notaCliente= n;
        }
    }

    //métodos especiais
    public String getServicos(){
        return this.servicos;
    }
    public void setServicos(String servicos){
        this.servicos = servicos;
    }
    public float getValor(){
        return this.valor;
    }
    public void setValor(float v){
        this.valor = v;
    }
    public String getEndereco(){
        return this.endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public String getBiografia(){
        return this.biografia;
    }
    public void setBiografia(String biografia){
        this.biografia = biografia;
    }
    public String getDatasDispon(){
        return this.datasDispon;
    }
    public void setDatasDispon(String datasDispon){
        this.datasDispon = datasDispon;
    }
    public String getHorariosDispon(){
        return this.horariosDispon;
    }
    public void setHorariosDispon(String horariosDispon){
        this.horariosDispon = horariosDispon;
    }
    public String getDatasAgend(){
        return this.datasAgend;
    }
    public void setDatasAgend(String diasAgend){
        this.datasAgend = diasAgend;
    }
    public String getHorariosAgend(){
        return this.horariosAgend;
    }
    public void setHorariosAgend(String horariosAgend){
        this.horariosAgend = horariosAgend;
    }
    public float getAvaliacao(){
        return this.avaliacao;
    }
    public void setAvaliacao(float n){
        this.avaliacao = n;
    }
    public int getQntAtend(){
        return this.qntAtend;
    }
    public void setQntAtend(int n){
        this.qntAtend = n;
    }
    public float getSaldo(){
        return this.saldo;
    }
    public void setSaldo(float s){
        this.saldo = s;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getDataNasc(){
        return this.dataNasc;
    }
    public void setDataNasc(String data){
        this.dataNasc = data;
    }
    public int getCpf(){
        return this.cpf;
    }
    public void setCpf(int cpf){
        this.cpf = cpf;
    }
    public String getCategoria(){
        return this.categoria;
    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    public String getUsuario(){
        return this.usuario;
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    protected String getSenha(){
        return this.senha;
    }
    protected void setSenha(String senha){
        this.senha = senha;
    }
    public String getCidadeAtend(){
        return this.cidadeAtend;
    }
    public void setCidadeAtend(String cidade){
        this.cidadeAtend = cidade;
    }

}