package InterfaceGraphique;

import java.awt.Color;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;

import BaseDonnee.manipulationBD;

public class Examen extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	manipulationBD bd;
	JComboBox Jour;
	JComboBox Moi;
	JComboBox annee;
	JComboBox semestre;
	private ClassPrincipale cp;
	public Examen() {
       
		cp = new ClassPrincipale("Examen Général",300,350);
		cp.getContentPane().setForeground(Color.CYAN);
		cp.setIconImage(Toolkit.getDefaultToolkit().getImage("picture\\logo.PNG"));
		JLabel lblDateExamen = new JLabel("Date Examen");
		lblDateExamen.setFont(new Font("Papyrus", Font.BOLD, 11));
		
		//activer/desactiver les menuItems
		cp.mnEdition.setEnabled(false);
		cp.mnApropos.setEnabled(true);
		cp.mnFichiers.setEnabled(true);
		
		cp.mntmNouveau.setEnabled(false);
		cp.mntmSupprimer.setEnabled(false);
		cp.mntmAide.setEnabled(false);
		cp.mntmApropos.setEnabled(false);
		cp.mntmContactMe.setEnabled(false);
		
		
		Jour = new JComboBox();
        for(int i=1; i<32;i++){
        	Jour.addItem(""+i);
        }
		Moi = new JComboBox();
        for(int i=1; i<13;i++){
        	Moi.addItem(""+i);
        }
		
		annee = new JComboBox();
        for(int i=0; i<10; i++){
        	int ann=2013+i;
        	annee.addItem(ann);
        }
		JLabel lblSemestre = new JLabel("Semestre");
		lblSemestre.setFont(new Font("Papyrus", Font.BOLD, 11));
		
		semestre = new JComboBox();
        for(int i=1;i<7; i++ ){
        	semestre.addItem(""+i);
        }
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnVoirDateExamen = new JButton("Voir Date Examen");
		btnVoirDateExamen.setFont(new Font("Papyrus", Font.BOLD, 11));
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setFont(new Font("Sylfaen", Font.BOLD, 11));
		btnRetour.setIcon(new ImageIcon("picture\\exit.png"));
		
		JButton btnSupprimer = new JButton("supprimer");
		btnSupprimer.setFont(new Font("Sylfaen", Font.BOLD, 11));
		
		JButton button = new JButton("Planifier");
		button.setFont(new Font("Papyrus", Font.BOLD, 11));
		GroupLayout groupLayout = new GroupLayout(cp.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDateExamen)
							.addGap(25)
							.addComponent(Jour, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(Moi, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(annee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblSemestre)
							.addGap(57)
							.addComponent(semestre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button, 0, 0, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnSupprimer)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnRetour, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(35, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(68, Short.MAX_VALUE)
					.addComponent(btnVoirDateExamen)
					.addGap(79))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDateExamen)
						.addComponent(Jour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Moi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(annee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(semestre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblSemestre))
					.addGap(18)
					.addComponent(btnVoirDateExamen)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSupprimer)
						.addComponent(btnRetour))
					.addContainerGap())
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		cp.getContentPane().setLayout(groupLayout);
		
        button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int j=Jour.getSelectedIndex()+1;
				int m = Moi.getSelectedIndex()+1;
				Object a = annee.getSelectedItem();
				String date =a+"-"+m+"-"+j;
				int semestr=semestre.getSelectedIndex()+1;
				bd.AjouterExamen(date, semestr);
				table.setModel(bd.AfficherExamen());
				
			}
        	
        });
		
		btnVoirDateExamen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try  {
					
					bd = new manipulationBD();
					bd.AfficherExamen();
					table.setModel(bd.AfficherExamen());
				}catch(Exception e){
					e.printStackTrace();
				}	
			}});
		btnSupprimer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg){
				bd.SupprimerExamen(table.getSelectedRow()+1);
				table.setModel(bd.AfficherExamen());
			}
		});
		
		//CLIQUE SUR BOUTTON RETOUR
		btnRetour.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg){
				cp.dispose();
			}
		});
	}
	
	public static void main(String[] args) {
		new accueilP();
		
}
}

