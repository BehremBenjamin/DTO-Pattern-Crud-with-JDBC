package Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {

    // C++ style declarations
    private static String
            jdbcUrl = "jdbc:mysql://localhost:3306/mvc_hibernate_project",
            user = "hibernateProject",
            password = "hibernateProject";

    public static Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(jdbcUrl, user, password);
            return con;
    }
}
