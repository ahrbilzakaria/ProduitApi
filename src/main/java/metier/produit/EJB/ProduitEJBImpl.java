package metier.produit.EJB;

import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import metier.produit.enteties.Produit;

@Stateless(name = "PROD")
public class ProduitEJBImpl implements IProduitLocal, IProduitRemote {
	@PersistenceContext(unitName = "ProduitEJB")
	private EntityManager em;

	@Override
	public Produit addProduit(Produit pr) {
		em.persist(pr);
		return pr;
	}

	@Override
	public List<Produit> getProduit(String key) {
		Query req = em.createQuery("SELECT p FROM Produit p WHERE p.libelle LIKE :key");
		req.setParameter("key", "%" + key + "%");
		return req.getResultList();
	}

	@Override
	public List<Produit> listProduits() {
		Query req = em.createQuery("SELECT p FROM Produit p");
		return req.getResultList();
	}

	@Override
	public void ajouterQte(Long code, double qt) {
		Produit pr = em.find(Produit.class, code);
		pr.setQuantite(pr.getQuantite() + qt);
	}

	@Override
	public void retirerQte(Long code, double qt) {
		Produit pr = em.find(Produit.class, code);
		pr.setQuantite(pr.getQuantite() - qt);
	}

	@Override
	public void deleteProduit(Long code) {
		Produit p = em.find(Produit.class, code);
		em.remove(p);
	}

	@Override
	public Produit editProduit(Produit pr) {
		return em.merge(pr);
	}
}