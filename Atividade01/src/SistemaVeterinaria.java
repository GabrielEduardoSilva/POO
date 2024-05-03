import java.util.*;

public class SistemaVeterinaria {
    private int opcao = 4;

    private Scanner scanner = new Scanner(System.in);;

    ArrayList<Animal> animais = new ArrayList<>();

    ArrayList<Consulta> consultas = new ArrayList<>();

    public void init() {
        do {

            System.out.println("Qual ação deseja realizar? " +
                    "\n1 - Adicionar animal " +
                    "\n2 - Remover animal " +
                    "\n3 - Listar animais " +
                    "\n4 - Buscar animal " +
                    "\n5 - Marcar consulta " +
                    "\n0 - Sair");
            opcao = scanner.nextInt();

            switch(opcao) {
                case 0:
                    break;
                case 1:
                    adicionarAnimal();
                    break;
                case 2:
                    removerAnimal();
                    break;
                case 3:
                    listarAnimais();
                    break;
                case 4:
                    buscarAnimal();
                    break;
                case 5:
                    marcarConsulta();
                    break;
                default:
                    System.out.println("Opção não válida, tente novamente!");
            }
        } while(opcao != 0);
    }

    private void adicionarAnimal() {
        // Adicionando animal
        Animal animal = new Animal();

        // Nome
        System.out.println("Nome do animal: ");
        animal.setNome(scanner.next());

        // Idade
        System.out.println("Anos de idade: ");
        animal.setIdade(scanner.nextInt());

        // Espécie
        System.out.println("Espécie: ");
        animal.setEspecie(scanner.next());

        // Tipo Sanguíneo
        System.out.println("Tipo Sanguíneo: ");
        animal.setTipoSanguineo(scanner.next());

        scanner.nextLine();

        // Vacinas tomadas
        System.out.println("Quais vacinas o animal tomou? ");
        animal.setVacinas(scanner.nextLine());

        // Saudável
        System.out.println("O animal está saudável? (S/N)");
        boolean saudavel = boolOption(scanner.next());
        animal.setSaudavel(saudavel);

        if (!saudavel) {
            // Doença
            System.out.println("Qual a doença do animal? ");
            animal.setDoenca(scanner.next());

            scanner.nextLine();

            // Remedios
            System.out.println("Quais os remédios o animal deve tomar? ");
            animal.setRemedios(scanner.nextLine());
        }

        animais.add(animal);

        System.out.println("Animal adicionado com sucesso.");
    }

    private void removerAnimal() {
        System.out.println("Nome do animal a ser removido: ");
        String animalStr = scanner.next();

        if (animalStr.isEmpty()) {
            return;
        }

        for (Animal animal: this.animais) {
            if (animal.nome.equals(animalStr)) {
                animais.remove(animal);
                System.out.println("Animal removido com sucesso.");
                return;
            }
        }

        System.out.println("Animal não encontrado.");
    }

    private void listarAnimais() {
        for (Animal animal: this.animais) {
            System.out.println("- " + animal.nome);
        }
        String buffer = scanner.nextLine();
    }

    private void buscarAnimal() {
        System.out.println("Nome do animal: ");
        String animalStr = scanner.next();

        if (animalStr.isEmpty()) {
            return;
        }

        for (Animal animal: this.animais) {
            if (animal.nome.equals(animalStr)) {

                System.out.println("Nome: " + animal.getNome()
                        + "\nIdade: " + animal.getIdade()
                        + "\nEspecie: " + animal.getEspecie()
                        + "\nTipoSanguineo: " + animal.getTipoSanguineo()
                        + "\nVacinas: " + animal.getVacinas()
                        + "\nStatus: " + animal.isSaudavel()
                        + "\nDoença: " + animal.getDoenca()
                        + "\nRemedios: " + animal.getRemedios());
                return;
            }
        }

        System.out.println("Animal não encontrado.");
    }

    private void marcarConsulta() {
        System.out.println("Marcar consulta para que animal? (Digite o número): ");

        int index = 0;

        // Listar animais
        for (Animal animal: this.animais) {

            System.out.println(Integer.toString(index + 1) + ". " + animal.nome);

            index++;
        }

        // Tentando marcar consulta
        try {
            int escolha = scanner.nextInt();
            scanner.nextLine();

            // Escolha inválida
            if (escolha - 1 < 0 || escolha - 1 > animais.size()) {
                System.out.println("Escolha inválida. Tente novamente.");
                marcarConsulta();
                return;
            }

            System.out.println("Digite a data da consulta (dd/mm/yyyy): ");
            String data = scanner.next();

            Consulta consulta = new Consulta(animais.get(escolha - 1), data);
            consultas.add(consulta);

            System.out.println("Consulta marcada com sucesso.");
        }  catch (Exception e) {
            System.out.println("Input inválido. Tentando novamente.");
            marcarConsulta();
        }
    }

    private boolean boolOption(String text) {
        return text.equals("S");
    }
}
