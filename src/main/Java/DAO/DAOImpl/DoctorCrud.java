package DAO.DAOImpl;

import DAO.Crud;
import Entity.Department;
import Entity.Doctor;
import Entity.Gender;

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
@Named("doctorCrud")
public class DoctorCrud extends Crud {
    public boolean create(Object o) {
        Doctor d = (Doctor) o;
        return mydb.write("insert into doctors (firstName, lastName, dob, idNumber, gender, phoneNumber, email, speciality, isContracted) values('"+d.getFirstName()+
                "','"+d.getLastName()+"',"+d.getDateOfBirth()+","+d.getIdNumber()+",'"+d.getGender()+"',"+d.getPhoneNumber()+",'"+d.getEmail()+"','"+d.getDoctorSpeciality()+"',"+d.isContracted()+")") >0;
    }

    public boolean update(Object o) {
        return false;
    }

    public boolean delete(Object o) {
        return false;
    }

    public Object findByID(Object o) {
        Doctor d = (Doctor) o;
        Doctor doctor = new Doctor();
        ResultSet rs  = mydb.read("select * from doctors where idNumber="+d.getIdNumber());
        try {
            while (rs.next()){
                doctor.setId(rs.getInt("id"));
                doctor.setFirstName(rs.getString("firstName"));
                doctor.setLastName(rs.getString("lastName"));
                doctor.setDateOfBirth(rs.getInt("dob"));
                doctor.setIdNumber(rs.getInt("idNumber"));
                doctor.setGender(Gender.valueOf(rs.getString("gender")));
                doctor.setPhoneNumber(rs.getInt("phoneNumber"));
                doctor.setEmail(rs.getString("email"));
                doctor.setDoctorSpeciality(new Department());
                doctor.setContracted(rs.getBoolean("isContracted"));

                return doctor;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctor;
    }

    public List findAll() {
        ArrayList<Doctor> allDoctors = new ArrayList<Doctor>();
        ResultSet rs = mydb.read("select * from doctors");
        try {
            while (rs.next()){
                Doctor doctor = new Doctor();
                doctor.setId(rs.getInt("id"));
                doctor.setFirstName(rs.getString("firstName"));
                doctor.setLastName(rs.getString("lastName"));
                doctor.setDateOfBirth(rs.getInt("dob"));
                doctor.setIdNumber(rs.getInt("idNumber"));
                doctor.setGender(Gender.valueOf(rs.getString("gender")));
                doctor.setPhoneNumber(rs.getInt("phoneNumber"));
                doctor.setEmail(rs.getString("email"));
                doctor.setDoctorSpeciality(new Department());
                doctor.setContracted(rs.getBoolean("isContracted"));

                allDoctors.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allDoctors;
    }
}
