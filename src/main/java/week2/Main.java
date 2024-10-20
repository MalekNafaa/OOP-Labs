package week2;


import java.util.Scanner;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
    /*
    //1.
    // Create a program that asks the user for a password. If the password is right, a secret message is shown to the user.
        String sifra = "MalekNafaa";

        while(true)
        {
            System.out.println("Hello, to get your sifra enter your user password. ");
            Scanner sc = new Scanner(System.in);
            String enteredSifra = sc.nextLine();
            if(sifra.equals(enteredSifra))
            {
                System.out.println("your SIFRA IS ab4fj2jfs");
                break;
            }
        }
    */
       /*
       //2.
       //Create a program that asks the user for three numbers and then prints their sum.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 3 numbers:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(mySum(a, b, c));
    }
    static int mySum(int a,int b,int c) {
        return a+b+c;

*/
        /*//3.
        //Create a program that reads numbers from the user and prints their sum.
        // The program should stop asking for numbers when the user enters the number 0.
        int counter=0;
        while(true)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter numbers:");
            int a = sc.nextInt();
            counter+=a;
            if(a==0){
                System.out.println(counter);
                System.out.println("Bye");
                break;
            }

        }*/
        /*//4.
        //Create a program that asks the user for the first number and the last number and then prints all numbers between those two.
        // Use a while loop.
        //If the first number is greater than the last number, the program prints those numbers.
        Scanner sc=new Scanner(System.in);
        int start=sc.nextInt();
        int end=sc.nextInt();
        if(start>end){
            System.out.println(start+" "+end);
        }
        else{
            for(int i=start;i<=end;i++){
                System.out.println(i);
            }
        }
*/
        //5.Create a program that calculates the sum of 20+21+22+...+2n, where n is a number entered by the user.
        // The notation 2i means raising the number 2 to the power of i, for example 24 = 222*2 = 16.
        // In Java we cannot write ab directly, but instead we can calculate the power with the command Math.pow(number, power). Note that the command returns a number of double types (i.e. floating point number). A double can be converted into the int type (i.e. whole number) as follows: int result = (int)Math.pow(2, 3).
        // This assigns the value of 23 to the variable result.
/*
        Scanner sc = new Scanner(System.in);
        double counter = 0;
        int n = sc.nextInt();
        for(int i=0;i<n;i++)
        {
            counter += Math.pow(2,i);

        }
        System.out.println(counter);*/



        //6.
        /*Create a method printText that prints the following string of characters: "In the beginning there were the swamp,
         the hoe and Java." and a line break.  Users should be able to enter  how many times the text should be printed*/

        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String m = "\"In the beginning there were the swamp, the hoe and Java.\"";
        for (int i = 0; i < n; i++) {
            System.out.println(m);
        }
        System.out.println("The string was printed "+n+" number of times");
*/
        // 7.
        /*Create a method called drawStarsPiramid that will accept the number of rows
        as a parameter and print a half pyramid shape where the number of rows will be dictated by the sent parameter. */

        /*drawStarsPiramid();*/

        //8.
        //Write a program to print the inverted half pyramid shape as shown in the image below?
        //drawStarsPiramidupsidedown();

        //9.
        //Modify the previously created starts piramid in a way that now you
        // are not printing the stars but in each row numbers from 1 to the current row count.
        //drawNumbersPiramid();

        //10
        /*Random rand = new Random();
        int rand_int = rand.nextInt(100);
        System.out.println("Random Integers: "+rand_int);

        while(true) {
            Scanner sc = new Scanner(System.in);
            int guess = sc.nextInt();
            if(guess==rand_int) {
                System.out.println("You guessed correctly!");
                break;
            } else if (guess<rand_int) {
                System.out.println("The number is greater");
            }
            else {
                System.out.println("The number is less");
            }

        }*/



    }

    //  7!
    /*static void drawStarsPiramid() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of rows of stars: ");
        int stars = in.nextInt();
        for(int i=0;i<stars;i++) {

            for(int j=0;j<i+1;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
*/

    //  8!
    /*static void drawStarsPiramidupsidedown() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of rows of stars: ");
        int stars = in.nextInt();
        for(int i=0;i<stars;i++) {

            for(int j=stars;j>i;j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }*/

    //9!
    /*static void drawNumbersPiramid() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of rows of stars: ");
        int stars = in.nextInt();
        for(int i=0;i<stars;i++) {

            for(int j=1;j<=i+1;j++) {
                System.out.print(j);
            }
            System.out.println();
        }

    }*/


}
