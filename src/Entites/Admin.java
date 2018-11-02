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
public class Admin {
    private String username;
    private String mdp;

    public Admin() {
    }

    public Admin(String username, String mdp) {
        this.username = username;
        this.mdp = mdp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Override
    public String toString() {
        return "Admin{" + "username=" + username + ", mdp=" + mdp + '}';
    }
    
}
