package week4.q1;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        // a) Create the package people and the class Person in it; Person works in relation to the following main program:
       // Person pekka = new Person("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa");
       // Person esko = new Person("Esko Ukkonen", "Mannerheimintie Street 15 00100 Helsinki");
       // System.out.println(pekka);
       // System.out.println(esko);

        // b)Create the class Student which inherits the class Person. Students have 0 credits, at the beginning. As long as a student studies,
        // their credits grow. Create the class, in relation to the following main program:
       /* System.out.println("part B");
        Student olli = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki");
        System.out.println(olli);
        System.out.println("credits " + olli.getCredits());
        olli.study();
        System.out.println("credits "+ olli.getCredits());*/

        //c)gether with the teacher information in String form.
        // Check whether the following main program generates the printout below:
        /*System.out.println("part c");
        Teacher pekka = new Teacher("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 1200);
        Teacher esko = new Teacher("Esko Ukkonen", "Mannerheimintie 15 Street 00100 Helsinki", 5400);
        System.out.println( pekka );
        System.out.println( esko );


        Student olli = new Student("Olli", "Ida Albergintie 1 Street 00400 Helsinki");
        for ( int i=0; i < 25; i++ ) {
            olli.study();
        }
        System.out.println( olli );*/

        // d)Implement the method public static void printDepartment(List<Person> people) in the Main class,
        // default package. The method prints all the people in the parameter list.
        // When the main method is called, printDepartment should work in the following way.

/*  List<Person> people = new ArrayList<Person>();
        people.add( new Teacher("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 1200) );
        people.add( new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki") );
        printDepartment(people);*/



        // 3.


        //4.
        Student student = new Student("Malek","krste 27",20,"Libya",0,123321);
        student.addGrades(20);
        student.addGrades(35.3);
        System.out.println(student);


    }
    public static void printDepartment(List<Person> people) {
        // we print all the people in the department
        for(Person person : people)
        {
            System.out.println(person);
        }

    }
}

class Student extends Person {
    private int credits;
    private int student_id;
    private List<Double> grades;


    public Student(String name,String address,int age,String country,int credits,int student_id)
    {
        super(name,address,age,country);
        this.credits = 0;
        this.student_id = student_id;
        this.grades = new ArrayList<>();
    }

    public int getCredits()
    {
        return this.credits;
    }
    public void setCredits(int credits){
        this.credits = credits;
    }
    public void setStudent_id(int student_id){
        this.student_id = student_id;
    }
    public int getStudent_id(){
        return this.student_id;
    }
    public void addGrades(double grade){
        grades.add(grade);

    }
    public List<Double> getGrades(){
        return this.grades;
    }

    public void study()
    {
        this.credits++;
    }



    @Override
    public String toString()
    {
        return super.toString()+ " \n" + "Credits " +this.credits + " \n" + this.grades;
    }
}

class Teacher extends Person
{
    private int salary;

    public Teacher(String name,String address,int salary,int age,String country)
    {
        super(name,address,age,country);
        this.salary = salary;
    }
    public int getSalary()
    {
        return this.salary;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }
    @Override
    public String toString()
    {
        return super.toString()+ " " +this.salary+" euros/month";
    }
}


class Person {
    private String name;
    private String address;
    private int age;
    private String country;

    public Person(String name,String address,int age,String country)
    {
        this.name = name;
        this.address = address;
        this.age = age;
        this.country = country;

    }
    public String getName()
    {
        return this.name;
    }
    public String getAddress()
    {
        return this.address;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setAddress(String name)
    {
        this.address=address;

    }
    //4
    public void setCountry(String country)
    {
        this.country = country;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public int getAge()
    {
        return this.age;
    }
    public String getCountry()
    {
        return this.country;
    }

    public String toString()
    {
        return this.name + "\n" +this.address + "\n" +this.age + "\n" +this.country;
    }
}