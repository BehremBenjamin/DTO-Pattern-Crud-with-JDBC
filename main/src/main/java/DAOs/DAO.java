package DAOs;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    T get(int id) throws SQLException, ClassNotFoundException;
    List<T> getAll() throws SQLException;
    void insert(T inserted) throws SQLException;
    void update (T updated) throws SQLException;
    void delete (T deleted) throws SQLException;
}
