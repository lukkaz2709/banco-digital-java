import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BancoDigital {
    private List<ContaBancaria> contas;

    public BancoDigital() {
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(ContaBancaria conta) {
        this.contas.add(conta);
        System.out.println("Conta " + conta.getNumeroConta() + " adicionada ao banco.");
    }

    public ContaBancaria buscarConta(String numeroConta) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
        }
        System.out.println("Conta " + numeroConta + " não encontrada.");
        return null;
    }

    public void realizarOperacao(Scanner scanner) {
        System.out.println("\nEscolha a operação:");
        System.out.println("1 - Depositar");
        System.out.println("2 - Sacar");
        System.out.println("3 - Exibir Saldo");
        System.out.println("4 - Aplicar Juros (Conta Poupança)");
        System.out.println("0 - Sair");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        if (opcao == 0) {
            System.out.println("Obrigado por utilizar o Banco Digital!");
            return;
        }

        System.out.print("Digite o número da conta: ");
        String numeroConta = scanner.nextLine();
        ContaBancaria conta = buscarConta(numeroConta);

        if (conta != null) {
            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a depositar: R$");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Digite o valor a sacar: R$");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    conta.exibirSaldo();
                    break;
                case 4:
                    if (conta instanceof ContaPoupanca) {
                        ((ContaPoupanca) conta).aplicarJuros();
                    } else {
                        System.out.println("Operação disponível apenas para contas poupança.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        realizarOperacao(scanner); // Chama recursivamente para continuar as operações
    }
}