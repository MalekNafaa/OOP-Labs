package CashierApplication;

import java.util.Date;
import java.util.HashMap;

public class InventoryTracking {
    private HashMap<Date, Integer> inventoryRecord;

    void addInventory(Date inventoryDate,int quantity){

        inventoryRecord.put(inventoryDate,quantity);

    }

    int getTotalInventory(){
        int total = 0;
        for(HashMap.Entry<Date, Integer> entry : inventoryRecord.entrySet()){
            total += entry.getValue();
        }
        return total;
    }

}
