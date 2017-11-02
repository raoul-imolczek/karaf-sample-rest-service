package sample.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

public interface SampleService {

    @GET
    @Path("/foo/{id}/")
    @Produces("application/json")
    public String getFoo(@PathParam("id") String id);
    
}
