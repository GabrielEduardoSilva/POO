// ALUNO: GABRIEL EDUARDO BARBOSA DA SILVA
// MATRICULA: UC22101937

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Livro> livros;

    public Pedido() {
        livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Livro livro : livros) {
            total += livro.getPreco() * livro.getQuantidade();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "livros: " + livros +
                ", valorTotal: " + calcularValorTotal() +
                '}';
    }
}
