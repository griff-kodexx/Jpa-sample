package DAO.DAOImpl;

import DAO.Crud;
import Entity.Appointment;
import Entity.Doctor;
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

@Stateless(mappedName = "appointment")
public class AppointmentCrud implements Crud {

    @PersistenceContext
    private EntityManager entityManager;
    public boolean create(Object o) {
        Appointment appointment = (Appointment) o;

        try{
            entityManager.persist(appointment);
        } catch (Exception ex){
            System.out.println("The following exception occured");
            System.out.println(ex);
            return false;
        }
        return true;
    }

    public boolean update(Object o) {

        Appointment appointment = (Appointment) o;
        try {
            entityManager.merge(appointment);
        }catch (Exception e){
            System.out.println("The following exception occured");
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }

    public boolean delete(Object o) {
        Appointment appointment = (Appointment) o;
        try {
            entityManager.remove(appointment);
        }catch (Exception e){
            System.out.println("The following exception occured");
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public Object findByID(int id) {
        Appointment appointment;
        try{
            appointment = entityManager.find(Appointment.class, id);
        }catch(Exception ex){
            System.out.println("The following exception occured");
            System.out.println(ex.getMessage());
            return null;
        }
        return appointment;
    }

    public List findAll() {

        return null;
    }
}
