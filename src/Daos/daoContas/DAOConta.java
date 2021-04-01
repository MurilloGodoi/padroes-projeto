package projeto;

import java.util.List;

public interface DAOConta<T> {

  public void criarConta(T o);

  public Double getSaldo(T o);

  public void sacar(T o);

  public void depositar(T o);

  public List<T> getListaTodosClientes();

}