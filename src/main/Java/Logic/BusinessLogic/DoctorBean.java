package Logic.BusinessLogic;

import DAO.Crud;
import Entity.Consultation;
import Entity.Doctor;
import Entity.Examination;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by kodexx on 2/12/18.
 */
@RequestScoped
public class DoctorBean{
    @Inject @Named("doctorCrud")
    private Crud doctorCrud;
    public boolean register(Doctor d){

        return !doctorCrud.findByID(d).equals(d) && doctorCrud.create(d);
    }
    public boolean consult(Consultation c){

        return false;
    }
    public boolean examine(Examination e){

        return false;
    }
    public List<Doctor> getAllDoctors(){
        return doctorCrud.findAll();

    }
}
