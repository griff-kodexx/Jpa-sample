package Logic.BusinessLogic;

import DAO.Crud;
import Entity.User;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by kodexx on 2/12/18.
 */

@RequestScoped
public class UserBean {
    @Inject @Named("userCrud")
    private Crud crud;
    public boolean register(User u){
        return !crud.findByID(u).equals(u) && crud.create(u);
    }

    public boolean login(User u){
        User userInDb = (User) crud.findByID(u);

        if (u.equals(userInDb)){
            System.out.println("User email okay");
            System.out.println(u.getPassword()+"-----IN DB: "+userInDb.getPassword());
            if (u.getPassword().equals(userInDb.getPassword())){
                System.out.println("user password okay");
                return true;
            }
        }
        return false;
    }

    public boolean logout(User u){

        return false;
    }

    public boolean delete(User u){
        return crud.delete(u);
    }



    public boolean isLoggedin(User u) {
        return false;
    }

    public User[] loggedInUsers() {
        return new User[0];
    }

    public List<User> allUsers() {

        return crud.findAll();
    }

}
