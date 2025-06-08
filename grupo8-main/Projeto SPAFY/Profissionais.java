public  abstract class Profissionais extends Usuarios{
    String servico;

    public Profissionais(String nome, String cidade, int telefone, String servico){
        super( nome,  cidade,  telefone);
        this.servico = servico;
    }

    public  abstract void prestarServico();

}  