package DAO.DAOImpl;

import DAO.Crud;
import Entity.Department;
import Entity.User;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by kodexx on 2/26/18.
 */

@Stateless(mappedName = "department")
public class DepartmentCrud implements Crud {

    @PersistenceContext
    private EntityManager entityManager;

    public boolean create(Object o) {
        Department department = (Department) o;
        try{
            entityManager.persist(department);
        } catch (Exception ex){
            System.out.println("The following exception occured");
            System.out.println(ex);
            return false;
        }
        return true;
    }

    public boolean update(Object o) {
        Department department = (Department) o;
        try {
            entityManager.merge(department);
        }catch (Exception e){
            System.out.println("The following exception occured");
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean delete(Object o) {
        Department department = (Department) o;
        try {
            entityManager.remove(department);
        }catch (Exception e){
            System.out.println("The following exception occured");
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public Object findByID(int id) {
        Department department;
        try{
            department = entityManager.find(Department.class, id);
        }catch(Exception ex){
            System.out.println("The following exception occured");
            System.out.println(ex.getMessage());
            return null;
        }
        return department;
    }

    public List findAll() {
        return null;
    }
}
