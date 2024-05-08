class Entregador {
    private String nome;

    public Entregador(String nome) {
        this.nome = nome;
    }

    public void entregarPizza(Pizza pizza) {
        System.out.println("Pizza " + pizza.getSabor() + " (" + pizza.getTamanho() + ") sendo entregue por " + nome);
    }
}