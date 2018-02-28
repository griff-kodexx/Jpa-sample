package DAO.DAOImpl;

import DAO.Crud;
import Entity.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kodexx on 2/22/18.
 */
@RequestScoped
@Named("userCrud")
public class UserCrud extends Crud {
    public boolean create(Object o) {

        User u  = (User) o;
        return mydb.write("insert into users (fname, lname, password, email) values('"+u.getFname()+"','"+u.getLname()+"','"+u.getPassword()+"','"+u.getEmail()+"')") > 0;

    }

    public boolean update(Object o) {
        return false;
    }

    public boolean delete(Object o) {
        return false;
    }

    public Object findByID(Object o) {
        User u = (User) o;
        User user = new User();
        ResultSet rs = mydb.read("select * from users where email='"+u.getEmail()+"'");
        try {
            while (rs.next()){
                user.setPassword(rs.getString("password"), false);
                user.setLname(rs.getString("lname"));
                user.setFname(rs.getString("fname"));
                user.setEmail(rs.getString("email"));
                user.setId(rs.getInt("id"));

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List findAll() {
        ArrayList<User> users = new ArrayList<User>();
        User user = new User();
        ResultSet rs = mydb.read("select * from users");
        try {
            while (rs.next()){
                user.setPassword(rs.getString("password"), false);
                user.setLname(rs.getString("lname"));
                user.setFname(rs.getString("fname"));
                user.setEmail(rs.getString("email"));
                user.setId(rs.getInt("id"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
