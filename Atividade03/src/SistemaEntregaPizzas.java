//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SistemaEntregaPizzas {
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();

        // Listar opções de pizzas
        restaurante.listarOpcoesPizzas();

        // Receber pedidos
        PedidoPizza pedido1 = new PedidoPizza("João", "123456789", "Rua A, 123", "marguerita", "grande");
        restaurante.receberPedido(pedido1);

        PedidoPizza pedido2 = new PedidoPizza("Maria", "987654321", "Rua B, 456", "calabresa", "família");
        restaurante.receberPedido(pedido2);

        // Iniciar o processo de preparo e entrega das pizzas
        restaurante.iniciarProcessoEntrega();
    }
}

class Restaurante {
    private List<String> opcoesPizzas;
    private Queue<PedidoPizza> filaPedidos;
    private List<Entregador> entregadores;
    private List<Pizza> pizzasSendoFeitas;

    public Restaurante() {
        this.opcoesPizzas = new ArrayList<>();
        this.opcoesPizzas.add("marguerita");
        this.opcoesPizzas.add("calabresa");
        this.opcoesPizzas.add("4 queijos");
        this.opcoesPizzas.add("chocolate");
        this.opcoesPizzas.add("strogonoff");

        this.filaPedidos = new LinkedList<>();
        this.entregadores = new ArrayList<>();
        this.entregadores.add(new Entregador("Entregador 1"));
        this.entregadores.add(new Entregador("Entregador 2"));
        this.entregadores.add(new Entregador("Entregador 3"));

        this.pizzasSendoFeitas = new ArrayList<>();
    }

    public void listarOpcoesPizzas() {
        System.out.println("Opções de pizzas disponíveis:");
        for (String pizza : opcoesPizzas) {
            System.out.println("- " + pizza);
        }
    }

    public void receberPedido(PedidoPizza pedido) {
        filaPedidos.add(pedido);
        System.out.println("Pedido recebido: " + pedido);
    }

    public void iniciarProcessoEntrega() {
        while (!filaPedidos.isEmpty()) {
            prepararPizzas();
            despacharPizzas();
        }
    }

    private void prepararPizzas() {
        int pizzasPreparadas = 0;
        while (!filaPedidos.isEmpty() && pizzasPreparadas < 6) {
            PedidoPizza pedido = filaPedidos.poll();
            Pizza pizza = new Pizza(pedido.getSabor(), pedido.getTamanho());
            pizzasSendoFeitas.add(pizza);
            System.out.println("Pizza " + pizza.getSabor() + " (" + pizza.getTamanho() + ") sendo preparada.");
            pizzasPreparadas++;
        }
    }

    private void despacharPizzas() {
        for (Pizza pizza : pizzasSendoFeitas) {
            Entregador entregador = escolherEntregador();
            entregador.entregarPizza(pizza);
        }
        pizzasSendoFeitas.clear();
    }

    private Entregador escolherEntregador() {
        // Simplesmente escolhe o próximo entregador na lista circular
        Entregador entregador = entregadores.remove(0);
        entregadores.add(entregador);
        return entregador;
    }
}

class PedidoPizza {
    private String nomeCliente;
    private String telefone;
    private String endereco;
    private String sabor;
    private String tamanho;

    public PedidoPizza(String nomeCliente, String telefone, String endereco, String sabor, String tamanho) {
        this.nomeCliente = nomeCliente;
        this.telefone = telefone;
        this.endereco = endereco;
        this.sabor = sabor;
        this.tamanho = tamanho;
    }

    public String getSabor() {
        return sabor;
    }

    public String getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        return "Pedido de " + sabor + " (" + tamanho + ") para " + nomeCliente + ", telefone " + telefone + ", endereço " + endereco;
    }
}

class Pizza {
    private String sabor;
    private String tamanho;

    public Pizza(String sabor, String tamanho) {
        this.sabor = sabor;
        this.tamanho = tamanho;
    }

    public String getSabor() {
        return sabor;
    }

    public String getTamanho() {
        return tamanho;
    }
}

class Entregador {
    private String nome;

    public Entregador(String nome) {
        this.nome = nome;
    }

    public void entregarPizza(Pizza pizza) {
        System.out.println("Pizza " + pizza.getSabor() + " (" + pizza.getTamanho() + ") sendo entregue por " + nome);
    }
}
