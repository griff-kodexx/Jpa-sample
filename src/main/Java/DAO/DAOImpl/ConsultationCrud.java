package DAO.DAOImpl;

import DAO.Crud;
import Entity.Appointment;
import Entity.Consultation;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by kodexx on 2/26/18.
 */
@RequestScoped
@Named("consultationCrud")
public class ConsultationCrud extends Crud {
    public boolean create(Object o) {
        Consultation c = (Consultation) o;
        return mydb.write("insert into consultations (appointmentID, comments) values("+c.getAppointment()+",'"+c.getDoctorComments()+"')") > 0;
    }

    public boolean update(Object o) {
        return false;
    }

    public boolean delete(Object o) {
        Consultation c = (Consultation) o;
        return mydb.write("delete * from consultations where id="+c.getId()) > 0;
    }

    public Object findByID(Object o) {
        Consultation c = (Consultation) o;
        Consultation consultation = new Consultation();
        ResultSet rs = mydb.read("select * from consultations where id="+c.getId());
        try {
            while (rs.next()){
                consultation.setId(rs.getInt("id"));
                consultation.setAppointment(new Appointment(rs.getInt("appointmentID")));
                consultation.setDoctorComments(rs.getString("comments"));

                return consultation;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultation;
    }

    public List findAll() {
        return null;
    }
}
