import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface para as operações bancárias comuns a todos os tipos de conta
interface ContaBancaria {
    void depositar(double valor);
    void sacar(double valor);
    void exibirSaldo();
    String getNumeroConta();
}
