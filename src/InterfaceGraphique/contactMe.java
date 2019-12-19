package InterfaceGraphique;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class contactMe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 new contactMe();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public contactMe() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Fire-PC\\Documents\\adt-bundle-windows-x86-20140702\\pROJETaNDROID\\GestionActivit\u00E9Etudiant\\picture\\about.png"));
		setTitle("CONTACT ME");
		setResizable(false);
		setVisible(true);
		setBounds(100, 100, 359, 165);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblTel = new JLabel("Tel: +237 672 08 13 08/695 15 99 24");
		lblTel.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblTel.setForeground(new Color(30, 144, 255));
		panel.add(lblTel);
		
		JLabel lblEmailTchindebebrunogmailcom = new JLabel("E-MAIL:     tchindebebruno@gmail.com");
		sl_panel.putConstraint(SpringLayout.WEST, lblTel, 0, SpringLayout.WEST, lblEmailTchindebebrunogmailcom);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblTel, -21, SpringLayout.NORTH, lblEmailTchindebebrunogmailcom);
		sl_panel.putConstraint(SpringLayout.WEST, lblEmailTchindebebrunogmailcom, 10, SpringLayout.WEST, panel);
		lblEmailTchindebebrunogmailcom.setFont(new Font("SimSun-ExtB", Font.BOLD | Font.ITALIC, 12));
		lblEmailTchindebebrunogmailcom.setForeground(new Color(0, 0, 128));
		panel.add(lblEmailTchindebebrunogmailcom);
		
		JLabel lblIgnabaitchindebebrunogmailcom = new JLabel("ignabaitchindebebruno@yahoo.fr");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblEmailTchindebebrunogmailcom, -6, SpringLayout.NORTH, lblIgnabaitchindebebrunogmailcom);
		sl_panel.putConstraint(SpringLayout.EAST, lblEmailTchindebebrunogmailcom, 0, SpringLayout.EAST, lblIgnabaitchindebebrunogmailcom);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblIgnabaitchindebebrunogmailcom, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblIgnabaitchindebebrunogmailcom, -34, SpringLayout.EAST, panel);
		lblIgnabaitchindebebrunogmailcom.setFont(new Font("SimSun-ExtB", Font.BOLD | Font.ITALIC, 12));
		lblIgnabaitchindebebrunogmailcom.setForeground(new Color(0, 0, 128));
		panel.add(lblIgnabaitchindebebrunogmailcom);
		
		JLabel lblContactMe = new JLabel("CONTACT ME");
		lblContactMe.setFont(new Font("Segoe Script", Font.BOLD, 11));
		sl_panel.putConstraint(SpringLayout.NORTH, lblContactMe, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblContactMe, 0, SpringLayout.EAST, lblTel);
		panel.add(lblContactMe);
		
		JLabel lblNewLabel = new JLabel("");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, lblContactMe);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, -47, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, -12, SpringLayout.SOUTH, lblTel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -10, SpringLayout.EAST, panel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Fire-PC\\Documents\\adt-bundle-windows-x86-20140702\\pROJETaNDROID\\GestionActivit\u00E9Etudiant\\images\\profilephoto.jpeg"));
		panel.add(lblNewLabel);
		contentPane.setLayout(gl_contentPane);
	}

}
