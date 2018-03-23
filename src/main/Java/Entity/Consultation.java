package Entity;

import javax.persistence.*;

/**
 * Created by kodexx on 2/6/18.
 */
@Entity
@Table(name = "consultations")
public class Consultation {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    private Appointment appointment;
    @Column
    @Lob
    private String doctorComments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public String getDoctorComments() {
        return doctorComments;
    }

    public void setDoctorComments(String doctorComments) {
        this.doctorComments = doctorComments;
    }

    public String toString(){
        return String.valueOf(id);
    }
}
