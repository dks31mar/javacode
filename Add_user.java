package com.admin.login.invoice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

@SuppressWarnings("serial")
public class Add_user extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField passwordField;
	private JPasswordField repasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_user frame = new Add_user();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Add_user() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Create Users");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterUserName = new JLabel("Enter User Name");
		lblEnterUserName.setBounds(97, 59, 111, 14);
		contentPane.add(lblEnterUserName);
		
		JLabel lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setBounds(97, 84, 99, 14);
		contentPane.add(lblEnterPassword);
		
		username = new JTextField();
		username.setBounds(218, 56, 140, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(218, 81, 140, 20);
		contentPane.add(passwordField);
		
		JLabel lblReEnterPassword = new JLabel("Re Enter Password");
		lblReEnterPassword.setBounds(97, 109, 111, 14);
		contentPane.add(lblReEnterPassword);
		
		repasswordField = new JPasswordField();
		repasswordField.setBounds(218, 106, 140, 20);
		contentPane.add(repasswordField);
		
		final JButton btnCreateUser = new JButton("Create User");
		btnCreateUser.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==btnCreateUser) {
					
					if (passwordField.getText().equals(repasswordField.getText())) {
						try{

							
							Connection con = ConnectionProvider.getConnection();
							String query="insert into emp_login(username, password)" + "values (?,?)";
							PreparedStatement presmt = con.prepareStatement(query);	
							presmt.setString(1,username.getText());
							presmt.setString(2,passwordField.getText());
							presmt.execute();
					        con.close();
						    JOptionPane.showMessageDialog(null,"User saved!!!");
						}catch(Exception e1){
							JOptionPane.showMessageDialog(null,"connection not created!!!");
						}
					} else {
						
						JOptionPane.showMessageDialog(null,"Password Not Match");

					}
					
					
				}
			}
		});
		btnCreateUser.setBounds(168, 153, 122, 23);
		contentPane.add(btnCreateUser);
		
		JLabel lblCreateUsers = new JLabel("Create Users");
		lblCreateUsers.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCreateUsers.setBounds(190, 11, 140, 14);
		contentPane.add(lblCreateUsers);
	}
}
