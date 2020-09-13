package py.com.prueba.laboratorio.rest;


import py.com.prueba.laboratorio.ejb.PersonaDAO;
import py.com.prueba.laboratorio.modelo.Persona;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("persona")
@Consumes("application/json")
@Produces("application/json")
public class PersonaRest {

    @Inject
    PersonaDAO personaDAO;

    @POST
    @Path("/")
    public Response agregar(Persona persona) {
        personaDAO.agregar(persona);
        return Response.ok().build();
    }


    @GET
    @Path("/")
    public Response lista() {
        return Response.ok(personaDAO.lista()).build();
    }
}
