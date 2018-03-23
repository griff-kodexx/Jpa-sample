package Rest.Endpoint;

import DAO.Crud;
import Entity.Patient;
import Entity.Patient;
import Entity.Patient;
import com.google.gson.Gson;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by kodexx on 3/22/18.
 */

@Path("/patients")
public class Patients {

    @EJB(mappedName = "patient")
    private Crud patientCrud;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(String jsonObject){
        Gson gson = new Gson();
        if(patientCrud.create(gson.fromJson(jsonObject, Patient.class))){
            return Response.status(200).entity("Added successfully").build();
        }
        return Response.status(201).entity("Failed!!").build();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id")  int id){
        Patient patient  = (Patient) patientCrud.findByID(id);
        if (patient!=null){
            return Response.status(200).entity(new Gson().toJson(patient)).build();
        }
        return Response.status(201).entity("That Patient not found!!").build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePatient(@PathParam("id") int id, String jsonObject){
        Patient patient = new Gson().fromJson(jsonObject, Patient.class);
        patient.setId(id);
        if (patientCrud.update(patient)){
            return Response.status(200).entity("Updated!!"+ patientCrud.findByID(id)).build();

        }
        return Response.status(201).entity("Update Failed!!").build();

    }

    @Path("/{id}")
    @DELETE
    public Response deletePatient(@PathParam("id") int id){
        Patient patient = new Patient();
        patient.setId(id);
        if (patientCrud.delete(patient)){
            return Response.status(200).entity("Patient deleted!!").build();
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
