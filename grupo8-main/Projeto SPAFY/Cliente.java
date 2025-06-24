public class Clientes extends Usuarios implements PagClientes{
    //protected String nome;
    //protected String dataNasc; //data de nascimento
    //protected int cpf;
    //protected String categoria;
    //protected String usuario; //cpf
    //protected String senha;
    //protected String cidadeAtend;
    //protected float saldo;
    //protected float avaliacao;
    public String agendar;
    public String servicoSolic;
    public Profissionais profissional;
    public int qntAtendimento;
    @Override
    public void novoUsuario(String nome, String dataNasc, int cpf, 
    String categoria, String senha){
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.categoria = categoria;
        this.senha = senha;
    }
    @Override
    public void cadastrarUsuario(){
        System.out.println("CADASTRO REALIZADO COM SUCESSO!");
        System.out.println("NOME: "+getNome());
        System.out.println("DATA DE NASCIMENTO: "+getDataNasc());
        System.out.println("CPF/USUÁRIO: "+getCpf());
    }
    //métodos da classe
    @Override
    public void realizarNovoAgendamento(String s){
        System.out.println("Gostaria de realizar um novo agendamento?");
        this.agendar = s;
        if (this.agendar == "SIM"){
            System.out.println("Informe a cidade onde gostaria de ser atendido(a)");
        }
    }
    @Override
    public void pesquisarCidade(String c){
        this.cidadeAtend = c;
        System.out.println("Pesquise o serviço da sua preferência");
    }
    @Override
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
    @Override
    public void selecionarProfissional(int codigo){
        System.out.println("Escolha o profissional desejado");
        //System.out.println(+apresentarProfissional());
    }
    @Override
    public void verificarAgenda(){}
    @Override
    public void escolherData(){}
    @Override
    public void escolherHorario(){}
    @Override
    public void escolherPagamento(){}
    @Override
    public void depositar(){}
    @Override
    public void confirmarAgendamento(){}
    @Override
    public void realizarCheckIn(){
        System.out.println("Check-in realizado com sucesso!");
    }
    @Override
    public void realizarCheckOut(){
        System.out.println("Check-out realizado com sucesso!");
        setQntAtendimento(getQntAtendimento()+1);
        System.out.println("Por favor, avalie o atendimento");
    }
    //classe para realizar a avaliação do profissional
    public class avaliarProfissional{
        public Profissionais profissional;
        public float nota;
        
        public void avaliarProfissional(Profissionais prof, float n){
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
    }}
    
