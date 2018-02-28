package Entity;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by kodexx on 2/8/18.
 */


public class User {
    private int id;
    private String fname="";
    private String lname="";
    private String email="";
    private String password="";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password, boolean encrypt) {
        if (encrypt){
        try {
            this.password = encyrptPassword(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        }else{
            this.password = password;
        }

    }


    public String toString(){
        return String.valueOf(id);
    }


    public boolean equals(Object obj) {

        if (obj == null){
            return false;
        }
        User u = (User) obj;
        if (this.getEmail().equals(u.getEmail())){
            return true;
        }else {
            return false;
        }
    }

    public String encyrptPassword(String password) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] mesagedigest = md.digest(password.getBytes());
        BigInteger num = new BigInteger(1, mesagedigest);
        String hash = num.toString(16);
        while( hash.length() < 32){
            hash = "0"+hash;
        }

        return hash;
    }

}
