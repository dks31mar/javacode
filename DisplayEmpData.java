package com.quote;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
@SuppressWarnings("serial")
public class DisplayEmpData extends JFrame implements ActionListener {
	public DisplayEmpData() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DisplayEmpData.class.getResource("/images/fgrtf.png")));
	}
 
    JFrame frame1;
    JLabel l2;
    JButton b1;
    Connection con;
    ResultSet rs, rs1;
    Statement st, st1;
    PreparedStatement pst;
    String ids;
    static JTable table;
    String[] columnNames = {"Customer ID", "Name", "Company Name", "Address", "Pin Code", "Phone Number"};
 public void actionPerformed(ActionEvent ae) {}
 public void showTableData() {
	 
        frame1 = new JFrame("Database Search Result");
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.getContentPane().setLayout(new BorderLayout());
        
//TableModel tm = new TableModel();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());
//table = new JTable(model);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        /*from = (String) c1.getSelectedItem();*/
//String textvalue = textbox.getText();
        String CustomerId = "";
        String name = "";
        String comapny_name = "";
        String Address = "";
        String Pin="";
        String Phone="";
 
        try {
        	con=ConnectionProvider.getConnection();
            pst = con.prepareStatement("select * from customer_info ");
            ResultSet rs = pst.executeQuery();
            int i = 0;
            while(rs.next()) {
                CustomerId = rs.getString("customer_id");
                name = rs.getString("name");
                comapny_name = rs.getString("company_name");
                Address = rs.getString("adress");
                Pin = rs.getString("pincode");
                Phone = rs.getString("phone_no");
                model.addRow(new Object[]{CustomerId,name,comapny_name,Address,Pin,Phone});
                i++;
            }
            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (i == 1) {
                System.out.println(i + " Record Found");
                JOptionPane.showMessageDialog(null, "Number of Entities is "+i);
            } else {
            	JOptionPane.showMessageDialog(null, "Number of Entities is "+i);
                System.out.println(i + " Records Found");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        frame1.getContentPane().add(scroll);
        frame1.setVisible(true);
        frame1.setSize(400, 300);
    }
 
    public static void main(String args[]) {
    	new DisplayEmpData().showTableData();
    	
    }
}