package py.com.prueba.laboratorio.rest;


import py.com.prueba.laboratorio.ejb.VencimientoPuntoDAO;
import py.com.prueba.laboratorio.modelo.VencimientoPunto;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("vencimientoPunto")
@Consumes("application/json")
@Produces("application/json")
public class VencimientoPuntoRest {

    @Inject
    VencimientoPuntoDAO vencimientoPuntoDAO;

    @GET
    @Path("/{pk}")
    public Response obtener(@PathParam("pk") Integer pk) {
        return Response.ok(vencimientoPuntoDAO.get(pk)).build();
    }
    
    @POST
    @Path("/")
    public Response agregar(VencimientoPunto vencimientoPunto) {
        vencimientoPuntoDAO.persist(vencimientoPunto);
        return Response.ok().build();
    }

    @PUT
    @Path("/")
    public Response modificar(VencimientoPunto vencimientoPunto) {
        vencimientoPuntoDAO.merge(vencimientoPunto);
        return Response.ok().build();
    }

    @GET
    @Path("/")
    public Response lista() {
        return Response.ok(vencimientoPuntoDAO.lista()).build();
    }
    
    @DELETE
    @Path("/{pk}")
    public Response borrar(@PathParam("pk") Integer pk){
        vencimientoPuntoDAO.delete(pk);
        return Response.ok().build();

    }
    
}
