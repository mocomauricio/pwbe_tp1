package py.com.prueba.laboratorio.rest;


import py.com.prueba.laboratorio.ejb.BolsaDAO;
import py.com.prueba.laboratorio.modelo.Bolsa;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("bolsa")
@Consumes("application/json")
@Produces("application/json")
public class BolsaRest {

    @Inject
    BolsaDAO bolsaDAO;

    @POST
    @Path("/")
    public Response agregar(Bolsa bolsa) {
        bolsaDAO.agregar(bolsa);
        return Response.ok().build();
    }


    @GET
    @Path("/")
    public Response lista() {
        return Response.ok(bolsaDAO.lista()).build();
    }
}
