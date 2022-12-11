package DAOs;

import entity.Customer;
import Connectivity.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    public CustomerDAOImpl() {
        super();
    }


    /*
     * Setting Connection object and mapping
     * customer object could be decoupled-refactored further
     * For the sake of learning and simplicity
     * I've wrote it in all methods / functions of
     * this class
     */

    @Override
    public Customer get(int id) throws SQLException, ClassNotFoundException {
        Customer customer = new Customer();
        Connection con = JDBC.getConnection();
        String sql = "SELECT * FROM Customer WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            customer.setId(rs.getInt(1));
            customer.setFirstName(rs.getString(2));
            customer.setLastName(rs.getString(3));
            customer.setEmail(rs.getString(4));
        }
        return customer;
    }

    @Override
    public List<Customer> getAll() throws SQLException {
        Connection con = JDBC.getConnection();
        String sql = "Select * from customer";
        PreparedStatement ps = con.prepareStatement(sql);
        List<Customer> allCustomers = new ArrayList<Customer>();
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Customer customer = new Customer();
            customer.setId(rs.getInt(1));
            customer.setFirstName(rs.getString(2));
            customer.setLastName(rs.getString(3));
            customer.setEmail(rs.getString(4));
            allCustomers.add(customer);
        }
        return allCustomers;
    }

    @Override
    public void insert(Customer inserted) throws SQLException {
        Connection con = JDBC.getConnection();
        String sql = "INSERT INTO customer (id, first_name, last_name, email) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, inserted.getId());
        ps.setString(2, inserted.getFirstName());
        ps.setString(3, inserted.getLastName());
        ps.setString(4, inserted.getEmail());
        int result = ps.executeUpdate();   // info about  number of updates
        ps.close();
        con.close();
    }

    @Override
    public void update(Customer updated) throws SQLException {
        Connection con = JDBC.getConnection();
        String sql = "UPDATE customer SET id = ?, first_name = ?, last_name = ?, email = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, updated.getId());
        ps.setString(2, updated.getFirstName());
        ps.setString(3, updated.getLastName());
        ps.setString(4, updated.getEmail());
        ps.setInt(5, updated.getId());
        int result = ps.executeUpdate();   // info about  number of updates
        ps.close();
        con.close();
    }

    @Override
    public void delete(Customer deleted) throws SQLException {
        Connection con = JDBC.getConnection();
        String sql = "DELETE FROM customer WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, deleted.getId());
        int result = ps.executeUpdate();   // info about  number of updates
        ps.close();
        con.close();
    }
}
