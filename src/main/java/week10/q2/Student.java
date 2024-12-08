package week10.q2;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String id;
    private List<Integer> grades;

    Student(String name,String id,List<Integer> grades)
    {
        this.name=name;
        this.grades= grades;
        this.id=id;
    }
    public void setName(String name){ this.name = name;}
    public void setGrades(List<Integer> grades){this.grades=grades;}
    public void setId(String id){this.id=id;}
    public String getName(){return name;}
    public String getId(){return id;}
    public List<Integer> getGrades() { return grades;}

    public void printInfo()
    {
        System.out.println("Student: ");
        System.out.println("ID: " +getId());
        System.out.println("Name: "+ getName());
        System.out.println("Grades:" +getGrades());
    }



}


