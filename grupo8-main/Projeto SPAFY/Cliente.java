public class Clientes extends Usuarios{
    
    //método abstrato
    public Clientes(String nome, String dataDeNasc, int cpf, String categoria, 
    String cidade){
        this.nome = nome;
        this.dataNasc = dataDeNasc;
        this.cpf = cpf;
        this.categoria = categoria;
        this.cidade = cidade;
    }
    //método herdado
    @Override
    public void cadastrar(){
        System.out.println("CADASTRO REALIZADO COM SUCESSO!");
        //super.cadastrar();
        
    }
    //métodos da classe
    public void pesquisarCidade(){
    
    }
    public void pesquisarServicos() {
       //System.out.println("LISTA DE PROFISSIONAIS:" +
    }
    public void escolherProfissional(){
        
    }
    public void verificarAgenda(){
        
    }
    public void escolherData(){
        
    }
    public void escolherHorario(){
        
    }
    public void confirmarAgendamento(){
        
    }
    public void realizarPagamento(){
        
    }
    public void depositar(){
        
    }
    public void verificarSaldo(){
        
    }
    public void conversarComProfissional(){
        
    }
    public void solicitarCancelamento(){
        
    }
    //métodos especiais declarados na classe abstrata
}
