// ALUNO: GABRIEL EDUARDO BARBOSA DA SILVA
// MATRICULA: UC22101937

public class Livro {
    private String titulo;
    private String autor;
    private int quantidade;
    private double preco;

    public Livro(String titulo, String autor, int quantidade, double preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo: " + titulo +
                ", autor: " + autor +
                ", quantidade: " + quantidade +
                ", preco: " + preco +
                '}';
    }
}
