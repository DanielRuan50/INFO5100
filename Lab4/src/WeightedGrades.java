public class WeightedGrades {

    //created double array variables
    private double[] totalOfAssignment;
    private double[] totalOfPercentages;
    private double[] totalOfEarned;


    //constructor
        public WeightedGrades() {

    }

    //created setPointTotal method
    public void setPointTotal(double[] totalOfAssignment) {
        this.totalOfAssignment = totalOfAssignment;

    }

    //created setEarnedTotal method
    public void setEarnedTotal(double[] totalOfEarned) {
        this.totalOfEarned = totalOfEarned;

    }

    //created setPercentageTotal method
    public void setPercentageTotal(double[] totalOfPercentages) {
        this.totalOfPercentages = totalOfPercentages;

    }
    //calculate final grade
    public double totalGrade(){

        double res;
        double total = 0;
        for(int i = 0; i < totalOfAssignment.length; i++){

            //calculate each assignment's grades
            res = totalOfEarned[i] / totalOfAssignment[i] * totalOfPercentages[i];
            total += res;

        }
        return total;
    }
}