package Midtermpreparation_AdvancedRestaurantManagementandOrderingSystem;

import java.util.Date;

public class Runmain {
    public static void main(String[] ags){

        Restaurant restaurant = new Restaurant();

        Dish pasta = new Dish("D001", "Spaghetti Carbonara", 12.99, CuisineType.ITALIAN, "Pasta");
        Drink wine = new Drink("B001", "Red Wine", 25.00, 750);
        restaurant.addMenuItem(pasta);
        restaurant.addMenuItem(wine);

        restaurant.displayMenu();

        Customer customer = new Customer("C001", "John Doe", "123-456-7890");
        restaurant.addCustomer(customer);

        TableReservation<MenuItem> reservation = new TableReservation<>("R001", new Date(), 5);
        reservation.addItemToOrder(pasta, 2);
        reservation.addItemToOrder(wine, 1);
        customer.addReservation(reservation);

        double totalSales = restaurant.calculateTotalSales();


    }
}
