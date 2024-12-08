package CashierApplication;

import java.util.ArrayList;
import java.util.List;

public class Customer{

    private String CustomerId;
    private String name;
    private String phoneNumber;
    private List<SaleTransaction<?extends Item>> purchaseHistory;

    Customer(String CustomerId, String name, String phoneNumber) {
        this.CustomerId = CustomerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.purchaseHistory = new ArrayList<SaleTransaction<?extends Item>>();

    }

    void addPurchaseTransaction(SaleTransaction<?> purchaseTransaction) {
        purchaseHistory.add(purchaseTransaction);
    }
    void setCustomerId(String CustomerId) { this.CustomerId = CustomerId; }
    void setName(String name) { this.name = name; }
    void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    String getCustomerId() { return CustomerId; }
    String getName() { return name; }
    String getPhoneNumber() { return phoneNumber; }
    List<SaleTransaction<?extends Item>> getPurchaseHistory() { return purchaseHistory; }


}
