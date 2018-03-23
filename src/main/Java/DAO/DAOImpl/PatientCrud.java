package DAO.DAOImpl;

import DAO.Crud;
import Entity.Gender;
import Entity.Insurance;
import Entity.Patient;
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

@Stateless(mappedName = "patient")
public class PatientCrud implements Crud {

    @PersistenceContext
    private EntityManager entityManager;

    public boolean create(Object o) {
        Patient patient = (Patient) o;
        try{
            entityManager.persist(patient);
        } catch (Exception ex){
            System.out.println("The following exception occured");
            System.out.println(ex);
            return false;
        }
        return true;
    }

    public boolean update(Object o) {
        Patient patient = (Patient) o;
        try {
            entityManager.merge(patient);
        }catch (Exception e){
            System.out.println("The following exception occured");
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }

    public boolean delete(Object o) {
        Patient patient = (Patient) o;
        try {
            entityManager.remove(patient);
        }catch (Exception e){
            System.out.println("The following exception occured");
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public Object findByID(int id) {
        Patient patient;
        try{
            patient = entityManager.find(Patient.class, id);
        }catch(Exception ex){
            System.out.println("The following exception occured");
            System.out.println(ex.getMessage());
            return null;
        }
        return patient;
    }

    public List findAll() {
        return null;
    }
}
