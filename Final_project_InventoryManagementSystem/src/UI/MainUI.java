package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainUI implements ActionListener {

    JButton jButton1, jButton2, jButton3, jButton4 ,jButton5 ,jButton6;             //create variables
    public MainUI() {

        layout();

    }
    private void layout() {

        JFrame frame = new JFrame();            //Create object frame of JFrame class
        JPanel panel = new JPanel();            //Create object panel of JPanel class

        panel.setBounds(0,0,460,250);           //Set panel bounds
        panel.setLayout(null);

        jButton1 = new JButton("Sales Record");
        jButton1.setBounds(230,20,200,50);
        jButton1.addActionListener(this);

        jButton2 = new JButton("Sale / Purchase / Damage");
        jButton2.setBounds(20,80,200,50);
        jButton2.addActionListener(this);

        jButton3 = new JButton("Purchase Record");
        jButton3.setBounds(230,80,200,50);
        jButton3.addActionListener(this);

        jButton4 = new JButton("<html>Setup Product and View<center>Stock</center></html>");
        jButton4.setBounds(20,20,200,50);
        jButton4.addActionListener(this);

        jButton5 = new JButton("Damage Record");
        jButton5.setBounds(230,140,200,50);
        jButton5.addActionListener(this);

        jButton6 = new JButton("Open Calculator");
        jButton6.setBounds(20,140,200,50);
        jButton6.addActionListener(this);

        frame.setTitle("Inventory Management System");              //Set up the contents of title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //stop running when click close
        frame.setResizable(false);                                  //Avoid user changes to the layout
        frame.setLayout(null);
        frame.setSize(460,250);                         //Set size
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);                                     //Display graphical interface
        frame.add(jButton1);                                        //add things into frame
        frame.add(jButton2);
        frame.add(jButton3);
        frame.add(jButton4);
        frame.add(jButton5);
        frame.add(jButton6);
        frame.add(panel);

        panel.add(jButton1);                                        //add things into panel
        panel.add(jButton2);
        panel.add(jButton3);
        panel.add(jButton4);
        panel.add(jButton5);
        panel.add(jButton6);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == jButton1){                               //choose buttons
            new SellUI();
        }
        else if (e.getSource() == jButton2) {
            new ReportUI();
        }
        else if (e.getSource() == jButton3) {
            new PurchaseUI();
        }
        else if (e.getSource() == jButton4) {
            new ProductSetupAndViewStockUI();
        }
        else if (e.getSource() == jButton5) {
            new DamageEntryUI();
        }
        else if (e.getSource() == jButton6) {
            try {
                Runtime.getRuntime().exec("calc");
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }
}
