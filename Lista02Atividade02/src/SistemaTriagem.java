import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaTriagem {
    private List<Paciente> pacientes;

    public SistemaTriagem() {
        pacientes = new ArrayList<>();
    }

    public void adicionarPaciente(String nome, int idade, int nivelDor) {
        Paciente paciente = new Paciente(nome, idade, nivelDor);
        pacientes.add(paciente);
        System.out.println("Paciente adicionado: " + paciente);
    }

    public void removerPaciente(String nome) {
        Paciente pacienteRemover = null;
        for (Paciente paciente : pacientes) {
            if (paciente.getNome().equalsIgnoreCase(nome)) {
                pacienteRemover = paciente;
                break;
            }
        }
        if (pacienteRemover != null) {
            pacientes.remove(pacienteRemover);
            System.out.println("Paciente removido: " + pacienteRemover);
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    public void atualizarPaciente(String nome, String novoNome, int idade, int nivelDor, String pressao, double altura, double peso, String medico) {
        for (Paciente paciente : pacientes) {
            if (paciente.getNome().equalsIgnoreCase(nome)) {
                paciente.setNome(novoNome);
                paciente.setIdade(idade);
                paciente.setNivelDor(nivelDor);
                paciente.setPressao(pressao);
                paciente.setAltura(altura);
                paciente.setPeso(peso);
                paciente.setMedico(medico);
                System.out.println("Paciente atualizado: " + paciente);
                return;
            }
        }
        System.out.println("Paciente não encontrado.");
    }

    public void realizarTriagem() {
        for (Paciente paciente : pacientes) {
            if (paciente.getNivelDor() <= 3) {
                medirDadosPaciente(paciente);
            }
            identificarMedico(paciente);
        }
    }

    private void medirDadosPaciente(Paciente paciente) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Medindo dados do paciente: " + paciente.getNome());
        System.out.print("Pressão: ");
        paciente.setPressao(scanner.nextLine());
        System.out.print("Altura (em metros): ");
        paciente.setAltura(scanner.nextDouble());
        System.out.print("Peso (em kg): ");
        paciente.setPeso(scanner.nextDouble());
        scanner.nextLine(); // Consumir a nova linha
        System.out.println("Dados medidos: " + paciente);
    }

    private void identificarMedico(Paciente paciente) {
        // Exemplo simples de identificação de médico
        if (paciente.getNivelDor() <= 3) {
            paciente.setMedico("Clinico Geral");
        } else {
            paciente.setMedico("Especialista em Dor");
        }
        System.out.println("Paciente " + paciente.getNome() + " será atendido por: " + paciente.getMedico());
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=== Sistema de Triagem de Hospital ===");
            System.out.println("1. Adicionar Paciente");
            System.out.println("2. Remover Paciente");
            System.out.println("3. Atualizar Paciente");
            System.out.println("4. Realizar Triagem");
            System.out.println("5. Listar Pacientes");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    System.out.print("Nível de Dor (1-5): ");
                    int nivelDor = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    adicionarPaciente(nome, idade, nivelDor);
                    break;
                case 2:
                    System.out.print("Nome do Paciente a remover: ");
                    String nomeRemover = scanner.nextLine();
                    removerPaciente(nomeRemover);
                    break;
                case 3:
                    System.out.print("Nome do Paciente a atualizar: ");
                    String nomeAtualizar = scanner.nextLine();
                    System.out.print("Novo Nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Idade: ");
                    int novaIdade = scanner.nextInt();
                    System.out.print("Nível de Dor (1-5): ");
                    int novoNivelDor = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    System.out.print("Pressão: ");
                    String pressao = scanner.nextLine();
                    System.out.print("Altura (em metros): ");
                    double altura = scanner.nextDouble();
                    System.out.print("Peso (em kg): ");
                    double peso = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a nova linha
                    System.out.print("Médico: ");
                    String medico = scanner.nextLine();
                    atualizarPaciente(nomeAtualizar, novoNome, novaIdade, novoNivelDor, pressao, altura, peso, medico);
                    break;
                case 4:
                    realizarTriagem();
                    break;
                case 5:
                    listarPacientes();
                    break;
                case 6:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    public void listarPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente registrado.");
        } else {
            System.out.println("=== Lista de Pacientes ===");
            for (Paciente paciente : pacientes) {
                System.out.println(paciente);
            }
        }
    }
}
