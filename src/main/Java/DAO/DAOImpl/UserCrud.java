package DAO.DAOImpl;

import DAO.Crud;
import Entity.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by kodexx on 2/22/18.
 */
@Stateless(mappedName = "user")
public class UserCrud implements Crud {

    @PersistenceContext
    private EntityManager entityManager;

    public boolean create(Object o) {
        User u  = (User) o;
        try{
            entityManager.persist(u);
        } catch (Exception ex){
            System.out.println("The following exception occured");
            System.out.println(ex);
            return false;
        }
        return true;

    }

    public boolean update(Object o) {
        User u  = (User) o;
        try {
            entityManager.merge(u);
        }catch (Exception e){
            System.out.println("The following exception occured");
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean delete(Object o) {
        User u  = (User) o;
        try {
            entityManager.remove(u);
        }catch (Exception e){
            System.out.println("The following exception occured");
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public Object findByID(int id) {
        User u;
        try{
            u = entityManager.find(User.class, id);
        }catch(Exception ex){
            System.out.println("The following exception occured");
            System.out.println(ex.getMessage());
            return null;
        }
        return u;
    }

    public List findAll() {
        //using JPQL

        /*String query = "select u from users u";
        try{
            return entityManager.createQuery(query).getResultList();
        }catch (Exception e){
            System.out.println("The following exception occured");
            System.out.println(e.getMessage());
            return null;
        }*/


        //using ORM

        return null;

    }
}
