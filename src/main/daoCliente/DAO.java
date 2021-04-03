package daoCliente;

import java.util.List;

import Models.Cliente;

public interface DAO<T> {

  public void adicionarCliente(T o);

  public Cliente retornarClienteUsandoNomeESenha(String nome, String senha);

  public boolean realizarLogin(String nome, String senha);

  public List<T> getListaTodosClientes();

}