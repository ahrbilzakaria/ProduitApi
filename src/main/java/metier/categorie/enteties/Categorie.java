package metier.categorie.enteties;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import metier.produit.enteties.Produit;

@Entity
@Table(name = "Categories")
public class Categorie implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	private String libelle;
	private String description;
	@OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    private List<Produit> produits = null;
	
	private static final long serialVersionUID = 1L;
	public Categorie() {
		super();
	}
	public Categorie(String libelle, String description) {
		super();
		this.libelle = libelle;
		this.description = description;
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
