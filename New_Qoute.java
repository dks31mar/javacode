package com.quote;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import javax.swing.JTextArea;
import javax.swing.JToggleButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JLayeredPane;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class New_Qoute extends JFrame {

	private JPanel contentPane;
	private JTextField custname;
	private JTextField custcompany;
	private JTextField custpin;
	private JTextField custphone;
	private JTextField qoute;
	private JTextField customerid;
	private JTextField linetotal;
	private JTextField total;
	private JTextField tax;
	private JTextField ratetax;
	private JTextField discount;
	private JTextField subtotal;
	private JLayeredPane layeredPane;
	private JPanel panel;
	private JButton btnNewButton;
	private JTextArea services;
	private JTextArea custaddress;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;
	private JTextArea projectdiscrption;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					New_Qoute frame = new New_Qoute();
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
	public New_Qoute() {
		setTitle("Qoute");
		setBounds(100, 100, 752, 455);
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
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(534, 276, 192, 130);
		layeredPane.setVisible(false);
		contentPane.add(layeredPane);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 172, 108);
		layeredPane.add(panel);
		panel.setLayout(null);
		
		discount = new HintTextField("discount");
		discount.setBounds(10, 3, 86, 20);
		panel.add(discount);
		discount.setColumns(10);
		
		ratetax = new HintTextField("rate(%)");
		
		ratetax.setBounds(10, 30, 86, 20);
		panel.add(ratetax);
		ratetax.setColumns(10);
		
		tax = new HintTextField("tax");
		
		tax.setBounds(10, 60, 86, 20);
		panel.add(tax);
		tax.setColumns(10);
		
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				float a,b,c;
				if(arg0.getSource()==btnNewButton){
					
				
				try {
					a=Integer.parseInt(discount.getText());
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			}
		});
		btnNewButton.setBounds(106, 74, 56, 23);
		panel.add(btnNewButton);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(471, 73, 46, 14);
		contentPane.add(lblDate);
		
		JLabel lblValidDate = new JLabel("Valid date");
		lblValidDate.setBounds(471, 98, 76, 14);
		contentPane.add(lblValidDate);
		
		JLabel lblQoute = new JLabel("Qoute");
		lblQoute.setBounds(471, 127, 46, 14);
		contentPane.add(lblQoute);
		
		JLabel lblCusto = new JLabel("Customer Id");
		lblCusto.setBounds(471, 153, 105, 14);
		contentPane.add(lblCusto);
		
		JLabel lblNewLabel = new JLabel("Customer name");
		lblNewLabel.setBounds(58, 73, 105, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Customer company");
		lblNewLabel_1.setBounds(58, 98, 107, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(58, 178, 86, 14);
		contentPane.add(lblAddress);
		
		JLabel lblPin = new JLabel("Pin");
		lblPin.setBounds(58, 127, 86, 14);
		contentPane.add(lblPin);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(58, 153, 86, 14);
		contentPane.add(lblPhone);
		
		custname = new JTextField();
		custname.setBounds(183, 70, 133, 20);
		contentPane.add(custname);
		custname.setColumns(10);
		
		custcompany = new JTextField();
		custcompany.setColumns(10);
		custcompany.setBounds(183, 95, 133, 20);
		contentPane.add(custcompany);
		
		custpin = new JTextField();
		custpin.setColumns(10);
		custpin.setBounds(183, 124, 133, 20);
		contentPane.add(custpin);
		
		custphone = new JTextField();
		custphone.setColumns(10);
		custphone.setBounds(183, 150, 133, 20);
		contentPane.add(custphone);
		
		qoute = new JTextField();
		qoute.setColumns(10);
		qoute.setBounds(544, 120, 92, 20);
		
		contentPane.add(qoute);
//		
		customerid = new JTextField();
		customerid.setColumns(10);
		customerid.setBounds(544, 148, 92, 20);
		contentPane.add(customerid);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(545, 64, 91, 20);
		contentPane.add(dateChooser);
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(545, 91, 91, 20);
		contentPane.add(dateChooser_1);
		
		custaddress = new JTextArea();
		custaddress.setLineWrap(true);
		custaddress.setBounds(183, 182, 133, 83);
		contentPane.add(custaddress);
		
		JLabel lblProjectDescrpation = new JLabel("Project Descrpation");
		lblProjectDescrpation.setBounds(471, 178, 154, 14);
		contentPane.add(lblProjectDescrpation);
		
		projectdiscrption = new JTextArea();
		projectdiscrption.setBounds(471, 203, 165, 62);
		contentPane.add(projectdiscrption);
		
		JLabel lblServices = new JLabel("Services");
		lblServices.setBounds(57, 285, 87, 14);
		contentPane.add(lblServices);
		
		services = new JTextArea();
		services.setBounds(58, 306, 258, 22);
		contentPane.add(services);
		
		JLabel lblLineTotal = new JLabel("Line Total");
		lblLineTotal.setBounds(333, 285, 76, 14);
		contentPane.add(lblLineTotal);
		
		linetotal = new JTextField();
		linetotal.setBounds(326, 308, 53, 20);
		contentPane.add(linetotal);
		linetotal.setColumns(10);
		
		JLabel lblSubtotal = new JLabel("subTotal & Total");
		lblSubtotal.setBounds(398, 285, 119, 14);
		contentPane.add(lblSubtotal);
		
		total = new JTextField();
		total.setBounds(398, 308, 46, 20);
		contentPane.add(total);
		total.setColumns(10);
		
		final JToggleButton showextra = new JToggleButton("...");
		showextra.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)
		        {
		            layeredPane.setVisible(true);
		            
		        }
		        else
		        {
		           layeredPane.setVisible(false);
		            
		        } 
				
			}
		});
		
	
		showextra.setBounds(495, 307, 29, 23);
		contentPane.add(showextra);
		
		subtotal = new JTextField();
		subtotal.setBounds(449, 308, 41, 20);
		contentPane.add(subtotal);
		subtotal.setColumns(10);
	}
}
