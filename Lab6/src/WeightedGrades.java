class WeightedGrades{

    //created integer and double variables
    private double PointTotal;
    private double EarnedPoints;
    private double AssignmentPercentage;

    //constructor
    public WeightedGrades(){

    }

    //created setPointTotal method
    public void setPointTotal(double PointTotal){

        this.PointTotal = PointTotal;
    }

    //created getPointTotal method
    public double getPointTotal() {

        return PointTotal;
    }

    //created setEarnedPoints method
    public void setEarnedPoints(double EarnedPoints) {

        this.EarnedPoints = EarnedPoints;
    }

    //created getEarnedPoints method
    public double getEarnedPoints() {

        return EarnedPoints;
    }

    //created setAssignmentPercentage method
    public void setAssignmentPercentage(double AssignmentPercentage){

        this.AssignmentPercentage = AssignmentPercentage;
    }

    //created getAssignmentPercentage method
    public double getAssignmentPercentage() {
        //to make 35 to 0.35
        return AssignmentPercentage;
    }
    //created TotalWeightedGrade method
    public double TotalWeightedGrade(){

        //calculate weighted score
        return EarnedPoints / PointTotal * AssignmentPercentage / 100 * 100;
    }

}
