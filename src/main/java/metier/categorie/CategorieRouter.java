package metier.categorie;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import metier.categorie.enteties.Categorie;
import metier.categorie.payloads.CreateCategoriePayload;
import metier.categorie.payloads.UpdateCategoriePayload;
import metier.commons.Errors.ErrorResponse;
import metier.commons.Errors.NotFoundErrorResponse;
import metier.commons.Util.Either;

import java.util.List;

@Path("/categories")
@Stateless
public class CategorieRouter {

    @Inject
    private CategorieService categorieService;

    @GET
    @Path("/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategorie(@PathParam("code") Long code) {
        Either<ErrorResponse, Categorie> result =  categorieService.findByCode(code);
        return result.isLeft() ? result.getLeft().toResponse() : Response.ok(result.getRight()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categorie> getCategories() {
        return categorieService.getCategories();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Categorie createCategorie(CreateCategoriePayload categoriePayload) {
        return categorieService.createCategorie(categoriePayload);
    }

    @PUT
    @Path("/{code}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCategorie(UpdateCategoriePayload categoriePayload, @PathParam("code") Long code) {
        Either<ErrorResponse, Categorie> result =  categorieService.updateCategorie(categoriePayload, code);
        return result.isLeft() ? result.getLeft().toResponse() : Response.ok(result.getRight()).build();
    }

    @DELETE
    @Path("/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCategorie(@PathParam("code") Long code) {
        Either<ErrorResponse, Void> result =  categorieService.deleteCategorie(code);
        return result.isLeft() ? result.getLeft().toResponse() : Response.ok().build();
    }

}

