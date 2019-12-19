package InterfaceGraphique;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import BaseDonnee.manipulationBD;
import javax.swing.SwingConstants;

public class EditerTache extends JPanel implements ActionListener {
	private ClassPrincipale cp;
	manipulationBD bd;
	JComboBox numTach;
	
	private static final long serialVersionUID = 1L;
	public EditerTache() {
		
		//utilisztion du JFrame de la classPrincipale
	 cp =new ClassPrincipale("EDITER TACHE", 350, 250);
	 cp.setIconImage(Toolkit.getDefaultToolkit().getImage("picture\\logo.PNG"));
	    //activation/desactivation des MenuItem	
	 
	 cp.mnFichiers.setEnabled(true);
	 cp.mntmNouveau.setEnabled(false);
	 cp.mntmSupprimer.setEnabled(false);
	 cp.mntmQuitter.setEnabled(true);
	 
	 cp.mnEdition.setEnabled(false);
		
	 
		JLabel lblRechercherLaTache = new JLabel("RECHERCHER LA TACHE A MODIFIER");
		lblRechercherLaTache.setBackground(Color.LIGHT_GRAY);
		lblRechercherLaTache.setToolTipText("");
		lblRechercherLaTache.setLabelFor(cp);
		lblRechercherLaTache.setHorizontalAlignment(SwingConstants.CENTER);
		lblRechercherLaTache.setForeground(Color.BLUE);
		lblRechercherLaTache.setFont(new Font("Sylfaen", Font.BOLD, 11));
		
		JLabel lblNumTache = new JLabel("CHOISIR");
		lblNumTache.setFont(new Font("Shonar Bangla", Font.BOLD | Font.ITALIC, 12));
		
		
		numTach = new JComboBox();
		
		
		
		JButton btnRechercher = new JButton("Editer");
		btnRechercher.setFont(new Font("Shonar Bangla", Font.BOLD, 14));
		btnRechercher.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
			
		});
		
		btnRechercher.setIcon(new ImageIcon("images\\editer.jpg"));
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setFont(new Font("Sylfaen", Font.BOLD, 11));
		btnRetour.setIcon(new ImageIcon("picture\\exit.png"));
		GroupLayout groupLayout = new GroupLayout(cp.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNumTache)
							.addGap(18)
							.addComponent(numTach, 0, 226, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRechercher, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
							.addComponent(btnRetour, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
					.addGap(42))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addComponent(lblRechercherLaTache, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(61, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(lblRechercherLaTache)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumTache)
						.addComponent(numTach, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRechercher, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRetour, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(34))
		);
		cp.getContentPane().setLayout(groupLayout);
		cp.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{cp.getContentPane(), lblNumTache, numTach, btnRechercher, lblRechercherLaTache}));

		try  {
		bd = new manipulationBD();
		bd.afficherTache();
		for(int i=0; i<bd.afficherTache().getRowCount();i++){
			numTach.addItem(""+bd.afficherTache().getValueAt(i, 1)+" De "+bd.afficherTache().getValueAt(i, 0));
		}
		}catch(Exception e){
			e.printStackTrace();
		}		
		btnRetour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				cp.dispose();
			}
			
		});
		btnRechercher.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				try{
				String a=(String)numTach.getSelectedItem();
				int i=0;
				
				while(!a.equals(""+bd.afficherTache().getValueAt(i, 1)+" De "+bd.afficherTache().getValueAt(i, 0)) && i<bd.afficherTache().getRowCount()){
					i++;
				}
				
				String type =(String)bd.afficherTache().getValueAt(i, 1);
				String matier =(String)bd.afficherTache().getValueAt(i, 0);
		
				if(a!=""+bd.afficherTache().getValueAt(i, 1)+" De "+bd.afficherTache().getValueAt(i, 0)){
				bd.SupprimerTache(matier, type);
				}
				System.out.println(matier+""+type);
				cp.dispose();
				new nouveauTache();
			}catch(Exception a){
				a.printStackTrace();
			}
			}
		
		});
	}
	public static void main(String[] args) {
		new EditerTache();
		
}
	@Override
	public void actionPerformed(ActionEvent arg0) {
			
		}
		
}

