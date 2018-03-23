package Rest.Endpoint;

import DAO.Crud;
import Entity.Consultation;
import com.google.gson.Gson;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by kodexx on 3/22/18.
 */
@Path("/consultations")
public class Consultations {

    @EJB(mappedName = "consultation")
    private Crud consultationCrud;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(String jsonObject){
        Gson gson = new Gson();
        if(consultationCrud.create(gson.fromJson(jsonObject, Consultation.class))){
            return Response.status(200).entity("Added successfully").build();
        }
        return Response.status(201).entity("Failed!!").build();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id")  int id){
        Consultation consultation  = (Consultation) consultationCrud.findByID(id);
        if (consultation!=null){
            return Response.status(200).entity(new Gson().toJson(consultation)).build();
        }
        return Response.status(201).entity("That Consultation not found!!").build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateConsultation(@PathParam("id") int id, String jsonObject){
        Consultation consultation = new Gson().fromJson(jsonObject, Consultation.class);
        consultation.setId(id);
        if (consultationCrud.update(consultation)){
            return Response.status(200).entity("Updated!!"+ consultationCrud.findByID(id)).build();

        }
        return Response.status(201).entity("Update Failed!!").build();

    }

    @Path("/{id}")
    public Response deleteConsultation(@PathParam("id") int id){
        Consultation consultation = new Consultation();
        consultation.setId(id);
        if (consultationCrud.delete(consultation)){
            return Response.status(200).entity("Consultation deleted!!").build();
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
