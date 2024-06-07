// ALUNO: GABRIEL EDUARDO BARBOSA DA SILVA
// MATRÍCULA: UC22101937

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class SistemaMatriculas {
    private Map<Integer, Aluno> alunos; // Map é tipo um "dicionário" do Python
    private Queue<Integer> matriculasDisponiveis; // A Queue do Java segue o princípio da fila mesmo
    private int proximaMatricula;

    public SistemaMatriculas() {
        alunos = new HashMap<>();
        matriculasDisponiveis = new LinkedList<>();
        proximaMatricula = 1;
    }

    public void adicionarAluno(String nome, String serie, String periodo) {
        // Gerando a matrícula
        int matricula = gerarMatricula();

        // Criando o aluno
        Aluno aluno = new Aluno(nome, matricula, serie, periodo);

        // Salvando o aluno
        alunos.put(matricula, aluno);

        System.out.println("Aluno adicionado: " + aluno);
    }

    public void removerAluno(int matricula) {
        // O Map do Java é bom porque posso encontrar um valor a partir de uma chave (ela não pode ser repetida)
        Aluno aluno = alunos.remove(matricula);

        if (aluno != null) {
            // Adicionando a matrícula do aluno como disponível
            matriculasDisponiveis.add(matricula);
            System.out.println("Aluno removido: " + aluno);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public void atualizarAluno(int matricula, String nome, String serie, String periodo) {
        // Encontrando o aluno (valor) pela matrícula (chave). O Map é mt bom slc
        Aluno aluno = alunos.get(matricula);
        if (aluno != null) {
            aluno.setNome(nome);
            aluno.setSerie(serie);
            aluno.setPeriodo(periodo);
            System.out.println("Aluno atualizado: " + aluno);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private int gerarMatricula() {
        if (!matriculasDisponiveis.isEmpty()) {
            // Se tiver alguma matrícula disponível, vai retornar a que estava disponível a mais tempo
            return matriculasDisponiveis.poll();
        } else {
            // Se não tiver nenhuma matrícula disponível, vai criar uma nova com base na última matrícula
            return proximaMatricula++;
        }
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=== Sistema de Matrículas ===");
            System.out.println("1. Adicionar Aluno");
            System.out.println("2. Remover Aluno");
            System.out.println("3. Atualizar Aluno");
            System.out.println("4. Listar Alunos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Série: ");
                    String serie = scanner.nextLine();
                    System.out.print("Período: ");
                    String periodo = scanner.nextLine();
                    adicionarAluno(nome, serie, periodo);
                    break;
                case 2:
                    System.out.print("Matrícula: ");
                    int matriculaRemover = scanner.nextInt();
                    removerAluno(matriculaRemover);
                    break;
                case 3:
                    System.out.print("Matrícula: ");
                    int matriculaAtualizar = scanner.nextInt();
                    scanner.nextLine(); // consumir a nova linha
                    System.out.print("Novo Nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Nova Série: ");
                    String novaSerie = scanner.nextLine();
                    System.out.print("Novo Período: ");
                    String novoPeriodo = scanner.nextLine();
                    atualizarAluno(matriculaAtualizar, novoNome, novaSerie, novoPeriodo);
                    break;
                case 4:
                    listarAlunos();
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno matriculado.");
        } else {
            System.out.println("=== Lista de Alunos ===");
            for (Aluno aluno : alunos.values()) {
                System.out.println(aluno);
            }
        }
    }
}
