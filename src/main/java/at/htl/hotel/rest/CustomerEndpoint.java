package at.htl.hotel.rest;

import at.htl.hotel.database.Database;
import at.htl.hotel.model.Customer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("customer")
public class CustomerEndpoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getAllCustomer() {
        return Database.getInstance().selectAllCustomer();
    }

}
