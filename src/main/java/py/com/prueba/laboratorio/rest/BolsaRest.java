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

    @GET
    @Path("/{pk}")
    public Response obtener(@PathParam("pk") Integer pk) {
        return Response.ok(bolsaDAO.get(pk)).build();
    }
    
    @POST
    @Path("/")
    public Response agregar(Bolsa bolsa) {
        bolsaDAO.persist(bolsa);
        return Response.ok().build();
    }

    @PUT
    @Path("/")
    public Response modificar(Bolsa bolsa) {
        bolsaDAO.merge(bolsa);
        return Response.ok().build();
    }

    @GET
    @Path("/")
    public Response lista() {
        return Response.ok(bolsaDAO.lista()).build();
    }
    
    @DELETE
    @Path("/{pk}")
    public Response borrar(@PathParam("pk") Integer pk){
        bolsaDAO.delete(pk);
        return Response.ok().build();

    }
    
}
