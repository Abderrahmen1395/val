/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author challakh
 */
public class Singleton { 
     static Singleton instance;
      final String url="jdbc:mySql://localhost/holidaysnow";
        final String login="root";
        final String password="";
        Connection connexion;
        private Singleton(){try {
             connexion = DriverManager.getConnection(url, login, password);
            System.out.println("connexion etablie");
        } catch (SQLException ex) {
            System.out.println("erreur de connexion");
        }}
        public static Singleton getInstance()
        {
            if(instance==null)
                instance=new Singleton();
            return instance;
        }
        public Connection getConnection()
        {
            return connexion;
        }
}
