package Midtermpreparation_AdvancedRestaurantManagementandOrderingSystem;

import java.util.Date;
import java.util.HashMap;

public class TableReservation<T extends MenuItem & Billable> {
    private String reservationID;
    private Date reservationDate;
    private HashMap<T,Integer> orderedItems;
    private int tableNumber;

    TableReservation(String reservationID, Date reservationDate, int tableNumber) {
        this.reservationID = reservationID;
        this.reservationDate = reservationDate;
        this.tableNumber = tableNumber;
        this.orderedItems = new HashMap<>();

    }
    public void addItemToOrder(T item,int quantity){
        orderedItems.put(item,quantity);
    }

    double calculateTotalAmount(){
        double total = 0;
        for(T item : orderedItems.keySet()){
            total += orderedItems.get(item)*item.getPrice();
        }
        return total;
    }
    void setReservationID(String reservationID) {this.reservationID = reservationID;}
    void setReservationDate(Date reservationDate) {this.reservationDate = reservationDate;}
    void setTableNumber(int tableNumber) {this.tableNumber = tableNumber;}
    String getReservationID() {return this.reservationID;}
    Date getReservationDate() {return this.reservationDate;}
    int getTableNumber() {return this.tableNumber;}

    HashMap<T,Integer> getOrderedItems(){return this.orderedItems;}


}
