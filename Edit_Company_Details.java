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
public class Edit_Company_Details extends JFrame {

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
	private JButton btnupdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit_Company_Details frame1 = new Edit_Company_Details();
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Edit_Company_Details() {
		setBackground(Color.GRAY);
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
		
	final	JButton btnShow = new JButton("Show");
	  btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnShow){
					try{
						Connection con = ConnectionProvider.getConnection();
						
						String query1="select * from company_information where company_id=1";
						String query3="select * from company_address where company_id=1";
						
						PreparedStatement pre1=con.prepareStatement(query1);
						ResultSet rs=pre1.executeQuery();
						while (rs.next()) {
							
							companyname.setText(rs.getString("company_name"));
							companyslogan.setText(rs.getString("company_slogan"));
							phone.setText(rs.getString("company_phone"));
							fax.setText(rs.getString("company_fax"));
							email.setText(rs.getString("company_email"));
							website.setText(rs.getString("company_website"));
							contactperson.setText(rs.getString("company_contact_person"));
							contactpersonno.setText(rs.getString("company_cont_pers_phn_no"));
							
						}
						PreparedStatement pre3=con.prepareStatement(query3);
						ResultSet rs1=pre3.executeQuery();
						while (rs1.next()) {
							
							buldingno.setText(rs1.getString("bulding_no"));
							street.setText(rs1.getString("street"));
							country.setText(rs1.getString("country"));
							city.setText(rs1.getString("city"));
							pincode.setText(rs1.getString("pincode"));
						}
						con.close();
					    JOptionPane.showMessageDialog(null,"Found!!!");
					    
					    }
						catch(Exception e1){
							System.out.println(e1);
						}
				}
			}
		});
		btnShow.setBounds(227, 398, 89, 23);
		contentPane.add(btnShow);
		
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
		
		btnupdate = new JButton("Up-date");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnupdate){
					try{
						Connection con = ConnectionProvider.getConnection();
						String query4="update company_information set company_name=?, "
								+ "company_slogan=?, "
								+ "company_phone=?, "
								+ "company_fax=?,"
								+ "company_email=?, "
								+ "company_website=?,"
								+ "company_contact_person=?,"
								+ "company_cont_pers_phn_no=?  "
								+ "where company_id=1 ";
						String query5="update company_address set bulding_no=?, "
								+ "street=?, "
								+ "country=?, "
								+ "city=?, "
								+ "pincode=?  "
								+ "where company_id=1 ";
						PreparedStatement smt = con.prepareStatement(query4);
						PreparedStatement smt1 = con.prepareStatement(query5);
						
						smt.setString(1, companyname.getText());
						smt.setString(2, companyslogan.getText());
						smt.setString(3, phone.getText());
						smt.setString(4, fax.getText());
						smt.setString(5, email.getText());
						smt.setString(6, website.getText());
						smt.setString(7, contactperson.getText());
						smt.setString(8, contactpersonno.getText());
						
						smt1.setString(1, buldingno.getText());
						smt1.setString(2, street.getText());
						smt1.setString(3, country.getText());
						smt1.setString(4, city.getText());
						smt1.setString(5, pincode.getText());
						smt.execute();
						smt1.execute();
						
						JOptionPane.showMessageDialog(null,"Data UpDated");
						}
						catch(Exception e2){
							System.out.println(e2);
						}
					
				}
			}
		});
		btnupdate.setBounds(326, 398, 107, 23);
		contentPane.add(btnupdate);
	}
}
