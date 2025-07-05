//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Classes;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.io.PrintStream;

@DatabaseTable(
    tableName = "Profissionais"
)
public class Profissionais extends Usuarios {
    @DatabaseField
    protected String nome;
    @DatabaseField
    protected String dataNasc;
    @DatabaseField(
        id = true
    )
    protected String cpf;
    @DatabaseField
    protected String categoria;
    @DatabaseField
    protected String senha;
    @DatabaseField
    protected double avaliacao;
    protected String cidadeAtend;
    protected float saldo;
    public String servicos;
    @DatabaseField
    public double valor;
    public String endereco;
    public String biografia;
    public String datasDispon;
    public String horariosDispon;
    public String datasAgend;
    public String horariosAgend;
    public int qntAtend;

    public Profissionais(String nome, String dataNasc, String cpf, String categoria, String senha, double avaliacao, double valor) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.categoria = categoria;
        this.senha = senha;
        this.avaliacao = avaliacao;
        this.valor = valor;
    }

    public Profissionais() {
    }

    public void cadastrarProfissional() {
        System.out.println("PROFISSIONAL CADASTRADO!");
        System.out.println("NOME: " + this.getNome());
        System.out.println("DATA DE NASCIMENTO: " + this.getDataNasc());
        System.out.println("CPF/USUÁRIO: " + this.getCpf());
    }

    public void cadastrarServicos(String s) {
        this.servicos = s;
        System.out.println("Servico cadastrado com sucesso!");
    }

    public void verificarAgenda() {
        PrintStream var10000 = System.out;
        String var10001 = this.getDatasAgend();
        var10000.println("Agendamento para o dia: " + var10001 + "Às " + this.getHorariosAgend() + "horas");
    }

    public void editarPerfil() {
    }

    public void realizarCheckIn() {
        System.out.println("Check-in realizado com sucesso!");
    }

    public void realizarCheckOut() {
        System.out.println("Check-out realizado com sucesso!");
        this.setQntAtend(this.getQntAtend() + 1);
    }

    public void verificarCarteira() {
        System.out.println("SALDO: " + this.getSaldo());
    }

    public void sacar(float f) {
        if (this.getSaldo() >= f) {
            this.setSaldo(this.getSaldo() - f);
            System.out.println("Saque realizado com sucesso");
        } else if (this.getSaldo() < f) {
            System.out.println("Valor insuficiente, o saque não pode ser realizado!");
        }

    }

    public String getServicos() {
        return this.servicos;
    }

    public void setServicos(String servicos) {
        this.servicos = servicos;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(float v) {
        this.valor = (double)v;
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

    public double getAvaliacao() {
        return this.avaliacao;
    }

    public void setAvaliacao(float n) {
        this.avaliacao = (double)n;
    }

    public int getQntAtend() {
        return this.qntAtend;
    }

    public void setQntAtend(int n) {
        this.qntAtend = n;
    }

    public float getSaldo() {
        return this.saldo;
    }

    public void setSaldo(float s) {
        this.saldo = s;
    }

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

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public class cancelarAtendimento {
        public Agendamento ag;

        public cancelarAtendimento(Agendamento ag) {
            this.ag = ag;
            System.out.println(String.valueOf(this.getAg()) + "Agendamento cancelado");
        }

        public Agendamento getAg() {
            return this.ag;
        }

        public void setAg(Agendamento ag) {
            this.ag = ag;
        }
    }

    public class AvaliarCliente {
        public Profissionais profissional;
        public Clientes cliente;
        public float nota;

        public AvaliarCliente(Profissionais p, Clientes c, float n) {
            this.profissional = p;
            this.cliente = c;
            this.nota = n;
        }
    }
}
