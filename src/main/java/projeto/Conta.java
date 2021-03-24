package projeto;

public class Conta {
  private Double saldo;
  private Integer numero;
  private Cliente cliente;

  private void sacar(Double valorSacado) {
    this.saldo -= valorSacado;
  }

  private void depositar(Double valorDepositado) {
    this.saldo += valorDepositado;
  }

  public Double getSaldo() {
    return saldo;
  }

}
