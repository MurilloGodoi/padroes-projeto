package Models;

public class ContaPoupanca extends Conta {
  private String dataAniversario;

  public ContaPoupanca(Double saldo, Integer numero, Cliente cliente, String dataAniversario) {
    super(saldo, numero, cliente);
    this.dataAniversario = dataAniversario;
  }

  public String getDataAniversario() {
    return dataAniversario;
  }

  @Override
  public String toString() {
    return "ContaPoupanca[cliente=" + cliente + ", numero=" + numero + ", saldo=" + saldo + ", dataAniversaio="
        + dataAniversario + "]";
  }
}
