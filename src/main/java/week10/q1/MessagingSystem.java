package week10.q1;

public class MessagingSystem {

    @CanSendMessage
    @RequiresPermission
    public void sendMessage(User user,String message)
    {
        if(user.defaultPermissionLevel().equals("Admin"))
        {
            System.out.println(user.getUserName() + ": "+message);
        }
        else System.out.println("Admin permission needed.");
    }

    public static void main(String[] args){
        MessagingSystem ms = new MessagingSystem();

        User regularUser = new RegularUser("Sanin");
        User adminUser = new AdminUser("Malek");

        String adminmessage= "WE ARE LUCKY TO BE HERE";

        ms.sendMessage(adminUser,adminmessage);
        ms.sendMessage(regularUser,adminmessage);
    }
}
