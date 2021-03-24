package projeto;

public class ContaCorrente extends Conta {
  private Double limite;

  public ContaCorrente(Double saldo, Integer numero, Cliente cliente, Double limite) {
    super(saldo, numero, cliente);
    this.limite = limite;
  }

  public Double getLimite() {
    return limite;
  }

  @Override
  void sacar(Double valorSacado) {
    this.saldo -= valorSacado;
  }

  @Override
  void depositar(Double valorDepositado) {
    this.saldo += valorDepositado;
  }

  @Override
  public String toString() {
    return "ContaCorrente [cliente=" + cliente + ", numero=" + numero + ", saldo=" + saldo + ", limite=" + limite + "]";
  }
}
