package FinalExamPreparation;

import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import static java.nio.file.Files.lines;

public class g {
    public static void main(String[] args) {

    }
}

enum CaseFormatter{
    ORDINARY,UPPER_CASE,LOWER_CASE
}
enum NumberFormatter{
    COMMA,PERCENTAGE
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface WriteConcerns {
    CaseFormatter case_format() default CaseFormatter.ORDINARY;
    NumberFormatter number_format() default NumberFormatter.COMMA;
}

class Book{
    private Date date;
    @WriteConcerns(case_format = CaseFormatter.ORDINARY)
    private String quarter;
    private  int qtr;
    private int year;
    @WriteConcerns(case_format = CaseFormatter.UPPER_CASE)
    private String customerId;
    private double totalAmount;
    @WriteConcerns(number_format = NumberFormatter.COMMA)
    private double profitPercentage;
    @WriteConcerns(number_format = NumberFormatter.PERCENTAGE)
    private double profitInr;
    private double costPrice;

    public Book(BookBuilder builder){
        this.date=builder.date;
        this.quarter=builder.quarter;
        this.qtr=builder.qtr;
        this.year=builder.year;
        this.customerId=builder.customerId;
        this.totalAmount=builder.totalAmount;
        this.profitPercentage=builder.profitPercentage;
        this.profitInr=builder.profitInr;
        this.costPrice=builder.costPrice;
    }
    public static class BookBuilder{
        private Date date;
        private String quarter;
        private  int qtr;
        private int year;
        private String customerId;
        private double totalAmount;
        private double profitPercentage;
        private double profitInr;
        private double costPrice;

        BookBuilder(){

        }

        public BookBuilder setDate(Date date){
            this.date=date;
            return this;
        }
        public BookBuilder setQuarter(String quarter){
            this.quarter = quarter;
            return this;
        }
        public BookBuilder setQtr(int qtr){
            this.qtr=qtr;
            return this;
        }
        public BookBuilder setYear(int year){
            this.year=year;
            return this;
        }
        public BookBuilder setCustomerId(String customerId){
            this.customerId=customerId;
            return this;
        }
        public BookBuilder setTotalAmount(double totalAmount){
            this.totalAmount=totalAmount;
            return this;
        }
        public BookBuilder setProfitPercentage(double profitPercentage){
            this.profitPercentage=profitPercentage;
            return this;
        }
        public BookBuilder setProfitInr(double profitInr){
            this.profitInr=profitInr;
            return this;
        }
        public BookBuilder setCostPrice(double costPrice){
            this.costPrice=costPrice;
            return this;
        }
        public Book build(){
            return new Book(this);
        }
    }
}

class WrongFormatException extends RuntimeException{
    public WrongFormatException(String message){
        super(message);
    }
    public WrongFormatException(String message,Throwable cause){
        super(message, cause);
    }
}

class FinalPrep{
    private List<Book> books= new ArrayList<>();

    public FinalPrep(String fileName){
        this.books = loadBooks(fileName);
    }

    public List<Book> getBooks()
    {
        return books;
    }

    public static List<Book> loadBooks(String fileName){
        List<Book> localbooks = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            List<String> info = reader.lines().collect(Collectors.toList());
            for(int i = 1; i < info.size(); i++){
                String[] oneline = info.get(i).split(";");

                if(oneline[0]==("") || oneline[4]==("") || oneline[5] ==("")){
                    throw new WrongFormatException("Values are empty");
                }

                localbooks.add(new Book.BookBuilder()
                        .setDate(new SimpleDateFormat("MM/dd/yyyy").parse(oneline[0]))
                        .setQuarter(oneline[1])
                        .setQtr(Integer.parseInt(oneline[2]))
                        .setYear(Integer.parseInt(oneline[3]))
                        .setCustomerId(oneline[4])
                        .setTotalAmount(Double.parseDouble(oneline[5]))
                        .setProfitPercentage(Double.parseDouble(oneline[6]))
                        .setProfitInr(Double.parseDouble(oneline[7]))
                        .setCostPrice(Double.parseDouble(oneline[8]))
                        .build()

                );

            }
        }catch(FileNotFoundException | ParseException e){
            throw new RuntimeException(e);
        }
        return localbooks;
    }
}

class ReportWriter{
    public static void writeReport(String outputFileName,List<Book> books){
        try{
            BufferedWriter writer= new BufferedWriter(new FileWriter(outputFileName));


            Field[] fields = Book.class.getDeclaredFields();
            for(int i =0;i<fields.length;i++){
                writer.write( fields.length-1 == i ? fields[i].getName().concat("\n") : fields[i].getName().concat(";")
                );
            }
            for(Book book : books){
                for(int i=0;i<fields.length;i++){
                    fields[i].setAccessible(true);
                    if(fields[i].isAnnotationPresent(WriteConcerns.class)){
                        if(fields[i].get(book) instanceof String){
                            CaseFormatter caseFormat = fields[i].getAnnotation(WriteConcerns.class).case_format();


                            switch (caseFormat)
                            {
                                case LOWER_CASE -> writer.write(
                                        fields.length-1 ==i ?
                                                fields[i].get(book).toString().toLowerCase().concat("\n") :
                                                fields[i].get(book).toString().toLowerCase().concat(";")

                                );

                                case UPPER_CASE -> writer.write(
                                        fields.length-1 == i ?
                                                fields[i].get(book).toString().toUpperCase().concat("\n") :
                                                fields[i].get(book).toString().toUpperCase().concat(";")

                                );
                                case ORDINARY -> writer.write(
                                        fields.length-1 == i ?
                                                fields[i].get(book).toString().concat("\n"):
                                                fields[i].get(book).toString().concat(";")

                                );


                            }
                        }
                        else{
                            NumberFormatter numberFormat = fields[i].getAnnotation(WriteConcerns.class).number_format();

                            if(numberFormat == NumberFormatter.COMMA){
                                DecimalFormat df = new DecimalFormat("#,###.##");
                                writer.write(
                                        fields.length -1 == i ? df.format(fields[i].get(book)).concat("\n") :
                                                df.format(fields[i].get(book)).concat(";")

                                );
                            }
                            else{
                                writer.write(
                                        fields.length-1==i ? "%".concat(fields[i].get(book).toString().concat("\n"))
                                                : "%".concat(fields[i].get(book).toString().concat(";"))

                                );

                            }

                        }
                    }
                    else{
                        writer.write( fields.length-1 == i ? fields[i].get(book).toString().concat("\n") : fields[i].get(book).toString().concat(";"));
                    }

                }
            }
            writer.close();
        } catch (IOException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

class DemoBooksTransformation {
    public static void main(String[] args) {
        FinalPrep prep = new FinalPrep("C:\\Users\\Malek\\IdeaProjects\\saedinom\\malek.cvs");
        ReportWriter writer = new ReportWriter();
        writer.writeReport("C:\\Users\\Malek\\IdeaProjects\\saedinom\\tmp.csv", prep.getBooks());
    }
}

