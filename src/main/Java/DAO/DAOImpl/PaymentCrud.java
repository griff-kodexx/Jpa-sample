package DAO.DAOImpl;

import DAO.Crud;
import Entity.Insurance;
import Entity.Patient;
import Entity.Payment;
import Entity.Service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kodexx on 2/26/18.
 */
@RequestScoped
@Named("paymentCrud")
public class PaymentCrud extends Crud {
    public boolean create(Object o) {
        Payment p = (Payment) o;
        return mydb.write("insert into payments (patientID, hospitalServiceID, insuranceID, amount) values("+p.getPatient()+",'"+p.getService()+"',"+p.getInsurance()+","+p.getAmount()+")") > 0;
    }

    public boolean update(Object o) {
        return false;
    }

    public boolean delete(Object o) {
        Payment p = (Payment) o;
        return mydb.write("delete * from payments where id="+p.getId()) > 0;
    }

    public Object findByID(Object o) {
        Payment p = (Payment) o;
        Payment payment = new Payment();
        ResultSet rs = mydb.read("select * from payments where id="+p.getId());
        try {
            while (rs.next()){
                payment.setId(rs.getInt("id"));
                payment.setPatient(new Patient(rs.getInt("patientID")));
                payment.setService(Service.valueOf(rs.getString("hospitalServiceID")));
                payment.setInsurance(new Insurance(rs.getInt("insuranceID")));
                payment.setAmount(rs.getDouble("amount"));

                return payment;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return payment;
    }

    public List findAll() {
        ArrayList<Payment> allPayments = new ArrayList<Payment>();
        ResultSet rs = mydb.read("select * from payments");
        try {
            while (rs.next()){
                Payment payment = new Payment();
                payment.setId(rs.getInt("id"));
                payment.setPatient(new Patient(rs.getInt("patientID")));
                payment.setService(Service.valueOf(rs.getString("hospitalServiceID")));
                payment.setInsurance(new Insurance(rs.getInt("insuranceID")));
                payment.setAmount(rs.getDouble("amount"));

                allPayments.add(payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allPayments;
    }
}
