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
public class Agence {
     private int id;
    private String nom;
    private String email;
    private String mdp;
    private String adresse;
    private int telephone;
    private int fax;
    private int role;
    private int connecter_agence;
private int verifier;
private int bloquer;
  

    public Agence() {
    }

    public Agence(int id, String nom, String email, String mdp, String adresse, int telephone, int fax, int role, int connecter_agence) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
        this.adresse = adresse;
        this.telephone = telephone;
        this.fax = fax;
        this.role = role;
        this.connecter_agence = connecter_agence;
    }

    public Agence(int id, String nom, String email, String mdp, String adresse, int telephone, int fax, int role) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
        this.adresse = adresse;
        this.telephone = telephone;
        this.fax = fax;
        this.role = role;
    }

    public Agence(String nom, String email, String mdp, String adresse, int telephone, int fax  ) {
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
        this.adresse = adresse;
        this.telephone = telephone;
        this.fax = fax;
        
    }

    public int getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getAdresse() {
        return adresse;
    }
    
    public int getConnecter_agence() {
        return connecter_agence;
    }

    public void setConnecter_agence(int connecter_agence) {
        this.connecter_agence = connecter_agence;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getFax() {
        return fax;
    }

    public void setFax(int fax) {
        this.fax = fax;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getVerifier() {
        return verifier;
    }

    public void setVerifier(int verifier) {
        this.verifier = verifier;
    }

    public int getBloquer() {
        return bloquer;
    }

    public void setBloquer(int bloquer) {
        this.bloquer = bloquer;
    }

    @Override
    public String toString() {
        return "Agence{" + "id=" + id + ", nom=" + nom + ", email=" + email + ", mdp=" + mdp + ", adresse=" + adresse + ", telephone=" + telephone + ", fax=" + fax + ", role=" + role + ", connecter_agence=" + connecter_agence + '}';
    }

   
    
    
}
