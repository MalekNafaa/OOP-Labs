package week13.task2;

public class PaypalPayment implements Payment{
    @Override
    public void processPayment(){
        System.out.println("PayPal");
    }
}
