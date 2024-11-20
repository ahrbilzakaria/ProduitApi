package metier.produit.EJB;

import java.util.List;
import jakarta.ejb.Remote;
import metier.produit.enteties.Produit;

@Remote
public interface IProduitRemote {
	public Produit addProduit(Produit pr);

	public List<Produit> getProduit(String key);

	public List<Produit> listProduits();

	public void ajouterQte(Long code, double qt);

	public void retirerQte(Long code, double qt);
}
