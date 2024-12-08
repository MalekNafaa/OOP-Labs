package LibraryManagementSystem;

import java.util.Date;
import java.util.HashMap;

public class BorrowTransaction<T extends Item & Borrowable>{
    private String transactionID;
    private Date borrowDate;
    private HashMap<T,Integer> borrowedItems;
    private int patronId;

    BorrowTransaction(String transactionId,Date borrowDate,int patronId){
        this.transactionID = transactionId;
        this.borrowDate = borrowDate;
        this.patronId = patronId;
        HashMap<T,Integer> borrowedItems = new HashMap<>();
    }
    void addItemToTransaction(T item, int quantity){
        borrowedItems.put(item,quantity);
    }
    double calculateTotalLateFees(int daysLate){
        double totalLateFee = 0;
        for(T item : borrowedItems.keySet()) {
            int quantity = borrowedItems.get(item);
            totalLateFee += quantity*daysLate*3;

        }
        return totalLateFee;
    }
    void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }
    void setBorrowDate(Date borrowDate) {this.borrowDate = borrowDate;}
    void setPatronId(int patronId) {this.patronId = patronId;}
    String getTransactionID() {return transactionID;}
    Date getBorrowDate() {return borrowDate;}
    int getPatronId() {return patronId;}
    HashMap<T,Integer> getBorrowedItems() {return borrowedItems;}

}
