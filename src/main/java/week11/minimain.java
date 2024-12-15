package week11;

public class minimain {
    public static void main(String[] args) {

        try{
        StudentSystem ss = new StudentSystem("C:/Users/Malek/IdeaProjects/Holasvjet/src/main/java/week11/students.csv");
        System.out.println(ss.noOfStudents());
        System.out.println(ss.noOfStudents());
        System.out.println(ss.getLongestNameStudent());
        System.out.println(ss.getHighestGpa());

        }
        catch(InvalidStudentDataException e)
        {
            System.out.println("mamma mia ivalid student data bla bla");
        }

    }
}
