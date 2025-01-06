package week13.task3;

import java.util.List;

public class CamelCaseFormatter implements TextFormatter {



    @Override
    public void formatText(String text){

        String[] sentence = text.split(" ");
        String camelcasetext ="";
        for(String word : sentence){
            if(!word.isEmpty()){
                camelcasetext += Character.toUpperCase(word.charAt(0))+word.substring(1).toLowerCase();

            }
        }

        System.out.println("CamelCaseFormat: "+camelcasetext);
    }

    public static void main(String[] args) {
        CamelCaseFormatter ma = new CamelCaseFormatter();
        ma.formatText("Malek Je Najbolji");

    }
}
