package BaseDonnee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import InterfaceGraphique.Login;
public class connexion {
	String NameDB="gestiontachesetudiant";
	public String url = "jdbc:mysql://localhost:3306/"+NameDB;
	Login l =new Login();
	public String usr ="root" ;
	public String pwd =null;
	public Connection conn;

	public connexion() {
		try  {
			//charge le driver
		Class.forName("com.mysql.jdbc.Driver"); 
		System.out.println("Driver Chargé ... ok!");
		System.out.println("Tentative de connexion à "+url+" avec " +usr+ " mpd "+pwd);
		  
		//connexion
		conn = DriverManager.getConnection(url,usr,pwd);
		System.out.println("Connexion .... ok!!!!");
		
		}catch(SQLException ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,"ERREUR DE CONNEXION","Message d’avertissement",JOptionPane.ERROR_MESSAGE);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Echec de connexion");
		}
	}
	public static void main(String[] args) {
		
	}}