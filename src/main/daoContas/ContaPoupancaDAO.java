package daoContas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Cliente;
import Models.ContaPoupanca;
import conexao.ConnectionFactory;

public class ContaPoupancaDAO implements DAOConta<ContaPoupanca, Cliente> {
  private Connection connection;

  public ContaPoupancaDAO() {
    this.connection = new ConnectionFactory().getConnection();
  }

  @Override

  public void criarConta(ContaPoupanca conta, Cliente cliente) {
    String sql = "insert into ContaPoupanca(cliente_id, saldo, numero, data_aniversario) values (?,?,?,?)";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setInt(1, cliente.getId());
      preparedStatement.setDouble(2, conta.getSaldo());
      preparedStatement.setInt(3, conta.getNumero());
      preparedStatement.setString(4, conta.getDataAniversario());

      preparedStatement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override

  public Double getSaldo(Cliente cliente) {
    String sql = "select saldo from ContaPoupanca where client_id = ?";
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
    String sql = "update ContaPoupanca set saldo = ? where cliente_id = ?";
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
    String sql = "update ContaPoupanca set saldo = ? where client_id = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setDouble(1, saldo + valorDepositado);
      preparedStatement.setInt(2, cliente.getId());

      preparedStatement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override

  public List<ContaPoupanca> getListaTodosClientes() {
    List<ContaPoupanca> contas = new ArrayList<>();

    String sql = "select * from ContaPoupanca";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        Integer id = resultSet.getInt("id");
        Integer cliente_id = resultSet.getInt("cliente_id");
        Double saldo = resultSet.getDouble("saldo");
        Integer numero = resultSet.getInt("numero");
        String data_aniversario = resultSet.getString("data_aniversario");

        ContaPoupanca conta = new ContaPoupanca(saldo, numero, data_aniversario);
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
