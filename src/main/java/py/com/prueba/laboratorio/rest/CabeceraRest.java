package py.com.prueba.laboratorio.rest;


import py.com.prueba.laboratorio.ejb.CabeceraDAO;
import py.com.prueba.laboratorio.modelo.Cabecera;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("cabecera")
@Consumes("application/json")
@Produces("application/json")
public class CabeceraRest {

    @Inject
    CabeceraDAO cabeceraDAO;

    @GET
    @Path("/{pk}")
    public Response obtener(@PathParam("pk") Integer pk) {
        return Response.ok(cabeceraDAO.get(pk)).build();
    }
    
    @POST
    @Path("/")
    public Response agregar(Cabecera cabecera) {
        cabeceraDAO.persist(cabecera);
        return Response.ok().build();
    }

    @PUT
    @Path("/")
    public Response modificar(Cabecera cabecera) {
        cabeceraDAO.merge(cabecera);
        return Response.ok().build();
    }

    @GET
    @Path("/")
    public Response lista() {
        return Response.ok(cabeceraDAO.lista()).build();
    }
    
    @DELETE
    @Path("/{pk}")
    public Response borrar(@PathParam("pk") Integer pk){
        cabeceraDAO.delete(pk);
        return Response.ok().build();

    }
    
}
