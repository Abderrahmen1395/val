/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;
import java.sql.Date;

/**
 *
 * @author RANI
 */
public class Vols {
    private int id_vol;
    private Date date_depart;
    private Date date_arrive;
    private String ville_depart;
    private String ville_arrive;
    private float prix;
    private String description;
    private String type_vol;
    private int placedisp;
    private int id_agence;

    public Vols(int id_vol, Date date_depart, Date date_arrive, String ville_depart, String ville_arrive, float prix, String description, String type_vol) {
        this.id_vol = id_vol;
        this.date_depart = date_depart;
        this.date_arrive = date_arrive;
        this.ville_depart = ville_depart;
        this.ville_arrive = ville_arrive;
        this.prix = prix;
        this.description = description;
        this.type_vol = type_vol;
    }

    public Vols() {
    }

    public Vols(int id_vol, Date date_depart, Date date_arrive, String ville_depart, String ville_arrive, float prix, String description, String type_vol, int placedisp) {
        this.id_vol = id_vol;
        this.date_depart = date_depart;
        this.date_arrive = date_arrive;
        this.ville_depart = ville_depart;
        this.ville_arrive = ville_arrive;
        this.prix = prix;
        this.description = description;
        this.type_vol = type_vol;
        this.placedisp = placedisp;
    }

    public int getId_vol() {
        return id_vol;
    }

    public void setId_vol(int id_vol) {
        this.id_vol = id_vol;
    }

    public Date getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(Date date_depart) {
        this.date_depart = date_depart;
    }

    public Date getDate_arrive() {
        return date_arrive;
    }

    public void setDate_arrive(Date date_arrive) {
        this.date_arrive = date_arrive;
    }

    public String getVille_depart() {
        return ville_depart;
    }

    public void setVille_depart(String ville_depart) {
        this.ville_depart = ville_depart;
    }

    public String getVille_arrive() {
        return ville_arrive;
    }

    public void setVille_arrive(String ville_arrive) {
        this.ville_arrive = ville_arrive;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType_vol() {
        return type_vol;
    }

    public void setType_vol(String type_vol) {
        this.type_vol = type_vol;
    }

    public int getPlacedisp() {
        return placedisp;
    }

    public void setPlacedisp(int placedisp) {
        this.placedisp = placedisp;
    }

    public int getId_agence() {
        return id_agence;
    }

    public void setId_agence(int id_agence) {
        this.id_agence = id_agence;
    }

    public Vols(Date date_depart, Date date_arrive, String ville_depart, String ville_arrive, float prix, String description, int placedisp, int id_agence) {
        this.date_depart = date_depart;
        this.date_arrive = date_arrive;
        this.ville_depart = ville_depart;
        this.ville_arrive = ville_arrive;
        this.prix = prix;
        this.description = description;
        this.placedisp = placedisp;
        this.id_agence = id_agence;
    }

    public Vols(Date date_depart, Date date_arrive, String ville_depart, String ville_arrive, float prix, String description, String type_vol, int placedisp, int id_agence) {
        this.date_depart = date_depart;
        this.date_arrive = date_arrive;
        this.ville_depart = ville_depart;
        this.ville_arrive = ville_arrive;
        this.prix = prix;
        this.description = description;
        this.type_vol = type_vol;
        this.placedisp = placedisp;
        this.id_agence = id_agence;
    }

    public Vols(Date date_depart, Date date_arrive, String ville_depart, String ville_arrive, float prix, String description, String type_vol, int placedisp) {
        this.date_depart = date_depart;
        this.date_arrive = date_arrive;
        this.ville_depart = ville_depart;
        this.ville_arrive = ville_arrive;
        this.prix = prix;
        this.description = description;
        this.type_vol = type_vol;
        this.placedisp = placedisp;
    }

    public Vols(int id_vol, Date date_depart, Date date_arrive, String ville_depart, String ville_arrive, float prix, String description, String type_vol, int placedisp, int id_agence) {
        this.id_vol = id_vol;
        this.date_depart = date_depart;
        this.date_arrive = date_arrive;
        this.ville_depart = ville_depart;
        this.ville_arrive = ville_arrive;
        this.prix = prix;
        this.description = description;
        this.type_vol = type_vol;
        this.placedisp = placedisp;
        this.id_agence = id_agence;
    }

    @Override
    public String toString() {
        return "Vols{" + "id_vol=" + id_vol + ", date_depart=" + date_depart + ", date_arrive=" + date_arrive + ", ville_depart=" + ville_depart + ", ville_arrive=" + ville_arrive + ", prix=" + prix + ", description=" + description + ", type_vol=" + type_vol + ", placedisp=" + placedisp + ", id_agence=" + id_agence + '}';
    }

   
    
    
    
}
