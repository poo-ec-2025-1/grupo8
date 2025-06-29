public class Clientes extends Usuarios{
    protected String nome;
    protected String dataNasc; //data de nascimento
    protected int cpf;
    protected String categoria;
    protected String usuario; //cpf
    protected String senha;
    protected String cidadeAtend;
    protected float saldo;
    protected float avaliacao;
    public String agendar;
    public String servicoSolic;
    public Profissionais profissional;
    public int qntAtendimento;
    public float avaliacaoCliente;
    public float notaCliente;
    //construtor
    public Clientes(String nome,  String data, int cpf,
    String categoria, String senha){
        this.nome = nome;
        this.dataNasc = data;
        this.cpf = cpf;
        this.categoria = categoria;
        this.senha = senha;
    }
    public void cadastrarCliente(){
        System.out.println("CLIENTE CADASTRADO!");
        System.out.println("NOME: "+getNome());
        System.out.println("DATA DE NASCIMENTO: "+getDataNasc());
        System.out.println("CPF/USUÁRIO: "+getCpf());
    }
    //métodos da classe
        public void realizarNovoAgendamento(String s){
        System.out.println("Gostaria de realizar um novo agendamento?");
        this.agendar = s;
              if (this.agendar == "SIM"){
            System.out.println("Informe a cidade onde gostaria de ser atendido(a)");
        }}
    
        public void pesquisarCidade(String c){
            this.cidadeAtend = c;
            System.out.println("Pesquise o serviço da sua preferência");
        }
        public void pesquisarServico(String sc){
        this.servicoSolic = sc;
        System.out.println("Seguem os profissionais em "+getCidadeAtend()+
        " que realizam o atendimento de "+getServicoSolic());
        System.out.println("LISTA DE PROFISSIONAIS"); //LISTA A SER CRIADA
        }
        public void apresentarProfissional(Profissionais profissional){
        this.profissional = profissional;
        //apresentarProf();
        //System.out.println(" "+getNome());
        System.out.println("Serviço: "+getServicoSolic());
        //System.out.println("Valor: "+getValorServicoSolic());
        //System.out.println("Endereço: "+getEndereco());
        
    }
    public void selecionarProfissional(int codigo){
        System.out.println("Escolha o profissional desejado");
        //System.out.println(+apresentarProfissional());
    }
    public void verificarAgenda(){}
    public void escolherData(){}
    public void escolherHorario(){}
    public void escolherPagamento(){}
    public void depositar(){}
    public void confirmarAgendamento(){}
    public void realizarCheckIn(){
        System.out.println("Check-in realizado com sucesso!");
    }
    public void realizarCheckOut(){
        System.out.println("Check-out realizado com sucesso!");
        setQntAtendimento(getQntAtendimento()+1);
        System.out.println("Por favor, avalie o atendimento");
    }
    //classe para realizar a avaliação do profissional
    public class AvaliarProfissional extends Clientes{
        public Profissionais profissional;
        public float nota;
        
        public void AvaliarProfissional(Profissionais prof, float n){
            this.profissional = prof;
            this.nota = n;
        }
        public float getNota(){
            return this.nota;
        }
        public void setNota(float n){
            this.nota = n;
        }
        public Profissionais getProfissional(){
            return this.profissional;
        }
        public void setProfissional(Profissionais prof){
            this.profissional = prof;
        }}
    //métodos especiais
    public String getAgendar(){
        return this.agendar;
    }
    public void setAgendar(String s){
        this.agendar = s;
    }
    public String getServicoSolic(){
        return this.servicoSolic;
    }
    public void setServicoSolic(String servicoSolic){
        this.servicoSolic = servicoSolic;
    }
    public int getQntAtendimento(){
        return this.qntAtendimento;
    }
    public void setQntAtendimento(int qntAtendimento){
        this.qntAtendimento = qntAtendimento;
    }
    public float getAvaliacaoCliente(){
        return this.avaliacaoCliente;
    }
    public void setAvaliacaoCliente(float f){
        this.avaliacaoCliente = f;
    }
    public float getNotaCliente(){
        return this.notaCliente;
    }
    public void setNotaCliente(float f){
        this.avaliacaoCliente +=this.notaCliente/qntAtendimento;
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
    public float getSaldo(){
        return this.saldo;
    }
    public void setSaldo(float saldo){
        this.saldo = saldo;
    }}
    
