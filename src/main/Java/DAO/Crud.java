package DAO;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by kodexx on 2/22/18.
 */
@Local
public interface Crud<T> {
    boolean create(T t);
    boolean update(T t);
    boolean delete(T t);
    T findByID(int id);
    List<T> findAll();
}
