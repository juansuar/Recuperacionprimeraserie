package org.example;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/crossword")
public class CrosswordResource {

    @POST
    @Path("/validate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public boolean validateCrossword(BoardInput input) {
        CrosswordValidator validator = new CrosswordValidator(input.getDictionary());
        return validator.isValidBoard(input.getBoard());
    }
}
