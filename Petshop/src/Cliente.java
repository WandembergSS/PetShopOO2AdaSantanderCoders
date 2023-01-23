import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
    private int id;
    private List<Animal> pets;

    public Cliente() {
        super();
        this.pets = new ArrayList<Animal>();
    }


    public Cliente(int id, List<Animal> pets) {
        this.pets = new ArrayList<Animal>();
        this.id = id;
        this.pets.addAll(pets);
    }

    public Cliente(String nome, String email, String telefone) {
        this.pets = new ArrayList<Animal>();
        this.setNome(nome);
        this.setEmail(email);
        this.setTelefone(telefone);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Animal> getPets() {
        return this.pets;
    }

    public void setPets(List<Animal> pets) {
        this.pets.addAll(pets);
    }
}
