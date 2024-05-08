import java.util.*;

public class SistemaBanco {
    private int opcao = 4;

    private List<Conta> contas = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);;

    public void init() {
        do {

            System.out.println("Qual ação deseja realizar? " +
                    "\n1 - Acessar conta " +
                    "\n2 - Cadastrar conta " +
                    "\n3 - Remover conta " +
                    "\n0 - Sair");
            opcao = scanner.nextInt();

            switch(opcao) {
                case 0:
                    break;
                case 1:
                    System.out.println("Numero da conta: ");
                    String contaStr = scanner.next();
                    for (Conta conta : contas) {
                        if (conta.getNumeroConta().equals(contaStr)) {
                            acessarConta(contaStr);
                        }
                    }
                    break;
                case 2:
                    cadastrarConta();
                    break;
                case 3:
                    removerConta();
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
            }
        } while(opcao != 0);
    }

    public void acessarConta(String numeroConta) {
        do {

            System.out.println("Qual ação deseja realizar? " +
                    "\n1 - Sacar " +
                    "\n2 - Enviar Pix " +
                    "\n0 - Sair");
            opcao = scanner.nextInt();

            switch(opcao) {
                case 0:
                    break;
                case 1:
                    System.out.println("Valor a ser sacado R$: ");
                    Double valor = scanner.nextDouble();
                    sacar(numeroConta, valor);
                    break;
                case 2:
                    System.out.println("Numero da conta que vai receber: ");
                    String contaStr = scanner.next();
                    System.out.println("Valor do pix R$: ");
                    Double valorPix = scanner.nextDouble();
                    enviarPix(numeroConta, contaStr, valorPix);
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
            }
        } while(opcao != 0);
    }

    public void cadastrarConta() {
        // Cadastrando conta
        Conta conta = new Conta();

        // Nome
        System.out.println("Nome do cliente: ");
        conta.setNomeCliente(scanner.nextLine());

        scanner.nextLine();

        // Número conta
        System.out.println("Número da conta: ");
        conta.setNumeroConta(scanner.next());

        // Agência
        System.out.println("Agência: ");
        conta.setAgencia(scanner.next());

        contas.add(conta);

        System.out.println("Conta cadastrada com sucesso.");
    }

    public void removerConta() {
        System.out.println("Numero da conta a ser removido: ");
        String contaStr = scanner.next();

        if (contaStr.isEmpty()) {
            return;
        }

        for (Conta conta: this.contas) {
            if (conta.getNomeCliente().equals(contaStr)) {
                contas.remove(conta);
                System.out.println("Conta removida com sucesso.");
                return;
            }
        }

        System.out.println("Conta não encontrada.");
    }

    public void sacar(String numeroConta, double valor) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                conta.sacar(valor);
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    public void enviarPix(String numeroConta, String numeroContaRecebedora, double valor) {
        Conta contaRecebedora = null;
        for (Conta contaRecebedoraFor : contas) {
            if (contaRecebedoraFor.getNumeroConta().equals(numeroContaRecebedora)) {
                contaRecebedora = contaRecebedoraFor;
                for (Conta conta : contas) {
                    if (conta.getNumeroConta().equals(numeroConta)) {
                        if (valor < conta.getSaldo()) {
                            conta.enviarPix(numeroContaRecebedora, valor);
                            contaRecebedora.receberPix(valor);
                        }
                    }
                }
            } else if (contaRecebedoraFor == contas.getLast()) {System.out.println("Conta não encontrada.");}
        }

    }
}