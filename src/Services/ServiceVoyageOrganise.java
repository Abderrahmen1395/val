package Services;

import Entites.VoyageOrganise;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import Utiles.Singleton;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServiceVoyageOrganise {
    

    Connection con = Singleton.getInstance().getConnection();
    private Statement st;

    public ServiceVoyageOrganise() {
        try {
            st = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void ajouterVoyageOrganise(VoyageOrganise c)  {
        
        
    try {
        String sqlInsert = "INSERT INTO `VoyageOrganise` (`prix_voyage`, `date_depart`, `date_retour`,`origine`, `pays_destination`, `ville_destination`, `nb_places`,  `hotel`,`id_agence`, `nom_agence`)" + "VALUES(?,?,?,?,?,?,?,?,?,?) ";
        PreparedStatement pre = con.prepareStatement(sqlInsert);
        pre.setInt(1, c.getPrix_voyage());
        pre.setDate(2, c.getDate_depart());
        pre.setDate(3, c.getDate_retour());
        pre.setString(4, c.getOrigine());
        pre.setString(5, c.getPays_destination());
        pre.setString(6, c.getVille_destination());
        pre.setInt(7, c.getnb_places());
        pre.setString(8, c.getHotel());
        pre.setInt(9, c.getId_agence());
        pre.setString(10, c.getNom_agence());
        pre.executeUpdate(); 
        System.out.println("succes ajout");
   } catch (SQLException ex) {
        Logger.getLogger(ServiceVoyageOrganise.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
   
     public boolean exist(VoyageOrganise u) {
         boolean b = false ;
     String requete = "select id from VoyageOrganise where id=?";

         PreparedStatement pst;
         try {
             pst = con.prepareStatement(requete);
              pst.setInt(1,u.getId());
            ResultSet resultat = pst.executeQuery();
            while ((resultat.next())&& (b==false)) {
                 int idUtilisateurs=resultat.getInt(1);
                  if (idUtilisateurs==u.getId()){
                      b=true ;
                      
                  }
                
              }
         } catch (SQLException ex) {
             Logger.getLogger(ServiceVoyageOrganise.class.getName()).log(Level.SEVERE, null, ex);
         }
      return b;
   
       
}
    
   
    public void modifierVoyageOrganise(VoyageOrganise c1,int id) throws SQLException {

        String sqlupdate = "update VoyageOrganise set Prix_voyage=? , origine=? , pays_destination=? ,ville_destination=? ,nb_places=?, hotel=?, id_agence=? ,nom_agence=? where id="+id ;
        PreparedStatement preupdate = con.prepareStatement(sqlupdate);

        preupdate.setInt(1, c1.getPrix_voyage());
        preupdate.setString(2, c1.getOrigine());
        preupdate.setString(3, c1.getPays_destination());
        preupdate.setString(4, c1.getVille_destination());
        preupdate.setInt(5, c1.getnb_places());
        preupdate.setString(6, c1.getHotel());
        preupdate.setInt(7, c1.getId_agence());
        preupdate.setString(8, c1.getNom_agence());
        
        preupdate.executeUpdate();
        System.out.println("Voyage Organise modifier");

    }
    
     public void supprimerVoyageOrganise(int id) throws SQLException {
        String sql = "DELETE FROM VoyageOrganise WHERE id=?";
        PreparedStatement stat= con.prepareStatement(sql);
        stat.setInt(1 , id);
        stat.executeUpdate();
        System.out.println("succees supprission");

    }
     
    public List<VoyageOrganise> afficherVoyageOrganise() {
       List<VoyageOrganise> maListe = new ArrayList();
        try {
            
            Statement sta = con.createStatement();
            String requette = "SELECT * from VoyageOrganise ";
            ResultSet rs = sta.executeQuery(requette);
            
            while (rs.next()) {
                VoyageOrganise U=new VoyageOrganise();
                U.setId(rs.getInt(1));
                U.setPrix_voyage(rs.getInt(2));
                U.setDate_depart(rs.getDate(3));
                U.setDate_retour(rs.getDate(4));
                U.setOrigine(rs.getString(5));
                U.setPays_destination(rs.getString(6));
                U.setVille_destination(rs.getString(7));
                U.setnb_places(rs.getInt(8));
                U.setHotel(rs.getString(9));
                U.setId_agence(rs.getInt(10));
                U.setNom_agence(rs.getString(11));
                maListe.add(U);
            }
        } catch (SQLException ex) {
         System.err.println(ex.getMessage());  
        }

        return maListe;
        
    }
    

}
