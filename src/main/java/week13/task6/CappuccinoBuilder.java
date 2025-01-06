package week13.task6;

import java.util.ArrayList;
import java.util.List;

public class CappuccinoBuilder implements CoffeeBuilder {
    private String type;
    private String size;
    private List<String> toppings;

    public CappuccinoBuilder() {
        toppings = new ArrayList<>();
    }

    @Override
    public void buildType() {
        this.type = "Cappuccino";
    }

    @Override
    public void buildSize() {
        this.size = "Large";
    }

    @Override
    public void buildToppings() {
        toppings.add("Chocolate Sprinkles");
        toppings.add("Whipped Cream");
    }


    public Coffee getCoffee() {
        return new Coffee(type, size, toppings);
    }
}