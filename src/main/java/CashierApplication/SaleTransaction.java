package CashierApplication;

import java.util.Date;
import java.util.HashMap;

public class SaleTransaction<T extends Item & Billable> {
    private String transactionId;
    private Date saleDate;
    private HashMap<T,Integer> soldItems;
    int customerId;

    SaleTransaction(String transactionId,Date saleDate,int customerId){
        this.transactionId = transactionId;
        this.saleDate = saleDate;
        this.customerId = customerId;
        HashMap<T,Integer> soldItems = new HashMap<>();
    }
    void addItemToSale(T item,int quantity){
        soldItems.put(item,quantity);
    }
    double calculateTotalAmount(){
        double total=0;
        for(T item : soldItems.keySet()){
            total += soldItems.get(item);
        }
        return total;
    }
    void setTransactionId(String transactionId){
        this.transactionId = transactionId;
    }
    void setSaleDate(Date saleDate){this.saleDate = saleDate;}
    void setCustomerId(int customerId){this.customerId = customerId;}

    String getTransactionId(){return transactionId;}
    Date getSaleDate(){return saleDate;}
    int getCustomerId(){return customerId;}
    HashMap<T,Integer> getSoldItems(){return soldItems;}


}
