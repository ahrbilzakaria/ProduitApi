package metier.categorie.EJB;

import java.util.List;

import jakarta.ejb.Remote;

import metier.categorie.enteties.Categorie;

@Remote
public interface ICategorieRemote {
	public Categorie getCategorie(Long code);
	
	public Categorie addCategorie(Categorie cg);
	
	public void deleteCategorie(Long code);
	
	public Categorie editCategorie(Categorie pr);

	public List<Categorie> listCategorie();
}
