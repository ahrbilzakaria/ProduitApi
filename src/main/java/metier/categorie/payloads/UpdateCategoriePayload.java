package metier.categorie.payloads;

import metier.categorie.enteties.Categorie;

public class UpdateCategoriePayload {
    private String libelle;
    private String description;

    // Constructors
    public UpdateCategoriePayload() {}
    public UpdateCategoriePayload(String libelle, String description) {;
        this.libelle = libelle;
        this.description = description;
    }

    // Getters and setters
    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Categorie toCategorie(Categorie categorie) {
        this.trim();
        categorie.setDescription(this.description);
        categorie.setLibelle(this.libelle);
        return categorie;
    }

    public UpdateCategoriePayload trim() {
        this.libelle = this.libelle.trim();
        this.description = this.description.trim();
        return this;
    }

}
