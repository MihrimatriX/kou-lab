import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection
{
    public Connection Connect()
    {
        String url  = "jdbc:mysql://localhost:3308/pekflix";
        String user = "afu";
        String pswd = "158358";

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pswd);
            return conn;
        }
        catch (ClassNotFoundException | SQLException e)
        {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
        return null;
    }
}
