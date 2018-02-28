package Entity;

/**
 * Created by kodexx on 2/6/18.
 */
public class Examination {
    private int id;
    private Appointment appointment;
    private String doctorComments;
    private String reccommendation;
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
