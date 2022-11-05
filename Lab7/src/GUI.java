import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    TextFile textFile = new TextFile();         //Create object textFile of TextFile class
    JLabel l1, l3;                            //Define 3 JLabels
    JButton b1, b2;                                //Define 2 JButtons
    JTextArea display, display2;                     //Define 2 JTextArea
    JTextField nameField, nameField1;                           //Define 1 JTextField
    GUI(){

        JFrame frame = new JFrame();            //Create object frame of JFrame class
        JPanel panel = new JPanel();            //Create object panel of JPanel class

        panel.setBounds(0,0,600,400);           //Set panel bounds
        panel.setLayout(null);

        l1 = new JLabel("Reading File Name");               //Set up the contents of l1
        l1.setFont(new Font("MV Boli", Font.PLAIN,20));
        l1.setBounds(20,0,200,75);

        l3 = new JLabel("File name to write");               //Set up the contents of l3
        l3.setFont(new Font("MV Boli", Font.PLAIN,20));
        l3.setBounds(300,0,200,75);

        display = new JTextArea();                               //Set up the contents of display
        display.setLineWrap(true);
        display.setBounds(20,175,200,350);

        display2 = new JTextArea();                             //Set up the contents of display2
        display2.setLineWrap(true);
        display2.setBounds(300,175,200,350);


        nameField = new JTextField();                           //Set up the contents of nameField
        nameField.setBounds(300,70,200,30);

        nameField1 = new JTextField("Annual.csv");                           //Set up the contents of nameField1
        nameField1.setBounds(20,60,200,30);

        b1 = new JButton("Click to read from file");        //Set up the contents of b1
        b1.setBounds(20,100,200,50);
        b1.addActionListener(this);

        b2 = new JButton("Click to write to file");         //Set up the contents of b2
        b2.setBounds(300,120,200,50);
        b2.addActionListener(this);



        frame.setTitle("Lab Seven - Data Files and GUI");           //Set up the contents of title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //stop running when click close
        frame.setResizable(false);                                  //Avoid user changes to the layout
        frame.setLayout(null);
        frame.setSize(600,600);                         //Set size
        frame.setVisible(true);                                     //Display graphical interface
        frame.add(l1);                                              //add things into frame
        frame.add(l3);
        frame.add(b1);
        frame.add(b2);
        frame.add(display);
        frame.add(display2);
        frame.add(nameField);
        frame.add(nameField1);
        frame.add(panel);

        panel.add(l1);                                              //add things into panel
        panel.add(l3);
        panel.add(b1);
        panel.add(b2);
        panel.add(display);
        panel.add(display2);
        panel.add(nameField);
        panel.add(nameField1);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String fileName = nameField.getText();                      //Save the file name entered by the user to filename
        String fileName1 = nameField1.getText();                    //Save the file name entered by the user
        if(e.getSource() == b1){                                    //click read button
            display.setText("");
            textFile.readTextFile(display, fileName1);              //call readTextFile
        }
        else{                                                       //click write button
            textFile.writeTextFile(display, fileName);              //call writeTextFile
            textFile.readTextFile1(display2, fileName);             //call readTextFile1
        }
    }
}
