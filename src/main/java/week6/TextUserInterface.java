package week6;

import java.sql.SQLOutput;
import java.util.Scanner;

public class TextUserInterface {
    private Scanner reader;
    private Dictionary dictionary;
    public TextUserInterface(Scanner reader,Dictionary dictionary)
    {
        this.reader = reader;
        this.dictionary = dictionary;
    }
    public void add(){
        System.out.println("Statement: ");
        String  word = reader.nextLine().trim();
        System.out.println("Translation: ");
        String  translation = reader.nextLine().trim();

        dictionary.add(word,translation);
        System.out.println("Added");

    }
    public void translate(){
        System.out.println("Statement: ");
        String  word = reader.nextLine().trim();
        String  translation = dictionary.translate(word);
        if(translation != null){
            System.out.println("Translation: "+translation);
        } else System.out.println("Translation not found");


    }
    public void start()
    {
        while(true) {
            System.out.println("Welcome to the TextUserInterface");
            System.out.println("Statement");
            System.out.println("    quit - quit the text user interface");
            System.out.println("    translate - asks a word and prints its translation");
            System.out.println("    add - adds a word pair to the dictionary");

            String command = reader.nextLine().trim();

            if (command.equals("quit")) {
                System.out.println("BYE BYE");
                break;
            }
            else if (command.equals("add")) {
                add();
            }
            else if (command.equals("translate")) {
                translate();
            }
            else System.out.println("Invalid command");


        }
    }
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        Scanner reader = new Scanner(System.in);
        TextUserInterface ui = new TextUserInterface(reader, dictionary);
        ui.start();
    }

}
