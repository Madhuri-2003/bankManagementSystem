package BankManagementSystem;
import java.sql.*;

public class conn {
    
    Connection c;
    Statement s;
    public conn()
    {
        try
        {
            System.out.println("connecting ");
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem ","root","1234567890");
            s = c.createStatement();
            System.out.println("connected");
        }

        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public PreparedStatement prepareStatement(String query) throws SQLException {
        if (c != null) {
            return c.prepareStatement(query);
        } else {
            throw new SQLException("Connection is null");
        }
    }
}
