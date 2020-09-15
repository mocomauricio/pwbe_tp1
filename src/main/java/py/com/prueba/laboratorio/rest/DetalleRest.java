package py.com.prueba.laboratorio.rest;


import py.com.prueba.laboratorio.ejb.DetalleDAO;
import py.com.prueba.laboratorio.modelo.Detalle;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("detalle")
@Consumes("application/json")
@Produces("application/json")
public class DetalleRest {

    @Inject
    DetalleDAO detalleDAO;

    @GET
    @Path("/{pk}")
    public Response obtener(@PathParam("pk") Integer pk) {
        return Response.ok(detalleDAO.get(pk)).build();
    }
    
    @POST
    @Path("/")
    public Response agregar(Detalle detalle) {
        detalleDAO.persist(detalle);
        return Response.ok().build();
    }

    @PUT
    @Path("/")
    public Response modificar(Detalle detalle) {
        detalleDAO.merge(detalle);
        return Response.ok().build();
    }

    @GET
    @Path("/")
    public Response lista() {
        return Response.ok(detalleDAO.lista()).build();
    }
    
    @DELETE
    @Path("/{pk}")
    public Response borrar(@PathParam("pk") Integer pk){
        detalleDAO.delete(pk);
        return Response.ok().build();

    }
    
}
