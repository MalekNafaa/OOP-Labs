package Midtermpreparation_MarketplaceInventoryandOrderManagementSystem;

import java.util.Date;

public class MainRun {
    public static void main(String[] args) {
        Milk milk1 = new Milk("milkbarcode","ALMATAI",2.5,3);
        Milk milk2 = new Milk("milkbarcode2","ALMATAI",2,2);

        Honey honey1 = new Honey("honeycode","Bosanski",20,HoneyType.LIVADSKI);
        Honey honey2 = new Honey("honeycode","NIJE BITNO",10,HoneyType.BAGREMOV);

        Order<Milk> milkorder = new Order<>("1",new Date());
        Order<Honey> honeyorder = new Order<>("2",new Date());

        milkorder.addItem(milk1,2);
        milkorder.addItem(milk2,1);

        honeyorder.addItem(honey1,2);
        honeyorder.addItem(honey2,1);

        Person customer = new Person("Malek",20);

        customer.addOrder(milkorder);
        customer.addOrder(honeyorder);

        for(Order<? extends Item> order : customer.getOrders()) {
            System.out.println("  Order No: " + order.getOrderNo());
            System.out.println("  Order Date: " + order.getCreateAt());

            for(Item item: order.getItems().keySet()){
                int quantity = order.getItems().get(item);
                System.out.println("    Item: " + item.getDescription());
                System.out.println("subtotal" +(item.getPrice()*quantity));
            }
            System.out.println("Total amount: "+order.calculateTotalAmount());

        }





    }
}
