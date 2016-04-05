package com.quote;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Initial_setup extends JFrame {

	/**
	 * Launch the application.
	 */
	private JPanel contentPane;
	private JButton company;
	private JButton editcompany;
	private JButton quote;
	private JButton customer;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Initial_setup frame = new Initial_setup();
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
	public Initial_setup() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Initial_setup.class.getResource("/images/fgrtf.png")));
		setTitle("Quote Generator");
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
		           setBounds(100, 100, 450, 300);
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
		            
		            company = new JButton("");
		            company.setToolTipText("Enter New Company Details");
		            company.addActionListener(new ActionListener() {
		            	public void actionPerformed(ActionEvent e) {
		            		if(e.getSource()==company){
		            			Company_Details cd =new Company_Details();
		            			cd.setVisible(true);
		            		}
		            	}
		            });
		            company.setIcon(new ImageIcon(Initial_setup.class.getResource("/images/company_icon1.png")));
		            company.setBounds(42, 11, 90, 90);
		            contentPane.add(company);
		            
		            editcompany = new JButton("");
		            editcompany.setToolTipText("Edit Company Details");
		            editcompany.setIcon(new ImageIcon(Initial_setup.class.getResource("/images/edit company1.png")));
		            editcompany.addActionListener(new ActionListener() {
		            	public void actionPerformed(ActionEvent e) {
		            		if(e.getSource()==editcompany){
		            			Edit_Company_Details ecd=new Edit_Company_Details();
		            			ecd.setVisible(true);
		            		}
		            	}
		            });
		            editcompany.setBounds(42, 150, 90, 90);
		            contentPane.add(editcompany);
		            
		            quote = new JButton("");
		            quote.setToolTipText("New Quote");
		            quote.addActionListener(new ActionListener() {
		            	public void actionPerformed(ActionEvent e) {
		            		if(e.getSource()==quote){
		            			Quote_Details qd=new Quote_Details();
		            			qd.setVisible(true);
		            		}
		            	}
		            });
		            quote.setIcon(new ImageIcon(Initial_setup.class.getResource("/images/quote1.png")));
		            quote.setBounds(307, 11, 90, 90);
		            contentPane.add(quote);
		            
		            customer = new JButton("");
		            customer.setToolTipText("Add New Customer");
		            customer.setIcon(new ImageIcon(Initial_setup.class.getResource("/images/customer1.png")));
		            customer.addActionListener(new ActionListener() {
		            	public void actionPerformed(ActionEvent e) {
		            		if(e.getSource()==customer){
		            			Customer_Details cd=new Customer_Details();
		            			cd.setVisible(true);
		            		}
		            	}
		            });
		            customer.setBounds(307, 150, 90, 90);
		            contentPane.add(customer);
		            
		            JLabel lblNewLabel = new JLabel("New label");
		            lblNewLabel.setIcon(new ImageIcon(Initial_setup.class.getResource("/images/wel.jpg")));
		            lblNewLabel.setBounds(81, 42, 287, 164);
		            contentPane.add(lblNewLabel);
	      }  
}
