public class ProfessorDeMusica implements Cantor, Baterista, Guitarrista{
    @Override
    public void darAulaDeBateria() {
        System.out.println("Dando aula de bateria");
    }

    @Override
    public void darAulaDeCanto() {
        System.out.println("Dando aula de canto");
    }

    @Override
    public void darAulaDeGuitarra() {
        System.out.println("Dando aula de guitarra");
    }
}
