package br.com.local.rest.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.local.domain.entity.Fruta;
import br.com.local.service.FrutaService;

@Path("/fruta")
public class FrutaResource {

	@Inject
	FrutaService frutaService;
	
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Fruta salvarFruta(Fruta novaFruta) {
        return frutaService.salvarFruta(novaFruta);
    }
    
    @GET
    @Path("{nome}")
    @Produces(MediaType.APPLICATION_JSON)
    public Fruta getFrutaPorNome(@PathParam("nome")final String nomeFruta) {
    	return frutaService.buscarFrutaPorNome(nomeFruta);
    }
}