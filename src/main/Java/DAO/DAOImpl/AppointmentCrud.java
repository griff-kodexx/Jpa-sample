package DAO.DAOImpl;

import DAO.Crud;
import Entity.Appointment;
import Entity.Doctor;
import Entity.Patient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kodexx on 2/26/18.
 */
@RequestScoped
@Named("appointmentCrud")
public class AppointmentCrud extends Crud {
    public boolean create(Object o) {
        Appointment a = (Appointment) o;
        return mydb.write("insert into appointments (patientID, doctorID, date, time) values("+a.getPatient()+","+a.getDoctor()+",'"+a.getDate()+"','"+a.getTime()+"')") > 0;
    }

    public boolean update(Object o) {
        Appointment a = (Appointment) o;
        return mydb.write("update appointments set date='12-12-12 time=1100 where id="+a.getId()) > 0 ;
    }

    public boolean delete(Object o) {
        Appointment a = (Appointment) o;
        return mydb.write("delete * from appointments where id="+a.getId()) > 0;
    }

    public Object findByID(Object o) {
        Appointment a = (Appointment) o;
        Appointment appointment =  new Appointment();
        ResultSet rs =  mydb.read("select * from appointments where id="+a.getId());
        try {
            while (rs.next()){
                appointment.setId(rs.getInt("id"));
                appointment.setPatient(new Patient(rs.getInt("patientID")));
                appointment.setDoctor(new Doctor(rs.getInt("doctorID")));
                appointment.setDate(rs.getString("date"));
                appointment.setTime(rs.getString("time"));

                return appointment;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointment;
    }

    public List findAll() {
        ArrayList<Appointment> allAppointments = new ArrayList<Appointment>();
        String sql = "select * from appointments";
        ResultSet rs = mydb.read(sql);
        try {
            while(rs.next()){
                Appointment appointment = new Appointment();
                appointment.setId(rs.getInt("id"));
                appointment.setPatient(new Patient(rs.getInt("patientID")));
                appointment.setDoctor(new Doctor(rs.getInt("doctorID")));
                appointment.setDate(rs.getString("date"));
                appointment.setTime(rs.getString("time"));

                allAppointments.add(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allAppointments;
    }
}
