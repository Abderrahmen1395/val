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
public class ReservationActivite {
    private int id_reservation;
    private int id_activite;
    private int id_user;
    private int id_agence;
    

    
    public ReservationActivite(int id_activite, int id_user, int id_agence) {
        this.id_activite = id_activite;
        this.id_user = id_user;
        this.id_agence = id_agence;
    }


    
    @Override
    public String toString() {
        return "Reservationactivite{" + "id_reservation=" + id_reservation + ", id_activite=" + id_activite +  ", id_agence=" + id_agence + '}';
    }

    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public int getId_activite() {
        return id_activite;
    }

    public void setId_activite(int id_activite) {
        this.id_activite = id_activite;
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

    public ReservationActivite(int id_reservation, int id_activite, int id_user, int id_agence) {
        this.id_reservation = id_reservation;
        this.id_activite = id_activite;
        this.id_user = id_user;
        this.id_agence = id_agence;
    }

    public ReservationActivite() {
    }
    
}
