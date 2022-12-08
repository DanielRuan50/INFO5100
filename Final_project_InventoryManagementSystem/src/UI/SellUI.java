package UI;

import MO.Product;
import MO.Sale;
import MO.Shop;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

public class SellUI implements ActionListener {

    JLabel jLabel1, jLabel2, jLabel3, jLabel4;          //create variables
    JTextField jTextField1, jTextField2;
    JButton jButton1;
    JComboBox jComboBox1;
    JDateChooser jDateChooser1;
    public SellUI() {
        layout();
        stockListComboBox();
    }

    private void layout() {

        JFrame frame = new JFrame();            //Create object frame of JFrame class
        JPanel panel = new JPanel();            //Create object panel of JPanel class

        panel.setBounds(0,0,400,300);           //Set panel bounds
        panel.setLayout(null);

        jLabel1 = new JLabel("Select Product");               //Set up the contents of jLabel1
        jLabel1.setBounds(20,0,200,75);

        jLabel2 = new JLabel("Sale Quantity");               //Set up the contents of jLabel2
        jLabel2.setBounds(20,30,200,75);

        jLabel3 = new JLabel("Total Bill Amount");               //Set up the contents of jLabel3
        jLabel3.setBounds(20,60,200,75);

        jLabel4 = new JLabel("Date");                         //Set up the contents of jLabel4
        jLabel4.setBounds(20,90,200,75);

        jComboBox1 = new JComboBox();                           //Set up the contents of jComboBox1
        jComboBox1.setBounds(150,30,200,20);

        jTextField1 = new JTextField();                           //Set up the contents of jTextField1
        jTextField1.setBounds(150,60,200,20);

        jTextField2 = new JTextField();                           //Set up the contents of jTextField2
        jTextField2.setBounds(150,90,200,20);

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser1.setBounds(150,120,200,20);
        JTextFieldDateEditor editor = (JTextFieldDateEditor) jDateChooser1.getDateEditor();
        editor.setEditable(false);
        jDateChooser1.setDate(new Date());
        jDateChooser1.setDateFormatString("d MMM, yyyy");

        jButton1 = new JButton("Save");
        jButton1.setBounds(250,150,100,20);
        jButton1.addActionListener(this);

        frame.setTitle("Sale Record");                               //Set up the contents of title
        frame.setResizable(false);                                  //Avoid user changes to the layout
        frame.setLayout(null);
        frame.setSize(400,300);                         //Set size
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);                                     //Display graphical interface
        frame.add(jLabel1);                                         //add things into frame
        frame.add(jLabel2);
        frame.add(jLabel3);
        frame.add(jLabel4);
        frame.add(jTextField1);
        frame.add(jTextField2);
        frame.add(jComboBox1);
        frame.add(jButton1);
        frame.add(jDateChooser1);
        frame.add(panel);

        panel.add(jLabel1);                                         //add things into panel
        panel.add(jLabel2);
        panel.add(jLabel3);
        panel.add(jLabel4);
        panel.add(jTextField1);
        panel.add(jTextField2);
        panel.add(jComboBox1);
        panel.add(jButton1);
        panel.add(jDateChooser1);


    }

    public void stockListComboBox() {
        for (Product aProduct : Shop.getShop().getProductList()) {              //add ProductList to jComboBox1
            jComboBox1.addItem(aProduct);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButton1){                                //if press save
            Sale aSale = new Sale();
            aSale.setProduct((Product) jComboBox1.getSelectedItem());

            try {
                int sellQuantity = Integer.parseInt(jTextField1.getText());
                double totalAmount = Double.parseDouble(jTextField2.getText());

                if (sellQuantity <= 0) {
                    throw new MyException("Sale Quantity can't be less than or equal to 0");        //if sellQuantity <= 0
                } else if (totalAmount <= 0) {
                    throw new MyException("Total bill can't be less than or equal to 0");       //if totalAmount <= 0
                }

                aSale.setTransactionQuantity(sellQuantity);         //save sellQuantity into setTransactionQuantity
                aSale.setTotalAmount(totalAmount);                  //save totalAmount into setTotalAmount
            } catch (MyException ex) {
                JOptionPane.showMessageDialog(null,
                        ex.getMessage(),
                        "FAILED!",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,
                        "Please enter data in right format.",
                        "ERROR!",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            aSale.setOperationDate(jDateChooser1);

            if (aSale.getProduct() != null) {
                String msg = Shop.getShop().addSale(aSale);
                stockListComboBox();
                JOptionPane.showMessageDialog(null,
                        msg,
                        "BINGO!",
                        JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Please select the product.",
                        "ERROR!",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
