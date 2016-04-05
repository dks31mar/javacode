package com.admin.login.invoice;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dialog.ModalExclusionType;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

import java.awt.Color;

import javax.swing.UIManager;

import com.toedter.calendar.JDateChooser;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Product_info_Form extends JFrame {

	private JPanel contentPane;
	private JTextField invoiceno;
	private JTextField order;
	private JTextField portal;
	private JTextField dispatch;
	private JTextField awbno;
	private JTextField sno;
	private JTextField partno;
	private JTextField quantity;
	private JTextField rate;
	private JTextField amount;
	private JTextField total;
	private JTextField amountinwords;
	private JTextField tax;
	private JTextField servicecharge;
	private JTextArea sender;
	private JTextArea buyer;
	private JTextArea description;
	@SuppressWarnings("rawtypes")
	private JComboBox paymentmode;
	private JDateChooser dateChooser;
	@SuppressWarnings("rawtypes")
	private JComboBox addproduct;
	
			/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product_info_Form frame = new Product_info_Form();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Product_info_Form() {
		setTitle("Invoice Generator");
		setBackground(new Color(204, 102, 102));
		Toolkit.getDefaultToolkit().getScreenSize();
		setResizable(false);
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setBounds(0, 0, 1341, 726);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnItems = new JMenu("Items");
		menuBar.add(mnItems);
		
		final JMenuItem mntmAddProduct = new JMenuItem("Add Product");
		mntmAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==mntmAddProduct){
					Add_Product ad=new Add_Product();
					ad.setVisible(true);
				}
			}
		});
		
		mnItems.add(mntmAddProduct);
		
		final JMenuItem mntmAddUsers = new JMenuItem("Add Users");
		mntmAddUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==mntmAddUsers){
					Add_user au=new Add_user();
					au.setVisible(true);
				}
			}
		});
		mnItems.add(mntmAddUsers);
		
		final JMenuItem mntmSearchData = new JMenuItem("Search Product");
		mntmSearchData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==mntmSearchData){
					Del_Product dp=new Del_Product();
					dp.setVisible(true);
				}
			}
		});
		mnItems.add(mntmSearchData);
		
		final JMenuItem mntmEditData = new JMenuItem("Edit Product\r\n");
		mntmEditData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==mntmEditData){
					Del_Product dp=new Del_Product();
					dp.setVisible(true);
				}
			}
		});
		mnItems.add(mntmEditData);
		
		final JMenuItem mntmDeleteData = new JMenuItem("Delete Product");
		mntmDeleteData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==mntmDeleteData){
					Del_Product dp=new Del_Product();
					dp.setVisible(true);
				}
			}
		});
		mnItems.add(mntmDeleteData);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("activeCaption"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblProductInformation = new JLabel("Product information");
		lblProductInformation.setBounds(339, 29, 571, 61);
		lblProductInformation.setFont(new Font("Tahoma", Font.BOLD, 37));
		lblProductInformation.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton SaveAndPrint = new JButton("save Details");
		SaveAndPrint.setBounds(954, 490, 151, 23);
		SaveAndPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("save Details")){
				
					try{

						
						Connection con = ConnectionProvider.getConnection();
						String query="insert into productinformation(sno, sender, invoiceno, date, userOrderNo, buyer, protal, paymentmode, dispatch, AWB, description, partno, quantity, rate, amount, total, amountinwords, tax, servicecharge)" + "values (?,?,?,?,?,?,?, ? ,?, ?, ? ,? ,?, ?, ? ,?, ?, ?, ?)";
						PreparedStatement presmt = con.prepareStatement(query);
							presmt.setString(1,sno.getText());
							presmt.setString(2,sender.getText());
							presmt.setString(3,invoiceno.getText());
							presmt.setString(4,((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
						    presmt.setString(5,order.getText());
						    presmt.setString(6,buyer.getText());
							presmt.setString(7,portal.getText());
							presmt.setString(8,paymentmode.getSelectedItem().toString());
							presmt.setString(9,dispatch.getText());
							presmt.setString(10,awbno.getText());
							presmt.setString(11,description.getText());
							presmt.setString(12,partno.getText());
							presmt.setString(13,quantity.getText());
							presmt.setString(14,rate.getText());
							presmt.setString(15,amount.getText());
							presmt.setString(16,total.getText());
							presmt.setString(17,amountinwords.getText());
							presmt.setString(18,tax.getText());
							presmt.setString(19,servicecharge.getText());
					        presmt.execute();
					        con.close();
						    JOptionPane.showMessageDialog(null,"Data saved!!!");
						    int conf=JOptionPane.showConfirmDialog(null," Do  You Want to store another data ? ","Confirmation",JOptionPane.YES_NO_OPTION);
							if(conf==JOptionPane.YES_OPTION)
								{
								invoiceno.setText("");
								dateChooser.setCalendar(null);
								order.setText("");
								awbno.setText("");
								sender.setText("");
								description.setText("");
								partno.setText("");
								amount.setText("");
								amountinwords.setText("");
								total.setText("");
								rate.setText("");
								tax.setText("");
								servicecharge.setText("");
								quantity.setText("");
								dispatch.setText("");
								portal.setText("");
								sno.setText("");
								buyer.setText("");
								paymentmode.setSelectedIndex(0);
								addproduct.setSelectedIndex(0);
								}
					}
					catch(Exception et){
						   System.out.println(et);
						   JOptionPane.showMessageDialog(null,"connection not created!!!");
						   }
				}
			}
			
		});
		
		JLabel sender_1 = new JLabel("Sender");
		sender_1.setBounds(873, 104, 151, 14);
		
		JLabel invoiceno_1 = new JLabel("invoice No.");
		invoiceno_1.setBounds(75, 104, 144, 14);
		
		JLabel date_1 = new JLabel("Date");
		date_1.setBounds(75, 138, 79, 14);
		
		JLabel orderno_1 = new JLabel("order no.");
		orderno_1.setBounds(75, 178, 79, 14);
		
		sender = new JTextArea();
		sender.setLineWrap(true);
		sender.setTabSize(0);
		sender.setBounds(869, 117, 275, 50);
		
		invoiceno = new JTextField();
		invoiceno.setBounds(184, 101, 163, 20);
		invoiceno.setColumns(10);
		
		order = new JTextField();
		order.setBounds(184, 175, 163, 20);
		order.setColumns(10);
		
		JLabel buyer_1 = new JLabel("Buyer");
		buyer_1.setBounds(869, 176, 183, 14);
		
		JLabel protal = new JLabel("portal");
		protal.setBounds(75, 252, 51, 14);
		
		JLabel paymentmode_1 = new JLabel("payment mode");
		paymentmode_1.setBounds(75, 289, 96, 14);
		
		JLabel dispatch_1 = new JLabel("dispatch through");
		dispatch_1.setBounds(75, 326, 107, 14);
		
		JLabel awbno_1 = new JLabel("AWB no.");
		awbno_1.setBounds(75, 363, 79, 14);
		
		buyer = new JTextArea();
		buyer.setLineWrap(true);
		buyer.setBounds(869, 200, 275, 50);
		
		portal = new JTextField();
		portal.setBounds(184, 249, 163, 20);
		portal.setColumns(10);
		
		paymentmode = new JComboBox();
		paymentmode.setBounds(181, 286, 166, 20);
		paymentmode.setModel(new DefaultComboBoxModel(new String[] {"select one of them", "COD(cash on delivery)", "Credit card", "Debit card", "net banking"}));
		paymentmode.setSelectedIndex(0);
		
		dispatch = new JTextField();
		dispatch.setBounds(184, 323, 163, 20);
		dispatch.setColumns(10);
		
		awbno = new JTextField();
		awbno.setBounds(184, 360, 163, 20);
		awbno.setColumns(10);
		
		JLabel sno_1 = new JLabel("S.No.");
		sno_1.setBounds(75, 215, 79, 14);
		
		sno = new JTextField();
		sno.setBounds(184, 212, 163, 20);
		sno.setColumns(10);
		
		JLabel descriptionofgoods = new JLabel("Description of goods");
		descriptionofgoods.setBounds(869, 262, 183, 14);
		
		JList list = new JList();
		list.setBounds(218, 692, 1, 1);
		
		description = new JTextArea();
		description.setLineWrap(true);
		description.setBounds(869, 277, 275, 50);
		
		JLabel partnumber = new JLabel("part number");
		partnumber.setBounds(488, 104, 84, 14);
		
		partno = new JTextField();
		partno.setBounds(597, 101, 183, 20);
		partno.setColumns(10);
		
		JLabel quantity_1 = new JLabel("quantity");
		quantity_1.setBounds(488, 138, 70, 14);
		
		JLabel rate_1 = new JLabel("rate");
		rate_1.setBounds(488, 178, 56, 14);
		
		JLabel amount_1 = new JLabel("amount");
		amount_1.setBounds(488, 215, 99, 14);
		
		quantity = new JTextField();
		quantity.setBounds(597, 138, 183, 20);
		quantity.setColumns(10);
		
		rate = new JTextField();
		rate.setBounds(597, 175, 183, 20);
		rate.setColumns(10);
		
		amount = new JTextField();
		amount.setBounds(597, 212, 183, 20);
		amount.setColumns(10);
		
		JLabel total_1 = new JLabel("total");
		total_1.setBounds(488, 252, 70, 14);
		
		total = new JTextField();
		total.setBounds(597, 249, 183, 20);
		total.setColumns(10);
		
		JLabel amountInWords = new JLabel("amount in words");
		amountInWords.setBounds(488, 398, 183, 14);
		
		amountinwords = new JTextField();
		amountinwords.setBounds(488, 423, 292, 20);
		amountinwords.setColumns(10);
		
		JLabel additionalTax = new JLabel("additional tax");
		additionalTax.setBounds(488, 289, 99, 14);
		
		JLabel serviceCharge = new JLabel("service charge");
		serviceCharge.setBounds(488, 330, 127, 14);
		
		tax = new JTextField();
		tax.setBounds(597, 286, 183, 20);
		tax.setColumns(10);
		
		servicecharge = new JTextField();
		servicecharge.setBounds(597, 323, 183, 20);
		servicecharge.setColumns(10);
		
		JButton btnSearchProduct = new JButton("search product");
		btnSearchProduct.setBounds(737, 490, 144, 23);
		btnSearchProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("search product")){
					RetriveDataOfProduct rdop=new RetriveDataOfProduct();
					rdop.setVisible(true);
					JOptionPane.showMessageDialog(null, "please enter order number in order box to search!!!");
				}
			}
		});
		
		
		dateChooser = new JDateChooser(Calendar.getInstance().getTime(), "yyyy-MM-dd");
		dateChooser.setBounds(184, 138, 163, 20);
		dateChooser.setCalendar(null);
		
		JLabel lblGoods = new JLabel("Goods");
		lblGoods.setBounds(488, 363, 84, 14);
		addproduct = new JComboBox();
		addproduct.setBounds(597, 360, 183, 20);
		try {
			Connection con = ConnectionProvider.getConnection();
			Statement st=con.createStatement();
	        String s="select productname from addproduct";
			ResultSet rs=st.executeQuery(s);
			addproduct.addItem("select product");
	        while(rs.next()){
	        	addproduct.addItem(rs.getString(1));
	        }
		} catch (Exception e1) {
			System.out.println(e1);
		}
		
		addproduct.setEditable(true);
		contentPane.setLayout(null);
		contentPane.add(list);
		contentPane.add(invoiceno_1);
		contentPane.add(date_1);
		contentPane.add(orderno_1);
		contentPane.add(sno_1);
		contentPane.add(protal);
		contentPane.add(paymentmode_1);
		contentPane.add(dispatch_1);
		contentPane.add(awbno_1);
		contentPane.add(dateChooser);
		contentPane.add(dispatch);
		contentPane.add(paymentmode);
		contentPane.add(invoiceno);
		contentPane.add(order);
		contentPane.add(sno);
		contentPane.add(portal);
		contentPane.add(awbno);
		contentPane.add(sender);
		contentPane.add(sender_1);
		contentPane.add(buyer);
		contentPane.add(buyer_1);
		contentPane.add(partnumber);
		contentPane.add(partno);
		contentPane.add(quantity_1);
		contentPane.add(quantity);
		contentPane.add(rate_1);
		contentPane.add(rate);
		contentPane.add(amount_1);
		contentPane.add(amount);
		contentPane.add(total_1);
		contentPane.add(total);
		contentPane.add(amountInWords);
		contentPane.add(additionalTax);
		contentPane.add(serviceCharge);
		contentPane.add(lblGoods);
		contentPane.add(servicecharge);
		contentPane.add(tax);
		contentPane.add(addproduct);
		contentPane.add(amountinwords);
		contentPane.add(descriptionofgoods);
		contentPane.add(description);
		contentPane.add(lblProductInformation);
		contentPane.add(btnSearchProduct);
		contentPane.add(SaveAndPrint);
		
		JScrollPane descripationscroll = new JScrollPane(description);
		descripationscroll.setBounds(869, 277, 275, 50);
		contentPane.add(descripationscroll);
		
		JScrollPane buyerscroll = new JScrollPane(buyer);
		buyerscroll.setBounds(869, 200, 275, 50);
		contentPane.add(buyerscroll);
		
		JScrollPane senderscroll = new JScrollPane(sender);
		senderscroll.setBounds(869, 117, 275, 50);
		contentPane.add(senderscroll);
		}
}
