/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entites.Agence;
import Utiles.Singleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author challakh
 */
public class AgenceServices {
    Connection connexion;

    public AgenceServices(Connection connexion) {
        this.connexion = connexion;
    }

    public AgenceServices() {
        connexion =Singleton.getInstance().getConnection();
    }
     public void ajouterAgence(Agence a) throws SQLException
  {
     String req= "INSERT INTO `agence`( `Nom_agence`, `Email_agence`, `Mdp_agence`, `Adresse_agence`, `Telephone_agence`, `Fax_agence`) VALUES ( ?,?,?,?,?,?)";
     PreparedStatement PS=connexion.prepareStatement(req);
     PS.setString(1,a.getNom());
     PS.setString(2,a.getEmail());
     PS.setString(3,a.getMdp());
     PS.setString(4,a.getAdresse());
     PS.setInt(5,a.getTelephone());
     PS.setInt(6,a.getFax());
    

     PS.executeUpdate();
     }
      public List<Agence> getALLAgences() throws SQLException
  { List<Agence> agences= new ArrayList<>();
      String req="SELECT * FROM `agence`";
      Statement stm=connexion.createStatement();
      ResultSet rst= stm.executeQuery(req);
      while(rst.next())
      {
          Agence a=new Agence(rst.getString("nom"),rst.getString("email"),rst.getString("mdp"),rst.getString("adresse"),rst.getInt("telephone")
                  ,rst.getInt("fax"));
          agences.add(a);
      }
      return agences;}
       public void modifierAgence(Agence a,int id) throws SQLException
  {
     String req= "UPDATE `agence` SET `Nom_agence`=?,`Email_agence`=?,`Mdp_agence`=?,`Adresse_agence`=?,`Telephone_agence`=?,`Fax_agence`=? WHERE `Id_agence`=?";
     PreparedStatement PS=connexion.prepareStatement(req);
    PS.setString(1,a.getNom());
     PS.setString(2,a.getEmail());
     PS.setString(3,a.getMdp());
     PS.setString(4,a.getAdresse());
     PS.setInt(5,a.getTelephone());
     PS.setInt(6,a.getFax());
     
     PS.setInt(7,id);
     
     PS.executeUpdate();
     }
       
       
          public void supprimerAgence(int id) throws SQLException
  {
     String req= "DELETE FROM `agence` WHERE `id`=?";
      PreparedStatement PS=connexion.prepareStatement(req);
     PS.setInt(1,id);
     PS.executeUpdate();
     }
      public boolean exist(String Email) throws SQLException {
         boolean b = false ;
     String req = "select  `Email_agence` from agence where `Email_agence`=?";
    

         PreparedStatement pst;
        
             pst = connexion.prepareStatement(req);
              pst.setString(1,Email);
            ResultSet resultat = pst.executeQuery();
            while ((resultat.next())&& (b==false)) {
                 String emailagence=resultat.getString(1);
                  if (emailagence.equalsIgnoreCase(Email))
                      
                  {
                      b=true ;
                      
                  }
                 
              }
        return b;
         }
        public boolean MotDePassseCorrect (String Email,String modp) throws SQLException
        {boolean b=false;
         String req = "select  `Mdp_agence` from agence where `Email_agence`=?";   
         PreparedStatement pst;
             pst = connexion.prepareStatement(req);
                pst.setString(1,Email);
            ResultSet resultat = pst.executeQuery();
              while ((resultat.next())&& (b==false)) {
                 String mdpagence=resultat.getString("Mdp_agence");
                  if (mdpagence.equalsIgnoreCase(modp))
                      
                  {
                      b=true ;
                      
                  }
                 
              }
        return b;
        }
        public void MettreAUn(String email) throws SQLException
        {
            String req = "UPDATE `agence` SET `Connecter_agence`=1 WHERE `Email_agence`=?";   
        PreparedStatement PS=connexion.prepareStatement(req);
     PS.setString(1,email);
     PS.executeUpdate();
        }
         public void MettreAZero() throws SQLException
        {
            String req = "UPDATE `agence` SET `Connecter_agence`=0";   
        PreparedStatement PS=connexion.prepareStatement(req);
  
     PS.executeUpdate();
        }
         public Agence AgenceConnecte() throws SQLException
         {
             
              String req="SELECT * FROM `agence` WHERE `Connecter_agence`=?";
              PreparedStatement stm=connexion.prepareStatement(req);
              stm.setInt(1,1);
      ResultSet rst= stm.executeQuery();
       Agence a=new Agence();
      while(rst.next())
      {
     a.setId(rst.getInt(1));
     a.setNom(rst.getString(2));
     a.setEmail(rst.getString(3));
     a.setMdp(rst.getString(4));
     a.setAdresse(rst.getString(5));
     a.setTelephone(rst.getInt(6));
     a.setFax(rst.getInt(7));
     a.setConnecter_agence(rst.getInt(8));
     a.setRole(rst.getInt(9));
          
           
      }
         
    return a;
         }
         public boolean TrouveAgence(String email) throws SQLException
         {
             boolean b=false;
             String req = "select  `Email_agence` from agence";   
         PreparedStatement stm;
             stm = connexion.prepareStatement(req);        
              ResultSet rst= stm.executeQuery();
              while(rst.next()&&(b==false))
      {
    String email_agence=rst.getString("Email_agence");
    if (email.equalsIgnoreCase(email_agence))
            b=true;
    
          
           
      }
              return b;
         }
       
    
           
      
         
  
         
         public boolean AgenceVerifie(String email) throws SQLException
         {
              boolean b=false;
             String req = "select  `verifier` from agence where `Email_agence`=? ";   
         PreparedStatement stm;
             stm = connexion.prepareStatement(req); 
             stm.setString(1,email);
              ResultSet rst= stm.executeQuery();
              while(rst.next()&&(b==false))
      {
    int verif=rst.getInt("verifier");
    if (verif==1)
            b=true;
         }
              return b;
}
          public boolean AgenceBloque(String email) throws SQLException
         {
              boolean b=false;
             String req = "select  `bloquer` from agence where `Email_agence`=? ";   
         PreparedStatement stm;
             stm = connexion.prepareStatement(req); 
             stm.setString(1,email);
              ResultSet rst= stm.executeQuery();
              while(rst.next()&&(b==false))
      {
    int bloq=rst.getInt("bloquer");
    if (bloq==1)
            b=true;
         }
              return b;
}
}