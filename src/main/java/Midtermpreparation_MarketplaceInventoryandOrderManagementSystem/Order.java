package Midtermpreparation_MarketplaceInventoryandOrderManagementSystem;

import java.util.Date;
import java.util.HashMap;

public class Order<T extends Item & Sellable> {
    private String orderNo;
    private Date createAt;
    private HashMap<T,Integer> items;

    public Order(String orderNo,Date createAt) {
        this.orderNo=orderNo;
        this.createAt=createAt;
        this.items=new HashMap<>();
    }
    void addItem(T item,int quantity) {
     if(items.containsKey(item)) {
         items.put(item,items.get(item)+quantity);
     }
     else {items.put(item,quantity);}

    }

    double calculateTotalAmount(){
        double total=0;
        for(T item : items.keySet()){
            total+=item.getPrice()*items.get(item);
        }
        return total;

    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
    public HashMap<T, Integer> getItems() {
        return items;
    }
    public void setItems(HashMap<T, Integer> items) {
        this.items = items;
    }
}
