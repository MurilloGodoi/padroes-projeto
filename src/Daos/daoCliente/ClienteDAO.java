import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConnectionFactory;
import Models.Cliente;

public class ClienteDAO implements DAO<Cliente> {
  private Connection connection;

  public ClienteDAO() {
    this.connection = new ConnectionFactory().getConnection();
  }

  @Override

  public void adicionarCliente(Cliente cliente) {
    String sql = "insert into clientes (nome, data_nascimento) values (? ,?)";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, cliente.getNome());
      preparedStatement.setString(2, cliente.getDataNascimento());

      preparedStatement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override

  public boolean realizarLogin(Cliente cliente) {
    String sql = "select name from Cliente where name = ?, senha = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, cliente.getNome());
      preparedStatement.setString(2, cliente.getSenha());
      ResultSet resultSet = preparedStatement.executeQuery();

      if (resultSet)
        return 1;
        
      return 0;
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
        Cliente cliente = new Cliente(id, nome, dataNascimento, senha);

        clientes.add(cliente);
      }
      return clientes;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }
}
