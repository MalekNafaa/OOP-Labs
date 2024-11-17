package week7.ECommerceDiscountEngine;

public class DiscountStrategies {
    public static DiscountStrategy precentageDisount(double precentage){
        return price -> price * precentage / 100;
    }
    public static DiscountStrategy fixedDiscount(double amount){
        return price -> price - amount;
    }
    public static DiscountStrategy bulkDiscount(double ProductPrice,double quantity){
        return productPrice -> {
            if(productPrice>quantity)
                return productPrice-quantity;
            else return productPrice;
        };
    }

}
