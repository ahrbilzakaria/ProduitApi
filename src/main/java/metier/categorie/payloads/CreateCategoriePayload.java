package metier.categorie.payloads;

import metier.categorie.enteties.Categorie;

public class CreateCategoriePayload {
    private String libelle;
    private String description;

    // Constructors
    public CreateCategoriePayload() {}
    public CreateCategoriePayload(String libelle, String description) {
        this.libelle = libelle;
        this.description = description;
    }

    // Getters and setters
    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Categorie toCategorie() {
        this.trim();
        return new Categorie(this.libelle, this.description);
    }

    public CreateCategoriePayload trim() {
        this.libelle = this.libelle.trim();
        this.description = this.description.trim();
        return this;
    }
}
