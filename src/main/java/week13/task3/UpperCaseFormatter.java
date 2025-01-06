package week13.task3;

public class UpperCaseFormatter implements TextFormatter{



    @Override
    public void formatText(String text){
        System.out.println("Upper Case format: "+text.toUpperCase());
    }

}
