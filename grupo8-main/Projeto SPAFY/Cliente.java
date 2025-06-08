public class Cliente extends Usuarios{

    public Cliente(String nome, String cidade, int telefone){
        super(nome, cidade, telefone);
    }

    //Método criado irá usar o nome do profissional e o nome da profissão do profissional
    public void agendar(int diaAgendamento, int mesAgendamento, double horario, String procedimento, String pessoa){
        Agendamento data = new Agendamentos(diaAgendamento, mesAgendamento, horario, procedimento, pessoa);
    }

}
