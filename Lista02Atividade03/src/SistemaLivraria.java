// ALUNO: GABRIEL EDUARDO BARBOSA DA SILVA
// MATRICULA: UC22101937

import java.util.*;

public class SistemaLivraria {
    private Map<String, Livro> livros;
    private Editora editora;

    public SistemaLivraria() {
        livros = new HashMap<>();
        editora = new Editora();
    }

    public void adicionarLivro(String titulo, String autor, int quantidade, double preco) {
        Livro livro = new Livro(titulo, autor, quantidade, preco);
        livros.put(titulo, livro);
        System.out.println("Livro adicionado: " + livro);
    }

    public void removerLivro(String titulo) {
        Livro livroRemovido = livros.remove(titulo);
        if (livroRemovido != null) {
            System.out.println("Livro removido: " + livroRemovido);
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    public void consultarLivro(String titulo) {
        Livro livro = livros.get(titulo);
        if (livro != null) {
            System.out.println("Livro encontrado: " + livro);
            if (livro.getQuantidade() == 0) {
                editora.solicitarCompra(titulo);
            }
        } else {
            System.out.println("Livro não encontrado.");
            editora.solicitarCompra(titulo);
        }
    }

    public void consultarNovasEdicoes(String titulo) {
        editora.consultarNovasEdicoes(titulo);
    }

    public Pedido agruparLivrosEmPedido(List<String> titulos) {
        Pedido pedido = new Pedido();
        for (String titulo : titulos) {
            Livro livro = livros.get(titulo);
            if (livro != null && livro.getQuantidade() > 0) {
                pedido.adicionarLivro(livro);
            } else {
                System.out.println("Livro " + titulo + " não disponível em estoque.");
            }
        }
        return pedido;
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=== Sistema de Livraria ===");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Remover Livro");
            System.out.println("3. Consultar Livro");
            System.out.println("4. Consultar Novas Edições");
            System.out.println("5. Agrupar Livros em Pedido");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a nova linha
                    adicionarLivro(titulo, autor, quantidade, preco);
                    break;
                case 2:
                    System.out.print("Título do Livro a remover: ");
                    String tituloRemover = scanner.nextLine();
                    removerLivro(tituloRemover);
                    break;
                case 3:
                    System.out.print("Título do Livro a consultar: ");
                    String tituloConsultar = scanner.nextLine();
                    consultarLivro(tituloConsultar);
                    break;
                case 4:
                    System.out.print("Título do Livro para novas edições: ");
                    String tituloNovasEdicoes = scanner.nextLine();
                    consultarNovasEdicoes(tituloNovasEdicoes);
                    break;
                case 5:
                    List<String> titulos = new ArrayList<>();
                    System.out.println("Digite os títulos dos livros para o pedido (digite 'fim' para terminar): ");
                    while (true) {
                        String tituloPedido = scanner.nextLine();
                        if (tituloPedido.equalsIgnoreCase("fim")) {
                            break;
                        }
                        titulos.add(tituloPedido);
                    }
                    Pedido pedido = agruparLivrosEmPedido(titulos);
                    System.out.println(pedido);
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
}
