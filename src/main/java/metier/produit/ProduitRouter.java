package metier.produit;

import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import metier.produit.EJB.IProduitLocal;
import metier.produit.enteties.Produit;

import java.util.List;

@Path("/produits")
public class ProduitRouter {

    @EJB
    private IProduitLocal metier;


    @GET
    @Produces("application/json")
    public List<Produit> getProduits() {
        return metier.listProduits();
    }
}

