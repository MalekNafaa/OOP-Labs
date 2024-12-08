package week10.q2;

import java.util.List;

public class GradeAnalyzer {
    private List<Integer> grades;
    GradeAnalyzer(List<Integer> grades){
        this.grades=grades;
    }

    public double calculateAverage(){
        int counter = 0;
        double sum = 0 ;

        for(double grade : grades)
        {
            sum += grade;
            counter++;
        }
        return sum/counter;
    }

    public void printSummary(){
        System.out.println("Average grade: "+calculateAverage());
    }
}
