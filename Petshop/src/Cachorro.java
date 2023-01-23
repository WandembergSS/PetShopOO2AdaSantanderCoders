import java.util.Date;
import java.util.List;

public class Cachorro extends Animal {
    private String corPelo;
    private boolean temPeloLongo;

    public Cachorro(String nome, Date nascimento, String raca, Porte porte, Double peso, EstadoAnimal estado, List<EsquemaVacinal> vacinas, String observacoes, String corPelo, boolean temPeloLongo) {
        super(nome, nascimento, raca, porte, peso, estado, vacinas, observacoes);
        this.corPelo = corPelo;
        this.temPeloLongo = temPeloLongo;
    }

    public Cachorro(String nome, Porte porte) {
        super(nome, porte);
    }

    public Cachorro(String nome, int i, EstadoAnimal limpo, Porte medio) {
        super(nome, i, limpo, medio);
    }

    public String getCorPelo() {
        return corPelo;
    }

    public void setCorPelo(String corPelo) {
        this.corPelo = corPelo;
    }


    public boolean isTemPeloLongo() {
        return temPeloLongo;
    }

    public void setTemPeloLongo(boolean temPeloLongo) {
        this.temPeloLongo = temPeloLongo;
    }
}

