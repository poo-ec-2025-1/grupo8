public class AvaliarCliente { 
    public Profissionais profissional; 
    public Clientes cliente; 
    public float nota; 
    public String comentario; 

    public AvaliarCliente(Profissionais p, Clientes c, float n, String comentario) {
        this.profissional = p; 
        this.cliente = c; 
        this.nota = n;
        this.comentario = comentario;

        if (c.getQntAtendimento() > 0) { 
            float novaAvaliacaoMedia = ((c.getAvaliacaoCliente() * c.getQntAtendimento()) + n) / (c.getQntAtendimento() + 1);
            c.setAvaliacaoCliente(novaAvaliacaoMedia);
        } else { 
            c.setAvaliacaoCliente(n);
            c.setQntAtendimento(1); 
        }

        System.out.println("Cliente " + c.getNome() + " avaliado com nota " + n + " e comentário: '" + comentario + "'");
        System.out.println("Nova avaliação média do cliente: " + c.getAvaliacaoCliente());
    }

    // Métodos Getters e Setters
    public Profissionais getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissionais profissional) {
        this.profissional = profissional;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    // Método toString 
    @Override
    public String toString() {
        return "Avaliação de " + cliente.getNome() + " para " + profissional.getNome() + // [cite: 458]
                ": nota " + nota + " - " + comentario; 
    }
}