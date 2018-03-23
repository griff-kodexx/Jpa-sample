package Rest.Endpoint;

import DAO.Crud;
import Entity.Payment;
import Entity.Payment;
import com.google.gson.Gson;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by kodexx on 3/22/18.
 */
@Path("/payments")
public class Payments {

    @EJB(mappedName = "payment")
    private Crud paymentCrud;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(String jsonObject){
        Gson gson = new Gson();
        if(paymentCrud.create(gson.fromJson(jsonObject, Payment.class))){
            return Response.status(200).entity("Added successfully").build();
        }
        return Response.status(201).entity("Failed!!").build();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id")  int id){
        Payment payment  = (Payment) paymentCrud.findByID(id);
        if (payment!=null){
            return Response.status(200).entity(new Gson().toJson(payment)).build();
        }
        return Response.status(201).entity("That Payment not found!!").build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePayment(@PathParam("id") int id, String jsonObject){
        Payment payment = new Gson().fromJson(jsonObject, Payment.class);
        payment.setId(id);
        if (paymentCrud.update(payment)){
            return Response.status(200).entity("Updated!!"+ paymentCrud.findByID(id)).build();

        }
        return Response.status(201).entity("Update Failed!!").build();

    }

    @Path("/{id}")
    @DELETE
    public Response deletePayment(@PathParam("id") int id){
        Payment payment = new Payment();
        payment.setId(id);
        if (paymentCrud.delete(payment)){
            return Response.status(200).entity("Payment deleted!!").build();
        }
        return Response.status(201).entity("Deletion Failed!!").build();
    }




    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/login")
    public Response login(@FormParam("username") String username, @FormParam("password") String password){
        if (username!=null && password!=null && username.equals("griffins") && password.equals("pass")){
            return Response.status(202).entity("Credentials accepted").build();
        }
        return Response.status(401).entity("Credentials not accepted").build();
    }


}
