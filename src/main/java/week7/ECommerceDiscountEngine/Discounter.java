package week7.ECommerceDiscountEngine;

import java.util.Arrays;
import java.util.List;

public class Discounter {

    public static double calculateTotalDiscountedPrice(List<Product> productList, DiscountStrategy strategy)
    {
        double totalPrice = 0;
        for(Product product : productList){
            double discountedPrice = strategy.applyDiscount(product.getPrice());
            totalPrice += discountedPrice*product.getQuantity();
        }
        return totalPrice;
    }

    public static void main(String[] args) {
    List<Product> cart = Arrays.asList(
            new Product("Laptop", 1000.00, 1),
            new Product("Headphones", 200.00, 2),
            new Product("Mouse", 50.00, 3)
    );


    DiscountStrategy percentageDiscount= DiscountStrategies.precentageDisount(10);
    DiscountStrategy fixedDiscount = DiscountStrategies.fixedDiscount(200);
    DiscountStrategy bulkDiscount = DiscountStrategies.bulkDiscount(20,2);

    double totalWithPercentageDiscount = calculateTotalDiscountedPrice(cart, percentageDiscount);
    System.out.println("Total with 10% discount: " + totalWithPercentageDiscount);

    double totalWithFixedDiscount = calculateTotalDiscountedPrice(cart, fixedDiscount);
    System.out.println("Total with $50 discount: " + totalWithFixedDiscount);

    double totalWithBulkDiscount = calculateTotalDiscountedPrice(cart, bulkDiscount);
    System.out.println("Total with bulk discount: " + totalWithBulkDiscount);


    }
}
