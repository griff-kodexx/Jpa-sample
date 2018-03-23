package Entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by kodexx on 2/6/18.
 */

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;
    @Column
    private Date date;
    @Column
    private String time;

    public Appointment() {
    }

    public Appointment(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String toString(){
        return String.valueOf(this.id);
    }
}
