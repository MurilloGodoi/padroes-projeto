package projeto;

public abstract class Conta {
  protected Double saldo;
  protected Integer numero;
  protected Cliente cliente;

  public Conta(Double saldo, Integer numero, Cliente cliente) {
    this.saldo = saldo;
    this.numero = numero;
    this.cliente = cliente;
  }

  abstract void sacar(Double valorSacado);

  abstract void depositar(Double valorDepositado);

  public Double getSaldo() {
    return saldo;
  }

  @Override
  public String toString() {
    return "Conta [cliente=" + cliente + ", numero=" + numero + ", saldo=" + saldo + "]";
  }

}
