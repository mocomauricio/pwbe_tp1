/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.prueba.laboratorio.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import py.com.prueba.laboratorio.ejb.BolsaPuntosDAO;
import py.com.prueba.laboratorio.modelo.BolsaPuntos;

@Path("/bolsas")
public class BolsaPuntosRest {

    @Inject
    private BolsaPuntosDAO bolsaPuntosDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar() {
        return Response.ok(bolsaPuntosDAO.listar()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregar(BolsaPuntos entity) throws Exception {
        this.bolsaPuntosDAO.agregar(entity);
        return Response.ok().build();
    }
    
    @GET
    @Path("/porCliente")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarByCliente(@QueryParam("id") Integer idCliente) {
        return Response.ok(bolsaPuntosDAO.listarByCliente(idCliente)).build();
    }
    
    @GET
    @Path("/porRango")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarByCliente(
            @QueryParam("valorInicio") Integer valorInicio,
            @QueryParam("valorFin") Integer valorFin) {
        return Response.ok(bolsaPuntosDAO.listarByRango(valorInicio, valorFin)).build();
    }
    
    @GET
    @Path("/vencidos/clientes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarClienteByPuntosAVencer(@QueryParam("dias") Integer dias){
        return Response.ok(bolsaPuntosDAO.listarClienteByPuntosAVencer(dias)).build();
    }
    
    @POST
    @Path("/cargar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cargaPuntos(@PathParam("id") Integer idCliente, @QueryParam("puntos") Integer puntos){
        this.bolsaPuntosDAO.cargarPuntos(idCliente, puntos);
        return Response.ok().build();
    }
    
}
