package IvoiceManagement;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class minimainInvoiceManagement {

}

enum TextFormat{
   CAPITALIZE,LOWERCASE,PLAIN
}
enum CurrencyFormat{
    USD,EURO,INR
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface FieldFormat{
    TextFormat text_format() default TextFormat.PLAIN;
    CurrencyFormat currency_format() default  CurrencyFormat.USD;

}


