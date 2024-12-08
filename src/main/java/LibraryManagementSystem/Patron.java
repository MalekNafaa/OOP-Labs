package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String patronId;
    private String name;
    private String phoneNumber;
    private List<BorrowTransaction<? extends Item>> borrowHistory;

    Patron(String patronId, String name, String phoneNumber) {
        this.patronId = patronId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.borrowHistory = new ArrayList<BorrowTransaction<? extends Item>>();
    }
    void addBorrowHistory(BorrowTransaction<? extends Item> item) {
        borrowHistory.add(item);
    }
    void setPatronId(String patronId) {this.patronId = patronId;}
    void setName(String name){this.name=name;}
    void setPhoneNumber(String phoneNumber){this.phoneNumber=phoneNumber;}
    
    String getPatronId(){return patronId;}
    String getName(){return name;}
    String getPhoneNumber(){return phoneNumber;}
    List<BorrowTransaction<? extends Item>> getBorrowHistory(){return borrowHistory;}

}
