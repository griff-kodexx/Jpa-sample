package Entity;

/**
 * Created by kodexx on 2/6/18.
 */
public class Consultation {
    private int id;
    private  Appointment appointment;
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
