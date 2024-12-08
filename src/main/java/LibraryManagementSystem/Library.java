package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private String libraryName;
    private List<Patron> patrons;
    private Map<String, Item> inventory;

    Library(String libraryName) {
        this.libraryName = libraryName;
        patrons = new ArrayList<Patron>();
        inventory = new HashMap<String, Item>();
    }
    void addPatron(Patron patron) {
        patrons.add(patron);
    }
    void addItemToInventory(Item item) {
        inventory.put(item.getItemId(), item);
    }
    Patron getPatron(String patronId) {
        for(Patron patron : patrons) {
            if(patronId.equals(patron.getPatronId())) {
                return patron;
            }
        }
        return null;
    }

}
