package py.com.prueba.laboratorio.rest;

import py.com.prueba.laboratorio.ejb.ClienteDAO;
import py.com.prueba.laboratorio.modelo.Cliente;

import java.text.ParseException;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/clientes")
public class ClienteRest {

    @EJB
    private ClienteDAO clienteDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar() {
        return Response.ok(clienteDAO.listar()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregar(Cliente entity) {
        this.clienteDAO.agregar(entity);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(Cliente cliente) {
        clienteDAO.actualizar(cliente);
        return Response.ok().build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrar(@QueryParam("id") Long idCliente) {
        clienteDAO.eliminar(idCliente);
        return Response.ok().build();
    }
    
    @GET
    @Path("/porNombre")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarPorNombre(@QueryParam("nombre") String nombre) {
        return Response.ok(clienteDAO.listarPorNombre(nombre)).build();
    }
    
    @GET
    @Path("/porApellido")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarPorApellido(@QueryParam("apellido") String apellido) {
        return Response.ok(clienteDAO.listarPorApellido(apellido)).build();
    }
    
    @GET
    @Path("/porCumple")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarPorCumple(@QueryParam("cumple") String cumple) throws ParseException {
        return Response.ok(clienteDAO.listarPorCumple(cumple)).build();
    }

}
