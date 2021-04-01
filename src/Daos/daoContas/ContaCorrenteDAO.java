package projeto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConnectionFactory;
import Models.ContaCorrente;
import Models.Cliente;

public class ContaCorrenteDAO implements DAOConta<ContaCorrente> {
  private Connection connection;

  public ClienteDAO() {
    this.connection = new ConnectionFactory().getConnection();
  }

  @Override

  public Double getSaldo(ContaCorrente conta) {
    String sql = "select saldo from ContaCorrente where client_id = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, cliente.getNome());

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

}
