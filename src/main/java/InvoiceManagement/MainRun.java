package InvoiceManagement;

import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainRun {
    public static void main(String[] args){
        InvoiceProcessor pr = new InvoiceProcessor("Invoices.cvs");
        System.out.println(pr.getInvoices());
        CSVReportGenerator gn = new CSVReportGenerator();
        gn.generateReport("malek.csv",pr.getInvoices());
    }

}


enum TextFormat{
    CAPITALIZE,LOWERCASE,PLAIN
}
enum CurrencyFormat{
    USD,EURO,INR
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@interface FieldFormat{
    TextFormat text_format() default TextFormat.PLAIN;
    CurrencyFormat currency_format() default CurrencyFormat.USD;
}

class Invoice{
    private Date invoiceDate;
    @FieldFormat(text_format = TextFormat.CAPITALIZE)
    private String invoiceNumber;
    private int qtr;
    private int year;
    @FieldFormat(text_format = TextFormat.CAPITALIZE)
    private String customerName;
    @FieldFormat(currency_format = CurrencyFormat.USD)
    private double totalAmount;
    @FieldFormat(currency_format = CurrencyFormat.EURO)
    private double taxAmount;
    private double netAmount;

    public Invoice(InvoiceBuilder b){
        this.invoiceDate=b.invoiceDate;
        this.invoiceNumber=b.invoiceNumber;
        this.qtr=b.qtr;
        this.year=b.year;
        this.customerName=b.customerName;
        this.totalAmount=b.totalAmount;
        this.taxAmount=b.taxAmount;
        this.netAmount =b.netAmount;

    }
    public double getTotalAMount(){
        return totalAmount;
    }
    static class InvoiceBuilder{
        private Date invoiceDate;
        private String invoiceNumber;
        private int qtr;
        private int year;
        private String customerName;
        private double totalAmount;
        private double taxAmount;
        private double netAmount;
        public InvoiceBuilder(){

        }

        public InvoiceBuilder setInvoiceDate(Date invoiceDate){
            this.invoiceDate = invoiceDate;
            return this;

        }

        public InvoiceBuilder setInvoiceNumber(String invoiceNumber){
            this.invoiceNumber=invoiceNumber;
            return this;
        }
        public InvoiceBuilder setQtr(int qtr){
            this.qtr=qtr;
            return this;
        }
        public InvoiceBuilder setYear(int year){
            this.year=year;
            return this;
        }
        public InvoiceBuilder setCustomerName(String customerName){
            this.customerName=customerName;
            return this;
        }

        public InvoiceBuilder setTotalAmount(double totalAmount){
            this.totalAmount=totalAmount;
            return this;
        }
        public InvoiceBuilder setTaxAmount(double taxAmount){
            this.taxAmount=taxAmount;
            return this;
        }
        public InvoiceBuilder setNetAmount(double netAmount){
            this.netAmount=netAmount;
            return this;
        }
        public Invoice build(){
            return new Invoice(this);
        }
    }

}

class InvalidInvoiceException extends RuntimeException{
    InvalidInvoiceException(String message,Throwable cause){
        super(message,cause);
    }
    InvalidInvoiceException(String message){
        super(message);
    }
}

class InvoiceProcessor{
    private List<Invoice> invoices;

    InvoiceProcessor(String fileName){
        this.invoices=loadInvoices(fileName);
    }

    public List<Invoice> getInvoices(){
        return invoices;
    }
    public static List<Invoice> loadInvoices(String fileName){
        List<Invoice> invoices=new ArrayList<>();
        try{

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            List<String> lines = reader.lines().toList();
            for(int i =1;i<lines.size();i++){
                String[] info = lines.get(i).split(",");
                if(info[0] == ""|info[1]==""|info[5]==""){
                    throw new InvalidInvoiceException("Missing required field",new ClassCastException());
                }
                invoices.add( new Invoice.InvoiceBuilder()
                                .setInvoiceDate(new SimpleDateFormat("MM/dd/yyyy").parse(info[0]))
                                .setInvoiceNumber(info[1])
                                .setQtr(Integer.parseInt(info[2]))
                                .setYear(Integer.parseInt(info[3]))
                                .setCustomerName(info[4])
                                .setTotalAmount(Double.parseDouble(info[5]))
                                .setTaxAmount(Double.parseDouble(info[6]))
                                .setNetAmount(Double.parseDouble(info[7]))
                        .build()
                );
            }
        }catch(FileNotFoundException | ParseException e){
            throw new RuntimeException(e);
        }

        return invoices;
    }

}

class CSVReportGenerator{

    static void generateReport(String outputFile,List<Invoice> invoices){

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            Field[] fields = Invoice.class.getDeclaredFields();
            for(int i=0;i<fields.length;i++){
                writer.write(
                  fields.length-1 == i ? fields[i].getName().concat("\n") : fields[i].getName().concat(",")
                );
            }

            for(Invoice invoice : invoices){
                for(int i = 0;i<fields.length;i++) {
                    fields[i].setAccessible(true);
                    if(fields[i].isAnnotationPresent(FieldFormat.class)) {
                        if(fields[i].get(invoice) instanceof String){
                            TextFormat text_format = fields[i].getAnnotation(FieldFormat.class).text_format();

                        switch(text_format) {
                            case LOWERCASE -> writer.write(
                                    fields.length-1 ==i? fields[i].get(invoice).toString().toLowerCase().concat("\n"):
                                            fields[i].get(invoice).toString().toLowerCase().concat(",")

                            );
                            case CAPITALIZE -> writer.write(
                                    fields.length-1 ==i ? fields[i].get(invoice).toString().toUpperCase().concat("\n"):
                                            fields[i].get(invoice).toString().toUpperCase().concat(",")
                            );
                            case PLAIN -> writer.write(
                                    fields.length-1 == i ? fields[i].get(invoice).toString().concat("\n"):
                                            fields[i].get(invoice).toString().concat(",")

                            );

                        }
                        } else{
                            CurrencyFormat currency_format = fields[i].getAnnotation(FieldFormat.class).currency_format();
                            switch(currency_format) {
                                case USD -> writer.write(
                                        fields.length-1 == i ? "$"+fields[i].get(invoice).toString().concat(",") :
                                                "$".concat(fields[i].get(invoice).toString().concat(","))
                                );
                                case EURO -> writer.write(
                                        fields.length-1 == i ? "€"+fields[i].get(invoice).toString().concat(",") :
                                                "€".concat(fields[i].get(invoice).toString().concat(","))
                                );
                                case INR -> writer.write(
                                        fields.length-1 == i ? " ₹"+fields[i].get(invoice).toString().concat(",") :
                                                " ₹".concat(fields[i].get(invoice).toString().concat(","))
                                );

                            }
                        }
                    }
                    else{
                        writer.write(
                                fields.length-1 == i ? fields[i].get(invoice).toString().concat("\n"):
                                fields[i].get(invoice).toString().concat(",")
                        );
                    }
                }
            }

            writer.close();
        }catch(IOException | IllegalAccessException e ){
        throw new RuntimeException(e);
        }
    }
}

