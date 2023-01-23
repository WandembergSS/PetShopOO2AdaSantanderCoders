import java.util.Date;
import java.util.List;

public class Gato extends Animal {
    private boolean castrado;

    public Gato(String nome, Date nascimento, String raca, Porte porte, Double peso, EstadoAnimal estado, List<EsquemaVacinal> vacinas, String observacoes, boolean castrado) {
        super(nome, nascimento, raca, porte, peso, estado, vacinas, observacoes);
        this.castrado = castrado;
    }

    public Gato(String nome, Vacinas vacina) {
        super(nome, vacina);
    }

    public boolean isCastrado() {
        return castrado;
    }

    public void setCastrado(boolean castrado) {
        this.castrado = castrado;
    }
}
