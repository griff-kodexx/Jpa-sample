package DAO.DAOImpl;

import DAO.Crud;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

/**
 * Created by kodexx on 2/26/18.
 */
@RequestScoped
@Named("departmentCrud")
public class DepartmentCrud extends Crud {
    public boolean create(Object o) {
        return false;
    }

    public boolean update(Object o) {
        return false;
    }

    public boolean delete(Object o) {
        return false;
    }

    public Object findByID(Object o) {
        return null;
    }

    public List findAll() {
        return null;
    }
}
