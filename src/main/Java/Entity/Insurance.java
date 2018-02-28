package Entity;

/**
 * Created by kodexx on 2/6/18.
 */
public class Insurance {
     private int id=0;
     private String name="";

    public Insurance(int id){
        this.id=id;
        this.name = "Britam";
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
