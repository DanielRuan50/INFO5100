import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {

    //create object calculate of WeightedGrades class
    WeightedGrades calculate = new WeightedGrades();

    //Define 4 JLabels
    JLabel l1,l2,l3,l4;

    //Define 4 JTextField
    JTextField t1,t2,t3,t4;

    //Define 1 JButton
    JButton b1;

    public GUI(){

        //title of the GUI
        super("Fun with GUI");


        //Write the contents of 4 JLabels
        l1 = new JLabel("Total Assignment Points");
        l2 = new JLabel("Earned Points");
        l3 = new JLabel("Percentage of class");
        l4 = new JLabel("Weighted Score");

        //Define the size of the 4 JTextField
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        t4 = new JTextField(10);

        //Avoid users to edit the display box
        t4.setEditable(false);

        //Calculation button
        b1 = new JButton("Click to calculate score");

        //Set the layout interface
        setLayout(new FlowLayout(FlowLayout.CENTER, 150, 10));
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);

        add(b1);

        //call addActionListener
        b1.addActionListener(this);


        //Avoid user changes to the layout
        setResizable(false);

        //Close the interface to stop the program from running
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set the graphical interface size
        setSize(400, 400);

        //Display graphical interface
        setVisible(true);

        //Set the background color
        getContentPane().setBackground(new Color(136, 166, 193));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Convert the JTextField input to a number
        double x = Integer.parseInt(t1.getText());

        //Put the number into setPointTotal
        calculate.setPointTotal(x);

        //Convert the JTextField input to a number
        double y = Integer.parseInt(t2.getText());

        //Put the number into setEarnedPoints
        calculate.setEarnedPoints(y);

        //Convert the JTextField input to a number
        double z = Integer.parseInt(t3.getText());

        //Put the number into setAssignmentPercentage
        calculate.setAssignmentPercentage(z);


        //call TotalWeightedGrade method
        double sum = calculate.TotalWeightedGrade();

        //define round off sum to roundOff
        String roundOff = String.format("%.2f", sum);

        //put roundOff into t4 JTextField
        t4.setText(String.valueOf(roundOff));

    }
}