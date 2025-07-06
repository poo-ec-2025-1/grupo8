public class CancelamentoAtendimento { 
    public Agendamento agendamento; 
    private String motivoCancelamento; 

    public CancelamentoAtendimento(Agendamento ag) {
        this.agendamento = ag; 
        if (this.agendamento != null) {
            this.agendamento.setStatus("Cancelado");
            System.out.println("Agendamento de " + ag.getCliente().getNome() + " com " + ag.getProfissional().getNome() + " cancelado.");
        } else {
            System.out.println("Agendamento não encontrado para cancelamento.");
        }
    }

    public CancelamentoAtendimento(Agendamento ag, String motivo) {
        this(ag);
        this.motivoCancelamento = motivo;
        System.out.println("Motivo do cancelamento: " + motivo);
    }

    public Agendamento getAgendamento() { 
        return this.agendamento; 
    }

    public void setAgendamento(Agendamento ag) { 
        this.agendamento = ag; 
    }

    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }

    public void setMotivoCancelamento(String motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
    }
}