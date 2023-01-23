import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Petshop {
    private String cnpj;
    private Endereco endereco;
    private List<Alimento> alimento;
    List<Remedio> remedios;

    public Petshop() {
        // existing constructor code
        this.alimento = new ArrayList<>();
        this.remedios = new ArrayList<>();
    }

    public ResponseVO higienizar(Cliente cliente, List<Animal> animais, Higiene higiene, String observacao) {
        // implementation here
        int id = 1; // generate unique id for service
        String serviceName = "Higiene";
        BigDecimal value = new BigDecimal("200.00"); // set value for service
        for (Animal animal : animais) {
            animal.setEstado(EstadoAnimal.LIMPO); // set animal's state to "clean"
        }
        return new ResponseVO(id, serviceName, value, cliente);
    }

    public ResponseVO atendimentoClinico(Cliente cliente, List<Animal> animais, String observacao) {
        // implementation here
        int id = 2; // generate unique id for service
        String serviceName = "Atendimento Clinico";
        BigDecimal value = new BigDecimal("300.00"); // set value for service
        for (Animal animal : animais) {
            animal.setObservacoes(observacao); // set observation for animal
        }
        return new ResponseVO(id, serviceName, value, cliente);
    }

    public ResponseVO vacinacao(Cliente cliente, List<Animal> animais, Vacinas vacina, String observacao) {
        for (Animal animal : animais) {
            EsquemaVacinal esquema = new EsquemaVacinal();
            esquema.setData(new Date());
            esquema.setVacina(vacina);
            esquema.setObservacao(observacao);
            animal.getVacinas().add(esquema);
        }
        ResponseVO response = new ResponseVO();
        response.setId(3);
        response.setNome(String.valueOf(Servicos.VACINACAO));
        response.setValor(new BigDecimal("755.00"));
        response.setCliente(cliente);
        return response;
    }

    public void addAlimento(Alimento alimento) {

        this.alimento.add(alimento);
    }

    public void addRemedio(Remedio remedio) {
        this.remedios.add(remedio);
    }

    public void verAlimentos() {
        System.out.println("Exibindo lista de alimento disponíveis:");
        if (this.alimento == null) {
            System.out.println("Nenhum alimento disponível.");
        } else {
            for (Alimento a : this.alimento) {
                System.out.println("ID: " + a.getId() + " Nome: " + a.getNome() + " Preço: " + a.getPreco());
            }
        }
    }

    public void verRemedios() {
        System.out.println("Exibindo lista de remédios disponíveis:");
        if (this.remedios == null) {
            System.out.println("Não existe remédios.");
        } else {
            for (Remedio r : this.remedios) {
                System.out.println("ID: " + r.getId() + " Nome: " + r.getNome() + " Preço: " + r.getPreco());
            }
        }
    }

    public Remedio getRemedioById(int id) {
        for (Remedio remedio : remedios) {
            if (remedio.getId() == id) {
                return remedio;
            }
        }
        return null;
    }

    public Alimento getAlimentoById(int id) {
        for (Alimento alimento : alimento) {
            if (alimento.getId() == id) {
                return alimento;
            }
        }
        return null;
    }

    public double pagamento(List<Integer> itens, List<Remedio> remedios, List<Alimento> alimentos) {
        double total = 0;
        System.out.println("Serviçoes contratados:");
        for (Integer i : itens) {
            Servicos s = Servicos.getServicoById(i);
            if (s != null) {
                System.out.println(s.name() + ". Valor: " + s.getValor());
                total += s.getValor();
            } else {
                System.out.println("Nenhum serviço contratado");
            }
        }

        System.out.println("Remédios comprados:");
        if(remedios != null) {
            for (Remedio remedio : remedios) {
                System.out.println(remedio.getNome() + ". Valor: " + remedio.getPreco());
                total += remedio.getPreco().doubleValue();
            }
        } else {
            System.out.println("Nenhum remédio foi comprado.");
        }

        System.out.println("Alimentos comprados:");
        if(alimentos != null) {
            for (Alimento alimento : alimentos) {
                System.out.println(alimento.getNome() + ". Valor: " + alimento.getPreco());
                total += alimento.getPreco().doubleValue();
            }
        } else {
            System.out.println("Nenhum alimento foi comprado.");
        }

        return total;
    }


}