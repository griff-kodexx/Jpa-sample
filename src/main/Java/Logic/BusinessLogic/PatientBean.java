package Logic.BusinessLogic;

import DAO.Crud;
import Entity.Appointment;
import Entity.Patient;
import Entity.Payment;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;


/**
 * Created by kodexx on 2/12/18.
 */
@RequestScoped
public class PatientBean {
    @Inject @Named("appointmentCrud")
    private Crud appointmentCrud;
    @Inject @Named("patientCrud")
    private Crud patientCrud;
    @Inject @Named("paymentCrud")
    private Crud paymentCrud;

    public boolean register(Patient p) {

        return !patientCrud.findByID(p).equals(p) && patientCrud.create(p);

    }

    public boolean book(Appointment a) {
        return appointmentCrud.create(a);
    }

    public boolean pay(Payment p) {

        return paymentCrud.create(p);
    }

    public List<Patient> getAllPatients() {

        return patientCrud.findAll();
    }
}
