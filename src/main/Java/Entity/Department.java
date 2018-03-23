package Entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kodexx on 2/6/18.
 */
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private String category; //should be enumerated type i think..

    @OneToMany
    private List<Doctor> doctors;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String toString(){
        return String.valueOf(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}
