/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

/**
 *
 * @author Y520-I7-1TR-4G
 */
public class ReservationHebergement {
    private int idReservationh;
    private int idAgence;
    private int idHebergement;
    private int idUtilisateur;

    public ReservationHebergement() {
    }

    public ReservationHebergement(int idReservationh, int idAgence, int idHebergement, int idUtilisateur) {
        this.idReservationh = idReservationh;
        this.idAgence = idAgence;
        this.idHebergement = idHebergement;
        this.idUtilisateur = idUtilisateur;
    }

    public ReservationHebergement( int idHebergement, int idUtilisateur,int idAgence) {
        this.idAgence = idAgence;
        this.idHebergement = idHebergement;
        this.idUtilisateur = idUtilisateur;
    }

    public int getIdReservationh() {
        return idReservationh;
    }

    public void setIdReservationh(int idReservationh) {
        this.idReservationh = idReservationh;
    }

    public int getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(int idAgence) {
        this.idAgence = idAgence;
    }

    public int getIdHebergement() {
        return idHebergement;
    }

    public void setIdHebergement(int idHebergement) {
        this.idHebergement = idHebergement;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
    
    
}
