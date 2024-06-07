// ALUNO: GABRIEL EDUARDO BARBOSA DA SILVA
// MATRÍCULA: UC22101937

public class Aluno {
    private String nome;
    private int matricula;
    private String serie;
    private String periodo;

    public Aluno(String nome, int matricula, String serie, String periodo) {
        this.nome = nome;
        this.matricula = matricula;
        this.serie = serie;
        this.periodo = periodo;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome: " + nome +
                ", matricula: " + matricula +
                ", serie: " + serie +
                ", periodo: " + periodo +
                '}';
    }
}
