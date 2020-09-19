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
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import py.com.prueba.laboratorio.ejb.ConceptoPuntosDAO;
import py.com.prueba.laboratorio.modelo.ConceptoPuntos;

@Path("conceptos")
@Consumes("application/json")
@Produces("application/json")
public class ConceptoPuntosRest {

    @Inject
    private ConceptoPuntosDAO conceptoPuntosDAO;

    @GET
    @Path("/")
    public Response listar() {
        return Response.ok(conceptoPuntosDAO.listar()).build();
    }

    @POST
    @Path("/")
    public Response agregar(ConceptoPuntos entity) {
        this.conceptoPuntosDAO.agregar(entity);
        return Response.ok().build();
    }

}
