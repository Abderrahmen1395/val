/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Y520-I7-1TR-4G
 */
public class Hebergement {
    private int idHebergement;
  private int idAgence;
  private String nomAgence;
  private String type_Hebergement;
    private String nom_Hebergement;
    private int nombre_etoile;
    private String Adresse_Hebergement;
    private int nombre_chambre;
     private int prix_single;
      private int prix_double;
      
        private int taux_demi;
         private int taux_complet;
    private int tel;
    private  String description;
    private  String image;
    private ImageView imgview;

    public Hebergement() {
    }

    public Hebergement(int idAgence, String nomAgence, String type_Hebergement, String nom_Hebergement, int nombre_etoile, String Adresse_Hebergement, int nombre_chambre, int prix_single, int prix_double, int taux_demi, int taux_complet, int tel, String description, String image, ImageView imgview) {
        this.idAgence = idAgence;
        this.nomAgence = nomAgence;
        this.type_Hebergement = type_Hebergement;
        this.nom_Hebergement = nom_Hebergement;
        this.nombre_etoile = nombre_etoile;
        this.Adresse_Hebergement = Adresse_Hebergement;
        this.nombre_chambre = nombre_chambre;
        this.prix_single = prix_single;
        this.prix_double = prix_double;
        this.taux_demi = taux_demi;
        this.taux_complet = taux_complet;
        this.tel = tel;
        this.description = description;
        this.image = image;
        this.imgview = imgview;
    }

    public Hebergement(String image) {
        this.image = image;
    }
    public Hebergement(int idHebergement, int idAgence,String nomAgence, String type_Hebergement, String nom_Hebergement, int nombre_etoile, String Adresse_Hebergement, 
            int nombre_chambre, int prix_single, int prix_double, int taux_demi, int taux_complet, int tel, String description,String image) {
        this.idHebergement = idHebergement;
        this.idAgence = idAgence;
        this.nomAgence=nomAgence;
        this.type_Hebergement = type_Hebergement;
        this.nom_Hebergement = nom_Hebergement;
        this.nombre_etoile = nombre_etoile;
        this.Adresse_Hebergement = Adresse_Hebergement;
        this.nombre_chambre = nombre_chambre;
        this.prix_single = prix_single;
        this.prix_double = prix_double;
       
        this.taux_demi = taux_demi;
        this.taux_complet = taux_complet;
        this.tel = tel;
        this.description = description;
        this.image=image;
    }
    
    public Hebergement(String nomAgence,String type_Hebergement, String nom_Hebergement, int nombre_etoile, String Adresse_Hebergement, 
            int nombre_chambre, int prix_single, int prix_double, int taux_demi, int taux_complet, int tel, String description,String image) {
   
        this.nomAgence=nomAgence;
        this.type_Hebergement = type_Hebergement;
        this.nom_Hebergement = nom_Hebergement;
        this.nombre_etoile = nombre_etoile;
        this.Adresse_Hebergement = Adresse_Hebergement;
        this.nombre_chambre = nombre_chambre;
        this.prix_single = prix_single;
        this.prix_double = prix_double;
        
        this.taux_demi = taux_demi;
        this.taux_complet = taux_complet;
        this.tel = tel;
        this.description = description;
        this.image=image;
    }

     public Hebergement(String nomAgence,String type_Hebergement, String nom_Hebergement, int nombre_etoile, String Adresse_Hebergement, 
            int nombre_chambre, int prix_single, int prix_double,  int taux_demi, int taux_complet, int tel, String description) {
   
        this.nomAgence=nomAgence;
        this.type_Hebergement = type_Hebergement;
        this.nom_Hebergement = nom_Hebergement;
        this.nombre_etoile = nombre_etoile;
        this.Adresse_Hebergement = Adresse_Hebergement;
        this.nombre_chambre = nombre_chambre;
        this.prix_single = prix_single;
        this.prix_double = prix_double;
       
        this.taux_demi = taux_demi;
        this.taux_complet = taux_complet;
        this.tel = tel;
        this.description = description;
        
    }

      public Hebergement(int idAgence,String nomAgence,String type_Hebergement, String nom_Hebergement, int nombre_etoile, String Adresse_Hebergement, 
            int nombre_chambre, int prix_single, int prix_double, int taux_demi, int taux_complet, int tel, String description) {
   this.idAgence=idAgence;
   this.nomAgence=nomAgence;
        this.type_Hebergement = type_Hebergement;
        this.nom_Hebergement = nom_Hebergement;
        this.nombre_etoile = nombre_etoile;
        this.Adresse_Hebergement = Adresse_Hebergement;
        this.nombre_chambre = nombre_chambre;
        this.prix_single = prix_single;
        this.prix_double = prix_double;
       
        this.taux_demi = taux_demi;
        this.taux_complet = taux_complet;
        this.tel = tel;
        this.description = description;
       
    }
    public String getAdresse_Hebergement() {
        return Adresse_Hebergement;
    }

    public String getDescription() {
        return description;
    }

    public int getIdAgence() {
        return idAgence;
    }

    public int getIdHebergement() {
        return idHebergement;
    }

    public String getNom_Hebergement() {
        return nom_Hebergement;
    }

    public int getNombre_chambre() {
        return nombre_chambre;
    }

    public int getNombre_etoile() {
        return nombre_etoile;
    }

    public int getPrix_double() {
        return prix_double;
    }

   

    public int getPrix_single() {
        return prix_single;
    }

    public int getTaux_complet() {
        return taux_complet;
    }

    public int getTaux_demi() {
        return taux_demi;
    }

    public int getTel() {
        return tel;
    }

    public String getType_Hebergement() {
        return type_Hebergement;
    }

    public String getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

    public void setAdresse_Hebergement(String Adresse_Hebergement) {
        this.Adresse_Hebergement = Adresse_Hebergement;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIdAgence(int idAgence) {
        this.idAgence = idAgence;
    }

    public void setIdHebergement(int idHebergement) {
        this.idHebergement = idHebergement;
    }

    public void setNom_Hebergement(String nom_Hebergement) {
        this.nom_Hebergement = nom_Hebergement;
    }

    public void setNombre_chambre(int nombre_chambre) {
        this.nombre_chambre = nombre_chambre;
    }

    public void setNombre_etoile(int nombre_etoile) {
        this.nombre_etoile = nombre_etoile;
    }

    public void setPrix_double(int prix_double) {
        this.prix_double = prix_double;
    }

    public void setPrix_single(int prix_single) {
        this.prix_single = prix_single;
    }

    public void setTaux_complet(int taux_complet) {
        this.taux_complet = taux_complet;
    }

    public void setTaux_demi(int taux_demi) {
        this.taux_demi = taux_demi;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setType_Hebergement(String type_Hebergement) {
        this.type_Hebergement = type_Hebergement;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
   
      public ImageView getImgview() {
        return imgview;
    }

    public void setImgview(ImageView imgview) {
        this.imgview = imgview;
        imgview.setFitHeight(150);
imgview.setFitWidth(250);
imgview.setPreserveRatio(false);
    }
  
   public static List<Hebergement> generateImageViews(List<Hebergement> hebergements) {
        List<Hebergement> liste = new ArrayList<Hebergement>();

        for (Hebergement hebergement : hebergements) {
            File f = new File("C:\\wamp64\\www\\image\\"+hebergement.getImage());
            hebergement.setImgview(new ImageView(new Image(f.toURI().toString())));
            liste.add(hebergement);
        }
        return liste;
    }
   
   public static ArrayList<Hebergement> generateImageViews(ArrayList<Hebergement> hebergements) {
        ArrayList<Hebergement> liste = new ArrayList<Hebergement>();

        for (Hebergement hebergement : hebergements) {
            File f = new File("C:\\wamp64\\www\\image\\"+hebergement.getImage());
            hebergement.setImgview(new ImageView(new Image(f.toURI().toString())));
            liste.add(hebergement);
        }
        return liste;
    }
     public static Hebergement generateImageViews(Hebergement hebergement) {
        
         Hebergement h;
        
            File f = new File("C:\\wamp64\\www\\image\\" + hebergement.getImage());
            hebergement.setImgview(new ImageView(new Image(f.toURI().toString())));
            h=hebergement;
        
        return h;
    }

    @Override
    public String toString() {
        return "Hebergement{" + "idHebergement=" + idHebergement + ", idAgence=" + idAgence + ", nomAgence=" + nomAgence + ", type_Hebergement=" + type_Hebergement + ", nom_Hebergement=" + nom_Hebergement + ", nombre_etoile=" + nombre_etoile + ", Adresse_Hebergement=" + Adresse_Hebergement + ", nombre_chambre=" + nombre_chambre + ", prix_single=" + prix_single + ", prix_double=" + prix_double + ", taux_demi=" + taux_demi + ", taux_complet=" + taux_complet + ", tel=" + tel + ", description=" + description + ", image=" + image + ", imgview=" + imgview + '}';
    }

   

   

    
    
 
}
