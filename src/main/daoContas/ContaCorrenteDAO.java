package daoContas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Models.Cliente;
import Models.ContaCorrente;
import conexao.ConnectionFactory;


public class ContaCorrenteDAO implements DAOConta<ContaCorrente> {
  private Connection connection;

  public ContaCorrenteDAO() {
    this.connection = new ConnectionFactory().getConnection();
  }

  @Override

  public Double getSaldo(ContaCorrente conta) {
    String sql = "select saldo from ContaCorrente where client_id = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, conta.getNome());

      preparedStatement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override

  public void sacar(ContaCorrente conta, Cliente cliente, Double valorDoSaque) {
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

  public List<ContaCorrente> getListaTodosClientes() {

    return;

}
}
