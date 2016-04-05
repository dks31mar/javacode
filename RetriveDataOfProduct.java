package com.admin.login.invoice;

import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JScrollPane;


@SuppressWarnings("serial")
public class RetriveDataOfProduct extends JFrame {

	private JPanel contentPane;
	private JTextField invoiceno;
	private JTextField date;
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
	private JTextField paymentmode;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RetriveDataOfProduct frame = new RetriveDataOfProduct();
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
	@SuppressWarnings({ "rawtypes" })
	public RetriveDataOfProduct() {
		setTitle("Print");
		
		@SuppressWarnings("unused")
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		setResizable(false);
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setBounds(0, 0, 1341, 726);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("activeCaption"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton find = new JButton("Find");
		find.setBounds(794, 478, 91, 23);
		find.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Find")){
					int tan = 0;
					
					try{

						
						Connection con = ConnectionProvider.getConnection();
						PreparedStatement st=con.prepareStatement("select * from productinformation where invoiceno=? or userOrderno=?");
				        st.setString(1,invoiceno.getText());
				        st.setString(2, order.getText());
						ResultSet rs=st.executeQuery();
						System.out.println(invoiceno.getText());
						System.out.println("dks1");
						
				        while(rs.next()){
				        	
				        	
				        invoiceno.setText(rs.getString("invoiceno"));
				        order.setText(rs.getString("userOrderNo"));
				        sno.setText(rs.getString("sno"));
				        paymentmode.setText(rs.getString("paymentmode"));
				        date.setText(rs.getString("date"));
				        portal.setText(rs.getString("protal"));
				        sender.setText(rs.getString("sender"));
				        description.setText(rs.getString("description"));
				        dispatch.setText(rs.getString("dispatch"));
				        awbno.setText(rs.getString("AWB"));
				        servicecharge.setText(rs.getString("servicecharge"));
				        tax.setText(rs.getString("tax"));
				        total.setText(rs.getString("total"));
				        buyer.setText(rs.getString("buyer"));
				        amount.setText(rs.getString("amount"));
				        amountinwords.setText(rs.getString("amountinwords"));
				        rate.setText(rs.getString("rate"));
				        quantity.setText(rs.getString("quantity"));
				        partno.setText(rs.getString("partno"));
				        tan=10;
				        
				        }
						con.close();
						if(tan==0){
							JOptionPane.showMessageDialog(null,"Data Not Found");
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
		sender_1.setBounds(843, 147, 97, 14);
		
		JLabel invoiceno_1 = new JLabel("invoice No.");
		invoiceno_1.setBounds(73, 147, 71, 14);
		
		final JLabel date_1 = new JLabel("Date");
		date_1.setBounds(73, 177, 71, 14);
		
		JLabel orderno_1 = new JLabel("Order no.");
		orderno_1.setBounds(73, 206, 89, 14);
		
		sender = new JTextArea();
		sender.setLineWrap(true);
		sender.setBounds(841, 172, 188, 48);
		sender.setEditable(false);
		sender.setWrapStyleWord(true);
		
		invoiceno = new JTextField();
		invoiceno.setBounds(212, 146, 183, 20);
		invoiceno.setColumns(10);
		
		date = new JTextField();
		date.setBounds(212, 174, 183, 20);
		date.setEditable(false);
		date.setColumns(10);
		
		order = new JTextField();
		order.setBounds(212, 203, 183, 20);
		order.setEditable(true);
		order.setColumns(10);
		
		JLabel buyer_1 = new JLabel("Buyer");
		buyer_1.setBounds(841, 238, 71, 14);
		
		JLabel protal = new JLabel("Protal");
		protal.setBounds(73, 273, 89, 14);
		
		JLabel paymentmode_1 = new JLabel("Payment mode");
		paymentmode_1.setBounds(73, 304, 103, 14);
		
		JLabel dispatch_1 = new JLabel("Dispatch through");
		dispatch_1.setBounds(73, 333, 129, 14);
		
		JLabel awbno_1 = new JLabel("AWB no.");
		awbno_1.setBounds(73, 369, 103, 14);
		
		buyer = new JTextArea();
		buyer.setLineWrap(true);
		buyer.setBounds(841, 258, 188, 48);
		buyer.setEditable(false);
		buyer.setWrapStyleWord(true);
		
		
		portal = new JTextField();
		portal.setBounds(212, 270, 183, 20);
		portal.setEditable(false);
		portal.setColumns(10);
		
		dispatch = new JTextField();
		dispatch.setBounds(212, 335, 183, 20);
		dispatch.setEditable(false);
		dispatch.setColumns(10);
		
		awbno = new JTextField();
		awbno.setBounds(212, 366, 183, 20);
		awbno.setEditable(false);
		awbno.setColumns(10);
		
		JLabel sno_1 = new JLabel("S.No.");
		sno_1.setBounds(73, 238, 89, 14);
		
		sno = new JTextField();
		sno.setBounds(212, 235, 183, 20);
		sno.setEditable(false);
		sno.setColumns(10);
		
		JLabel descriptionofgoods = new JLabel("Description of goods");
		descriptionofgoods.setBounds(842, 327, 98, 14);
		
		JList list = new JList();
		list.setBounds(218, 692, 1, 1);
		
		description = new JTextArea();
		description.setLineWrap(true);
		description.setBounds(841, 353, 188, 48);
		description.setEditable(false);
		description.setWrapStyleWord(true);
		
		
		JLabel partnumber = new JLabel("Part number");
		partnumber.setBounds(463, 147, 129, 14);
		
		partno = new JTextField();
		partno.setBounds(578, 141, 196, 20);
		partno.setEditable(false);
		partno.setColumns(10);
		
		JLabel quantity_1 = new JLabel("Quantity");
		quantity_1.setBounds(463, 177, 115, 14);
		
		JLabel rate_1 = new JLabel("Rate");
		rate_1.setBounds(463, 206, 115, 14);
		
		JLabel amount_1 = new JLabel("Amount");
		amount_1.setBounds(463, 238, 115, 14);
		
		quantity = new JTextField();
		quantity.setBounds(578, 174, 196, 20);
		quantity.setEditable(false);
		quantity.setColumns(10);
		
		rate = new JTextField();
		rate.setBounds(578, 203, 196, 20);
		rate.setEditable(false);
		rate.setColumns(10);
		
		amount = new JTextField();
		amount.setBounds(578, 234, 196, 20);
		amount.setEditable(false);
		amount.setColumns(10);
		
		JLabel total_1 = new JLabel("Total");
		total_1.setBounds(463, 263, 115, 14);
		
		total = new JTextField();
		total.setBounds(578, 260, 196, 20);
		total.setEditable(false);
		total.setColumns(10);
		
		JLabel amountInWords = new JLabel("Amount in words");
		amountInWords.setBounds(463, 358, 80, 14);
		
		amountinwords = new JTextField();
		amountinwords.setBounds(463, 379, 311, 20);
		amountinwords.setEditable(false);
		amountinwords.setColumns(10);
		
		JLabel additionalTax = new JLabel("Additional tax");
		additionalTax.setBounds(463, 292, 97, 14);
		
		JLabel serviceCharge = new JLabel("Service charge");
		serviceCharge.setBounds(463, 327, 97, 14);
		
		tax = new JTextField();
		tax.setBounds(578, 288, 196, 20);
		tax.setEditable(false);
		tax.setColumns(10);
		
		servicecharge = new JTextField();
		servicecharge.setBounds(578, 324, 196, 20);
		servicecharge.setEditable(false);
		servicecharge.setColumns(10);
		
		paymentmode = new JTextField();
		paymentmode.setBounds(212, 301, 183, 20);
		paymentmode.setEditable(false);
		paymentmode.setColumns(10);
		
		JButton btnPrint = new JButton("print");
		btnPrint.setBounds(659, 478, 89, 23);
		btnPrint.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("print")){
					
					try{
						Connection con1=ConnectionProvider.getConnection();
						Connection con2=ConnectionProvider.getConnection();
						
						
						String query1="insert into report(sno, sender, invoiceno, date, userOrderNo, buyer, protal, paymentmode, dispatch, AWB, description, partno, quantity, rate, amount, total, amountinwords, tax, servicecharge)" + "values (?,?,?,?,?,?,?, ? ,?, ?, ? ,? ,?, ?, ? ,?, ?, ?, ?)";
						String query2="delete from report";
						PreparedStatement presmt1 = con1.prepareStatement(query1);
						
							presmt1.setString(1,sno.getText());
							presmt1.setString(2,sender.getText());
							presmt1.setString(3,invoiceno.getText());
							presmt1.setString(4,date.getText());
						    presmt1.setString(5,order.getText());
						    presmt1.setString(6,buyer.getText());
							presmt1.setString(7,portal.getText());
							presmt1.setString(8,paymentmode.getText());
							presmt1.setString(9,dispatch.getText());
							presmt1.setString(10,awbno.getText());
							presmt1.setString(11,description.getText());
							presmt1.setString(12,partno.getText());
							presmt1.setString(13,quantity.getText());
							presmt1.setString(14,rate.getText());
							presmt1.setString(15,amount.getText());
							presmt1.setString(16,total.getText());
							presmt1.setString(17,amountinwords.getText());
							presmt1.setString(18,tax.getText());
							presmt1.setString(19,servicecharge.getText());
					        presmt1.execute();
					        JasperReport jasperReport = JasperCompileManager.compileReport(("resource/finalreport.jrxml"));
							JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null,con1);
							JasperViewer.viewReport(jasperPrint,false);
							PreparedStatement presmt21= con2.prepareStatement(query2);
							presmt21.execute();
							con1.close();
							con2.close();
							
								
					}
					catch(Exception ex){
						JOptionPane.showMessageDialog(null,ex);
					}
					
				}//if end
			}//actionperformed end
		});
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
		contentPane.add(dispatch);
		contentPane.add(date);
		contentPane.add(invoiceno);
		contentPane.add(order);
		contentPane.add(sno);
		contentPane.add(portal);
		contentPane.add(awbno);
		contentPane.add(paymentmode);
		contentPane.add(sender);
		contentPane.add(sender_1);
		contentPane.add(buyer_1);
		contentPane.add(buyer);
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
		contentPane.add(servicecharge);
		contentPane.add(tax);
		contentPane.add(btnPrint);
		contentPane.add(amountinwords);
		contentPane.add(description);
		contentPane.add(descriptionofgoods);
		contentPane.add(find);
		
		JLabel lblShowProductDetail = new JLabel("Show Product Detail");
		lblShowProductDetail.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblShowProductDetail.setBounds(463, 11, 657, 90);
		contentPane.add(lblShowProductDetail);
		
		JScrollPane senderscrollPane = new JScrollPane(sender);
		senderscrollPane.setBounds(841, 172, 188, 48);
		contentPane.add(senderscrollPane);
		
		JScrollPane buyerscrollPane = new JScrollPane(buyer);
		buyerscrollPane.setBounds(841, 258, 188, 48);
		contentPane.add(buyerscrollPane);
		
		JScrollPane descriptionscrollPane = new JScrollPane(description);
		descriptionscrollPane.setBounds(841, 353, 188, 48);
		contentPane.add(descriptionscrollPane);
		
		final JButton btnClean = new JButton("Clean");
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eq) {
				if(eq.getSource()==btnClean){
					
					{
						invoiceno.setText("");
						date.setText("");
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
						paymentmode.setText("");;
						
						}
				}
			}
		});
		btnClean.setBounds(903, 478, 89, 23);
		contentPane.add(btnClean);
	}
}
