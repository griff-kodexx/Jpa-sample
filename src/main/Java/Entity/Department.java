package Entity;

/**
 * Created by kodexx on 2/6/18.
 */
public class Department {
    private int id;
    private String name;
    private String category;

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
}
