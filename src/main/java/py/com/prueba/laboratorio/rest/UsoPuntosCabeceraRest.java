/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.prueba.laboratorio.rest;

import java.text.ParseException;
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

import py.com.prueba.laboratorio.ejb.UsoPuntosCabeceraDAO;
import py.com.prueba.laboratorio.modelo.UsoPuntosCabecera;

@Path("usos/cabeceras")
@Consumes("application/json")
@Produces("application/json")
public class UsoPuntosCabeceraRest {

    @Inject
    private UsoPuntosCabeceraDAO usoPuntosCabeceraDAO;

    @GET
    @Path("/")
    public Response listar() {
        return Response.ok(usoPuntosCabeceraDAO.listar()).build();
    }

    @POST
    @Path("/")
    public Response agregar(UsoPuntosCabecera entity) {
        this.usoPuntosCabeceraDAO.agregar(entity);
        return Response.ok().build();
    }

    @GET
    @Path("/porConcepto")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarByConcepto(@QueryParam("id") Integer idConcepto) {
        return Response.ok(usoPuntosCabeceraDAO.listarByConcepto(idConcepto)).build();
    }

    @GET
    @Path("/porFecha")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarByFecha(
            @QueryParam("fechaInicio") String fechaInicio,
            @QueryParam("fechaFin") String fechaFin) {

        try {
            return Response.ok(usoPuntosCabeceraDAO.listarByFecha(fechaInicio, fechaFin)).build();
        } catch (ParseException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GET
    @Path("/porCliente")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarByCliente(@QueryParam("id") Integer idCliente) {
        return Response.ok(usoPuntosCabeceraDAO.listarByCliente(idCliente)).build();
    }
    
    @POST
    @Path("/cargar/{idCliente}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response utilizarPuntos(@PathParam("idCliente") Integer idCliente, @QueryParam("idConcepto") Integer idConcepto){
        this.usoPuntosCabeceraDAO.utilizarPuntos(idCliente, idConcepto);
        return Response.ok().build();
    }
}
