import java.util.ArrayList;
import java.util.Date; 
public class Agendamento {
    public Profissionais profissional; 
    public Clientes cliente;
    private String data; 
    private String horario; 
    private String status; 
    private Servicos servicoAgendado; 

    // Construtor do Agendamento
    public Agendamento(Clientes cliente, Profissionais profissional, Servicos servico, String data, String horario) {
        this.cliente = cliente;
        this.profissional = profissional;
        this.servicoAgendado = servico;
        this.data = data;
        this.horario = horario;
        this.status = "Pendente"; 
    }

    // Métodos Getters e Setters 
    public Profissionais getProfissional() { 
        return this.profissional; 
    }

    public void setProfissional(Profissionais prof) { 
        this.profissional = prof; 
    }

    public Clientes getCliente() { 
        return this.cliente; 
    }

    public void setCliente(Clientes c) { 
        this.cliente = c; 
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return this.horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Servicos getServicoAgendado() {
        return this.servicoAgendado;
    }

    public void setServicoAgendado(Servicos servicoAgendado) {
        this.servicoAgendado = servicoAgendado;
    }

    // Métodos de lógica de agendamento (anteriormente vazios)
    public void pesquisarCidade(String cidade, ArrayList<Profissionais> listaProfissionais) { 
        boolean encontrado = false;
        for (Profissionais p : listaProfissionais) {
            if (p.getCidadeAtend() != null && p.getCidadeAtend().equalsIgnoreCase(cidade)) {
                System.out.println("- " + p.getNome() + " (" + p.getServicoPrincipal() + ")");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum profissional encontrado nesta cidade.");
        }
    }

    public void pesquisarServico(String servico, ArrayList<Profissionais> listaProfissionais) { 
        System.out.println("Pesquisando profissionais que oferecem o serviço: " + servico);
        boolean encontrado = false;
        for (Profissionais p : listaProfissionais) {
            if (p.ofereceServico(servico)) {
                System.out.println("- " + p.getNome() + " (Valor médio: R$" + p.getValorGeral() + ")");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum profissional encontrado para este serviço.");
        }
    }

    public void apresentarProfissionais(ArrayList<Profissionais> listaProfissionais) { 
        System.out.println("Lista de Todos os Profissionais:");
        if (listaProfissionais.isEmpty()) {
            System.out.println("Nenhum profissional cadastrado no sistema.");
        } else {
            for (Profissionais p : listaProfissionais) {
                System.out.println("------------------------------------");
                System.out.println("Nome: " + p.getNome());
                System.out.println("Categoria: " + p.getCategoria());
                System.out.println("Serviço Principal: " + p.getServicoPrincipal());
                System.out.println("Cidade de Atendimento: " + p.getCidadeAtend());
                System.out.println("Avaliação: " + p.getAvaliacao());
                System.out.println("------------------------------------");
            }
        }
    }

    public void escolherProfissional(Profissionais profissional) { 
        this.setProfissional(profissional);
        System.out.println("Profissional " + profissional.getNome() + " escolhido para o agendamento.");
    }

    public void verificarDisponibilidade() { 
        if (this.profissional != null) {
            System.out.println("Verificando disponibilidade para " + this.profissional.getNome() + ":");
            this.profissional.verificarAgenda();
            System.out.println("Nenhum profissional selecionado para verificar a disponibilidade.");
        }
    }

    public void escolherData(String data) {
        this.setData(data);
        System.out.println("Data " + data + " selecionada.");
    }

    public void escolherHorario(String horario) {
        this.setHorario(horario);
        System.out.println("Horário " + horario + " selecionado.");
    }

    public void escolherFormaDePag(String forma) { 
        System.out.println("Forma de pagamento " + forma + " selecionada.");
    }

    public void realizarPagamento() {
        if (this.cliente != null && this.servicoAgendado != null) {
            float valorTotal = this.servicoAgendado.getValor();
            if (this.cliente.getSaldo() >= valorTotal) {
                this.cliente.setSaldo(this.cliente.getSaldo() - valorTotal);
                this.setStatus("Confirmado");
                System.out.println("Pagamento de R$" + valorTotal + " realizado com sucesso! Agendamento confirmado.");
                // Aqui o valor pago será transferido para o saldo do profissional
                this.profissional.setSaldo(this.profissional.getSaldo() + valorTotal);
                System.out.println("Saldo do cliente: R$" + this.cliente.getSaldo());
                System.out.println("Saldo do profissional: R$" + this.profissional.getSaldo());
            } else {
                System.out.println("Saldo insuficiente para realizar o pagamento. Saldo atual: R$" + this.cliente.getSaldo());
                this.setStatus("Aguardando Pagamento");
            }
        } else {
            System.out.println("Cliente ou serviço não definidos para pagamento.");
        }
    }

    public void confirmarAgendamento() {
        System.out.println("Agendamento para " + getCliente().getNome() + " com " + getProfissional().getNome() + " do serviço " + getServicoAgendado().getNomeServico() +
                " em " + getData() + " às " + getHorario() + " está " + getStatus() + "."); 
    }
}