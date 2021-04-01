import java.util.List;

public interface DAO<T> {
	
	public void adicionarCliente(T o);

  public boolean realizarLogin(T o);

  public void sacar(T o);

  public void depositar(T o);

  public double getSaldo(T o);

	public List<T> getListaTodosClientes();
	
}