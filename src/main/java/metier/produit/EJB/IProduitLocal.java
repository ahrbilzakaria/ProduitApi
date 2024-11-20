package metier.produit.EJB;

import java.util.List;
import jakarta.ejb.Local;
import metier.produit.enteties.Produit;

@Local
public interface IProduitLocal {
	public Produit addProduit(Produit pr);

	public List<Produit> getProduit(String key);
	
	public void deleteProduit(Long code);
	
	public Produit editProduit(Produit pr);

	public List<Produit> listProduits();

	public void ajouterQte(Long code, double qt);

	public void retirerQte(Long code, double qt);
	
	
}
