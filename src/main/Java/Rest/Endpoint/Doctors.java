package Rest.Endpoint;

import DAO.Crud;
import Entity.Doctor;
import Entity.Doctor;
import com.google.gson.Gson;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by kodexx on 3/22/18.
 */

@Path("/doctors")
public class Doctors {

    @EJB(mappedName = "doctor")
    private Crud doctorCrud;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(String jsonObject){
        Gson gson = new Gson();
        if(doctorCrud.create(gson.fromJson(jsonObject, Doctor.class))){
            return Response.status(200).entity("Added successfully").build();
        }
        return Response.status(201).entity("Failed!!").build();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id")  int id){
        Doctor doctor  = (Doctor) doctorCrud.findByID(id);
        if (doctor!=null){
            return Response.status(200).entity(new Gson().toJson(doctor)).build();
        }
        return Response.status(201).entity("That Doctor not found!!").build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDoctor(@PathParam("id") int id, String jsonObject){
        Doctor doctor = new Gson().fromJson(jsonObject, Doctor.class);
        doctor.setId(id);
        if (doctorCrud.update(doctor)){
            return Response.status(200).entity("Updated!!"+ doctorCrud.findByID(id)).build();

        }
        return Response.status(201).entity("Update Failed!!").build();

    }

    @Path("/{id}")
    @DELETE
    public Response deleteDoctor(@PathParam("id") int id){
        Doctor doctor = new Doctor();
        doctor.setId(id);
        if (doctorCrud.delete(doctor)){
            return Response.status(200).entity("Doctor deleted!!").build();
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
