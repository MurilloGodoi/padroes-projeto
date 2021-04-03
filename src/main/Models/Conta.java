package Models;

public abstract class Conta {
  protected Double saldo;
  protected Integer numero;
  protected Integer id;
  protected Integer clienteId;

  public Conta(Double saldo, Integer numero) {
    this.saldo = saldo;
    this.numero = numero;
  }

  public void sacar(Double valorSacado) {
    this.saldo -= valorSacado;
  }

  public void depositar(Double valorDepositado) {
    this.saldo += valorDepositado;
  }

  public Double getSaldo() {
    return saldo;
  }

  public Integer getNumero() {
    return numero;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getClienteId() {
    return clienteId;
  }

  public void setClienteId(Integer clienteId) {
    this.clienteId = clienteId;
  }

  @Override
  public String toString() {
    return "Conta [numero=" + numero + ", saldo=" + saldo + "]";
  }
}
