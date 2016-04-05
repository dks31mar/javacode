package com.quote;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@SuppressWarnings("serial")
public class Add_Features extends JFrame {

	private JTextField feature1;
	private JTextField feature2;
	private JTextField feature3;
	private JTextField feature4;
	private JTextField feature5;
	private JTextField feature6;
	private JTextField feature7;
	private JTextField feature8;
	private JTextField feature9;
	private JTextField feature10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Features frame = new Add_Features();
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
	public Add_Features() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Add_Features.class.getResource("/images/fgrtf.png")));
		setTitle("Add Features");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 468, 324);
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
		
		JLabel lblFeature = new JLabel("Feature 1");
		lblFeature.setBounds(35, 20, 70, 14);
		contentPane.add(lblFeature);
		
		JLabel lblFeature_1 = new JLabel("Feature 2");
		lblFeature_1.setBounds(35, 46, 70, 14);
		contentPane.add(lblFeature_1);
		
		JLabel lblFeature_2 = new JLabel("Feature 3");
		lblFeature_2.setBounds(35, 70, 70, 14);
		contentPane.add(lblFeature_2);
		
		JLabel lblFeature_3 = new JLabel("Feature 4");
		lblFeature_3.setBounds(35, 96, 70, 14);
		contentPane.add(lblFeature_3);
		
		JLabel lblFeature_5 = new JLabel("Feature 6");
		lblFeature_5.setBounds(35, 145, 70, 14);
		contentPane.add(lblFeature_5);
		
		JLabel lblFeature_6 = new JLabel("Feature 7");
		lblFeature_6.setBounds(35, 172, 70, 14);
		contentPane.add(lblFeature_6);
		
		JLabel lblFeature_7 = new JLabel("Feature 8");
		lblFeature_7.setBounds(35, 200, 70, 14);
		contentPane.add(lblFeature_7);
		
		JLabel lblFeature_8 = new JLabel("Feature 9");
		lblFeature_8.setBounds(35, 225, 70, 14);
		contentPane.add(lblFeature_8);
		
		JLabel lblFeature_9 = new JLabel("Feature 10");
		lblFeature_9.setBounds(35, 251, 70, 14);
		contentPane.add(lblFeature_9);
		
		JLabel lblFeature_4 = new JLabel("Feature 5");
		lblFeature_4.setBounds(35, 123, 70, 14);
		contentPane.add(lblFeature_4);
		
		feature1 = new JTextField();
		feature1.setBounds(158, 17, 201, 20);
		contentPane.add(feature1);
		feature1.setColumns(10);
		
		feature2 = new JTextField();
		feature2.setColumns(10);
		feature2.setBounds(158, 43, 201, 20);
		contentPane.add(feature2);
		
		feature3 = new JTextField();
		feature3.setColumns(10);
		feature3.setBounds(158, 67, 201, 20);
		contentPane.add(feature3);
		
		feature4 = new JTextField();
		feature4.setColumns(10);
		feature4.setBounds(158, 93, 201, 20);
		contentPane.add(feature4);
		
		feature5 = new JTextField();
		feature5.setColumns(10);
		feature5.setBounds(158, 119, 201, 20);
		contentPane.add(feature5);
		
		feature6 = new JTextField();
		feature6.setColumns(10);
		feature6.setBounds(158, 144, 201, 20);
		contentPane.add(feature6);
		
		feature7 = new JTextField();
		feature7.setColumns(10);
		feature7.setBounds(158, 169, 201, 20);
		contentPane.add(feature7);
		
		feature8 = new JTextField();
		feature8.setColumns(10);
		feature8.setBounds(158, 197, 201, 20);
		contentPane.add(feature8);
		
		feature9 = new JTextField();
		feature9.setColumns(10);
		feature9.setBounds(158, 222, 201, 20);
		contentPane.add(feature9);
		
		feature10 = new JTextField();
		feature10.setColumns(10);
		feature10.setBounds(158, 248, 201, 20);
		contentPane.add(feature10);
		
	final	JButton btnNewButton = new JButton("Done");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton){
					int i=0;
					try {
						Connection con = ConnectionProvider.getConnection();
						Connection con1 = ConnectionProvider.getConnection();
						String query0="insert into features(id,features,features1,features2,features3,features4,features5)"+"values(?,?,?,?,?,?,?)";
						String query1="select id from features";
						PreparedStatement pre1=con1.prepareStatement(query1);
						ResultSet rs=pre1.executeQuery();
						while (rs.next()) {
							i=rs.getInt(1);
						}
						con1.close();
						PreparedStatement pre=con.prepareStatement(query0);
						/*System.out.println(i);
						pre.setInt(1,++i);
						pre.setString(2,feature1.getText());
						System.out.println(feature1.getText());
						pre.addBatch();
						System.out.println("after1"+i);
						pre.setInt(1,++i);
						pre.setString(2,feature2.getText());
						pre.addBatch();
						System.out.println("after2"+i);
						pre.setInt(1,++i);
						pre.setString(2,feature3.getText());
						pre.addBatch();
						System.out.println("after3"+i);
						pre.setInt(1,++i);
						pre.setString(2,feature4.getText());
						pre.addBatch();
						System.out.println("after4"+i);
						pre.setInt(1,++i);
						pre.setString(2,feature5.getText());
						pre.addBatch();
						System.out.println("after5"+i);
						pre.setInt(1,++i);
						pre.setString(2,feature6.getText());
						pre.addBatch();
						System.out.println("after5"+i);
						pre.setInt(1,++i);
						pre.setString(2,feature7.getText());
						pre.addBatch();
						System.out.println("after7"+i);
						pre.setInt(1,++i);
						pre.setString(2,feature8.getText());
						pre.addBatch();
						System.out.println("after8"+i);
						pre.setInt(1,++i);
						pre.setString(2,feature9.getText());
						pre.addBatch();
						System.out.println("after9"+i);
						pre.setInt(1,++i);
						pre.setString(2,feature10.getText());
						pre.addBatch();*/
						pre.setString(1, "1");
						pre.setString(2,feature1.getText());
						pre.setString(3,feature2.getText() );
						pre.setString(4,feature3.getText() );
						pre.setString(5, feature4.getText());
						pre.setString(6, feature5.getText());
						pre.setString(7, feature6.getText());
						
						System.out.println("after10"+i);
						pre.execute();
						dispose();
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
			}
		});
		btnNewButton.setBounds(369, 247, 83, 23);
		contentPane.add(btnNewButton);
	}
}
