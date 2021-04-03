package daoContas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Cliente;
import Models.ContaCorrente;
import conexao.ConnectionFactory;

public class ContaCorrenteDAO implements DAOConta<ContaCorrente, Cliente> {
  private Connection connection;

  public ContaCorrenteDAO() {
    this.connection = new ConnectionFactory().getConnection();
  }

  @Override

  public void criarConta(ContaCorrente conta, Cliente cliente) {
    String sql = "insert into ContaCorrente(cliente_id, saldo, numero, limite) values (?,?,?,?)";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setInt(1, cliente.getId());
      preparedStatement.setDouble(2, conta.getSaldo());
      preparedStatement.setInt(3, conta.getNumero());
      preparedStatement.setDouble(4, conta.getLimite());

      preparedStatement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override

  public Double getSaldo(Cliente cliente) {
    String sql = "select saldo from ContaCorrente where client_id = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setInt(1, cliente.getId());
      ResultSet resultSet = preparedStatement.executeQuery();
      Double saldo = resultSet.getDouble("saldo");

      return saldo;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override

  public void sacar(Cliente cliente, Double valorDoSaque) {
    Double saldo = getSaldo(cliente);
    String sql = "update ContaCorrente set saldo = ? where cliente_id = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setDouble(1, saldo - valorDoSaque);
      preparedStatement.setInt(2, cliente.getId());

      preparedStatement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override

  public void depositar(Cliente cliente, Double valorDepositado) {
    Double saldo = getSaldo(cliente);
    String sql = "update ContaCorrente set saldo = ? where client_id = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setDouble(1, saldo + valorDepositado);
      preparedStatement.setInt(2, cliente.getId());

      preparedStatement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override

  public List<ContaCorrente> getListaTodosClientes() {
    List<ContaCorrente> contas = new ArrayList<>();

    String sql = "select * from ContaCorrente";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        Integer id = resultSet.getInt("id");
        Integer cliente_id = resultSet.getInt("cliente_id");
        Double saldo = resultSet.getDouble("saldo");
        Integer numero = resultSet.getInt("numero");
        Double limite = resultSet.getDouble("limite");

        ContaCorrente conta = new ContaCorrente(saldo, numero, limite);
        conta.setId(id);
        conta.setClienteId(cliente_id);

        contas.add(conta);
      }
      return contas;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }
}
