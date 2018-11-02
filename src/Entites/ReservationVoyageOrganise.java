/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

/**
 *
 * @author pc
 */
public class ReservationVoyageOrganise {
    private int id_reservation;
    private int id_voyageorganise;
    private int id_user;
    private int id_agence;
    

    
    public ReservationVoyageOrganise(int id_voyageorganise, int id_user, int id_agence) {
        this.id_voyageorganise = id_voyageorganise;
        this.id_user = id_user;
        this.id_agence = id_agence;
    }


    
    @Override
    public String toString() {
        return "ReservationVoyageOrganise{" + "id_reservation=" + id_reservation + ", id_voyageorganise=" + id_voyageorganise +  ", id_agence=" + id_agence + '}';
    }

    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public int getId_voyageorganise() {
        return id_voyageorganise;
    }

    public void setId_voyageorganise(int id_voyageorganise) {
        this.id_voyageorganise = id_voyageorganise;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_agence() {
        return id_agence;
    }

    public void setId_agence(int id_agence) {
        this.id_agence = id_agence;
    }

    public ReservationVoyageOrganise(int id_reservation, int id_voyageorganise, int id_user, int id_agence) {
        this.id_reservation = id_reservation;
        this.id_voyageorganise = id_voyageorganise;
        this.id_user = id_user;
        this.id_agence = id_agence;
    }

    public ReservationVoyageOrganise() {
    }
    
}
