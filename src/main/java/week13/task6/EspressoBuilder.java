package week13.task6;

import java.util.ArrayList;
import java.util.List;

public class EspressoBuilder implements CoffeeBuilder {
    private String type;
    private String size;
    private List<String> toppings;

    public EspressoBuilder() {
        toppings = new ArrayList<>();
    }
    @Override
    public void buildType() {
        this.type = "Espresso";
    }

    @Override
    public void buildSize() {
        this.size = "Small";
    }

    @Override
    public void buildToppings() {
        toppings.add("Sugar");
    }

    public Coffee getCoffee() {
        return new Coffee(type, size, toppings);
    }
}
