import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Exercises:
/*      1. Create a program that prints your name to the screen. The program output should resemble the following:
        2. Create a program that prints out the following:
        3. Create a program that counts and displays how many seconds there are in a year.
        You can assume that a year consists of 365 days (therefore the year is not a leap year).
        4. Create a program that asks the user for two integers and then prints their sum.
        5. Create a program that asks the user for a number and tells if the number is positive (i.e. greater than zero).
        6. Create a program that asks the user for two numbers and prints the greater of those two.
        The program should also handle the case in which the two numbers are equal.*/
        // 1.
                System.out.println("My name is Malek Altaruni");
        //2.
        System.out.println("Hello World!");
        System.out.println("(AND ALL THE PEOPLE OF THE WORLD)");
        //3.
        double  year = 365;
        System.out.println("There is "+year*12*24*60+" seconds in a year");
        //4.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        System.out.println(num1+num2);
        //5.
        Scanner number = new Scanner(System.in);
        System.out.println("Enter number: ");
        int newNumber = number.nextInt();
        if(newNumber>0){
            System.out.println("your number is positive");
        }
        else {
            System.out.println("your number is negative");
        }
        //6.
        Scanner biggerNum = new Scanner(System.in);
        System.out.println("Enter number: ");
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        if(number1>number2){
            System.out.println(number1+" is bigger than"+number2);
        }
        else if (number1<number2) {
            System.out.println(number1+" is smaller than"+number2);
        }
        else {
            System.out.println("BOTH NUMBERS ARE EQUAL");
        }
    }
}