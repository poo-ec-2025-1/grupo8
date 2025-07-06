public class Servicos { 

    public String nomeServico;  
    public float valor;
    public Profissionais profissional; 

    // Construtor 
    public Servicos(Profissionais profissional, String nomeServico, float valor) {
        this.profissional = profissional; 
        this.nomeServico = nomeServico;
        this.valor = valor;
    }

    // Métodos
    public void cadastrarServicos() { 
        System.out.println("SERVIÇO CADASTRADO!"); 
        System.out.println("Profissional: " + getProfissional().getNome()); 
        System.out.println("Serviço cadastrado: " + getNomeServico());
        System.out.println("Valor: R$" + getValor());
    }

    public String getNomeServico() {
        return this.nomeServico; 
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public float getValor() {
        return this.valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Profissionais getProfissional() {
        return this.profissional;
    }

    public void setProfissional(Profissionais profissional) {
        this.profissional = profissional;
    }
}