public class WeightedGrades {

    //created double array variables
    private double[] totalofassignment;
    private double[] totalofpercentages;
    private double[] totalofearned;


    //constructor
    public WeightedGrades() {

    }

    //created setPointTotal method
    public void setPointTotal(double[] totalofassignment) {
        this.totalofassignment = totalofassignment;

    }

    //created setEarnedTotal method
    public void setEarnedTotal(double[] totalofearned) {
        this.totalofearned = totalofearned;

    }

    //created setPercentageTotal method
    public void setPercentageTotal(double[] totalofpercentages) {
        this.totalofpercentages = totalofpercentages;

    }
    //calculate final grade
    public double TotalGrade(){

        double res;
        double total = 0;
        for(int i = 0; i < totalofassignment.length; i++){

            res = totalofearned[i] / totalofassignment[i] * totalofpercentages[i];
            total += res;

        }
        return total;
    }
}