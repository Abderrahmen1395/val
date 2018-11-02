/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.sql.Date;

/**
 *
 * @author challakh
 */
public class Utilisateur {
     private int idu;
    private String nomu;
    private String prenomu;
    private String emailu;
    private String mdpu;
    private String sexeu;  
    private int connecteru;        
    private String adresseu;
    private int telephoneu;
    private int role;

    public Utilisateur() {
    }

    public Utilisateur(int idu, String nomu, String prenomu, String emailu, String mdpu, String sexeu, int connecteru, String adresseu, int telephoneu, int role) {
        this.idu = idu;
        this.nomu = nomu;
        this.prenomu = prenomu;
        this.emailu = emailu;
        this.mdpu = mdpu;
        this.sexeu = sexeu;
        this.connecteru = connecteru;
        this.adresseu = adresseu;
        this.telephoneu = telephoneu;
        this.role = role;
    }

    public Utilisateur(String nomu, String prenomu, String emailu, String mdpu, String sexeu, String adresseu, int telephoneu) {
        this.nomu = nomu;
        this.prenomu = prenomu;
        this.emailu = emailu;
        this.mdpu = mdpu;
        this.sexeu = sexeu;
        this.adresseu = adresseu;
        this.telephoneu = telephoneu;
    }

    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    public String getNomu() {
        return nomu;
    }

    public void setNomu(String nomu) {
        this.nomu = nomu;
    }

    public String getPrenomu() {
        return prenomu;
    }

    public void setPrenomu(String prenomu) {
        this.prenomu = prenomu;
    }

    public String getEmailu() {
        return emailu;
    }

    public void setEmailu(String emailu) {
        this.emailu = emailu;
    }

    public String getMdpu() {
        return mdpu;
    }

    public void setMdpu(String mdpu) {
        this.mdpu = mdpu;
    }

    public String getSexeu() {
        return sexeu;
    }

    public void setSexeu(String sexeu) {
        this.sexeu = sexeu;
    }

    public int getConnecteru() {
        return connecteru;
    }

    public void setConnecteru(int connecteru) {
        this.connecteru = connecteru;
    }

   

    public String getAdresseu() {
        return adresseu;
    }

    public void setAdresseu(String adresseu) {
        this.adresseu = adresseu;
    }

    public int getTelephoneu() {
        return telephoneu;
    }

    public void setTelephoneu(int telephoneu) {
        this.telephoneu = telephoneu;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "idu=" + idu + ", nomu=" + nomu + ", prenomu=" + prenomu + ", emailu=" + emailu + ", mdpu=" + mdpu + ", sexeu=" + sexeu + ", connecteru=" + connecteru + ", adresseu=" + adresseu + ", telephoneu=" + telephoneu + ", role=" + role + '}';
    }

   
    
}
