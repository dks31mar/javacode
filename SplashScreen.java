package com.admin.login.invoice;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class SplashScreen extends JWindow {

    static boolean isRegistered;
    private static JProgressBar progressBar = new JProgressBar();
    private static SplashScreen execute;
    private static int count;
    private static Timer timer1;
    private JLabel lblNewLabel;

    public SplashScreen() {

        Container container = getContentPane();
        container.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBorder(new javax.swing.border.EtchedBorder());
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 10, 348, 150);
        panel.setLayout(null);
        container.add(panel);
        
        lblNewLabel = new JLabel(new ImageIcon("pics/icon/syndtechinvoicesplash.jpg"));
        /*lblNewLabel.setText("                 Invoice V1.0\r\n      Syndtec Private Limited!!!");*/
        lblNewLabel.setBounds(0, 0, 348, 150);
        panel.add(lblNewLabel);

        progressBar.setMaximum(110);
        progressBar.setBounds(55, 180, 250, 15);
        container.add(progressBar);
        loadProgressBar();
        setSize(370, 215);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadProgressBar() {
        ActionListener al = new ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                count++;

                progressBar.setValue(count);

                System.out.println(count);

                if (count == 110) {

                    createFrame();

                    execute.setVisible(false);//swapped this around with timer1.stop()

                    timer1.stop();
                }

            }

            private void createFrame() throws HeadlessException {
                Invoice_Application ia=new Invoice_Application();
                ia.frmLogin.setVisible(true);
            }
        };
        timer1 = new Timer(50, al);
        timer1.start();
    }

    public static void main(String[] args) {
        execute = new SplashScreen();
    }
};
