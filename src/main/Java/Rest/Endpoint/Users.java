package Rest.Endpoint;
import DAO.Crud;
import Entity.User;
import com.google.gson.Gson;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by kodexx on 3/14/18.
 */
@Path("/users")
public class Users {

    @EJB(mappedName = "user")
    private Crud userCrud;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(String jsonObject){
        Gson gson = new Gson();
        if(userCrud.create(gson.fromJson(jsonObject, User.class))){
           return Response.status(200).entity("Added successfully").build();
        }
        return Response.status(201).entity("Failed!!").build();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id")  int id){
        User user  = (User) userCrud.findByID(id);
        if (user!=null){
            return Response.status(200).entity(new Gson().toJson(user)).build();
        }
        return Response.status(201).entity("That User not found!!").build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") int id, String jsonObject){
        User user = new Gson().fromJson(jsonObject, User.class);
        user.setId(id);
        if (userCrud.update(user)){
            return Response.status(200).entity("Updated!!"+ userCrud.findByID(id)).build();

        }
        return Response.status(201).entity("Update Failed!!").build();

    }

    @Path("/{id}")
    @DELETE
    public Response deleteUser(@PathParam("id") int id){
        User user = new User();
        user.setId(id);
        if (userCrud.delete(user)){
            return Response.status(200).entity("User deleted!!").build();
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
