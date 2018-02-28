package DAO;

import Logic.UtilLogic.DBUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by kodexx on 2/22/18.
 */
public abstract class Crud<T> {
    protected DBUtil mydb  = null;

    protected Crud() {
        try {
            mydb = new DBUtil();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public abstract boolean create(T t);
    public abstract boolean update(T t);
    public abstract boolean delete(T t);
    public abstract T findByID(T t);
    public abstract List<T> findAll();
}
