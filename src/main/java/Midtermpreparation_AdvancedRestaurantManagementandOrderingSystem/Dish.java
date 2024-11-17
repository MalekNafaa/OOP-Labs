package Midtermpreparation_AdvancedRestaurantManagementandOrderingSystem;

public class Dish extends MenuItem{
    private CuisineType cuisineType;
    private String mainIngredient;

    Dish(String code,String name,double price,CuisineType cuisineType,String mainIngredient)
    {
        super(code,name,price);
        this.cuisineType = cuisineType;
        this.mainIngredient = mainIngredient;
    }

    @Override
    public String getDescription(){
    return super.getDescription()+ " Cuisine type: "+ cuisineType + " Main Ingretient: " +mainIngredient;
    }

    void setcuisineType(CuisineType cuisineType){this.cuisineType = cuisineType;}
    void setMainIngredient(String mainIngredient){this.mainIngredient = mainIngredient;}

    CuisineType getcuisineType(){return cuisineType;}
    String getMainIngredient(){return mainIngredient;}



}
