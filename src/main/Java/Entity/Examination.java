package Entity;

import javax.persistence.*;

/**
 * Created by kodexx on 2/6/18.
 */
@Entity
@Table(name = "examinations")
public class Examination {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    private Appointment appointment;
    @Column
    @Lob
    private String doctorComments;
    @Column
    @Lob
    private String reccommendation;
    @Column
    @Lob
    private String prescription;

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

    public String getReccommendation() {
        return reccommendation;
    }

    public void setReccommendation(String reccommendation) {
        this.reccommendation = reccommendation;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String toString(){
        return String.valueOf(id);
    }
}
