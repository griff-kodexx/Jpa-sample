package Rest.Endpoint;
import DAO.Crud;
import Entity.Appointment;
import Entity.Appointment;
import com.google.gson.Gson;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by kodexx on 3/22/18.
 */
@Path("/appointments")
public class Appointments {

    @EJB(mappedName = "appointment")
    private Crud appointmentCrud;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(String jsonObject){
        Gson gson = new Gson();
        if(appointmentCrud.create(gson.fromJson(jsonObject, Appointment.class))){
            return Response.status(200).entity("Added successfully").build();
        }
        return Response.status(201).entity("Failed!!").build();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id")  int id){
        Appointment appointment  = (Appointment) appointmentCrud.findByID(id);
        if (appointment!=null){
            return Response.status(200).entity(new Gson().toJson(appointment)).build();
        }
        return Response.status(201).entity("That Appointment not found!!").build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAppointment(@PathParam("id") int id, String jsonObject){
        Appointment appointment = new Gson().fromJson(jsonObject, Appointment.class);
        appointment.setId(id);
        if (appointmentCrud.update(appointment)){
            return Response.status(200).entity("Updated!!"+ appointmentCrud.findByID(id)).build();

        }
        return Response.status(201).entity("Update Failed!!").build();

    }

    @Path("/{id}")
    public Response deleteAppointment(@PathParam("id") int id){
        Appointment appointment = new Appointment();
        appointment.setId(id);
        if (appointmentCrud.delete(appointment)){
            return Response.status(200).entity("Appointment deleted!!").build();
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
