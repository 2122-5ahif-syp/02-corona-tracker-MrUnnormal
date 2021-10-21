package at.htl.guest_register.boundary;

import at.htl.guest_register.entity.Visitor;
import at.htl.guest_register.repository.VisitorRepository;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.Instant;

@Path("/api/visitor")
public class VisitorService {
    @Inject
    VisitorRepository visitorRepository;

    @Inject
    Logger logger;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response getById(
            @FormParam("firstname") String firstname,
            @FormParam("lastname") String lastname,
            @FormParam("email") String email,
            @FormParam("phonenumber") String phonenumber
    )  {
        var visitor = new Visitor(firstname, lastname, email, phonenumber, Instant.now());
        visitorRepository.persist(visitor);
        logger.infof("Visitor created: %s", visitor);
        return Response.status(201).entity(visitor).build();
    }
}
