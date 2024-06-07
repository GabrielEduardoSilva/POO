public class Paciente {
    private String nome;
    private int idade;
    private int nivelDor;
    private String pressao;
    private double altura;
    private double peso;
    private String medico;

    public Paciente(String nome, int idade, int nivelDor) {
        this.nome = nome;
        this.idade = idade;
        this.nivelDor = nivelDor;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getNivelDor() {
        return nivelDor;
    }

    public void setNivelDor(int nivelDor) {
        this.nivelDor = nivelDor;
    }

    public String getPressao() {
        return pressao;
    }

    public void setPressao(String pressao) {
        this.pressao = pressao;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nome: " + nome +
                ", idade: " + idade +
                ", nivelDor: " + nivelDor +
                ", pressao: " + pressao +
                ", altura: " + altura +
                ", peso: " + peso +
                ", medico: " + medico +
                '}';
    }
}
