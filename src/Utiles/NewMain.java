/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import Entites.Agence;
import Services.AgenceServices;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author challakh
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Singleton database = Singleton.getInstance();
        java.sql.Connection connexion = Singleton.getInstance().getConnection();
        Agence a=new Agence("tahavoyage", "tahavoyage@gmail.com", "taha1995", "nahj l bahrain 22 tunis", 98556554, 98556554);
        Agence a1=new Agence("abdouvoyage", "abdouvoyage@gmail.com", "abdou1995", "nahj l koteb 22 tunis", 53403110, 70222225);
        AgenceServices as =new AgenceServices();
      /* try {
            as.ajouterAgence(a1);
            System.out.println("ajoutée avec succes");
        } catch (SQLException ex) {
            System.out.println(ex);        }*/
        try {
            boolean b;
            b=as.exist("tahavo@gmail.com");
            System.out.println(b);
        } catch (SQLException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        try {boolean b1;
            b1=as.MotDePassseCorrect("abdouvoyage@gmail.com", "abdou1995");
            System.out.println(b1);
        } catch (SQLException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
       
          
    }
    }
    

