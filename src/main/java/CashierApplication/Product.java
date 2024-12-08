package CashierApplication;

public class Product extends Item{
    private String category;
    private boolean isTaxable;

    Product(String itemId,String name,int price,String category,boolean isTaxable){
        super(itemId,name,price);
        this.category = category;
        this.isTaxable = isTaxable;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+ " category: "+category+" isTaxable: "+isTaxable;
    }
    void setCategory(String category){this.category = category;}
    void setIsTaxable(boolean isTaxable){this.isTaxable = isTaxable;}
    String getCategory(){return category;}
    boolean isTaxable(){return isTaxable;}



}
