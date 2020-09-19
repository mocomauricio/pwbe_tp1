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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import py.com.prueba.laboratorio.ejb.ReglaAsignacionPuntosDAO;
import py.com.prueba.laboratorio.modelo.ReglaAsignacionPuntos;

@Path("reglas-asignaciones")
public class ReglaAsignacionPuntosRest {

    @Inject
    private ReglaAsignacionPuntosDAO reglaAsignacionPuntosDAO;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar() {
        return Response.ok(reglaAsignacionPuntosDAO.listar()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregar(ReglaAsignacionPuntos entity) {
        this.reglaAsignacionPuntosDAO.agregar(entity);
        return Response.ok().build();
    }

    @GET
    @Path("/get-puntos/{monto}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPuntos(@PathParam("monto") Double monto) {
        return Response.ok(reglaAsignacionPuntosDAO.getCantidadDePuntos(monto)).build();
    }

}
