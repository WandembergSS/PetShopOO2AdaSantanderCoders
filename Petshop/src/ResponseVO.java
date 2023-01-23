import java.math.BigDecimal;

public class ResponseVO {
    private int id;
    private String nome;
    private BigDecimal valor;
    private Cliente cliente;

    public ResponseVO(int id, String nome, BigDecimal valor, Cliente cliente) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.cliente = cliente;
    }


    public ResponseVO() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }



}
