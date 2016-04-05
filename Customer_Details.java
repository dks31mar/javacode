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

@SuppressWarnings("serial")
public class Customer_Details extends JFrame {
	private JTextField name;
	private JTextField companyname;
	private JTextField pincode;
	private JTextField phone;
	private JTextArea address;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_Details frame = new Customer_Details();
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
	public Customer_Details() {
		setResizable(false);
		setTitle("Customer Detail");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Customer_Details.class.getResource("/images/fgrtf.png")));
		setBounds(100, 100, 507, 300);
		JPanel contentPane = new JPanel() {  
            public void paintComponent(Graphics g) {  
                  Image img = Toolkit.getDefaultToolkit().getImage(  
                            Initial_setup.class.getResource("/images/Abstract Background.jpg"));  
                  g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
              }  
         };
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(73, 40, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setBounds(73, 65, 137, 14);
		contentPane.add(lblCompanyName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(73, 140, 89, 14);
		contentPane.add(lblAddress);
		
		JLabel lblPinCode = new JLabel("Pin Code");
		lblPinCode.setBounds(73, 90, 89, 14);
		contentPane.add(lblPinCode);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setBounds(73, 115, 116, 14);
		contentPane.add(lblPhoneNumber);
		
		name = new JTextField();
		name.setBounds(194, 37, 137, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		companyname = new JTextField();
		companyname.setBounds(194, 62, 137, 20);
		contentPane.add(companyname);
		companyname.setColumns(10);
		
		pincode = new JTextField();
		pincode.setBounds(194, 87, 137, 20);
		contentPane.add(pincode);
		pincode.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(194, 112, 137, 20);
		contentPane.add(phone);
		phone.setColumns(10);
		
		address = new JTextArea();
		address.setLineWrap(true);
		address.setBounds(194, 143, 137, 77);
		contentPane.add(address);
		
		final JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnSave){
					int counter=0,counterid;
					
					try{
						Connection con = ConnectionProvider.getConnection();
						String query0="insert into customer_info(customer_id,name,company_name,adress,pincode,phone_no)" + "values(?,?,?,?,?,?)";
						String query1="select customer_id from customer_info";
						
						PreparedStatement pre1=con.prepareStatement(query1);
						ResultSet rs=pre1.executeQuery();
						while (rs.next()) {
							counter=rs.getInt(1);
						}
						counterid=counter+127;
						PreparedStatement pre=con.prepareStatement(query0);
						
						pre.setInt(1,counterid);
						pre.setString(2,name.getText());
						System.out.println("1");
						pre.setString(3,companyname.getText());
						System.out.println("2");
						pre.setString(4,address.getText());
						System.out.println("3");
						pre.setString(5,pincode.getText());
						System.out.println("4");
						pre.setString(6, phone.getText());
						System.out.println("5");
						pre.execute();
						System.out.println("6");
						JOptionPane.showMessageDialog(null,"Data Saved!!!!\nPlease Remember customer ID");
						JOptionPane.showMessageDialog(null,"customer Id is : "+counterid);
						}
						catch(Exception e1){
							System.out.println(e1);
						}
				}
			}
		});
		btnSave.setBounds(243, 231, 89, 23);
		contentPane.add(btnSave);
		JScrollPane compsl= new JScrollPane(address);
		compsl.setBounds(194, 143, 137, 77);
		contentPane.add(compsl);
	}

}
