package DAO.DAOImpl;

import DAO.Crud;
import Entity.Department;
import Entity.Doctor;
import Entity.Gender;
import Entity.User;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kodexx on 2/26/18.
 */

@Stateless(mappedName = "doctor")
public class DoctorCrud implements Crud {

    @PersistenceContext
    private EntityManager entityManager;

    public boolean create(Object o) {
        Doctor doctor = (Doctor) o;
        try{
            entityManager.persist(doctor);
        } catch (Exception ex){
            System.out.println("The following exception occured");
            System.out.println(ex);
            return false;
        }
        return true;
    }

    public boolean update(Object o) {
        Doctor doctor = (Doctor) o;
        try {
            entityManager.merge(doctor);
        }catch (Exception e){
            System.out.println("The following exception occured");
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean delete(Object o) {
        Doctor doctor = (Doctor) o;
        try {
            entityManager.remove(doctor);
        }catch (Exception e){
            System.out.println("The following exception occured");
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public Object findByID(int id) {
        Doctor doctor;
        try{
            doctor = entityManager.find(Doctor.class, id);
        }catch(Exception ex){
            System.out.println("The following exception occured");
            System.out.println(ex.getMessage());
            return null;
        }
        return doctor;
    }

    public List findAll() {
        return null;
    }
}
