package at.htl.hotel.rest;

import at.htl.hotel.database.Database;
import at.htl.hotel.model.Customer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("customer")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerEndpoint {

    @GET
    public List<Customer> getAllCustomer() {
        return Database.getInstance().selectAllCustomer();
    }

    @GET
    @Path("{id}")
    public Response getCustomerById(@PathParam("id") long id) {
        Customer customer = Database.getInstance().selectCustomerById(id);
        if (customer == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(customer).build();
    }
}
