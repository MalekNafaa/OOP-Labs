package week13.task2;

public class PaymentFactoryCLASS implements PaymentFactory{
    @Override
    public Payment createPayment(String type){
        return switch (type) {
            case "CreditCard" -> new CreditCardPayment();
            case "PayPal" -> new PaypalPayment();
            default -> throw new IllegalArgumentException();
        };
    }

    public static void main(String[] args) {
        PaymentFactory paymentfactory = new PaymentFactoryCLASS();

        Payment credit = paymentfactory.createPayment("CreditCard");
        credit.processPayment();

        Payment paypal = paymentfactory.createPayment("PayPal");
        paypal.processPayment();
    }
}
