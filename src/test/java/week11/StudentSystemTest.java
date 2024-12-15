package week11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentSystemTest {

    StudentSystem system;

    @BeforeEach
    void setup()
    {
        try {
            system = new StudentSystem("C:/Users/Malek/IdeaProjects/Holasvjet/src/main/java/week11/students.csv");
            System.out.println("we are between tests...");
        }
        catch(InvalidStudentDataException e)
        {
            System.out.println("INVALID DATA");
        }
    }

    @Test
    void noOfStudents() {
        StudentSystem localsystem = system;
        assertEquals(71,localsystem.noOfStudents());

    }

    @Test
    void testStudentWithId100() {
        assertEquals("Camila Wood",system.getStudentId(0).get().getName());
        assertEquals(Optional.empty(),system.getStudentId(100));
    }

    @Test
    void getHighestGpa() {
        assertEquals("Malek Nafa Elmabrouk Atarhuni",system.getHighestGpa().getName());
    }
    @Test
    void testHighestGPAStudent()
    {
        assertEquals(10,system.getHighestGpa().getGpa());
    }
    @Test
    void testExceptionMessageForEmptyStudentList() throws InvalidStudentDataException {
        StudentSystem local = new StudentSystem("C:/Users/Malek/IdeaProjects/Holasvjet/src/main/java/week11/empty.csv");
        EmptyStudentListException exception = assertThrows(
                EmptyStudentListException.class,
                () -> local.getHighestGpa());
        assertTrue(exception.getMessage().equals("List of Students is empty!"));
        // UCI OVO NIJE TI JASNO 100%
    }

    @Test
    void testNamesArray(){
        List<Student> stu = StudentSystem.readStudents("C:/Users/Malek/IdeaProjects/Holasvjet/src/main/java/week11/students.csv");
        List<String> fivenams = new ArrayList<>();
        for(int i=0;i<5;i++){
            fivenams.add(stu.get(i).getName());
        }
        List<String> names = new ArrayList<>(List.of("Camila Wood", "Alexander Thompson", "Liam Taylor", "Evelyn Jenkins", "Michael Jackson"));
        for(int i = 0; i < 5; i++)
        {
            assertEquals(fivenams.get(i), names.get(i));
        }
    }

    @Test
    void testSameStudent(){
        assertEquals(system.getStudentId(70).get(),system.getHighestGpa());
    }

    @Test
    void getLongestNameStudent() {
        assertEquals("Malek Nafa Elmabrouk Atarhuni",system.getLongestNameStudent().getName());
    }

}