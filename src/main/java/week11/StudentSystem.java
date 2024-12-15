package week11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentSystem {
    private List<Student> students;

    public StudentSystem(String filename) throws InvalidStudentDataException{
        // readStudents(filename);
        List<Student> somethinidk = readStudents(filename);
        validateStudentData(somethinidk);
        students = somethinidk;

    }
    public StudentSystem(List<Student> students)
    {
        this.students=students;
    }

    public int noOfStudents(){
        return students.size();
    }

    public Optional<Student> getStudentId(int id)
    {
        Optional<Student> empty = Optional.empty();
        String idstr = String.valueOf(id);
        for(Student student : students)
        {
            if(student.getId().equals(idstr))
            {
                empty = Optional.of(student);
               break;
            }
        }

        return empty;
    }
    public Student getHighestGpa()
    {
        if(noOfStudents()==0) throw new EmptyStudentListException("List of Students is empty!");

        double highestgpa=0;
        Student notknown = null;
        for(Student student : students)
        {
            if(student.getGpa() >= highestgpa)
            {
                highestgpa = student.getGpa();
                notknown = student;
            }
        }
        return notknown;
    }
    public Student getLongestNameStudent()
    {
        if(noOfStudents()==0) throw new EmptyStudentListException("List of Students is empty!");

        int numberoflettersinname=0;
        Student notknown = null;
        for(Student student : students)
        {
            if(student.getName().length() >= numberoflettersinname)
            {
                numberoflettersinname = student.getName().length();
                notknown = student;
            }
        }
        return notknown;
    }


    private void validateStudentData(List<Student> students)throws InvalidStudentDataException
    {
        for(Student student : students)
        {
            if(student.getGpa() < 6 || student.getGpa() >10)
            {
                throw new InvalidStudentDataException("Read data has invalid rows!");
            }
        }

    }




    public static List<Student> readStudents(String filename)
    {
        List<Student> loadStudent = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            List<String> StringOfstudents = reader.lines().toList();

            for(String str : StringOfstudents)
            {
                String[]  newlist = str.split(",");
                loadStudent.add(new Student(newlist[0],newlist[1],newlist[2],newlist[3],Double.parseDouble(newlist[4])));

            }
        }
        catch(IOException e)
        {
            System.out.println("The file is not there!!!");
        }
    return loadStudent;
    }
}
