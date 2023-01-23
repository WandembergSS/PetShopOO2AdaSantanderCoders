import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Date;


public class Main {

    public static void main(String[] args) {
        //Crie o objeto Petshop
        Petshop petshop = new Petshop();

        //Crie no mínimo dois cliente, com pelo menos um deles tendo mais do que um pet
        Cliente cliente1 = new Cliente("João Silva", "joao@email.com", "123456789");

        List<Animal> cachorros = new ArrayList<>();
        cachorros.add(new Cachorro("Fido", new Date(), "Golden Retriever", Porte.MEDIO, 20.0, EstadoAnimal.LIMPO,
                new ArrayList<EsquemaVacinal>(), "", "Amarelo", true));
        cliente1.setPets(cachorros);

        Cliente cliente2 = new Cliente("Maria Santos", "maria@email.com", "987654321");
        List<Animal> pets = new ArrayList<>();
        pets.add(new Cachorro("Max", new Date(), "Golden Retriever", Porte.GRANDE, 20.0, EstadoAnimal.LIMPO,
                new ArrayList<EsquemaVacinal>(), "", "Amarelo", true));
        pets.add(new Gato("Mia", Vacinas.ANTIRABICA));
        cliente2.setPets(pets);

        //Chame o método atendimentoClinico do petshop, e faça-o retornar no campo observações
        // o pedido do médico para o pet tomar a vacina X
        ResponseVO atendimento = petshop.atendimentoClinico(cliente1, cliente1.getPets(), "ANTIRABICA");

        //Valide se o retorno do método atendimentoClinico possui o id do serviço, o serviço prestado,
        // o valor e valide principalmente, se há no campo observação do animal, o pedido do médico para a vacina
        if (atendimento.getId() == 2 && atendimento.getNome().equals("Atendimento Clinico") &&
                atendimento.getValor().equals(new BigDecimal("300.00")) && cliente1.getPets().get(0).getObservacoes().equals("ANTIRABICA")) {
            System.out.println("Atendimento Clinico realizado com sucesso.");
        } else {
            System.out.println("Erro no atendimento Clinico.");
        }

        //Chame o método vacinação do pet shop, e faça o pet tomar a vacina pedido no retorno do atendimentoClinico
        Vacinas vacina = Vacinas.getVacinaPorString("ANTIRABICA");
        ResponseVO vacination = petshop.vacinacao(cliente1, cliente1.getPets(), vacina, "Observacao");

        //Valide se o retorno do método vacinação possui o esquemaVacinal do pet preenchido com
        // o vacina que foi pedida, o id, o serviço prestado e o valor
        List<EsquemaVacinal> esquema = vacination.getCliente().getPets().get(0).getVacinas();
        String atual = String.valueOf(esquema.get(0).getVacina());
        if (String.valueOf(vacina).equals(atual)) {
            System.out.println("Vacina correta");
        } else {
            System.out.println("Vacina não está correta");
        }

        if (3 == vacination.getId()) {
            System.out.println("Correta");
        } else {
            System.out.println("Incorreta");
        }

        if ("VACINACAO".equals(vacination.getNome())) {
            System.out.println("Correta");
        } else {
            System.out.println("Incorreto");
        }

        if (vacination.getValor().compareTo(new BigDecimal(755.0)) == 0) {
            System.out.println("Correto");
        } else {
            System.out.println("Incorreto");
        }

        //Chame o método higienizar do petshop, e faça-o retornar no campo estado do animal, um valor
        // referente ao serviço prestado ex: se chamou o método apenas pedindo para dar banho, o animal
        // deverá estar limpo no retorno do método
        ResponseVO higienizacao = petshop.higienizar(cliente1, cliente1.getPets(), Higiene.BANHO, "Banho realizado com sucesso");
        if (higienizacao.getId() == 1 && higienizacao.getNome().equals("Higiene") && higienizacao.getValor().compareTo(new BigDecimal(200.0)) == 0 &&
                cliente1.getPets().get(0).getEstado().equals(EstadoAnimal.LIMPO)) {
            System.out.println("Higienização feita com sucesso");
        } else {
            System.out.println("Higienização falhou");
        }

        //Chame os métodos verRemedio e verAlimentos
        petshop.verRemedios();
        petshop.verAlimentos();

        // Por último, passe para o método pagamentos, a lista de todos os ids do serviços utilizados mais pelo
        // menos 1 remédio e 1 alimento e valide se a soma dos valores do pedido do cliente está correta
        List<Integer> servicosUsados = new ArrayList<>();
        servicosUsados.add(atendimento.getId());
        servicosUsados.add(vacination.getId());
        servicosUsados.add(higienizacao.getId());

        Remedio remedio = new Remedio(1, "Azium", new BigDecimal(31.9));
        Alimento alimento = new Alimento(1, "Biscoito", new BigDecimal(20.0));

        List<Remedio> remedios = new ArrayList<>(Arrays.asList(remedio));
        List<Alimento> alimentos = new ArrayList<>(Arrays.asList(alimento));

        petshop.addRemedio(remedio);
        petshop.addAlimento(alimento);

        double valorTotal = petshop.pagamento(servicosUsados, remedios, alimentos);
        double valorEsperado = atendimento.getValor().doubleValue() + vacination.getValor().doubleValue() +
                higienizacao.getValor().doubleValue() + 31.9 + 20.0;

        Double diferenca = valorEsperado - valorTotal;
        if (valorEsperado == valorTotal) {
            System.out.println("A soma está correta");
        } else {
            System.out.println("A soma está incorreta, porque os valores diferem de: " + diferenca.toString());
        }

    }
}