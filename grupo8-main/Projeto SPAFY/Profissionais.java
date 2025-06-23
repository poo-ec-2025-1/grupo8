public class Profissionais extends Usuarios{
    public String servicos;
    public float valor;
    public String endereco;
    public String biografia;
    public String datasDispon; //datas disponiveis
    public String horariosDispon; //horarios disponiveis
    public String datasAgend; //datas não disponíveis
    public String horariosAgend; //horarios não disponíveis
    
    //métodos da classe
    public void cadastrar(){
        
    }
    public void cadastrarServicos(){
        
    }
    public void cadastrarAgenda(){
        
    }
    public void verificarSaldo(){
        
    }
    public void sacar(){
        
    } 
    public void verificarAgenda(){
        
    }
    public void avaliarCliente(){
        
    }
    //métodos especiais
    public String getServicos(){
        return this.servicos;
    }
    public void setServicos(String servicos){
        this.servicos = servicos;
    }
    public float getValor(){
        return this.valor;
    }
    public void setValor(float v){
        this.valor = v;
    }
    public String getEndereco(){
        return this.endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public String getBiografia(){
        return this.biografia;
    }
    public void setBiografia(String biografia){
        this.biografia = biografia;
    }
    public String getDatasDispon(){
        return this.datasDispon;
    }
    public void setDatasDispon(String datasDispon){
        this.datasDispon = datasDispon;
    }
    public String horariosDispon(){
        return this.horariosDispon;
    }
    public void horariosDispon(String horariosDispon){
        this.horariosDispon = horariosDispon;
    }
    public String getDiasAgend(){
        return this.datasAgend;
    }
    public void setDiasAgend(String diasAgend){
        this.datasAgend = diasAgend;
    }
    public String horariosAgend(){
        return this.horariosAgend;
    }
    public void horariosAgend(String horariosAgend){
        this.horariosAgend = horariosAgend;
    }
    
}
