package week13.task6;

import java.util.ArrayList;
import java.util.List;

public class LatteBuilder implements CoffeeBuilder{
    private String type;
    private String size;
    private List<String> toppings;

    public LatteBuilder() {
        toppings = new ArrayList<>();
    }
    @Override
    public void buildType() {
        this.type = "Latte";
    }

    @Override
    public void buildSize() {
        this.size = "Medium";
    }

    @Override
    public void buildToppings() {
        toppings.add("Foamed Milk");
        toppings.add("Cinnamon");
    }

    public Coffee getCoffee() {
        return new Coffee(type, size, toppings);
    }
}
