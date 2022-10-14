import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //use the Scanner class
        Scanner scanner = new Scanner(System.in);

        //create an object of WeightedGrades class
        WeightedGrades calculate = new WeightedGrades();

        //prompt users to enter Total point total of assignments
        System.out.print("Total point total of assignments (split by space): \n");

        String res = scanner.nextLine();

        //split String res1 with space
        String[] res1 = res.split(" ");

        //new an array of totalofassignment
        double[] totalofassignment = new double[res1.length];

        //turn String res1 array back to int and copy to totalofassignment
        for (int i = 0; i < res1.length; i++){
            totalofassignment[i] = Integer.parseInt(res1[i]);
        }


        //save the value entered by the user to calculate class
        calculate.setPointTotal(totalofassignment);


        //new an array of totalearnedpoints
        double[] totalearnedpoints = new double[res1.length];



        //prompt users to enter Total earned points total of assignments
        System.out.print("Total earned points total of assignments: \n");
        for (int i = 0; i < totalearnedpoints.length; i++) {
            totalearnedpoints[i] = scanner.nextDouble();

        }


        calculate.setEarnedTotal(totalearnedpoints);


        //new an array of totalofpercentages
        double[] totalofpercentages = new double[res1.length];

        //prompt users to enter Total percentages total of assignments
        System.out.print("Total percentages total of assignments: \n");
        for(int i = 0; i < totalofpercentages.length; i++){
            totalofpercentages[i] = scanner.nextDouble();

        }

        calculate.setPercentageTotal(totalofpercentages);

        //get grade from TotalGrade method
        double grade = calculate.TotalGrade();

        System.out.printf("Assignments score: %.3f\n", grade);

        //check grade matches which statement
        if(100 >= grade && grade >= 90){
            System.out.println("Grade: A");

        }
        else if(90 > grade && grade >= 80){
            System.out.println("Grade: B");

        }
        else if(80 > grade && grade >= 70){
            System.out.println("Grade: C");

        }
        else if(70 > grade && grade >= 60){
            System.out.println("Grade: D");

        }
        else if(60 > grade && grade >= 0){
            System.out.println("Grade: F");

        }
        else {
            //if grade >100 or <0
            System.out.println("Wrong input");
        }
    }
}