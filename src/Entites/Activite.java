/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

/**
 *
 * @author challakh
 */
public class Activite {
    private int id;
    private String nom;
    private String type;
    private String adresse;
    private String pays;
    private String region;
    private String description;
    private float prix;
    private int id_agence;
    private int placedisponible;

    public Activite(String nom, String type, String adresse, String pays, String region, String description, float prix, int id_agence, int placedisponible) {
        this.nom = nom;
        this.type = type;
        this.adresse = adresse;
        this.pays = pays;
        this.region = region;
        this.description = description;
        this.prix = prix;
        this.id_agence = id_agence;
        this.placedisponible = placedisponible;
    }

    public Activite(String nom, String type, String adresse, String pays, String region, String description, float prix, int placedisponible) {
        this.nom = nom;
        this.type = type;
        this.adresse = adresse;
        this.pays = pays;
        this.region = region;
        this.description = description;
        this.prix = prix;
        this.placedisponible = placedisponible;
    }

    public Activite(int id, String nom, String type, String adresse, String pays, String region, String description, float prix, int id_agence, int placedisponible) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.adresse = adresse;
        this.pays = pays;
        this.region = region;
        this.description = description;
        this.prix = prix;
        this.id_agence = id_agence;
        this.placedisponible = placedisponible;
    }

    public int getPlacedisponible() {
        return placedisponible;
    }

    public void setPlacedisponible(int placedisponible) {
        this.placedisponible = placedisponible;
    }
    
    public Activite() {
    }

    public Activite(int id, String nom, String type, String adresse, String pays, String region, String description, float prix) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.adresse = adresse;
        this.pays = pays;
        this.region = region;
        this.description = description;
        this.prix = prix;
    }

    public Activite(int id, String nom, String type, String adresse, String pays, String region, String description, float prix, int id_agence) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.adresse = adresse;
        this.pays = pays;
        this.region = region;
        this.description = description;
        this.prix = prix;
        this.id_agence = id_agence;
    }

   
    public Activite(String nom, String type, String adresse, String pays, String region, String description, float prix) {
        this.nom = nom;
        this.type = type;
        this.adresse = adresse;
        this.pays = pays;
        this.region = region;
        this.description = description;
        this.prix = prix;
    }

   
  

  
    

    public int getId() {
        return id;
    }

    public int getId_agence() {
        return id_agence;
    }

    public void setId_agence(int id_agence) {
        this.id_agence = id_agence;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Activite{" + "id=" + id + ", nom=" + nom + ", type=" + type + ", adresse=" + adresse + ", pays=" + pays + ", region=" + region + ", description=" + description + ", prix=" + prix + ", id_agence=" + id_agence + ", placedisponible=" + placedisponible + '}';
    }

    

  

    
    
            
}
