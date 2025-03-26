class ContaCorrente extends Conta {
    private double limiteChequeEspecial;

    public ContaCorrente(String numeroConta, double limiteChequeEspecial) {
        super(numeroConta);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && (getSaldo() + limiteChequeEspecial) >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque de R$" + String.format("%.2f", valor) + " realizado com sucesso na conta corrente " + getNumeroConta() + ".");
        } else if (valor <= 0) {
            System.out.println("Valor de saque inválido.");
        } else {
            System.out.println("Saldo insuficiente (incluindo cheque especial) na conta corrente " + getNumeroConta() + ".");
        }
    }

    @Override
    public void exibirSaldo() {
        System.out.println("Saldo da conta corrente " + getNumeroConta() + ": R$" + String.format("%.2f", getSaldo()) +
                           " (Limite Cheque Especial: R$" + String.format("%.2f", limiteChequeEspecial) + ")");
    }
}
