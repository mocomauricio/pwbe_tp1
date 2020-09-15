package py.com.prueba.laboratorio.rest;


import py.com.prueba.laboratorio.ejb.ClienteDAO;
import py.com.prueba.laboratorio.modelo.Cliente;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("cliente")
@Consumes("application/json")
@Produces("application/json")
public class ClienteRest {

    @Inject
    ClienteDAO clienteDAO;

    @GET
    @Path("/{pk}")
    public Response obtener(@PathParam("pk") Integer pk) {
        return Response.ok(clienteDAO.get(pk)).build();
    }
    
    @POST
    @Path("/")
    public Response agregar(Cliente cliente) {
        clienteDAO.persist(cliente);
        return Response.ok().build();
    }

    @PUT
    @Path("/")
    public Response modificar(Cliente cliente) {
        clienteDAO.merge(cliente);
        return Response.ok().build();
    }

    @GET
    @Path("/")
    public Response lista() {
        return Response.ok(clienteDAO.lista()).build();
    }
    
    @DELETE
    @Path("/{pk}")
    public Response borrar(@PathParam("pk") Integer pk){
        clienteDAO.delete(pk);
        return Response.ok().build();

    }
    
}
