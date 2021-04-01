import java.sql.DriverManager;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class ConnectionFactory {
  public Connection getConnection() {
    try {
      return DriverManager.getConnection(url, user, password);
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeErrorException(e);
    }
  }
}
