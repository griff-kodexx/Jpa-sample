package Entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kodexx on 2/6/18.
 */

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String firstName="";
    @Column
    private String lastName="";
    @Column
    private String dateOfBirth="";
    @Column
    private String idNumber="";
    @Column
    private Gender gender;
    @Column
    private String phoneNumber="";
    @Column
    private String nextOfKinName="";
    @Column
    private String nextOfKinPhone="";

    @OneToMany
    private List<Insurance> insurance;

    public Patient(){}

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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNextOfKinName() {
        return nextOfKinName;
    }

    public void setNextOfKinName(String nextOfKinName) {
        this.nextOfKinName = nextOfKinName;
    }

    public String getNextOfKinPhone() {
        return nextOfKinPhone;
    }

    public void setNextOfKinPhone(String nextOfKinPhone) {
        this.nextOfKinPhone = nextOfKinPhone;
    }

    public List<Insurance> getInsurance() {
        return insurance;
    }

    public void setInsurance(List<Insurance> insurance) {
        this.insurance = insurance;
    }

    public String toString(){
        return String.valueOf(id);
    }

    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        Patient p = (Patient) obj;
        if (this.getIdNumber() == (p.getIdNumber())){
            return true;
        }else {
            return false;
        }
    }

}
