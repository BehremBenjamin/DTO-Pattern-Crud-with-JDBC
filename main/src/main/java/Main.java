import Connectivity.JDBC;
import DAOs.CustomerDAO;
import DAOs.CustomerDAOImpl;
import entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection con = JDBC.getConnection();
        if (con != null) {
            System.out.println("Database connection successful !!!");
        }

        CustomerDAO customerDAO = new CustomerDAOImpl();

        List<Customer> all = customerDAO.getAll();
        System.out.println(all);

        Customer newCustomer = new Customer(56, "This is", "Another Example",
            "insertingExample@email.com");
        customerDAO.insert(newCustomer);
        customerDAO.delete(newCustomer);
    }
}
