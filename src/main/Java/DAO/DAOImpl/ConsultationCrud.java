package DAO.DAOImpl;

import DAO.Crud;
import Entity.Appointment;
import Entity.Consultation;
import Entity.User;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by kodexx on 2/26/18.
 */

@Stateless(mappedName = "consultation")
public class ConsultationCrud implements Crud {

    @PersistenceContext
    private EntityManager entityManager;

    public boolean create(Object o) {
        Consultation consultation = (Consultation) o;

        try{
            entityManager.persist(consultation);
        } catch (Exception ex){
            System.out.println("The following exception occured");
            System.out.println(ex);
            return false;
        }
        return true;
    }

    public boolean update(Object o) {

        Consultation consultation = (Consultation) o;
        try {
            entityManager.merge(consultation);
        }catch (Exception e){
            System.out.println("The following exception occured");
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean delete(Object o) {
        Consultation consultation = (Consultation) o;
        try {
            entityManager.remove(consultation);
        }catch (Exception e){
            System.out.println("The following exception occured");
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public Object findByID(int id) {
        Consultation consultation;
        try{
            consultation = entityManager.find(Consultation.class, id);
        }catch(Exception ex){
            System.out.println("The following exception occured");
            System.out.println(ex.getMessage());
            return null;
        }
        return consultation;
    }

    public List findAll() {
        return null;
    }
}
