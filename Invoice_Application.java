package com.admin.login.invoice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Invoice_Application {

	JFrame frmLogin;
	private JTextField textFieldadmin;
	private JPasswordField passwordFieldadmin;
	private JTextField textFieldemp;
	private JPasswordField passwordFieldemp;
	private JPanel Adminpanel;
	private JPanel Employeepanel;
	private JButton btnadminlogin;
	private JLabel adminlable;
	private JLabel emplable;
	private JButton btnemplogin;
	private JButton btnIAmEmployee;
	private JButton btnIAmAdmin;
	private JLabel loginwindowlable;
	private JButton btnHome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Invoice_Application window = new Invoice_Application();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Invoice_Application() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
	
		frmLogin.setTitle("Login");
		frmLogin.getContentPane().setForeground(UIManager.getColor("InternalFrame.activeBorderColor"));
		frmLogin.getContentPane().setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		frmLogin.setBounds(100, 100, 629, 348);
		/*setResizable(false);*/
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnIAmAdmin = new JButton("I Am Admin");
		btnIAmAdmin.setBounds(65, 173, 171, 23);
		btnIAmAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnIAmAdmin){
					{
						
						int conf=JOptionPane.showConfirmDialog(null," Do You Want to login as admin ? ","Confirmation",JOptionPane.YES_NO_OPTION);
						if(conf==JOptionPane.YES_OPTION)
							{
							JOptionPane.showMessageDialog(null, 
			 				"\n WELLCOME " +
			 				"\n\n Enter Your User Name & Password ","Please login", JOptionPane.PLAIN_MESSAGE );
							
							/*JOptionPane.showMessageDialog(null,
							"\n SORRY!!!" +
			 				"\n Doesn't working" , "ERROR", JOptionPane.ERROR_MESSAGE );*/
							Adminpanel.setVisible(true);
							btnIAmEmployee.setVisible(false);
							btnIAmAdmin.setVisible(false);
							loginwindowlable.setVisible(false);
							btnHome.setVisible(true);
							}
						}
					
				
				
				}
			}
		});
		
		loginwindowlable = new JLabel("LOGIN WINDOW");
		loginwindowlable.setBounds(237, 11, 125, 17);
		loginwindowlable.setFont(new Font("Times New Roman", Font.BOLD, 14));
		frmLogin.getContentPane().setLayout(null);
		frmLogin.getContentPane().add(btnIAmAdmin);
		frmLogin.getContentPane().add(loginwindowlable);
		
		btnIAmEmployee = new JButton("I Am Employee");
		btnIAmEmployee.setBounds(318, 173, 163, 23);
		frmLogin.getContentPane().add(btnIAmEmployee);
		
		btnHome = new JButton("Home");
		btnHome.setBounds(501, 276, 89, 23);
		btnHome.setVisible(false);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnHome){
					Invoice_Application ia=new Invoice_Application();
					ia.frmLogin.setVisible(true);
				frmLogin.dispose();
				}
			}
		});
		frmLogin.getContentPane().add(btnHome);
		
		Employeepanel = new JPanel();
		Employeepanel.setBounds(150, 34, 274, 128);
		frmLogin.getContentPane().add(Employeepanel);
		Employeepanel.setVisible(false);
		Employeepanel.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		
		JLabel label = new JLabel("");
		label.setBounds(139, 5, 0, 0);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(18, 31, 80, 14);
		
		textFieldemp = new JTextField();
		textFieldemp.setBounds(126, 25, 130, 20);
		textFieldemp.setColumns(10);
		
		passwordFieldemp = new JPasswordField();
		passwordFieldemp.setBounds(126, 51, 130, 20);
		
		btnemplogin = new JButton("Login");
		btnemplogin.setBounds(153, 89, 103, 23);
		btnemplogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnemplogin){
					System.out.println("emp");
					int t=0;
					try{
						System.out.println("emp1");
						Connection con1 = ConnectionProvider.getConnection();
	                    Statement st1=con1.createStatement();
	                    ResultSet rs=st1.executeQuery("SELECT * FROM emp_login");
	                    while(rs.next())
	                    {
	                    	System.out.println("emp2");
	                            if((textFieldemp.getText().equals(rs.getString("username"))) && (passwordFieldemp.getText().equals(rs.getString("password"))))
	                            {
								
								t++;
									RetriveDataOfProduct rdop=new RetriveDataOfProduct();
									rdop.setVisible(true);
									
	                            }

	                    }
	                    if(t==0)
	                    {
	                    	         JOptionPane.showMessageDialog(null,"You Are Not a Valid User ,Check Your User ID or Password");
	                   }
					}
					catch(Exception et){
						   
						   JOptionPane.showMessageDialog(null,"Check your connective and try again !!!");
						   }
				}
			}
		});
		
		emplable = new JLabel("Employee Login");
		emplable.setBounds(65, 5, 158, 14);
		emplable.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Employeepanel.setLayout(null);
		Employeepanel.add(lblUserName);
		Employeepanel.add(passwordFieldemp);
		Employeepanel.add(textFieldemp);
		Employeepanel.add(emplable);
		Employeepanel.add(label);
		Employeepanel.add(btnemplogin);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(18, 54, 80, 14);
		Employeepanel.add(lblNewLabel_2);
		
		Adminpanel = new JPanel();
		Adminpanel.setBounds(160, 79, 274, 128);
		frmLogin.getContentPane().add(Adminpanel);
		Adminpanel.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(10, 36, 80, 14);
		
		textFieldadmin = new JTextField();
		textFieldadmin.setBounds(100, 33, 148, 20);
		textFieldadmin.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(10, 67, 80, 14);
		
		passwordFieldadmin = new JPasswordField();
		passwordFieldadmin.setBounds(100, 64, 148, 20);
		
		btnadminlogin = new JButton("Login");
		btnadminlogin.setBounds(145, 102, 103, 23);
		btnadminlogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnadminlogin){
					System.out.println("admin");
					int t=0;
					try{
						System.out.println("admin1");
						Connection con = ConnectionProvider.getConnection();
	                    Statement st=con.createStatement();
	                    ResultSet rs1=st.executeQuery("SELECT * FROM admin_login");
	                    
	                    while(rs1.next())
	                    {
	                    	System.out.println("admin2");
	                            if((textFieldadmin.getText().equals(rs1.getString("username"))) && (passwordFieldadmin.getText().equals(rs1.getString("password"))))
	                            {
								
								t++;
									Product_info_Form pif=new Product_info_Form();
									pif.setVisible(true);
	                            }

	                    }
	                    if(t==0)
	                    {
	                    	         JOptionPane.showMessageDialog(null,"You Are Not a Valid User ,Check Your User ID or Password");
	                   }
					}
					catch(Exception et){
						   
						   JOptionPane.showMessageDialog(null,"Check your connective and try again !!!");
						   }
				}
					
				}
			}
		);
		
		adminlable = new JLabel("Admin login");
		adminlable.setBounds(80, 8, 115, 14);
		adminlable.setFont(new Font("Times New Roman", Font.BOLD, 14));
		adminlable.setHorizontalAlignment(SwingConstants.CENTER);
		Adminpanel.setLayout(null);
		Adminpanel.add(lblNewLabel);
		Adminpanel.add(lblNewLabel_1);
		Adminpanel.add(adminlable);
		Adminpanel.add(textFieldadmin);
		Adminpanel.add(passwordFieldadmin);
		Adminpanel.add(btnadminlogin);
		Adminpanel.setVisible(false);
		btnIAmEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("I Am Employee")){
					{
						int conf=JOptionPane.showConfirmDialog(null," Do You Want to login as employee ? ","Confirmation",JOptionPane.YES_NO_OPTION);
						if(conf==JOptionPane.YES_OPTION)
							{
							JOptionPane.showMessageDialog(null, 
			 				"\n WELLCOME " +
			 				"\n\n Enter Your User Name & Password ","Please login", JOptionPane.PLAIN_MESSAGE );
							
							/*JOptionPane.showMessageDialog(null,
							"\n SORRY!!!" +
			 				"\n Doesn't working" , "ERROR", JOptionPane.ERROR_MESSAGE );*/
							Employeepanel.setVisible(true);
							btnIAmEmployee.setVisible(false);
							
							loginwindowlable.setVisible(false);
							btnIAmAdmin.setVisible(false);
							btnHome.setVisible(true);
							}
						}
					
				}
			}
		});
	}
}
