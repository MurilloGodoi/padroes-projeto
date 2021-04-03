package daoCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Cliente;
import conexao.ConnectionFactory;

public class ClienteDAO implements DAO<Cliente> {
  private Connection connection;

  public ClienteDAO() {
    this.connection = new ConnectionFactory().getConnection();
  }

  @Override

  public void adicionarCliente(Cliente cliente) {
    String sql = "insert into Cliente (nome, data_nascimento, senha) values (? ,?, ?)";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, cliente.getNome());
      preparedStatement.setString(2, cliente.getDataNascimento());
      preparedStatement.setString(3, cliente.getSenha());

      preparedStatement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override

  public boolean realizarLogin(String nome, String senha) {
    String sql = "select name from Cliente where name = ?, senha = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, nome);
      preparedStatement.setString(2, senha);
      ResultSet resultSet = preparedStatement.executeQuery();

      if (resultSet != null)
        return true;

      return false;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Cliente> getListaTodosClientes() {
    List<Cliente> clientes = new ArrayList<>();

    String sql = "select * from cliente";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        Integer id = resultSet.getInt("id");
        String nome = resultSet.getString("nome");
        String dataNascimento = resultSet.getString("data_nascimento");
        String senha = resultSet.getString("senha");
        Cliente cliente = new Cliente(nome, dataNascimento, senha);
        cliente.setId(id);

        clientes.add(cliente);
      }
      return clientes;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override

  public Cliente retornarClienteUsandoNomeESenha(String nome, String senha) {
    String sql = "select id,nome,data_nascimento,senha from Cliente where nome = ? and senha = ? ";

    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, nome);
      preparedStatement.setString(2, senha);
      ResultSet resultSet = preparedStatement.executeQuery();
      System.out.println(resultSet);
      Integer idRetornado = resultSet.getInt("id");
      String nomeRetornado = resultSet.getString("nome");
      String dataNascimentoRetornado = resultSet.getString("data_nascimento");
      String senhaRetornado = resultSet.getString("senha");
      Cliente cliente = new Cliente(nomeRetornado, dataNascimentoRetornado, senhaRetornado);
      cliente.setId(idRetornado);

      return cliente;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

}
