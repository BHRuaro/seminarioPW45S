package br.edu.utfpr.pw45s.resource;

import br.edu.utfpr.pw45s.service.PessoaService;
import br.edu.utfpr.pw45s.model.Pessoa;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@RequestScoped
@Path("/pessoa")
public class PessoaResource {

    @Inject
    PessoaService pessoaService;

    @POST
    @Path("/create")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Pessoa pessoa) {
        try {
            pessoaService.create(pessoa);
            return Response.ok(pessoa.getId()).build();
        }catch (Exception e){
            e.printStackTrace();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

    @PUT
    @Path("/update")
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(Pessoa pessoa) {
        try {
            pessoaService.update(pessoa);
            return Response.ok(pessoa).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces("application/json")
    public void delete(@PathParam("id") Long id) {
        try {
            pessoaService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GET
    @Path("/get/{id}")
    @Produces("application/json")
    public Pessoa getById(@PathParam("id") Long id) {
        try {
            return pessoaService.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GET
    @Path("/getAll")
    @Produces("application/json")
    public List<Pessoa> getAll() {
        try {
            return pessoaService.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
