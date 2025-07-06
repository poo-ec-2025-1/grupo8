public abstract class Usuarios {
    protected String nome; 
    protected String dataNasc;
    protected int cpf; 
    protected String categoria;
    protected String usuario; 
    protected String senha; 
    protected String cidadeAtend; 
    protected float saldo;

    // Construtor Usuarios
    public Usuarios(String nome, String dataNasc, int cpf, String categoria,
    String usuario, String senha) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.categoria = categoria;
        this.usuario = usuario;
        this.senha = senha;
        this.saldo = 0.0f;
    }

    // Métodos Getters e Setters
    public String getNome() { 
        return this.nome; 
    }

    public void setNome(String nome) { 
        this.nome = nome; 
    }

    public String getDataNasc() { 
        return this.dataNasc;
    }

    public void setDataNasc(String data) {
        this.dataNasc = data; 
    }

    public int getCpf() { 
        return this.cpf; 
    }

    public void setCpf(int cpf) {
        this.cpf = cpf; 
    }

    public String getCategoria() { 
        return this.categoria; 
    }

    public void setCategoria(String categoria) { 
        this.categoria = categoria; 
    }

    public String getUsuario() { 
        return this.usuario; 
    }

    public void setUsuario(String usuario) { 
        this.usuario = usuario;
    }

    protected String getSenha() { 
        return this.senha; 
    }

    protected void setSenha(String senha) {
        this.senha = senha; 
    }

    public String getCidadeAtend() { 
        return this.cidadeAtend; 
    }

    public void setCidadeAtend(String cidade) {
        this.cidadeAtend = cidade; 
    }

    public float getSaldo() { 
        return this.saldo; 
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo; 
    }
}
