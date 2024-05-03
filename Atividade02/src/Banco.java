//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.List;

public class Banco {
    public static void main(String[] args) {
        SistemaBanco sistema = new SistemaBanco();

        // Criar algumas contas de exemplo
        ContaCorrente conta1 = new ContaCorrente("João", 1000.0, "123456", "001");
        ContaCorrente conta2 = new ContaCorrente("Maria", 2000.0, "789012", "002");

        sistema.cadastrarConta(conta1);
        sistema.cadastrarConta(conta2);

        // Realizar algumas operações
        sistema.sacar("123456", 500.0);
        sistema.sacar("789012", 1000.0);

        sistema.listarContas();
    }
}

class SistemaBanco {
    private List<ContaCorrente> contas;

    public SistemaBanco() {
        this.contas = new ArrayList<>();
    }

    public void cadastrarConta(ContaCorrente conta) {
        contas.add(conta);
    }

    public void removerConta(String numeroConta) {
        contas.removeIf(conta -> conta.getNumero().equals(numeroConta));
    }

    public void sacar(String numeroConta, double valor) {
        for (ContaCorrente conta : contas) {
            if (conta.getNumero().equals(numeroConta)) {
                conta.sacar(valor);
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    public void listarContas() {
        for (ContaCorrente conta : contas) {
            System.out.println(conta);
        }
    }
}

class ContaCorrente {
    private String nomeCliente;
    private double saldo;
    private String numero;
    private String agencia;

    public ContaCorrente(String nomeCliente, double saldo, String numero, String agencia) {
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
        this.numero = numero;
        this.agencia = agencia;
    }

    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
        } else {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        }
    }

    // Outros métodos para enviar e receber PIX podem ser adicionados aqui

    @Override
    public String toString() {
        return "Nome: " + nomeCliente + ", Saldo: R$" + saldo + ", Conta: " + numero + ", Agência: " + agencia;
    }
}
