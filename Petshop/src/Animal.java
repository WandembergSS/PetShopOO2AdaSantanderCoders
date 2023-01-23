import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Animal extends ArrayList<Animal> {
    private String nome;
    private Date nascimento;
    private String raca;
    private Porte porte;
    private Double peso;
    private EstadoAnimal estado;
    private List<EsquemaVacinal> vacinas;
    private String observacoes;


    public Animal(String nome, Date nascimento, String raca, Porte porte, Double peso, EstadoAnimal estado, List<EsquemaVacinal> vacinas, String observacoes) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.raca = raca;
        this.porte = porte;
        this.peso = peso;
        this.estado = estado;
        this.vacinas = vacinas;
        this.observacoes = observacoes;
    }

    public Animal(String nome, Vacinas porte) {
    }

    public Animal(String nome, int i, EstadoAnimal limpo, Porte medio) {
    }

    public Animal(String nome, Porte porte) {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Porte getPorte() {
        return porte;
    }

    public void setPorte(Porte porte) {
        this.porte = porte;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public EstadoAnimal getEstado() {
        return estado;
    }

    public void setEstado(EstadoAnimal estado) {
        this.estado = estado;
    }

    public List<EsquemaVacinal> getVacinas() {
        return vacinas;
    }

    public void setVacinas(List<EsquemaVacinal> vacinas) {
        this.vacinas = vacinas;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }


}
