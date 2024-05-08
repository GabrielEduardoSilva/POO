import java.util.*;

class SistemaEntregaPizzas {
    private int opcao = 4;

    private Queue<Pedido> filaPedidos = new LinkedList<>();
    private List<Entregador> entregadores = new ArrayList<>();
    private List<Pizza> pizzasSendoFeitas = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);;

    public SistemaEntregaPizzas() {

        this.entregadores.add(new Entregador("Entregador 1"));
        this.entregadores.add(new Entregador("Entregador 2"));
        this.entregadores.add(new Entregador("Entregador 3"));

    }

    public void init() {
        do {

            System.out.println("Qual ação deseja realizar? " +
                    "\n1 - Listar opções de pizzas " +
                    "\n2 - Receber pedido " +
                    "\n3 - Despachar pizzas para entrega " +
                    "\n4 - Listar pizzas pedidos " +
                    "\n0 - Sair");
            opcao = scanner.nextInt();

            switch(opcao) {
                case 0:
                    break;
                case 1:
                    listarOpcoesPizzas();
                    break;
                case 2:
                    receberPedido();
                    break;
                case 3:
                    iniciarProcessoEntrega();
                    break;
                case 4:
                    listarPedidos();
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
            }
        } while(opcao != 0);
    }

    public void listarOpcoesPizzas() {
        System.out.println("Opções de pizza: " +
                "\n1 - Marguerita " +
                "\n2 - Calabresa " +
                "\n3 - 4 Queijos " +
                "\n4 - Chocolate " +
                "\n5 - Strogonoff ");
    }

    public void receberPedido() {
        // Criando pedido
        Pedido pedido = new Pedido();

        // Nome
        System.out.println("Nome do cliente: ");
        pedido.setNomeCliente(scanner.nextLine());

        scanner.nextLine();

        // Telefone
        System.out.println("Telefone do cliente: ");
        pedido.setTelefone(scanner.nextLine());

        // Endereço
        System.out.println("Endereço: ");
        pedido.setEndereco(scanner.nextLine());

        // Sabor
        System.out.println("Sabor: ");
        pedido.setSabor(scanner.nextLine());

        // Tamanho
        System.out.println("Tamanho: ");
        pedido.setTamanho(scanner.nextLine());

        filaPedidos.add(pedido);
        System.out.println("Pedido recebido: " + pedido);
    }

    public void iniciarProcessoEntrega() {
        while (!filaPedidos.isEmpty()) {
            prepararPizzas();
            despacharPizzas();
        }
    }
    public void listarPedidos() {
        System.out.println("Fila de Pedidos:");
        for (Pedido pedido : filaPedidos) {
            System.out.println(pedido);
        }
    }

    private void prepararPizzas() {
        while (!filaPedidos.isEmpty() && pizzasSendoFeitas.size() < 6) {
            Pedido pedido = filaPedidos.poll();
            if (pedido != null ) {
                Pizza pizza = new Pizza(pedido.getSabor(), pedido.getTamanho());
                pizzasSendoFeitas.add(pizza);
                System.out.println("Pizza " + pizza.getSabor() + " (" + pizza.getTamanho() + ") sendo preparada.");
            } else {
                break;
            }
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
