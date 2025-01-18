package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String userName = "root";
    private static final String userPassword = "Vidhyadharan@123";
    private static final String url = "jdbc:mysql://localhost:3306/eventmanagement";

    public static Connection getConnect()throws SQLException
    {

        return DriverManager.getConnection(url,userName,userPassword);
    }

}
