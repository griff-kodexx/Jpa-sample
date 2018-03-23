package Entity;

import javax.persistence.*;

/**
 * Created by kodexx on 2/6/18.
 */

@Entity
@Table
public class Insurance {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id=0;
    @Column
    private String name="";

    /*public Insurance(int id){
        this.id=id;
        this.name = "Britam";
    }*/

    public Insurance() {
    }

    public  int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return String.valueOf(getId());
    }
}
