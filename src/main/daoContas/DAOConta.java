package daoContas;

import java.util.List;

public interface DAOConta<T, J> {

  public void criarConta(T o, J ob);

  public Double getSaldo(J ob);

  public void sacar(J ob, Double valorDoSaque);

  public void depositar(J ob, Double valorDepositado);

  public List<T> getListaTodosClientes();

}