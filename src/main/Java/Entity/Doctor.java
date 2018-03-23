package Entity;

import javax.persistence.*;
import javax.print.Doc;
import java.util.Date;
import java.util.List;

/**
 * Created by kodexx on 2/6/18.
 */
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private int dateOfBirth;
    @Column
    private String email;
    @Column
    private int idNumber;
    @Column
    private Gender gender;
    @Column
    private int phoneNumber;

    @OneToMany
    private List<Department> doctorSpeciality;
    @Column
    private boolean isContracted;

    public Doctor(){

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

    public List<Department> getDoctorSpeciality() {
        return doctorSpeciality;
    }

    public void setDoctorSpeciality(List<Department> doctorSpeciality) {
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
