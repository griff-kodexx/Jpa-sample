package Rest.Endpoint;

import DAO.Crud;
import Entity.Department;
import com.google.gson.Gson;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by kodexx on 3/22/18.
 */
@Path("/departments")
public class Departments {

    @EJB(mappedName = "department")
    private Crud departmentCrud;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(String jsonObject){
        Gson gson = new Gson();
        if(departmentCrud.create(gson.fromJson(jsonObject, Department.class))){
            return Response.status(200).entity("Added successfully").build();
        }
        return Response.status(201).entity("Failed!!").build();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id")  int id){
        Department department  = (Department) departmentCrud.findByID(id);
        if (department!=null){
            return Response.status(200).entity(new Gson().toJson(department)).build();
        }
        return Response.status(201).entity("That Department not found!!").build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDepartment(@PathParam("id") int id, String jsonObject){
        Department department = new Gson().fromJson(jsonObject, Department.class);
        department.setId(id);
        if (departmentCrud.update(department)){
            return Response.status(200).entity("Updated!!"+ departmentCrud.findByID(id)).build();

        }
        return Response.status(201).entity("Update Failed!!").build();

    }

    @Path("/{id}")
    public Response deleteDepartment(@PathParam("id") int id){
        Department department = new Department();
        department.setId(id);
        if (departmentCrud.delete(department)){
            return Response.status(200).entity("Department deleted!!").build();
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
