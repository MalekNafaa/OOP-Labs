package week7.ECommerceDiscountEngine;
@FunctionalInterface
public interface DiscountStrategy {

    double applyDiscount(double price);

}
