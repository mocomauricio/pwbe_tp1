package py.com.prueba.laboratorio.rest;


import py.com.prueba.laboratorio.ejb.PuntoDAO;
import py.com.prueba.laboratorio.modelo.Punto;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("punto")
@Consumes("application/json")
@Produces("application/json")
public class PuntoRest {

    @Inject
    PuntoDAO puntoDAO;

    @GET
    @Path("/{pk}")
    public Response obtener(@PathParam("pk") Integer pk) {
        return Response.ok(puntoDAO.get(pk)).build();
    }
    
    @POST
    @Path("/")
    public Response agregar(Punto punto) {
        puntoDAO.persist(punto);
        return Response.ok().build();
    }

    @PUT
    @Path("/")
    public Response modificar(Punto punto) {
        puntoDAO.merge(punto);
        return Response.ok().build();
    }

    @GET
    @Path("/")
    public Response lista() {
        return Response.ok(puntoDAO.lista()).build();
    }
    
    @DELETE
    @Path("/{pk}")
    public Response borrar(@PathParam("pk") Integer pk){
        puntoDAO.delete(pk);
        return Response.ok().build();

    }
    
}
