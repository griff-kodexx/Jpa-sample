package Entity;

import javax.print.Doc;
import java.util.Date;

/**
 * Created by kodexx on 2/6/18.
 */
public class Doctor {
    private int id;
    private String firstName;
    private String lastName;
    private int dateOfBirth;
    private String email;
    private int idNumber;
    private Gender gender;
    private int phoneNumber;
    private Department doctorSpeciality;
    private boolean isContracted;

    public Doctor(){

    }

    public Doctor(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Department getDoctorSpeciality() {
        return doctorSpeciality;
    }

    public void setDoctorSpeciality(Department doctorSpeciality) {
        this.doctorSpeciality = doctorSpeciality;
    }

    public boolean isContracted() {
        return isContracted;
    }

    public void setContracted(boolean contracted) {
        isContracted = contracted;
    }

    public String toString(){
        return String.valueOf(id);
    }

    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        Doctor doc = (Doctor) obj;
        if (this.getIdNumber() == doc.getIdNumber() ){
            return true;
        }else{
            return false;
        }

    }
}
