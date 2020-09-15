package py.com.prueba.laboratorio.rest;


import py.com.prueba.laboratorio.ejb.AsignacionPuntoDAO;
import py.com.prueba.laboratorio.modelo.AsignacionPunto;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("asignacionPunto")
@Consumes("application/json")
@Produces("application/json")
public class AsignacionPuntoRest {

    @Inject
    AsignacionPuntoDAO asignacionPuntoDAO;

    @GET
    @Path("/{pk}")
    public Response obtener(@PathParam("pk") Integer pk) {
        return Response.ok(asignacionPuntoDAO.get(pk)).build();
    }
    
    @POST
    @Path("/")
    public Response agregar(AsignacionPunto asignacionPunto) {
        asignacionPuntoDAO.persist(asignacionPunto);
        return Response.ok().build();
    }

    @PUT
    @Path("/")
    public Response modificar(AsignacionPunto asignacionPunto) {
        asignacionPuntoDAO.merge(asignacionPunto);
        return Response.ok().build();
    }

    @GET
    @Path("/")
    public Response lista() {
        return Response.ok(asignacionPuntoDAO.lista()).build();
    }
    
    @DELETE
    @Path("/{pk}")
    public Response borrar(@PathParam("pk") Integer pk){
        asignacionPuntoDAO.delete(pk);
        return Response.ok().build();

    }
    
}
