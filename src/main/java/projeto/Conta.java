package projeto;

public class Conta {
  private Double saldo;
  private Integer numero;
  private Cliente cliente;

  public Conta(Double saldo, Integer numero, Cliente cliente) {
    this.saldo = saldo;
    this.numero = numero;
    this.cliente = cliente;
  }

  private void sacar(Double valorSacado) {
    this.saldo -= valorSacado;
  }

  private void depositar(Double valorDepositado) {
    this.saldo += valorDepositado;
  }

  public Double getSaldo() {
    return saldo;
  }

  @Override
  public String toString() {
    return "Conta [cliente=" + cliente + ", numero=" + numero + ", saldo=" + saldo + "]";
  }

}
