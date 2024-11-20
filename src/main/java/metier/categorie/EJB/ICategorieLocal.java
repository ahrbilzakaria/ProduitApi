package metier.categorie.EJB;

import java.util.List;

import jakarta.ejb.Local;

import metier.categorie.enteties.Categorie;

@Local
public interface ICategorieLocal {
	public Categorie getCategorie(Long code);

	public Categorie addCategorie(Categorie cg);
	
	public void deleteCategorie(Long code);
	
	public Categorie editCategorie(Categorie pr);

	public List<Categorie> listCategorie();
}
