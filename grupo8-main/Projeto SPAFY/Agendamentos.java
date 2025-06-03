public class Agendamentos {

    public int diaAgendamento;
    public int mesAgendamento;
    public double horario;
    public String procedimento;
    public String pessoa;              //Cliente ou profissional


    public Agendamentos(int diaAgendamento, int mesAgendamento, double horario, String procedimento, String pessoa){

        this.diaAgendamento = diaAgendamento;
        this.mesAgendamento = mesAgendamento;
        this.horario = horario;
        this.procedimento = procedimento;
        this.pessoa = pessoa;
    
    }

    public void setDiaAgendamento(int dia){
        this.diaAgendamento = dia;
    } 

    public int getDiaAgendamento(){
        return this.diaAgendamento;
    }

    public void setMesAgendamento(int mes){
        if (mes <= 12 || mes > 0){
           this.mesAgendamento = mes;
        }
    } 

    public int getMesAgendamento(){
        return this.mesAgendamento;
    }
    
    public void setHorario(double horas){
        this.horario = horas;
    } 

     public double getHorario(){
        return this.horario;
    }

    public String getProcedimento(){
        return this.procedimento;
    }
    
    public void setProcedimento(String nome){
        this.procedimento = nome;
    } 

}
