import java.util.Scanner;

public class BancoDigitalApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BancoDigital banco = new BancoDigital();

        // Criando algumas contas para teste
        ContaCorrente cc1 = new ContaCorrente("12345-6", 500.0);
        ContaPoupanca cp1 = new ContaPoupanca("78901-2", 0.01); // 1% de juros mensal

        banco.adicionarConta(cc1);
        banco.adicionarConta(cp1);

        System.out.println("Bem-vindo ao Banco Digital!");
        banco.realizarOperacao(scanner);

        scanner.close();
    }
}