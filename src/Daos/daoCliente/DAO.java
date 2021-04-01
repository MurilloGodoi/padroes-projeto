import java.util.List;

public interface DAO<T> {

  public void adicionarCliente(T o);

  public boolean realizarLogin(T o);

  public List<T> getListaTodosClientes();

}