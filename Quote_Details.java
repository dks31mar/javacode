package com.quote;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JLabel;

import com.toedter.calendar.JDateChooser;

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
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.Color;

@SuppressWarnings("serial")
public class Quote_Details extends JFrame {
	private JTextField rate5;
	private JTextField ltotal1;
	private JTextField ltotal2;
	private JTextField ltotal3;
	private JTextField ltotal4;
	private JTextField ltotal5;
	private JTextField rate4;
	private JTextField rate3;
	private JTextField rate2;
	private JTextField rate1;
	private JLabel lblLineTotal;
	private JTextField total;
	private JTextField salestax;
	private JTextField saletaxrate;
	private JTextField discount;
	private JTextField subtotal;
	private JTextField customerid;
	private JTextField qoute;
	private JDateChooser untilldate;
	private JDateChooser date;
	private JTextField namecust;
	private JTextField companynamecust;
	private JTextField pincust;
	private JTextField phonecust;
	private JTextArea Adresscust;
	private JPanel maincontentPane;
	private JPanel customerpanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quote_Details frame = new Quote_Details();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Quote_Details() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Quote Detail");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Quote_Details.class.getResource("/images/fgrtf.png")));
		setBounds(100, 100, 969, 656);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAdd = new JMenu("Add ");
		menuBar.add(mnAdd);
		
		JMenuItem mntmAddFeature = new JMenuItem("Add Feature");
		mntmAddFeature.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Features af=new Add_Features();
				af.setVisible(true);
			}
		});
		mnAdd.add(mntmAddFeature);
		
		final JMenuItem mntmEditFeatureList = new JMenuItem("Edit Feature list");
		mntmEditFeatureList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e21) {
				if(e21.getSource()==mntmEditFeatureList){
					Edit_Features ef=new Edit_Features();
					ef.setVisible(true);
				}
			}
		});
		mnAdd.add(mntmEditFeatureList);
		maincontentPane = new JPanel() {  
            public void paintComponent(Graphics g) {  
                  Image img = Toolkit.getDefaultToolkit().getImage(  
                            Initial_setup.class.getResource("/images/Abstract Background.jpg"));  
                  g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
              }  
         };
		maincontentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(maincontentPane);
		maincontentPane.setLayout(null);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(134, 64, 46, 14);
		maincontentPane.add(lblDate);
		
		JLabel lblValidDate = new JLabel("Valid Untill");
		lblValidDate.setBounds(134, 110, 75, 14);
		maincontentPane.add(lblValidDate);
		
		JLabel lblNewLabel = new JLabel("Quote");
		lblNewLabel.setBounds(134, 160, 46, 14);
		maincontentPane.add(lblNewLabel);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setBounds(134, 206, 75, 14);
		maincontentPane.add(lblCustomerId);
		
		JLabel lblProjectDescription = new JLabel("Project Description");
		lblProjectDescription.setBounds(377, 44, 203, 14);
		maincontentPane.add(lblProjectDescription);
		
		JLabel lblDescription = new JLabel("Description 1");
		lblDescription.setBounds(379, 135, 172, 14);
		maincontentPane.add(lblDescription);
		
		JLabel lblDescription_1 = new JLabel("Description 2");
		lblDescription_1.setBounds(375, 209, 203, 14);
		maincontentPane.add(lblDescription_1);
		
		JLabel lblDescription_2 = new JLabel("Description 3");
		lblDescription_2.setBounds(375, 283, 193, 14);
		maincontentPane.add(lblDescription_2);
		
		JLabel lblDescription_3 = new JLabel("Description 4");
		lblDescription_3.setBounds(373, 361, 151, 14);
		maincontentPane.add(lblDescription_3);
		
		JLabel lblDescription_4 = new JLabel("Description 5");
		lblDescription_4.setBounds(375, 442, 193, 14);
		maincontentPane.add(lblDescription_4);
		
		JLabel lblNewLabel_1 = new JLabel("Rate");
		lblNewLabel_1.setBounds(652, 131, 46, 18);
		maincontentPane.add(lblNewLabel_1);
		
		JLabel lblSu = new JLabel("Subtotal");
		lblSu.setBounds(134, 255, 64, 14);
		maincontentPane.add(lblSu);
		
		JLabel lblDiscount = new JLabel("Discount ");
		lblDiscount.setBounds(134, 305, 97, 14);
		maincontentPane.add(lblDiscount);
		
		JLabel lblSalesTaxRate = new JLabel("Sales tax Rate");
		lblSalesTaxRate.setBounds(134, 357, 135, 14);
		maincontentPane.add(lblSalesTaxRate);
		
		JLabel lblSalesTax = new JLabel("Sales tax");
		lblSalesTax.setBounds(134, 408, 142, 14);
		maincontentPane.add(lblSalesTax);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(134, 460, 133, 14);
		maincontentPane.add(lblTotal);
		
		date = new JDateChooser(Calendar.getInstance().getTime(), "yyyy-MM-dd");
		date.setBounds(134, 82, 161, 20);
		date.setCalendar(null);
		maincontentPane.add(date);
		
		untilldate = new JDateChooser(Calendar.getInstance().getTime(), "yyyy-MM-dd");
		untilldate.setBounds(134, 135, 161, 20);
		untilldate.setCalendar(null);
		maincontentPane.add(untilldate);
		
		qoute = new JTextField();
		qoute.setBounds(134, 185, 160, 20);
		maincontentPane.add(qoute);
		qoute.setColumns(10);
		
		customerid = new JTextField();
		customerid.setBounds(134, 224, 161, 20);
		maincontentPane.add(customerid);
		customerid.setColumns(10);
		
		subtotal = new JTextField();
		subtotal.setEditable(false);
		subtotal.setBounds(134, 280, 161, 20);
		maincontentPane.add(subtotal);
		subtotal.setColumns(10);
		
		discount = new JTextField();
		discount.setBounds(134, 330, 162, 20);
		maincontentPane.add(discount);
		discount.setColumns(10);
		
		saletaxrate = new JTextField();
		saletaxrate.setBounds(134, 377, 161, 20);
		maincontentPane.add(saletaxrate);
		saletaxrate.setColumns(10);
		
		salestax = new JTextField();
		salestax.setEditable(false);
		salestax.setBounds(134, 428, 161, 20);
		maincontentPane.add(salestax);
		salestax.setColumns(10);
		
		total = new JTextField();
		total.setEditable(false);
		total.setBounds(134, 485, 161, 20);
		maincontentPane.add(total);
		total.setColumns(10);
		
		final JTextArea projectdescription = new JTextArea();
		projectdescription.setBounds(375, 66, 261, 59);
		maincontentPane.add(projectdescription);
		
		final JTextArea discription1 = new JTextArea();
		discription1.setBounds(375, 160, 261, 38);
		maincontentPane.add(discription1);
		
		final JTextArea discription2 = new JTextArea();
		discription2.setBounds(375, 234, 261, 38);
		maincontentPane.add(discription2);
		
		final JTextArea discription3 = new JTextArea();
		discription3.setBounds(375, 308, 261, 38);
		maincontentPane.add(discription3);
		
		final JTextArea discription4 = new JTextArea();
		discription4.setBounds(375, 386, 261, 38);
		maincontentPane.add(discription4);
		
		final JTextArea discription5 = new JTextArea();
		discription5.setBounds(375, 467, 261, 38);
		maincontentPane.add(discription5);
		
		final JButton btnCalculation = new JButton("Calculations");
		btnCalculation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnCalculation){
					@SuppressWarnings("unused")
					float fin,fin1,j,z1,z2,z3,z4,z5;
					int iny=10;
					try {
						z1=Integer.parseInt(ltotal1.getText());//get discount
						z2=Integer.parseInt(ltotal2.getText());
						z3=Integer.parseInt(ltotal3.getText());
						z4=Integer.parseInt(ltotal4.getText());
						z5=Integer.parseInt(ltotal5.getText());
						
						
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null,"Please fill blank line total box with zero(0)");
					}
					subtotal.setText("" +(Integer.parseInt(ltotal1.getText())+Integer.parseInt(ltotal2.getText())+Integer.parseInt(ltotal3.getText())+Integer.parseInt(ltotal4.getText())+Integer.parseInt(ltotal5.getText())));
					float subtotall=Integer.parseInt(subtotal.getText());// store subtatal
					float i=Integer.parseInt(saletaxrate.getText());// get tax rate
					iny++;
					System.out.println(i);
					fin=(subtotall*i)/100;// find %
				try {
					j=Integer.parseInt(discount.getText());//get discount
				} catch (Exception e2) {
					j=0;
				}
					fin1=subtotall+fin;
					fin1=(subtotall+fin)-j;// grant total
					
					total.setText(""+fin1);//set value
					salestax.setText("" +fin);
					if(iny==10){
						
					}
				}
			}
		});
		btnCalculation.setBounds(485, 553, 151, 23);
		maincontentPane.add(btnCalculation);
		
	final	JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnPrint){
					int i=0;
					try {
						Connection con= ConnectionProvider.getConnection();
						
						String quary1="insert into quote_details(id,date,"
								+ "last_date,"
								+ "quote,customerid,"
								+ "discount,subtotal,"
								+ "tax_rate,tax,total)"
								+"values(?,?,?,?,?,?,?,?,?,?)";
						
						
						String quary2="insert into project_description(id,project_description,"
								+ "project_description1,"
								+ "project_description2,"
								+ "project_description3,"
								+ "project_description4,"
								+ "project_description5,"
								+ "dsrate1,"
								+ "dsrate2,"
								+ "dsrate3,"
								+ "dsrate4,"
								+ "dsrate5,"
								+ "linetotal1,"
								+ "linetotal2,"
								+ "linetotal3,"
								+ "linetotal4,"
								+ "linetotal5)"
								+"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
						
						
						String quary3="insert into report(id, date, tilldate, quote,"
								+ " custmid, name,  compname,  adress,  pincode,  "
								+ "phone,  prodiscp,  discp1,  discp2,  discp3,  "
								+ "discp4,  discp5,  rate1,  rate2,  rate3,  "
								+ "rate4,  rate5,  ltotal1,  ltotal2,  ltotal3,  "
								+ "ltotal4,  ltotal5,  feature1,  feature2,  "
								+ "feature3,  feature4,  feature5,  feature6,  "
								+ "feature7,  feature8,  feature9,  feature10,  "
								+ "subtotal,  discount,  taxrate,  rate,  total)"
								+"value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
						
						
						String quary4="delete from report where id=1";
						String quary5="delete from features where id=1";
						String quary6="delete from project_description where id=1";
						String query1="select id from quote_details";
						
						PreparedStatement pre1=con.prepareStatement(query1);
						ResultSet rs=pre1.executeQuery();
						while (rs.next()) {
							i=rs.getInt(1);
						}
						PreparedStatement prst=con.prepareStatement(quary1);
						PreparedStatement prst1=con.prepareStatement(quary2);
						prst.setInt(1,++i);
						prst.setString(2,((JTextField)date.getDateEditor().getUiComponent()).getText());
						prst.setString(3,((JTextField)untilldate.getDateEditor().getUiComponent()).getText());
						prst.setString(4,qoute.getText());
						prst.setString(5,customerid.getText());
						prst.setString(6,discount.getText());
						prst.setString(7,subtotal.getText());
						prst.setString(8,saletaxrate.getText());
						prst.setString(9,salestax.getText());
						prst.setString(10,total.getText());
						prst.execute();
						
						prst1.setInt(1,1);
						prst1.setString(2,projectdescription.getText());
						prst1.setString(3,discription1.getText());
						prst1.setString(4,discription2.getText());
						prst1.setString(5,discription3.getText());
						prst1.setString(6,discription4.getText());
						prst1.setString(7,discription5.getText());
						prst1.setString(8,rate1.getText());
						prst1.setString(9,rate2.getText());
						prst1.setString(10,rate3.getText());
						prst1.setString(11,rate4.getText());
						prst1.setString(12,rate5.getText());
						prst1.setString(13,ltotal1.getText());
						prst1.setString(14,ltotal2.getText());
						prst1.setString(15,ltotal3.getText());
						prst1.setString(16,ltotal4.getText());
						prst1.setString(17,ltotal5.getText());
						prst1.execute();
						
						PreparedStatement prst2=con.prepareStatement(quary3);
						prst2.setInt(1,1);
						prst2.setString(2,((JTextField)date.getDateEditor().getUiComponent()).getText());
						prst2.setString(3,((JTextField)untilldate.getDateEditor().getUiComponent()).getText());
						prst2.setString(4,qoute.getText());
						prst2.setString(5,customerid.getText());
						prst2.setString(6,namecust.getText());
						prst2.setString(7,companynamecust.getText());
						prst2.setString(8,Adresscust.getText());
						prst2.setString(9,pincust.getText());
						prst2.setString(10,phonecust.getText());
						prst2.setString(11,projectdescription.getText());
						prst2.setString(12,discription1.getText());
						prst2.setString(13,discription2.getText());
						prst2.setString(14,discription3.getText());
						prst2.setString(15,discription4.getText());
						prst2.setString(16,discription5.getText());
						prst2.setString(17,rate1.getText());
						prst2.setString(18,rate2.getText());
						prst2.setString(19,rate3.getText());
						prst2.setString(20,rate4.getText());
						prst2.setString(21,rate5.getText());
						prst2.setString(22,ltotal1.getText());
						prst2.setString(23,ltotal2.getText());
						prst2.setString(24,ltotal3.getText());
						prst2.setString(25,ltotal4.getText());
						prst2.setString(26,ltotal5.getText());
						prst2.setString(27,"a");
						prst2.setString(28,"a");
						prst2.setString(29,"a");
						prst2.setString(30,"a");
						prst2.setString(31,"a");
						prst2.setString(32,"a");
						prst2.setString(33,"a");
						prst2.setString(34,"a");
						prst2.setString(35,"a");
						prst2.setString(36,"a");
						prst2.setString(37,subtotal.getText());
						prst2.setString(38,discount.getText());
						prst2.setString(39,saletaxrate.getText());
						prst2.setString(40,salestax.getText());
						prst2.setString(41,total.getText());
						prst2.execute();
						
						JasperReport jasperReport = JasperCompileManager.compileReport(("report/quote.jrxml"));
					       /* JasperReport jasperReport = JasperCompileManager.compileReport(("D:\\reports\\quote.jrxml"));*/
							JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null,con);
							JasperViewer.viewReport(jasperPrint,false);
						PreparedStatement prstdel=con.prepareStatement(quary4);
						prstdel.execute();
						System.out.println("report delete");
						PreparedStatement prstdel1=con.prepareStatement(quary5);
						prstdel1.execute();
						System.out.println("features delete");
						PreparedStatement prstdel2=con.prepareStatement(quary6);
						prstdel2.execute();
						System.out.println("discr delete");
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "data not found"
								+ "ok");
						System.out.println(e2);
					}
				}
			}
		});
		btnPrint.setBounds(652, 553, 126, 23);
		maincontentPane.add(btnPrint);
		
		JLabel lblRate = new JLabel("Rate");
		lblRate.setBounds(652, 209, 46, 14);
		maincontentPane.add(lblRate);
		
		JLabel label = new JLabel("Rate");
		label.setBounds(652, 283, 46, 14);
		maincontentPane.add(label);
		
		JLabel label_1 = new JLabel("Rate");
		label_1.setBounds(652, 361, 46, 14);
		maincontentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Rate");
		label_2.setBounds(652, 442, 46, 14);
		maincontentPane.add(label_2);
		
		rate1 = new JTextField();
		rate1.setBounds(685, 132, 75, 20);
		maincontentPane.add(rate1);
		rate1.setColumns(10);
		
		rate2 = new JTextField();
		rate2.setColumns(10);
		rate2.setBounds(685, 206, 75, 20);
		maincontentPane.add(rate2);
		
		rate3 = new JTextField();
		rate3.setColumns(10);
		rate3.setBounds(685, 280, 75, 20);
		maincontentPane.add(rate3);
		
		rate4 = new JTextField();
		rate4.setColumns(10);
		rate4.setBounds(685, 358, 75, 20);
		maincontentPane.add(rate4);
		
		rate5 = new JTextField();
		rate5.setColumns(10);
		rate5.setBounds(685, 439, 75, 20);
		maincontentPane.add(rate5);
		
		JScrollPane compsl= new JScrollPane(projectdescription);
		compsl.setBounds(375, 66, 261, 59);
		maincontentPane.add(compsl);
		
		JScrollPane compsl1= new JScrollPane(discription1);
		compsl1.setBounds(375, 160, 261, 38);
		maincontentPane.add(compsl1);
		
		JScrollPane compsl2= new JScrollPane(discription2);
		compsl2.setBounds(375, 234, 261, 38);
		maincontentPane.add(compsl2);
		
		JScrollPane compsl3= new JScrollPane(discription3);
		compsl3.setBounds(375, 308, 261, 38);
		maincontentPane.add(compsl3);
		
		JScrollPane compsl4= new JScrollPane(discription4);
		compsl4.setBounds(375, 386, 261, 38);
		maincontentPane.add(compsl4);
		
		JScrollPane compsl5= new JScrollPane(discription5);
		compsl5.setBounds(375, 467, 261, 38);
		maincontentPane.add(compsl5);
		
		lblLineTotal = new JLabel("Line total");
		lblLineTotal.setBounds(781, 135, 86, 14);
		maincontentPane.add(lblLineTotal);
		
		JLabel label_3 = new JLabel("Line total");
		label_3.setBounds(781, 209, 86, 14);
		maincontentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Line total");
		label_4.setBounds(781, 283, 86, 14);
		maincontentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Line total");
		label_5.setBounds(781, 361, 86, 14);
		maincontentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Line total");
		label_6.setBounds(781, 442, 86, 14);
		maincontentPane.add(label_6);
		
		ltotal1 = new JTextField();
		ltotal1.setBounds(838, 132, 64, 20);
		maincontentPane.add(ltotal1);
		ltotal1.setColumns(10);
		
		ltotal2 = new JTextField();
		ltotal2.setColumns(10);
		ltotal2.setBounds(838, 206, 64, 20);
		maincontentPane.add(ltotal2);
		
		ltotal3 = new JTextField();
		ltotal3.setColumns(10);
		ltotal3.setBounds(838, 280, 64, 20);
		maincontentPane.add(ltotal3);
		
		ltotal4 = new JTextField();
		ltotal4.setColumns(10);
		ltotal4.setBounds(838, 352, 64, 20);
		maincontentPane.add(ltotal4);
		
		ltotal5 = new JTextField();
		ltotal5.setColumns(10);
		ltotal5.setBounds(838, 439, 64, 20);
		maincontentPane.add(ltotal5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(4);
		comboBox.setBounds(134, 516, 161, 20);
		maincontentPane.add(comboBox);
		try {
			Connection con = ConnectionProvider.getConnection();
			Statement st=con.createStatement();
	        String s="select features,features1,features2 from features where id=1";
			ResultSet rs=st.executeQuery(s);
			comboBox.addItem("see features here");
			while(rs.next()){
				comboBox.addItem(rs.getString(1));
				comboBox.addItem(rs.getString(2));
				comboBox.addItem(rs.getString(3));
			}
			
			customerpanel = new JPanel(){  
	            public void paintComponent(Graphics g) {  
	                  Image img = Toolkit.getDefaultToolkit().getImage(  
	                            Initial_setup.class.getResource("/images/Abstract Background.jpg"));  
	                  g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
	              }  
	         };
			customerpanel.setBackground(Color.GRAY);
			customerpanel.setBounds(0, 89, 119, 518);
			maincontentPane.add(customerpanel);
			customerpanel.setVisible(false);
			customerpanel.setLayout(null);
			
			JLabel lblName = new JLabel("Name");
			lblName.setBounds(10, 35, 87, 14);
			customerpanel.add(lblName);
			
			namecust = new JTextField();
			namecust.setEditable(false);
			namecust.setBounds(0, 60, 119, 20);
			customerpanel.add(namecust);
			namecust.setColumns(10);
			
			JLabel lblCompanyName = new JLabel("Company Name ");
			lblCompanyName.setBounds(10, 90, 125, 14);
			customerpanel.add(lblCompanyName);
			
			companynamecust = new JTextField();
			companynamecust.setEditable(false);
			companynamecust.setBounds(0, 109, 119, 20);
			customerpanel.add(companynamecust);
			companynamecust.setColumns(10);
			
			JLabel lblPin = new JLabel("Pin");
			lblPin.setBounds(10, 140, 46, 14);
			customerpanel.add(lblPin);
			
			pincust = new JTextField();
			pincust.setEditable(false);
			pincust.setBounds(0, 165, 119, 20);
			customerpanel.add(pincust);
			pincust.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Phone");
			lblNewLabel_2.setBounds(10, 196, 46, 14);
			customerpanel.add(lblNewLabel_2);
			
			phonecust = new JTextField();
			phonecust.setEditable(false);
			phonecust.setBounds(0, 219, 119, 20);
			customerpanel.add(phonecust);
			phonecust.setColumns(10);
			
			Adresscust = new JTextArea();
			Adresscust.setEditable(false);
			Adresscust.setBounds(0, 263, 119, 202);
			customerpanel.add(Adresscust);
			
			JLabel lblAddress = new JLabel("Address");
			lblAddress.setBounds(10, 247, 109, 14);
			customerpanel.add(lblAddress);
			
			final JButton find = new JButton("...");
			
			find.setBackground(Color.GRAY);
			find.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getActionCommand().equals("...")){
						System.out.println("2");
						customerpanel.setVisible(true);
						try {
							Connection con11=ConnectionProvider.getConnection();
							String qu="select * from customer_info where customer_id=? ";
							PreparedStatement pst=con11.prepareStatement(qu);
							pst.setString(1,customerid.getText());
							ResultSet rs=pst.executeQuery();
							while(rs.next()){
								namecust.setText(rs.getString("name"));
								companynamecust.setText(rs.getString("company_name"));
								Adresscust.setText(rs.getString("adress"));
								pincust.setText(rs.getString("pincode"));
								phonecust.setText(rs.getString("phone_no"));
								
							}
								
							
							} catch (Exception e2) {
							System.out.println(e2);
						}
					}
				
				}
			});
			
			
			find.setBounds(294, 224, 25, 20);
			find.setVisible(true);
			maincontentPane.add(find);
			find.requestFocusInWindow();
			
		final	JButton search = new JButton("...");
			search.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent exe) {
					if(exe.getSource()==search){
						new DisplayEmpData().showTableData();
						
						
					}
				}
			});
			search.setBounds(318, 224, 25, 20);
			search.setVisible(true);
			maincontentPane.add(search);
			search.requestFocusInWindow();
	        while(rs.next()){
	        	comboBox.addItem(rs.getString(1));
	        }
		} catch (Exception e1) {
			System.out.println(e1);
		}
	}
}