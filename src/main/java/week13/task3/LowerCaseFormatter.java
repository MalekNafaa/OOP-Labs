package week13.task3;

public class LowerCaseFormatter implements TextFormatter{


    @Override
    public void formatText(String text){
        System.out.println("Lower Case format: "+text.toLowerCase());
    }

}
