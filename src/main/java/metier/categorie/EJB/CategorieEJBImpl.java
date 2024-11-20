package metier.categorie.EJB;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

import metier.categorie.enteties.Categorie;

@Stateless(name = "CAT")
public class CategorieEJBImpl implements ICategorieLocal, ICategorieRemote {
    @PersistenceContext(unitName = "ProduitEJB")
    private EntityManager em;

    public Categorie getCategorie(Long code){
        return em.find(Categorie.class, code);
    }
    @Override
    public Categorie addCategorie(Categorie cg) {
        em.persist(cg);
        return cg;
    }

    @Override
    public void deleteCategorie(Long code) {
        Categorie cg = em.find(Categorie.class, code);
        if (cg != null) {
            em.remove(cg);
        }
    }

    @Override
    public Categorie editCategorie(Categorie cg) {
        return em.merge(cg);
    }

    @Override
    public List<Categorie> listCategorie() {
        return em.createQuery("SELECT c FROM Categorie c", Categorie.class).getResultList();
    }

}
