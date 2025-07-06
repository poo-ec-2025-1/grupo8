
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Clientes> listaClientes = new ArrayList<>();
    private static ArrayList<Profissionais> listaProfissionais = new ArrayList<>();
    private static ArrayList<Agendamento> listaAgendamentos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Spafy!");

        System.out.println("\n--- Cadastro de Usuários ---");

        Clientes cliente1 = new Clientes("Ana Silva", "15/03/1990", 123456789, "Cliente", "anasilva", "senha123");
        cliente1.cadastrarCliente();
        cliente1.setSaldo(100.0f); 
        listaClientes.add(cliente1);

        Profissionais prof1 = new Profissionais("Pedro Mendes", "20/07/1985", 987654321, "Profissional", "pedrom", "senhaabc", "Massagem Relaxante", "Rua das Flores, 100", "Especialista em relaxamento e bem-estar.", "São Paulo");
        prof1.cadastrarProfissional();
        prof1.setSaldo(50.0f); 
        listaProfissionais.add(prof1);

        // Adicionando serviços ao profissional
        prof1.cadastrarServico("Massagem Relaxante", 80.0f);
        prof1.cadastrarServico("Massagem Terapêutica", 120.0f);
        prof1.setDatasDispon("Seg, Qua, Sex");
        prof1.setHorariosDispon("09:00-12:00, 14:00-18:00");

        Profissionais prof2 = new Profissionais("Maria Oliveira", "10/01/1992", 112233445, "Profissional", "mariaoli", "pass123", "Manicure", "Av. Principal, 500", "Dedicação e arte para suas unhas.", "São Paulo");
        prof2.cadastrarProfissional();
        prof2.cadastrarServico("Manicure", 30.0f);
        prof2.cadastrarServico("Pedicure", 40.0f);
        prof2.setDatasDispon("Ter, Qui");
        prof2.setHorariosDispon("10:00-13:00, 15:00-19:00");
        listaProfissionais.add(prof2);


        // 2. Cliente realiza agendamento ---
        System.out.println("\n--- Cliente realizando agendamento ---");
        cliente1.realizarNovoAgendamento("SIM");
        String cidadeCliente = "São Paulo";
        cliente1.pesquisarCidade(cidadeCliente, listaProfissionais);

        String servicoDesejado = "Massagem Relaxante";
        cliente1.pesquisarServico(servicoDesejado, listaProfissionais);

        Servicos servicoMassagem = null;
        for (Servicos s : prof1.listaServicos) { // Acessando listaServicos diretamente (pode ser via getter)
            if (s.getNomeServico().equalsIgnoreCase("Massagem Relaxante")) {
                servicoMassagem = s;
                break;
            }
        }

        if (servicoMassagem != null) {
            cliente1.selecionarProfissional(prof1);
            cliente1.verificarAgenda(prof1);

            String dataAgendamento = "2025-07-01";
            String horarioAgendamento = "10:00";
            cliente1.escolherData(dataAgendamento);
            cliente1.escolherHorario(horarioAgendamento);

            Agendamento agendamento1 = new Agendamento(cliente1, prof1, servicoMassagem, dataAgendamento, horarioAgendamento);
            listaAgendamentos.add(agendamento1);

            System.out.println("\n--- Realizando Pagamento ---");
            cliente1.escolherPagamento("Saldo Spafy");
            agendamento1.realizarPagamento(); // O pagamento atualiza o status do agendamento e saldos

            cliente1.confirmarAgendamento(agendamento1);
        } else {
            System.out.println("Serviço 'Massagem Relaxante' não encontrado para o profissional " + prof1.getNome());
        }

        // --- 3. Simulação de Check-in/Check-out e Avaliação ---
        System.out.println("\n--- Simulação de Check-in/Check-out e Avaliação ---");
        if (!listaAgendamentos.isEmpty()) {
            Agendamento ag = listaAgendamentos.get(0); // Pegando o primeiro agendamento para simular

            ag.getCliente().realizarCheckIn(); // Cliente faz check-in
            ag.getProfissional().realizarCheckIn(); // Profissional faz check-in

            System.out.println("\nAtendimento em andamento...");
            System.out.println("...");

            ag.getCliente().realizarCheckOut(); // Cliente faz check-out
            ag.getProfissional().realizarCheckOut(); // Profissional faz check-out

            // Cliente avalia o profissional
            System.out.println("\n--- Cliente avaliando profissional ---");
            AvaliarProfissional avaliaProf = new AvaliarProfissional(cliente1, prof1, 4.5f, "Excelente massagem, muito relaxante!");

            // Profissional pode avaliar o cliente (opcional)
            System.out.println("\n--- Profissional avaliando cliente ---");
            AvaliarCliente avaliaCli = new AvaliarCliente(prof1, cliente1, 5.0f, "Cliente muito pontual e educado!");

            System.out.println("\nAvaliação do Profissional: " + prof1.getAvaliacao());
            System.out.println("Avaliação do Cliente: " + cliente1.getAvaliacaoCliente());
        }

        // --- 4. Cancelamento de Agendamento ---
        System.out.println("\n--- Teste de Cancelamento de Agendamento ---");
        // Criar um novo agendamento para cancelar
        Clientes cliente2 = new Clientes("Bruno Costa", "01/01/2000", 998877665, "Cliente", "brunoc", "segura");
        listaClientes.add(cliente2);
        cliente2.setSaldo(200.0f);

        Profissionais prof3 = new Profissionais("Carla Souza", "11/11/1988", 223344556, "Profissional", "carlas", "segredos", "Corte de Cabelo", "Rua da Beleza, 77", "Estilista com anos de experiência.", "São Paulo");
        prof3.cadastrarProfissional();
        prof3.cadastrarServico("Corte Feminino", 70.0f);
        listaProfissionais.add(prof3);

        Servicos servicoCorte = null;
        for (Servicos s : prof3.listaServicos) {
            if (s.getNomeServico().equalsIgnoreCase("Corte Feminino")) {
                servicoCorte = s;
                break;
            }
        }

        if (servicoCorte != null) {
            Agendamento agCancelavel = new Agendamento(cliente2, prof3, servicoCorte, "2025-07-05", "16:00");
            listaAgendamentos.add(agCancelavel);
            System.out.println("Agendamento criado para teste de cancelamento. Status: " + agCancelavel.getStatus());

            CancelamentoAtendimento cancelamento = new CancelamentoAtendimento(agCancelavel, "Mudança de planos do cliente.");
            System.out.println("Status do agendamento após tentativa de cancelamento: " + agCancelavel.getStatus());
        }

        // --- 5. Verificando saldos ---
        System.out.println("\n--- Verificação de Saldos Finais ---");
        System.out.println("Saldo de " + cliente1.getNome() + ": R$" + cliente1.getSaldo());
        System.out.println("Saldo de " + prof1.getNome() + ": R$" + prof1.getSaldo());
        System.out.println("Saldo de " + cliente2.getNome() + ": R$" + cliente2.getSaldo());
        System.out.println("Saldo de " + prof3.getNome() + ": R$" + prof3.getSaldo());


        scanner.close();
    }
}