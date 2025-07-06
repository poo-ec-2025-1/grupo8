import java.util.ArrayList; 
import java.util.Scanner;

public class Clientes extends Usuarios { 
    // Atributos específicos de Cliente
    protected float avaliacao; 
    public String agendar; 
    public String servicoSolic; 
    public Profissionais profissionalEscolhido; 
    public int qntAtendimento; 
    public float avaliacaoCliente; 
    public float notaCliente; 

    //cnstrutor
    public Clientes(String nome, String dataNasc, int cpf, String categoria,
    String usuario, String senha) { // Adicionado 'usuario' para o construtor da superclasse
        super(nome, dataNasc, cpf, categoria, usuario, senha);
        this.avaliacao = 0.0f; 
        this.qntAtendimento = 0; 
    }

    // Métodos da classe
    public void cadastrarCliente() { 
        System.out.println("CLIENTE CADASTRADO!"); 
        System.out.println("NOME: " + getNome());
        System.out.println("DATA DE NASCIMENTO: " + getDataNasc()); 
        System.out.println("CPF/USUÁRIO: " + getCpf()); 
        System.out.println("CATEGORIA: " + getCategoria());
        System.out.println("USUÁRIO: " + getUsuario());
    }

    public void realizarNovoAgendamento(String s) { 
        System.out.println("Gostaria de realizar um novo agendamento? (SIM/NAO)"); // [cite: 92]
        this.agendar = s; 

        if ("SIM".equalsIgnoreCase(this.agendar)) {
            System.out.println("Informe a cidade onde gostaria de ser atendido(a)"); // [cite: 96]
            
        }
    }

    // Método para pesquisar cidade e listar profissionais disponíveis nela
    public void pesquisarCidade(String cidade, ArrayList<Profissionais> listaDeProfissionais) { // 
        this.setCidadeAtend(cidade);
        System.out.println("Pesquise o serviço da sua preferência"); 
        System.out.println("Seguem os profissionais em " + getCidadeAtend() +
                " que realizam atendimentos:");
        System.out.println("LISTA DE PROFISSIONAIS NA CIDADE:"); 

        boolean encontrouProfissional = false;
        for (Profissionais p : listaDeProfissionais) {
            // Verifica se o profissional atende na cidade
            if (p.getCidadeAtend() != null && p.getCidadeAtend().equalsIgnoreCase(cidade)) {
                apresentarProfissional(p); 
                encontrouProfissional = true;
            }
        }
        if (!encontrouProfissional) {
            System.out.println("Nenhum profissional encontrado nesta cidade.");
        }
    }

    // Método para pesquisar serviço e listar profissionais que o oferecem
    public void pesquisarServico(String servico, ArrayList<Profissionais> listaDeProfissionais) { // 
        this.servicoSolic = servico; 
        System.out.println("Seguem os profissionais que realizam o atendimento de " + getServicoSolic() + ":"); // [cite: 104]
        System.out.println("LISTA DE PROFISSIONAIS POR SERVIÇO:");

        boolean encontrouProfissional = false;
        for (Profissionais p : listaDeProfissionais) {
            // Verifica se o profissional oferece o serviço solicitado
            // Supondo que Profissionais tenha um método para verificar se oferece um serviço
            if (p.ofereceServico(servico)) {
                apresentarProfissional(p); // Apresenta o profissional 
                encontrouProfissional = true;
            }
        }
        if (!encontrouProfissional) {
            System.out.println("Nenhum profissional encontrado que ofereça este serviço.");
        }
    }

    // Método para apresentar detalhes de um profissional
    public void apresentarProfissional(Profissionais profissional) { // 
        this.profissionalEscolhido = profissional; 
        System.out.println("--- Dados do Profissional ---");
        System.out.println("Nome: " + profissional.getNome());
        System.out.println("Cidade de Atendimento: " + profissional.getCidadeAtend());
        System.out.println("Biografia: " + profissional.getBiografia()); 
        System.out.println("Serviço Principal: " + profissional.getServicoPrincipal());
        System.out.println("Serviços Oferecidos:");
        profissional.listarServicos(); 
        System.out.println("Avaliação Média: " + profissional.getAvaliacao());
        System.out.println("-----------------------------");
    }
    
    public void selecionarProfissional(Profissionais profissionalSelecionado) { // 
        this.profissionalEscolhido = profissionalSelecionado;
        System.out.println("Profissional " + profissionalSelecionado.getNome() + " selecionado com sucesso!");
    }

    public void verificarAgenda(Profissionais profissional) { 
        System.out.println("Verificando agenda de " + profissional.getNome() + ":");
        System.out.println("Datas Disponíveis: " + profissional.getDatasDispon());
        System.out.println("Horários Disponíveis: " + profissional.getHorariosDispon());
        // Aqui o cliente veria as datas e horários e escolheria um
    }

    public void escolherData(String data) { 
        System.out.println("Data escolhida para o agendamento: " + data);
    }

    public void escolherHorario(String horario) { 
        System.out.println("Horário escolhido para o agendamento: " + horario);
    }

    public void escolherPagamento(String formaPagamento) { 
        System.out.println("Forma de pagamento escolhida: " + formaPagamento);
        // Aqui o sistema apresenta opções (cartão, pix, saldo)
    }

    public void depositar(float valor) { 
        setSaldo(getSaldo() + valor);
        System.out.println("Depósito de R$" + valor + " realizado com sucesso. Novo saldo: R$" + getSaldo());
    }

    public void confirmarAgendamento(Agendamento agendamento) {
        System.out.println("Agendamento confirmado com sucesso!");
        System.out.println("Detalhes: " + agendamento.getCliente().getNome() + " com " + agendamento.getProfissional().getNome() + " em " 
        + agendamento.getData() + " às " + agendamento.getHorario());
    }

    public void realizarCheckIn() { 
        System.out.println("Check-in realizado com sucesso!"); 
        
    }

    public void realizarCheckOut() {
        System.out.println("Check-out realizado com sucesso!");
        setQntAtendimento(getQntAtendimento() + 1); 
        System.out.println("Por favor, avalie o atendimento"); 
    }

    // Métodos especiais (Getters e Setters específicos de Clientes)
    public String getAgendar() { 
        return this.agendar; 
    }

    public void setAgendar(String s) { 
        this.agendar = s; 
    }

    public String getServicoSolic() { 
        return this.servicoSolic; 
    }

    public void setServicoSolic(String servicoSolic) { 
        this.servicoSolic = servicoSolic; 
    }

    public int getQntAtendimento() { 
        return this.qntAtendimento; 
    }

    public void setQntAtendimento(int qntAtendimento) { 
        this.qntAtendimento = qntAtendimento; 
    }

    public float getAvaliacaoCliente() { 
        return this.avaliacaoCliente; 
    }

    public void setAvaliacaoCliente(float f) { 
        this.avaliacaoCliente = f; 
    }

    public float getNotaCliente() { 
        return this.notaCliente;
    }

    public void setNotaCliente(float f) { 
        this.notaCliente = f;
        
        if (this.qntAtendimento > 0) {
            this.avaliacaoCliente = (this.avaliacaoCliente * (this.qntAtendimento - 1) + f) / this.qntAtendimento; // Lógica para média
        } else {
            this.avaliacaoCliente = f; 
        }
    }
}