package week6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {

    static HashMap<String,String> dictionary=new HashMap<>();

    public String translate(String word) {
        return dictionary.getOrDefault(word, "Word not found");
    }

    public void add (String word,String translation) {
        dictionary.put(word,translation);
    }

    public int amountOfWords(){
        return dictionary.size();
    }

    public static ArrayList<String> translationList(){
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : dictionary.entrySet())
                {
                    list.add(entry.getKey()+" = "+ entry.getValue());
                }
        return list;
    }

    public static void main(String[] args) {

    /*Dictionary dictionary = new Dictionary();
    dictionary.add("apina", "monkey");
    dictionary.add("banaani", "banana");
    dictionary.add("cembalo", "harpsichord");
    System.out.println(dictionary.translate("apina"));
    System.out.println(dictionary.translate("porkkana"));*/
    /*Dictionary dictionary = new Dictionary();
    dictionary.add("apina", "monkey");
    dictionary.add("banaani", "banana");
    System.out.println(dictionary.amountOfWords());
    dictionary.add("cembalo", "harpsichord");
    System.out.println(dictionary.amountOfWords());*/
 /*   Dictionary dictionary = new Dictionary();
    dictionary.add("apina", "monkey");
    dictionary.add("banaani", "banana");
    dictionary.add("cembalo", "harpsichord");
    ArrayList<String> translations = dictionary.translationList();
    for(String translation: translations) {
        System.out.println(translation);
    }*/

    }
}
