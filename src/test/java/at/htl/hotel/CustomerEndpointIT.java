package at.htl.hotel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CustomerEndpointIT {
    private Client client;
    private WebTarget webTarget;

    @BeforeEach
    public void initClient() {
        this.client = ClientBuilder.newClient();
        this.webTarget = client.target("http://localhost:8080/vehicle/api/vehicle");
    }

    @Test
    public void getAllCustomer() {
        Response response = this.webTarget.request(MediaType.APPLICATION_JSON).get();
        assertThat(response.getStatus(), is(200));
    }


}
