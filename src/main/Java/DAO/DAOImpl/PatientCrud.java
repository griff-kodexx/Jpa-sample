package DAO.DAOImpl;

import DAO.Crud;
import Entity.Gender;
import Entity.Insurance;
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
@Named("patientCrud")
public class PatientCrud extends Crud {
    public boolean create(Object o) {
        Patient p = (Patient) o;
        return mydb.write("insert into patients (firstName, lastName, dob, idNumber, gender, phoneNumber, nextOfKinName, nextOfKinPhone, insurance)" +
                " values('"+p.getFirstName()+"','"+p.getLastName()+"','"+p.getDateOfBirth()+"','"+p.getIdNumber()+"','"+p.getGender()+"','"+p.getPhoneNumber()+"','"+p.getNextOfKinName()+"','"+p.getNextOfKinPhone()+"',"+p.getInsurance()+")") > 0;
    }

    public boolean update(Object o) {
        return false;
    }

    public boolean delete(Object o) {
        return false;
    }

    public Object findByID(Object o) {
        Patient p = (Patient) o;
        Patient patient = new Patient();
        ResultSet rs = mydb.read("select * from patients where idNumber='"+p.getIdNumber()+"'");
        try {
            while (rs.next()){
                patient.setId(rs.getInt("id"));
                patient.setFirstName(rs.getString("firstName"));
                patient.setLastName(rs.getString("lastName"));
                patient.setDateOfBirth(rs.getString("dob"));
                patient.setIdNumber(rs.getString("idNumber"));
                if (rs.getString("gender").equals("female")){
                    patient.setGender(Gender.female);
                }else{
                    patient.setGender(Gender.male);
                }
                patient.setPhoneNumber(rs.getString("phoneNumber"));
                patient.setNextOfKinName(rs.getString("nextOfKinName"));
                patient.setNextOfKinPhone(rs.getString("nextOfKinPhone"));
                patient.setInsurance(new Insurance(rs.getInt("insurance")));

                return patient;
            }
        } catch (SQLException e) {
            System.out.println("First sql here..."+e.getMessage());
        } catch (NullPointerException e){
            System.out.println("Then Null here.."+e.getMessage());
        }
        return patient;
    }

    public List findAll() {
        ArrayList<Patient> allPatients = new ArrayList<Patient>();
        String sql = "select * from patients";
        ResultSet rs = mydb.read(sql);
        try {
            while (rs.next()){
                Patient patient = new Patient();
                patient.setId(rs.getInt("id"));
                patient.setFirstName(rs.getString("firstName"));
                patient.setLastName(rs.getString("lastName"));
                patient.setDateOfBirth(rs.getString("dob"));
                patient.setIdNumber(rs.getString("idNumber"));
                if (rs.getString("gender").equals("female")){
                    patient.setGender(Gender.female);
                }else{
                    patient.setGender(Gender.male);
                }
                patient.setPhoneNumber(rs.getString("phoneNumber"));
                patient.setNextOfKinName(rs.getString("nextOfKinName"));
                patient.setNextOfKinPhone(rs.getString("nextOfKinPhone"));
                patient.setInsurance(new Insurance(rs.getInt("insurance")));

                allPatients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allPatients;
    }
}
