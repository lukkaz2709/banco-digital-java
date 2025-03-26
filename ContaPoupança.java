class ContaPoupanca extends Conta {
    private double taxaJurosMensal;

    public ContaPoupanca(String numeroConta, double taxaJurosMensal) {
        super(numeroConta);
        this.taxaJurosMensal = taxaJurosMensal;
    }

    public void aplicarJuros() {
        double juros = getSaldo() * taxaJurosMensal;
        depositar(juros);
        System.out.println("Juros de R$" + String.format("%.2f", juros) + " aplicados na conta poupança " + getNumeroConta() + ".");
    }
}

