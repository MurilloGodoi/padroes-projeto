package projeto;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class ConnectionFactory {
  public Connection getConnection() {
    try {
      return DriverManager.getConnection("jdbc:mysql://localhost/d2mbank","root","password");
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeErrorException(e);
    }
  }
}
