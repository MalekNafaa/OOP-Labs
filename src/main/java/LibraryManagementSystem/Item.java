package LibraryManagementSystem;

import java.util.Date;
import java.util.HashMap;

public abstract class Item implements Borrowable {

    private String itemId;
    private String title;
    private String author;
    private boolean isAvailable;
    private HashMap<Date,Boolean> borrowingHistory;

    Item(String itemId,String title,String author,boolean isAvailable) {
        this.itemId=itemId;
        this.title=title;
        this.author=author;
        this.isAvailable=isAvailable;
        this.borrowingHistory=new HashMap<>();
    }
    @Override
    public String getDescription(){
        return "ID "+ itemId + "title "+  title + "author "+ author;
    }
    @Override
    public double applyLateFee(int lateFee)
    {
        return 3*lateFee;
    }
    void setItemI(String itemId){this.itemId=itemId;}
    void setTitle(String title){this.title=title;}
    void setAuthor(String author){this.author=author;}
    void setIsAvailable(boolean isAvailable){this.isAvailable=isAvailable;}

    String getItemId(){return itemId;}
    String getTitle(){return title;}
    String getAuthor(){return author;}
    boolean isAvailable(){return isAvailable;}

    void recordBorrowing(Date date,boolean isReturned)
    {
        borrowingHistory.put(date,isReturned);
    }
    int getTotalBorrows(){
        int total = 0;
        for(Date date : borrowingHistory.keySet())
        {
            total++;
        }
        return total;
    }


}
