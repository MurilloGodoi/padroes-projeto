package Models;

public class ContaPoupanca extends Conta {
  private String dataAniversario;

  public ContaPoupanca(Double saldo, Integer numero, String dataAniversario) {
    super(saldo, numero);
    this.dataAniversario = dataAniversario;
  }

  public String getDataAniversario() {
    return dataAniversario;
  }

  @Override
  public String toString() {
    return "ContaPoupanca[numero=" + numero + ", saldo=" + saldo + ", dataAniversaio=" + dataAniversario + "]";
  }
}
