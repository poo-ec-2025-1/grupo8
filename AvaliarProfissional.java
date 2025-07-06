public class AvaliarProfissional {
    private Profissionais profissional; 
    private Clientes cliente; 
    private float nota; 
    private String comentario;

    // Construtor  
    public AvaliarProfissional(Clientes cliente, Profissionais prof, float n, String comentario) {
        this.cliente = cliente;
        this.profissional = prof; 
        this.nota = n; 
        this.comentario = comentario;

        if (prof.getQntAtend() > 0) { 
            float novaAvaliacaoMedia = ((prof.getAvaliacao() * prof.getQntAtend()) + n) / (prof.getQntAtend() + 1);
            prof.setAvaliacao(novaAvaliacaoMedia);
            prof.setQntAtend(prof.getQntAtend() + 1);
        } else { 
            prof.setAvaliacao(n);
            prof.setQntAtend(1);
        }
        System.out.println("Profissional " + prof.getNome() + " avaliado com nota " + n + " e comentário: '" + comentario + "'");
        System.out.println("Nova avaliação média do profissional: " + prof.getAvaliacao());
    }

    // Métodos Getters e Setters
    public float getNota() { 
        return this.nota; 
    }

    public void setNota(float n) {
        this.nota = n; 
    }

    public Profissionais getProfissional() { 
        return this.profissional; 
    }

    public void setProfissional(Profissionais prof) { 
        this.profissional = prof; 
    }

    public Clientes getCliente() {
        return this.cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Avaliação do Cliente " + cliente.getNome() + " para o Profissional " + profissional.getNome() +
                ": Nota " + nota + " - Comentário: \"" + comentario + "\"";
    }
}