import java.util.ArrayList;

public class Animal {
    String nome;
    int idade;
    String especie;
    String tipoSanguineo;
    String vacinas;
    boolean saudavel;
    String doenca;
    String remedios;

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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getVacinas() {
        return vacinas;
    }

    public void setVacinas(String vacinas) {
        this.vacinas = vacinas;
    }

    public String isSaudavel() {
        if (saudavel) {
            return "Saudável";
        } else return "Doente";
    }

    public void setSaudavel(boolean saudavel) {
        this.saudavel = saudavel;
    }

    public String getDoenca() {
        if (doenca == null) {
            return "Não está doente";
        } else return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    public String getRemedios() {
        if (remedios == null) {
            return "Sem remédios";
        } else return remedios;
    }

    public void setRemedios(String remedios) {
        this.remedios = remedios;
    }
}
