package projeto;

public abstract class Conta {
  protected Double saldo;
  protected Integer numero;
  protected Cliente cliente;
  protected Integer id;
  protected Integer userId;

  public Conta(Double saldo, Integer numero, Cliente cliente) {
    this.saldo = saldo;
    this.numero = numero;
    this.cliente = cliente;
  }

  void sacar(Double valorSacado) {
    this.saldo -= valorSacado;
  }
  
  void depositar(Double valorDepositado) {
    this.saldo += valorDepositado;
  }

  public Double getSaldo() {
    return saldo;
  }

  public Integer getNumero() {
    return numero;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }
  
  @Override
  public String toString() {
    return "Conta [cliente=" + cliente + ", numero=" + numero + ", saldo=" + saldo + "]";
  }
}
