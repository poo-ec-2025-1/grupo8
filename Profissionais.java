import java.util.ArrayList; 

public class Profissionais extends Usuarios {
    protected float avaliacao; 
    public String servicosGeral;
    public float valorGeral;
    public String endereco; 
    public String biografia; 
    public String datasDispon; 
    public String horariosDispon; 
    public String datasAgend; 
    public String horariosAgend; 
    public int qntAtend; 
    public String servicoPrincipal;

    public ArrayList<Servicos> listaServicos; 

    public Profissionais(String nome, String dataNasc, int cpf, String categoria, String usuario, String senha) {
        super(nome, dataNasc, cpf, categoria, usuario, senha);
        this.qntAtend = 0; 
        this.avaliacao = 0.0f; 
        this.listaServicos = new ArrayList<>(); 
    }

    public Profissionais(String nome, String dataNasc, int cpf, String categoria, String usuario, String senha, String servicoPrincipal, String endereco, String biografia, String cidadeAtend) {
        this(nome, dataNasc, cpf, categoria, usuario, senha); 
        this.servicoPrincipal = servicoPrincipal;
        this.endereco = endereco; 
        this.biografia = biografia;
        this.setCidadeAtend(cidadeAtend); 
    }

    public void cadastrarProfissional() { 
        System.out.println("PROFISSIONAL CADASTRADO!"); 
        System.out.println("NOME: " + getNome()); 
        System.out.println("DATA DE NASCIMENTO: " + getDataNasc()); 
        System.out.println("CPF/USUÁRIO: " + getCpf()); 
        System.out.println("CATEGORIA: " + getCategoria());
        System.out.println("SERVIÇO PRINCIPAL: " + getServicoPrincipal());
        System.out.println("CIDADE DE ATENDIMENTO: " + getCidadeAtend());
    }

    // Método para adicionar um novo serviço oferecido pelo profissional
    public void cadastrarServico(String nomeServico, float valor) { 
        Servicos novoServico = new Servicos(this, nomeServico, valor);
        listaServicos.add(novoServico);
        System.out.println("SERVIÇO ADICIONADO COM SUCESSO!");
        System.out.println("Profissional: " + this.getNome()); 
        System.out.println("Serviço: " + nomeServico); 
        System.out.println("Valor: R$" + valor); 
    }

    // Método para listar todos os serviços oferecidos pelo profissional
    public void listarServicos() { 
        System.out.println("Serviços oferecidos por " + this.getNome() + ":");
        if (listaServicos.isEmpty()) {
            System.out.println("Nenhum serviço cadastrado.");
        } else {
            for (Servicos s : listaServicos) { 
                System.out.println("- " + s.getNomeServico() + " (R$" + s.getValor() + ")"); 
            }
        }
    }

    // Método para verificar a agenda do profissional
    public void verificarAgenda() { 
        System.out.println("Agendamento para o dia: " + getDatasAgend() + " Às " + 
                getHorariosAgend() + " horas"); 
        
    }

    public void editarPerfil() { // 
        System.out.println("Editando perfil do profissional " + getNome() + "...");
        //porteriormente colocaremos a função para editar dados
    }

    public void realizarCheckIn() { 
        System.out.println("Check-in realizado com sucesso!");
    }

    public void realizarCheckOut() { 
        System.out.println("Check-out realizado com sucesso!"); 
        setQntAtend(getQntAtend() + 1);
    }

    public void verificarCarteira() { 
        System.out.println("SALDO ATUAL: R$" + getSaldo()); 
    }

    public void sacar(float valorSaque) { 
    if (getSaldo() >= valorSaque) {
            setSaldo(getSaldo() - valorSaque);
            System.out.println("Saque de R$" + valorSaque + " realizado com sucesso. Novo saldo: R$" + getSaldo()); 
        } else {
            System.out.println("Valor insuficiente, o saque não pode ser realizado! Saldo atual: R$" + getSaldo()); 
        }
    }

    // Método para verificar se o profissional oferece um determinado serviço
    public boolean ofereceServico(String nomeServico) {
        for (Servicos s : listaServicos) {
            if (s.getNomeServico().equalsIgnoreCase(nomeServico)) {
                return true;
            }
        }
        return false;
    }

    // Métodos Getters e Setters 
    public String getServicosGeral() { 
        return this.servicosGeral; 
    }

    public void setServicosGeral(String servicosGeral) {
        this.servicosGeral = servicosGeral; 
    }

    public float getValorGeral() { 
        return this.valorGeral; 
    }

    public void setValorGeral(float v) { 
        this.valorGeral = v; 
    }

    public String getEndereco() { 
        return this.endereco; 
    }

    public void setEndereco(String endereco) { 
        this.endereco = endereco; 
    }

    public String getBiografia() { 
        return this.biografia; 
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia; 
    }

    public String getDatasDispon() { 
        return this.datasDispon; 
    }

    public void setDatasDispon(String datasDispon) {
        this.datasDispon = datasDispon; 
    }

    public String getHorariosDispon() { 
        return this.horariosDispon; 
    }

    public void setHorariosDispon(String horariosDispon) {
        this.horariosDispon = horariosDispon; 
    }

    public String getDatasAgend() {
        return this.datasAgend; 
    }

    public void setDatasAgend(String diasAgend) { 
        this.datasAgend = diasAgend;
    }

    public String getHorariosAgend() { 
        return this.horariosAgend; 
    }

    public void setHorariosAgend(String horariosAgend) { 
        this.horariosAgend = horariosAgend; 
    }

    public float getAvaliacao() { 
        return this.avaliacao; 
    }

    public void setAvaliacao(float n) {
        this.avaliacao = n; 
    }

    public int getQntAtend() { 
        return this.qntAtend; 
    }

    public void setQntAtend(int n) {
        this.qntAtend = n; 
    }

    public String getServicoPrincipal() {
        return this.servicoPrincipal;
    }

    public void setServicoPrincipal(String servicoPrincipal) {
        this.servicoPrincipal = servicoPrincipal;
    }
}