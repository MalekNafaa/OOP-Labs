package Midtermpreparation_AdvancedRestaurantManagementandOrderingSystem;

import java.util.List;
import java.util.Map;

public class Restaurant {
    String restaurantName;
    List<Customer> customers;
    Map<String, MenuItem> menuItem;


    void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // come back
    void addMenuItem(MenuItem menuItem) {

    }

    Customer getCustomer(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    void displayMenu(){
        for(MenuItem menuItem : menuItem.values()) {
            System.out.println(menuItem);
            System.out.println(menuItem.getName()+" "+menuItem.getDescription());
            System.out.println("------------");

        }
    }
    double calculateTotalSales(){
        double totalPrice = 0;
        for(Customer customer : customers)
        {
            for(TableReservation<? extends MenuItem> reservation: customer.getReservationList())
            {
                totalPrice+= reservation.calculateTotalAmount();
            }
        }
        return totalPrice;
    }

}
