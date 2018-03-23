package Entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kodexx on 2/6/18.
 */
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    private Patient patient;
    @Column
    private Service service;

    @OneToMany
    private List<Insurance> insurance;
    @Column
    private Double amount;

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

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<Insurance> getInsurance() {
        return insurance;
    }

    public void setInsurance(List<Insurance> insurance) {
        this.insurance = insurance;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
