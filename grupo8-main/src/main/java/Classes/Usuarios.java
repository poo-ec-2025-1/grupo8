package Classes;


public abstract class Usuarios{


    protected String nome;
    protected String dataNasc; //data de nascimento
    protected String cpf;
    protected String categoria;
    protected String senha;
    protected String cidadeAtend;
    protected float saldo;

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
    public String getCpf(){
        return this.cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public String getCategoria(){
        return this.categoria;
    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
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
    }

}
