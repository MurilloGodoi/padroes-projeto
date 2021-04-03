package Models;

public class ContaCorrente extends Conta {
  private Double limite;

  public ContaCorrente(Double saldo, Integer numero, Double limite) {
    super(saldo, numero);
    this.limite = limite;
  }

  public Double getLimite() {
    return limite;
  }

  public void setLimite(Double limite) {
    this.limite = limite;
  }

  @Override
  public String toString() {
    return "ContaCorrente [ numero=" + numero + ", saldo=" + saldo + ", limite=" + limite + "]";
  }
}
