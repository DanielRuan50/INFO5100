package UI;

import MO.Product;
import MO.Shop;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductSetupAndViewStockUI implements ActionListener {


    JLabel jLabel1, jLabel2, jLabel3, jLabel4;                      //create variables
    JTextField jTextField1, jTextField2, jTextField3, jTextField4;
    JButton jButton1;
    JRadioButton jRadioButton1, jRadioButton2;
    JTextArea productListBox;
    public ProductSetupAndViewStockUI() {
        layout();
        updateProductListBox();
    }
    private void layout() {

        JFrame frame = new JFrame();            //Create object frame of JFrame class
        JPanel panel = new JPanel();            //Create object panel of JPanel class

        panel.setBounds(0,0,600,600);           //Set panel bounds
        panel.setLayout(null);

        jLabel1 = new JLabel("Name");                       //Set up the contents of jLabel1
        jLabel1.setBounds(20,0,200,75);

        jLabel2 = new JLabel("Code");                       //Set up the contents of jLabel2
        jLabel2.setBounds(20,30,200,75);

        jLabel3 = new JLabel("Initial Qty");               //Set up the contents of jLabel3
        jLabel3.setBounds(20,60,200,75);

        jLabel4 = new JLabel("Reorder Level");               //Set up the contents of jLabel4
        jLabel4.setBounds(20,90,200,75);

        jTextField1 = new JTextField();                           //Set up jTextField1
        jTextField1.setBounds(150,30,200,20);

        jTextField2 = new JTextField();                           //Set up jTextField2
        jTextField2.setBounds(150,60,200,20);

        jTextField3 = new JTextField();                           //Set up jTextField3
        jTextField3.setBounds(150,90,200,20);

        jTextField4 = new JTextField();                           //Set up jTextField4
        jTextField4.setBounds(150,120,200,20);

        jButton1 = new JButton("Save");
        jButton1.setBounds(370,120,100,20);
        jButton1.addActionListener(this);

        jRadioButton1 = new JRadioButton("Show all");
        jRadioButton1.setBounds(20,150,130,50);
        jRadioButton1.setSelected(true);
        jRadioButton1.addActionListener(this);

        jRadioButton2 = new JRadioButton("Products which reorder level exceeded the quantity");
        jRadioButton2.setBounds(150,150,350,50);
        jRadioButton2.addActionListener(this);

        productListBox = new JTextArea();                               //Set up productListBox
        productListBox.setBounds(20,200,550,300);

        frame.setTitle("Setup Product and View stock");              //Set up the contents of title
        frame.setResizable(false);                                  //Avoid user changes to the layout
        frame.setLayout(null);
        frame.setSize(600,600);                         //Set size
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);                                     //Display graphical interface
        frame.add(jLabel1);                                          //add things into frame
        frame.add(jLabel2);
        frame.add(jLabel3);
        frame.add(jLabel4);
        frame.add(jTextField1);
        frame.add(jTextField2);
        frame.add(jTextField3);
        frame.add(jTextField4);
        frame.add(jButton1);
        frame.add(jRadioButton1);
        frame.add(jRadioButton2);
        frame.add(productListBox);
        frame.add(panel);

        panel.add(jLabel1);                                          //add things into panel
        panel.add(jLabel2);
        panel.add(jLabel3);
        panel.add(jLabel4);
        panel.add(jTextField1);
        panel.add(jTextField2);
        panel.add(jTextField3);
        panel.add(jTextField4);
        panel.add(jButton1);
        panel.add(jRadioButton1);
        panel.add(jRadioButton2);
        panel.add(productListBox);


    }

    public void updateProductListBox() {                //get products info
        productListBox.setText("");
        String format = "%s\t\t%s\t\t%s\t\t%s\n";
        productListBox.append(String.format(format, "Name", "Code", "Quantity", "Reorder Level"));

        for (Product aProduct : Shop.getShop().getProductList()) {
            productListBox.append(String.format(format, aProduct.getName(), aProduct.getCode(), aProduct.getTotalQuantity(), aProduct.getReorderLevel()));
        }
    }

    public void showShortageProducts() {                //get shortage products info
        productListBox.setText("");
        String format = "%s\t\t%s\t\t%s\t\t%s\n";
        productListBox.append(String.format(format, "Name", "Code", "Quantity", "Reorder Level"));

        for (Product aProduct : Shop.getShop().getProductList()) {
            if (aProduct.getTotalQuantity() < aProduct.getReorderLevel()) {
                productListBox.append(String.format(format, aProduct.getName(), aProduct.getCode(), aProduct.getTotalQuantity(), aProduct.getReorderLevel()));
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButton1){                  //if press save
            Product aProduct = new Product();
            try {
                aProduct.setName(jTextField1.getText());
                aProduct.setCode(jTextField2.getText());

                int totalQuantity = Integer.parseInt(jTextField3.getText());
                int reorderLevel = Integer.parseInt(jTextField4.getText());

                if (totalQuantity < 0) {
                    throw new MyException("Initial Quantity can't be less than 0");         //if totalQuantity < 0
                } else if (reorderLevel < 0) {
                    throw new MyException("Reorder level can't be less than 0");            //if reorderLevel < 0
                }

                aProduct.setTotalQuantity(totalQuantity);
                aProduct.setReorderLevel(reorderLevel);
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");

                String message = Shop.getShop().enlistProduct(aProduct);
                JOptionPane.showMessageDialog(null,
                        message,
                        "SUCCESS!",
                        JOptionPane.PLAIN_MESSAGE);
                updateProductListBox();
            } catch (MyException ex) {
                JOptionPane.showMessageDialog(null,
                        ex.getMessage(),
                        "FAILED!",
                        JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,         //if not valid inputs
                        "Not valid inputs! try again.",
                        "FAILED!",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (e.getSource() == jRadioButton1) {              //if choose jRadioButton1 call updateProductListBox()
            jRadioButton1.setSelected(true);
            jRadioButton2.setSelected(false);
            updateProductListBox();
        }
        else if (e.getSource() == jRadioButton2) {              //if choose jRadioButton2 call showShortageProducts()
            jRadioButton1.setSelected(false);
            jRadioButton2.setSelected(true);
            showShortageProducts();
        }
    }
}
