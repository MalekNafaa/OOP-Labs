package CashierApplication;

public interface Billable {

    double applyDiscount(double DiscountRate);
    String getDescription();

}
