package UI;

import MO.Damage;
import MO.Purchase;
import MO.Sale;
import MO.Shop;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

public class ReportUI implements ActionListener {

    JLabel jLabel1, jLabel2;                            //create variables
    JTextField jTextField1;
    JButton jButton1, jButton2, jButton3;
    JTextArea jTextArea1;
    JDateChooser jDateChooser1;
    public ReportUI() {
        layout();
        setVisibilityOfTotalAmountTextBoxes(false);
    }

    private void layout() {

        JFrame frame = new JFrame();            //Create object frame of JFrame class
        JPanel panel = new JPanel();            //Create object panel of JPanel class

        panel.setBounds(0,0,650,520);           //Set panel bounds
        panel.setLayout(null);

        jLabel1 = new JLabel("Select Date");               //Set up the contents of l1
        jLabel1.setBounds(20,0,200,75);

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser1.setBounds(150,30,200,20);
        JTextFieldDateEditor editor = (JTextFieldDateEditor) jDateChooser1.getDateEditor();
        editor.setEditable(false);
        jDateChooser1.setDate(new Date());
        jDateChooser1.setDateFormatString("d MMM, yyyy");

        jButton1 = new JButton("Show Sale");
        jButton1.setBounds(20,60,100,20);
        jButton1.addActionListener(this);

        jButton2 = new JButton("Show Purchase");
        jButton2.setBounds(140,60,150,20);
        jButton2.addActionListener(this);

        jButton3 = new JButton("Show Damage");
        jButton3.setBounds(310,60,150,20);
        jButton3.addActionListener(this);

        jLabel2 = new JLabel("Total Amount");               //Set up the contents of jLabel2
        jLabel2.setBounds(20,410,200,75);

        jTextField1 = new JTextField();                           //Set up jTextField1
        jTextField1.setBounds(150,440,200,20);

        jTextArea1 = new JTextArea();                               //Set up jTextArea1
        jTextArea1.setBounds(20,90,600,330);


        frame.setTitle("Report");                                   //Set up the contents of title
        frame.setResizable(false);                                  //Avoid user changes to the layout
        frame.setLayout(null);
        frame.setSize(650,520);                         //Set size
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);                                     //Display graphical interface
        frame.add(jLabel1);                                         //add things into frame
        frame.add(jLabel2);
        frame.add(jDateChooser1);
        frame.add(jButton1);
        frame.add(jButton2);
        frame.add(jButton3);
        frame.add(jTextArea1);
        frame.add(jLabel2);
        frame.add(jTextField1);
        frame.add(panel);

        panel.add(jLabel1);                                         //add things into panel
        panel.add(jLabel2);
        panel.add(jDateChooser1);
        panel.add(jButton1);
        panel.add(jButton2);
        panel.add(jButton3);
        panel.add(jTextArea1);
        panel.add(jLabel2);
        panel.add(jTextField1);



    }

    public void setVisibilityOfTotalAmountTextBoxes(boolean state) {
        if (state) {                        //if show sale or show purchase
            jLabel2.setVisible(true);
            jTextField1.setVisible(true);
        } else {                            //if show damage
            jLabel2.setVisible(false);
            jTextField1.setVisible(false);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == jButton1){                      //if press show sale
            setVisibilityOfTotalAmountTextBoxes(true);
            List<Sale> salesListOfADate = Shop.getShop().getSalesOfADate(jDateChooser1);
            jTextArea1.setText("");
            String format = "%s\t\t%s\t\t%s\t\t%s\n";
            jTextArea1.append(String.format(format, "Name", "Code", "Sale Qty", "Amount"));
            jTextField1.setText("0");
            double totalAmount = 0.0;

            for (Sale aSale : salesListOfADate) {           //show sale list
                jTextArea1.append(String.format(format, aSale.getProduct().getName(), aSale.getProduct().getCode(), aSale.getTransactionQuantity(), aSale.getTotalAmount()));
                totalAmount += aSale.getTotalAmount();
            }
            jTextField1.setText(String.format("%.2f", totalAmount));
        }
        else if (e.getSource() == jButton2) {                      //if press show purchase
            setVisibilityOfTotalAmountTextBoxes(true);
            List<Purchase> purchaseListOfADate = Shop.getShop().getPurchaseOfADate(jDateChooser1);
            jTextArea1.setText("");
            String format = "%s\t\t%s\t\t%s\t\t%s\t\t%s\n";
            jTextArea1.append(String.format(format, "Name", "Code", "Purchase Qty", "Amount", "Vendor"));
            jTextField1.setText("0");
            double totalAmount = 0.0;

            for (Purchase aPurchase : purchaseListOfADate) {        //show purchase list
                jTextArea1.append(String.format(format, aPurchase.getProduct().getName(), aPurchase.getProduct().getCode(), aPurchase.getTransactionQuantity(), aPurchase.getTotalAmount(), aPurchase.getVendorName()));
                totalAmount += aPurchase.getTotalAmount();
            }
            jTextField1.setText(String.format("%.2f", totalAmount));
        }
        else if (e.getSource() == jButton3) {               //if press show damage
            setVisibilityOfTotalAmountTextBoxes(false);
            List<Damage> damageListOfADate = Shop.getShop().getDamageOfADate(jDateChooser1);
            jTextArea1.setText("");
            String format = "%s\t\t%s\t\t%s\t\t%s\n";
            jTextArea1.append(String.format(format, "Name", "Code", "Damage Qty", "Cause"));

            for (Damage aDamage : damageListOfADate) {              //show damage list
                jTextArea1.append(String.format(format, aDamage.getProduct().getName(), aDamage.getProduct().getCode(), aDamage.getTransactionQuantity(), aDamage.getCause()));
            }
        }
    }
}
