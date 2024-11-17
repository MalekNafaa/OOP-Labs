package week7.EmployeeMS;
import java.time.LocalDate;
import java.time.Period;

public record EmployeeRecord(String name, String position,int salary,LocalDate employmentDate) {

    public static EmployeeRecord createIntern(String name)
    {
        return new EmployeeRecord(name,"Intern",1200,LocalDate.now());
    }
    public boolean overFiveYears(){
        return  Period.between(employmentDate, LocalDate.now()).getYears() > 5;
    }

}
