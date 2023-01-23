import java.util.Date;

public class EsquemaVacinal {
    private Date data;
    private Vacinas vacina;
    private String observacao;

    public EsquemaVacinal(Date data, Vacinas vacina, String observacao) {
        this.data = data;
        this.vacina = vacina;
        this.observacao = observacao;
    }

    public EsquemaVacinal() {

    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Vacinas getVacina() {
        return vacina;
    }

    public void setVacina(Vacinas vacina) {
        this.vacina = vacina;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
