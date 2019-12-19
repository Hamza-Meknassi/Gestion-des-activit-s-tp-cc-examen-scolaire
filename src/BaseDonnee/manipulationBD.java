package BaseDonnee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class manipulationBD extends connexion{
	public String requete;
	public DefaultTableModel dtt;
	public manipulationBD() {
	
	}
public DefaultTableModel  AfficherMatiere(){
		
		
		DefaultTableModel dt = new DefaultTableModel();
		dt.addColumn("Nom Matiere");
		dt.addColumn("Crédits");
		dt.addColumn("Nombre Enseignant");
		dt.addColumn("TP");
		try{
			Statement  stx=conn.createStatement();
	
			String  query="SELECT * FROM matieres";
		    ResultSet	rset=stx.executeQuery(query);
		    
			while(rset.next()){
				Object []tableau={rset.getObject("matiere"),rset.getInt("Credits"),rset.getObject("nomEnseignant"),rset.getObject("TP")};
				dt.addRow(tableau);
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,"ERROR","Message d’avertissement",JOptionPane.ERROR_MESSAGE);
			
		}
		return dt;
	
	}
    public DefaultTableModel  afficherTache(){
	DefaultTableModel dt = new DefaultTableModel();
	dt.addColumn("Nom Matiere");
	dt.addColumn("Type de Tache");
	dt.addColumn("DateComposi");
	dt.addColumn("Heure");
	try{
		Statement  stx=conn.createStatement();
		String  query="SELECT * FROM tache";
	    ResultSet	rset=stx.executeQuery(query);
		while(rset.next()){
			Object []tableau={rset.getObject("matiere"),rset.getObject("typeTache"),rset.getObject("DateComposi"),rset.getObject("Heure")};
			dt.addRow(tableau);
		}
	}
	catch(SQLException ex){
		ex.printStackTrace();		
	}
	return dt;

}
public DefaultTableModel  AfficherExamen(){
		
		
		dtt = new DefaultTableModel();
		dtt.addColumn("Date d'Examen");
		dtt.addColumn("Semestre");
		try{
			connexion c =new connexion();
			Statement  stx=c.conn.createStatement();
			String  query="SELECT * FROM examen";
		    ResultSet	rset=stx.executeQuery(query);
			while(rset.next()){
				Object []tableau={rset.getObject("DateExamen"),rset.getInt("semestre")};
				dtt.addRow(tableau);
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,"ERROR DE CONNEXION SUR LA BD","Message d’avertissement",JOptionPane.ERROR_MESSAGE);
			
		}
		return dtt;
	
	}


public DefaultTableModel  AfficherFiliere(){
	
	
	DefaultTableModel dt = new DefaultTableModel();
	dt.addColumn("Filiere");
	dt.addColumn("Cycle");
	try{
		Statement  stx=conn.createStatement();
		String  query="SELECT * FROM matieres";
	    ResultSet	rset=stx.executeQuery(query);
		while(rset.next()){
			Object []tableau={rset.getObject("NomFiliere"),rset.getObject("cycle")};
			dt.addRow(tableau);
		}
	}
	catch(SQLException ex){
		ex.printStackTrace();
		JOptionPane.showMessageDialog(null,"ERROR","Message d’avertissement",JOptionPane.ERROR_MESSAGE);
		
	}
	return dt;
}


	public int AjouterMatiere(String nomMatiere,int credit, String nomEnseig, boolean tp){
		int rset=0;
		try {
			Statement state =conn.createStatement();
			String requete ="INSERT INTO matieres VALUES('"+nomMatiere+"',"+credit+",'"+nomEnseig+"',"+tp+")";
			rset =state.executeUpdate(requete);
		}
		catch(SQLException sq){
			sq.printStackTrace();
			JOptionPane.showMessageDialog(null,"ERROR INCONNU","Message d’avertissement",JOptionPane.ERROR_MESSAGE);
			
		}
		return rset;
	}
	public int AjouterTache(String matiere,String typeTach, String date, String Heure){
		int rset=0;
		try {
			Statement state =conn.createStatement();
			String requete ="INSERT INTO tache VALUES('"+matiere+"','"+typeTach+"','"+date+"','"+Heure+"')";
			rset =state.executeUpdate(requete);
		}
		catch(SQLException sq){
			sq.printStackTrace();
			JOptionPane.showMessageDialog(null,"ERROR INCONNU","Message d’avertissement",JOptionPane.ERROR_MESSAGE);
		}
		return rset;
	}
	public int AjouterExamen(String date, int semestre){
		int rset=0;
		try {
			Statement state =conn.createStatement();
			String requete ="INSERT INTO examen VALUES("+semestre+",'"+date+"')";
			rset =state.executeUpdate(requete);
		}
		catch(SQLException sq){
			sq.printStackTrace();
			JOptionPane.showMessageDialog(null,"Semestre "+semestre+" Existe déjà!!!","Message d’avertissement",JOptionPane.ERROR_MESSAGE);
		}
		return rset;
	}	
	public int SupprimerTache(String matier,String typeTach){
		
		int rset=0;
		try {
			Statement state =conn.createStatement();
			
			requete ="DELETE FROM tache where matiere='"+matier+"' and typeTache='"+typeTach+"';";
			rset =state.executeUpdate(requete);
		}
		catch(SQLException sq){
			sq.printStackTrace();
			JOptionPane.showMessageDialog(null,"ERROR INCONNU","Message d’avertissement",JOptionPane.ERROR_MESSAGE);
			
		}
		return rset;
	}
	public int SupprimerMatiere(String matier){
		int rset=0;
		try {
			Statement state =conn.createStatement();
			//int i = 0;
			afficherTache();
			requete ="DELETE FROM matieres where matiere='"+matier+"';";
			rset =state.executeUpdate(requete);
		}
		catch(SQLException sq){
			sq.printStackTrace();
			JOptionPane.showMessageDialog(null,"ERROR INCONNU","Message d’avertissement",JOptionPane.ERROR_MESSAGE);
		}
		return rset;
	}
	public int SupprimerExamen(int semestre){
		int rset=0;
		try {
			Statement state =conn.createStatement();
			afficherTache();
			requete ="DELETE FROM examen where semestre="+semestre+";";
			rset =state.executeUpdate(requete);
		}
		catch(SQLException sq){
			sq.printStackTrace();
			JOptionPane.showMessageDialog(null,"ERROR INCONNU","Message d’avertissement",JOptionPane.ERROR_MESSAGE);
		}
		return rset;
	}
	public int InsertConnect(String user){
		int rset=0;
		try {
			Statement state =conn.createStatement();
			String requete ="INSERT INTO connect VALUE('"+user+"',now())";
			rset =state.executeUpdate(requete);
			System.out.println(requete);
		}
		catch(SQLException sq){
			sq.printStackTrace();
		}
		return rset;
	}	
	public String PersonneConnecte(){
		String text = "non";
		try {
			Statement st =conn.createStatement();
			ResultSet r=st.executeQuery("Select* from connect");
			while(r.next()){
					text=(String)r.getObject("usr").toString();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return text;
	}
	public DefaultTableModel afficheHistoriqueConnect(){
		DefaultTableModel dt =new DefaultTableModel();
		dt.addColumn("User");
		dt.addColumn("Date de Connexion");
	    
	    try {
	    	//statement
	    	Statement st=conn.createStatement();
			ResultSet rs =st.executeQuery("SELECT* FROM connect");
			while(rs.next()){
				//charger tous les element de connect dans un tableau
				Object[] tab={rs.getObject("usr"),rs.getObject("date")};
				//tab devient ici les ligne de notre tableau
				dt.addRow(tab);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dt;
		
	}
	
	
	public static void main(String[] args) {
		
}
	
}