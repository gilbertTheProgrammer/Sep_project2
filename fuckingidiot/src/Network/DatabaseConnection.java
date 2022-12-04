package Network;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection
{
  public Connection connectionToDataBase(String dbname, String user, String password) throws SQLException
  {
    Connection connection = null;

    try {
      Class.forName("org.postgresql.Driver");
      connection= DriverManager.getConnection("jdbc:postgresql://localhost:5433/" +dbname, user, password);

      if (connection!=null){
        System.out.println("Connection to database stable");
      }else {
        System.out.println("Connection to database failed");
      }
    }catch (Exception e){
      System.out.println(e);
    }
    return connection;

  }
}
