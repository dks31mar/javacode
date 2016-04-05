package com.quote;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;

@SuppressWarnings("serial")
public class Company_Details extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblCompanySlogan;
	private JLabel lblCompanyName;
	private JTextField companyname;
	private JTextField buldingno;
	private JTextField street;
	private JTextField country;
	private JTextField city;
	private JTextField phone;
	private JTextField fax;
	private JTextField email;
	private JTextField website;
	private JLabel lblEnterCompanyDetails;
	private JLabel lblContactPerson;
	private JTextField contactperson;
	private JLabel lblPhoneNumber;
	private JTextField contactpersonno;
	private JLabel lblPincode;
	private JTextField pincode;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Company_Details frame = new Company_Details();
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
	public Company_Details() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Company_Details.class.getResource("/images/fgrtf.png")));
		setTitle("Company Details");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 506, 473);
		contentPane = new JPanel() {  
            public void paintComponent(Graphics g) {  
                  Image img = Toolkit.getDefaultToolkit().getImage(  
                            Initial_setup.class.getResource("/images/Abstract Background.jpg"));  
                  g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
              }  
         };
         
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCompanyName = new JLabel("Company Name ");
		lblCompanyName.setBounds(55, 53, 107, 14);
		contentPane.add(lblCompanyName);
		
		lblCompanySlogan = new JLabel("Company Slogan");
		lblCompanySlogan.setBounds(284, 49, 107, 14);
		contentPane.add(lblCompanySlogan);
		
		lblNewLabel = new JLabel("Bulding No.");
		lblNewLabel.setBounds(55, 109, 107, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblStreet = new JLabel("Street");
		lblStreet.setBounds(284, 109, 107, 14);
		contentPane.add(lblStreet);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(284, 163, 46, 14);
		contentPane.add(lblCity);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(55, 163, 73, 14);
		contentPane.add(lblCountry);
		
		JLabel lblPhoneNo = new JLabel("Phone No.");
		lblPhoneNo.setBounds(55, 219, 107, 14);
		contentPane.add(lblPhoneNo);
		
		JLabel lblFa = new JLabel("Fax");
		lblFa.setBounds(284, 219, 46, 14);
		contentPane.add(lblFa);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(58, 275, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblWebSite = new JLabel("Web Site");
		lblWebSite.setBounds(284, 275, 93, 14);
		contentPane.add(lblWebSite);
		
		companyname = new JTextField();
		companyname.setBounds(55, 78, 140, 20);
		contentPane.add(companyname);
		companyname.setColumns(10);
		
		final JTextArea companyslogan = new JTextArea();
		companyslogan.setLineWrap(true);
		companyslogan.setBounds(284, 66, 153, 22);
		contentPane.add(companyslogan);
		
		buldingno = new JTextField();
		buldingno.setBounds(55, 134, 140, 20);
		contentPane.add(buldingno);
		buldingno.setColumns(10);
		
		street = new JTextField();
		street.setBounds(284, 132, 153, 20);
		contentPane.add(street);
		street.setColumns(10);
		
		country = new JTextField();
		country.setBounds(55, 188, 140, 20);
		contentPane.add(country);
		country.setColumns(10);
		
		city = new JTextField();
		city.setBounds(284, 188, 73, 20);
		contentPane.add(city);
		city.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(55, 244, 140, 20);
		contentPane.add(phone);
		phone.setColumns(10);
		
		fax = new JTextField();
		fax.setBounds(284, 244, 153, 20);
		contentPane.add(fax);
		fax.setColumns(10);
		
		email = new JTextField();
		email.setBounds(55, 300, 140, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		website = new JTextField();
		website.setBounds(284, 300, 153, 20);
		contentPane.add(website);
		website.setColumns(10);
		
		
	final	JButton btnSubmit = new JButton("Submit");
	  btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnSubmit){
					try{
						Connection con = ConnectionProvider.getConnection();
						String query0="insert into company_information(company_id, company_name,"
									+ " company_slogan, company_phone, company_fax,"
									+ "company_email, company_website,company_contact_person,company_cont_pers_phn_no)" 
									+ "values (?,?,?,?,?,?,?,?,?)";
						String query1="select company_id from company_information";
						String query2="insert into company_address(company_id, bulding_no, street, country, city, pincode)"+"values(?,?,?,?,?,?)"; 
						String query3="select company_id from company_address";
						PreparedStatement pre1=con.prepareStatement(query1);
						ResultSet rs=pre1.executeQuery();
						while (rs.next()) {
						}
						PreparedStatement pre3=con.prepareStatement(query3);
						ResultSet rs1=pre3.executeQuery();
						while (rs1.next()) {
						}
						PreparedStatement pre = con.prepareStatement(query0);
						PreparedStatement pre2 = con.prepareStatement(query2);
						pre.setInt(1,1);
						pre.setString(2,companyname.getText());
						pre.setString(3,companyslogan.getText());
						pre.setString(4, phone.getText());
						pre.setString(5, fax.getText());
						pre.setString(6, email.getText());
						pre.setString(7, website.getText());
						pre.setString(8, contactperson.getText());
						pre.setString(9, contactpersonno.getText());
						
						pre2.setInt(1,1);
						pre2.setString(2, buldingno.getText());
						pre2.setString(3, street.getText());
						pre2.setString(4, country.getText());
						pre2.setString(5, city.getText());
						pre2.setString(6, pincode.getText());
						
						pre2.execute();
						pre.execute();
						
				        con.close();
					    JOptionPane.showMessageDialog(null,"Data saved!!!");
					    
					    companyname.setText("");
					    companyslogan.setText("");
					    pincode.setText("");
					    city.setText("");
					    country.setText("");
					    buldingno.setText("");
					    website.setText("");
					    email.setText("");
					    street.setText("");
					    contactperson.setText("");
					    contactpersonno.setText("");
					    fax.setText("");
					    phone.setText("");
					    
						}
						catch(Exception e1){
							String str="Delete last comapny data";
							JOptionPane.showMessageDialog(null,"Please click on "+str);
						}
				}
			}
		});
		btnSubmit.setBounds(348, 387, 89, 23);
		contentPane.add(btnSubmit);
		
		JScrollPane compsl= new JScrollPane(companyslogan);
		compsl.setBounds(280, 76, 153, 22);
		contentPane.add(compsl);
		
		lblEnterCompanyDetails = new JLabel("Enter Company Details");
		lblEnterCompanyDetails.setBounds(187, 24, 153, 14);
		contentPane.add(lblEnterCompanyDetails);
		
		lblContactPerson = new JLabel("Contact Person");
		lblContactPerson.setBounds(55, 331, 140, 14);
		contentPane.add(lblContactPerson);
		
		contactperson = new JTextField();
		contactperson.setBounds(55, 356, 140, 20);
		contentPane.add(contactperson);
		contactperson.setColumns(10);
		
		lblPhoneNumber = new JLabel("Phone number ");
		lblPhoneNumber.setBounds(284, 331, 107, 14);
		contentPane.add(lblPhoneNumber);
		
		contactpersonno = new JTextField();
		contactpersonno.setBounds(284, 356, 153, 20);
		contentPane.add(contactpersonno);
		contactpersonno.setColumns(10);
		
		lblPincode = new JLabel("Pincode");
		lblPincode.setBounds(364, 163, 73, 14);
		contentPane.add(lblPincode);
		
		pincode = new JTextField();
		pincode.setBounds(362, 188, 73, 20);
		contentPane.add(pincode);
		pincode.setColumns(10);
		
		btnNewButton = new JButton("Delete last company details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==btnNewButton) {
					try {
						Connection con2 = ConnectionProvider.getConnection();
						String query2="delete from company_information";
						String query3="delete from company_address";
						PreparedStatement presmt21= con2.prepareStatement(query2);
						presmt21.execute();
						PreparedStatement presmt212= con2.prepareStatement(query3);
						presmt212.execute();
						 JOptionPane.showMessageDialog(null,"Data All Clear");
					} catch (Exception e21) {
						JOptionPane.showMessageDialog(null,e21 +"\n contact to system manufacturer");
					}
					
				}
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(210, 422, 227, 23);
		contentPane.add(btnNewButton);
	}
}
