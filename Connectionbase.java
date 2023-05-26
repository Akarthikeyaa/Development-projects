import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
  
public class Connectionbase{
  
    // static reference to itself
    private static Connectionbase instance = new Connectionbase();
  
    String url = "jdbc:mysql://localhost:3306/online_store";
    String user = "root";
    String password = "Abcdefg@12";
    String driverClass = "com.mysql.jdbc.Driver";
  
    // private constructor
    private Connectionbase()
    {
        try {
            Class.forName(driverClass);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
  
    public static Connectionbase getInstance()
    {
        return instance;
    }
  
    public Connection getConnection() throws SQLException, ClassNotFoundException
    {
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}