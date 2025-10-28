package dao_database_access_object;

import java.sql.SQLException;
import java.util.List;

public interface BaseDAO<T> {
    void create(T entity) throws SQLException;
    T findById(int id) throws SQLException;
    List<T> findAll() throws SQLException;
    void update(T entity) throws SQLException;
    void delete(int id) throws SQLException;
}
