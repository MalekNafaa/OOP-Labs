package week11;

public class Student{
    private String id;
    private String name;
    private String university;
    private double gpa;
    private String department;


    Student(String id,String name,String university,String department,double gpa){
        this.id=id;
        this.name=name;
        this.gpa=gpa;
        this.university=university;
        this.department=department;
    }
    void setId(String id){this.id=id;}
    void setNAme(String name){this.name=name;}
    void setUniversity(String university){this.university=university;}
    void setGpa(double gpa){this.gpa=gpa;}
    void SetDepartment(String department){this.department=department;}

    public String getId(){return id;}
    public String getName(){return name;}
    public String getUniversity(){return university;}
    public double getGpa(){return gpa;}
    public String getDepartment(){return department;}

    @Override
    public String toString()
    {
        return name;
    }


}
