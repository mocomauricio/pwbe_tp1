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

    @POST
    @Path("/")
    public Response agregar(Cliente cliente) {
        clienteDAO.agregar(cliente);
        return Response.ok().build();
    }


    @GET
    @Path("/")
    public Response lista() {
        return Response.ok(clienteDAO.lista()).build();
    }
}
