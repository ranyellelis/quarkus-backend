package br.com.ranyel.resource;

import java.util.List;

import br.com.ranyel.domain.Pessoa;
import br.com.ranyel.service.PessoaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/pessoa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResource {

	@Inject
	private PessoaService service;
	
	@GET
	@Path("/buscar/{id}")
	public Response buscarPessoa(@PathParam(value = "id") Long id) {
		try {
			Pessoa retorno = service.buscarPessoa(id);
			return Response.ok(retorno).build();
		} catch (Exception e) {
			return Response.status(500).entity("NOK").build();
		}
	}
	
	@POST
	@Path("/incluir")
	public Response incluirPessoa(Pessoa p) {
		try {
			service.incluirPessoa(p);
			return Response.ok("OK").build();
		} catch (Exception e) {
			return Response.status(500).entity("NOK").build();
		}
	}
	
	@PUT
	@Path("/alterar")
	public Response alterarPessoa(Pessoa p) {
		try {
			Pessoa retorno = service.alterarPessoa(p);
			return Response.ok(retorno).build();
		} catch (Exception e) {
			return Response.status(500).entity("NOK").build();
		}
	}
	
	@DELETE
	@Path("/deletar/{id}")
	public Response removerPessoa(@PathParam(value = "id") Long id) {
		try {
			service.removerPessoa(id);
			return Response.ok("OK").build();
		} catch (Exception e) {
			return Response.status(500).entity("NOK").build();
		}
	}
	
	@GET
	@Path("/listar")
	public Response buscarTodos() {
		try {
			List<Pessoa> retorno = service.buscarTodos();
			return Response.ok(retorno).build();
		} catch (Exception e) {
			return Response.status(500).entity("NOK").build();
		}
	}
}
