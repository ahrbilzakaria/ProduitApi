package metier.categorie;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import metier.categorie.EJB.ICategorieLocal;
import metier.categorie.enteties.Categorie;
import metier.categorie.payloads.CreateCategoriePayload;
import metier.categorie.payloads.UpdateCategoriePayload;
import metier.commons.Errors.ErrorResponse;
import metier.commons.Errors.NotFoundErrorResponse;
import metier.commons.Util.Either;

import java.util.List;

@Stateless
public class CategorieService {
    @Inject
    private ICategorieLocal metier;

    public Either<ErrorResponse,Categorie> findByCode(Long code) {
        Categorie categorie =  metier.getCategorie(code);
        if(categorie == null) {
            return Either.left(new NotFoundErrorResponse("Categorie not found with code " + code));
        }
        return Either.right(categorie);

    }
    public List<Categorie> getCategories() {
        return metier.listCategorie();
    }

    public Categorie createCategorie(CreateCategoriePayload categoriePayload) {
        Categorie cg = categoriePayload.toCategorie();
        return metier.addCategorie(cg);
    }

    public Either<ErrorResponse, Categorie> updateCategorie(UpdateCategoriePayload categoriePayload, Long code) {
        Categorie categorie = metier.getCategorie(code);
        if(categorie == null) {
            return Either.left(new NotFoundErrorResponse("Categorie not found with code " + code));
        }
        return Either.right(metier.editCategorie(categoriePayload.toCategorie(categorie)));
    }

    public Either<ErrorResponse, Void > deleteCategorie(Long code) {
        Categorie categorie = metier.getCategorie(code);
        if(categorie == null) {
            return Either.left(new NotFoundErrorResponse("Categorie not found with code " + code));
        }
        metier.deleteCategorie(code);
        return Either.right(null);
    }

}
