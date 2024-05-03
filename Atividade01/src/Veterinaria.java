//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Classe principal que contém o método main
public class Veterinaria {
    public static void main(String[] args) {
        SistemaVeterinaria sistema = new SistemaVeterinaria();

        // Exemplo de utilização do sistema
        Animal cachorro1 = new Cachorro("Rex", 5, "A+", true);
        sistema.adicionarAnimal(cachorro1);

        Animal gato1 = new Gato("Whiskers", 3, "B-", true);
        sistema.adicionarAnimal(gato1);

        sistema.listarAnimais();

        sistema.verFichaAnimal("Rex");

        Consulta consulta = new Consulta("Rotina de vacinação", "2024-05-03", "09:00");
        sistema.agendarConsulta("Rex", consulta);
    }
}

// Classe para representar o sistema de veterinária
class SistemaVeterinaria {
    private List<Animal> animais;
    private Map<String, Consulta> consultas; // Mapeia o nome do animal para suas consultas

    public SistemaVeterinaria() {
        this.animais = new ArrayList<>();
        this.consultas = new HashMap<>();
    }

    public void adicionarAnimal(Animal animal) {
        animais.add(animal);
    }

    public void removerAnimal(String nome) {
        animais.removeIf(animal -> animal.getNome().equals(nome));
    }

    public void listarAnimais() {
        for (Animal animal : animais) {
            System.out.println(animal);
        }
    }

    public void verFichaAnimal(String nome) {
        for (Animal animal : animais) {
            if (animal.getNome().equals(nome)) {
                System.out.println(animal);
                return;
            }
        }
        System.out.println("Animal não encontrado.");
    }

    public void agendarConsulta(String nomeAnimal, Consulta consulta) {
        consultas.put(nomeAnimal, consulta);
        System.out.println("Consulta agendada para " + nomeAnimal + ": " + consulta);
    }
}

// Classe abstrata para representar um animal
abstract class Animal {
    protected String nome;
    protected int idade;
    protected String tipoSanguineo;
    protected boolean saudavel;

    public Animal(String nome, int idade, String tipoSanguineo, boolean saudavel) {
        this.nome = nome;
        this.idade = idade;
        this.tipoSanguineo = tipoSanguineo;
        this.saudavel = saudavel;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Tipo Sanguíneo: " + tipoSanguineo + ", Saudável: " + saudavel;
    }
}

// Subclasses específicas de animais
class Cachorro extends Animal {
    public Cachorro(String nome, int idade, String tipoSanguineo, boolean saudavel) {
        super(nome, idade, tipoSanguineo, saudavel);
    }
}

class Gato extends Animal {
    public Gato(String nome, int idade, String tipoSanguineo, boolean saudavel) {
        super(nome, idade, tipoSanguineo, saudavel);
    }
}

// Classe para representar consultas
class Consulta {
    private String motivo;
    private String data;
    private String hora;

    public Consulta(String motivo, String data, String hora) {
        this.motivo = motivo;
        this.data = data;
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Motivo: " + motivo + ", Data: " + data + ", Hora: " + hora;
    }
}
