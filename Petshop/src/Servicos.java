public enum Servicos {
    HIGIENIZAR(1, "Higiene", 200.0),
    ATENDIMENTO_CLINICO(2, "Atendimento Clínico", 300.0),
    VACINACAO(3, "Vacinação", 755.0);
    private final int id;
    private final String nome;
    private final double valor;

    Servicos(int id, String nome, double valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public static Servicos getServicoById(int id) {
        for (Servicos servico : values()) {
            if (servico.getId() == id) {
                return servico;
            }
        }
        return null;
    }
}
