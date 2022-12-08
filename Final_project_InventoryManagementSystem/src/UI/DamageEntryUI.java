package UI;

import MO.Damage;
import MO.Product;
import MO.Shop;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;


public class DamageEntryUI implements ActionListener {

    JLabel jLabel1, jLabel2, jLabel3, jLabel4;              //create variables
    JTextField jTextField1, jTextField2;
    JButton jButton1;
    JComboBox jComboBox1;
    JDateChooser jDateChooser1;
    public DamageEntryUI() {
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

        jLabel2 = new JLabel("Damage Quantity");               //Set up the contents of jLabel2
        jLabel2.setBounds(20,30,200,75);

        jLabel3 = new JLabel("Cause of Damage");               //Set up the contents of jLabel3
        jLabel3.setBounds(20,60,200,75);

        jLabel4 = new JLabel("Date");                            //Set up the contents of jLabel4
        jLabel4.setBounds(20,90,200,75);

        jComboBox1 = new JComboBox();                               //Set up jComboBox1
        jComboBox1.setBounds(150,30,200,20);

        jTextField1 = new JTextField();                           //Set up jTextField1
        jTextField1.setBounds(150,60,200,20);

        jTextField2 = new JTextField();                           //Set up jTextField2
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

        frame.setTitle("Damage Record");                            //Set up the contents of title
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

        panel.add(jLabel1);                                              //add things into panel
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
        if(e.getSource() == jButton1){              //if press save
            Damage aDamage = new Damage();
            aDamage.setProduct((Product) jComboBox1.getSelectedItem());

            try {
                int damageQuantity = Integer.parseInt(jTextField1.getText());
                if (damageQuantity <= 0) {
                    throw new MyException("Damage Quantity can't be less than or equal to 0");      //if input damageQuantity <= 0
                }

                aDamage.setTransactionQuantity(damageQuantity);         //update inventory quantity
                aDamage.setCause(jTextField2.getText());                //update damage cause
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

            aDamage.setOperationDate(jDateChooser1);

            if (aDamage.getProduct() != null) {
                String msg = Shop.getShop().addDamage(aDamage);
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
