package com.admin.login.invoice;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

@SuppressWarnings("serial")
public class Del_Product extends JFrame {

	private JPanel contentPane;
	private JTextField productId;
	private JTextField productName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Del_Product frame = new Del_Product();
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
	public Del_Product() {
		setTitle("Modifications");
		
		setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblProductId = new JLabel("Product Id");
		
		JLabel lblAddProduct = new JLabel("Modify Product");
		lblAddProduct.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		JLabel lblProductName = new JLabel("Product Name");
		
		productId = new JTextField();
		productId.setColumns(10);
		
		productName = new JTextField();
		productName.setColumns(10);
		
		JButton btnSearch = new JButton("search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("search")){
						try{
						Connection con = ConnectionProvider.getConnection();
						String query="select * from addproduct where id=? or productname=?";
						PreparedStatement presmt = con.prepareStatement(query);
						presmt.setString(1,productId.getText());
						presmt.setString(2,productName.getText());
						ResultSet rs=presmt.executeQuery();
						
				        while(rs.next()){
				        productName.setText(rs.getString("productname"));
						
				        
					    JOptionPane.showMessageDialog(null,"find!!!");
				        }
				        }
						catch(Exception e1){
							System.out.println(e1);
						}
				}
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Delete")){
					try{
					Connection con = ConnectionProvider.getConnection();
					String query="delete from addproduct where id=? ";
					PreparedStatement presmt = con.prepareStatement(query);
					presmt.setString(1,productId.getText());
					presmt.execute();
					}
					catch(Exception e1){
						
					}
					}
					
			}
		});
		
		JButton btnUpdate = new JButton("update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("update")){
					try{
					Connection con = ConnectionProvider.getConnection();
					String query="update addproduct set productname=?  where id=? ";
					PreparedStatement presmt = con.prepareStatement(query);
					presmt.setString(2,productId.getText());
					presmt.setString(1,productName.getText());
					presmt.execute();
					}
					catch(Exception e2){
						System.out.println(e2);
					}
					}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(117)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblProductId)
						.addComponent(lblProductName)
						.addComponent(productId, 138, 138, 138)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSearch)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnDelete))
						.addComponent(productName, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
					.addGap(169))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(160)
					.addComponent(btnUpdate)
					.addContainerGap(197, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(150)
					.addComponent(lblAddProduct, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(121, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAddProduct)
					.addGap(39)
					.addComponent(lblProductId)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(productId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(lblProductName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(productName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSearch)
						.addComponent(btnDelete))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnUpdate)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
