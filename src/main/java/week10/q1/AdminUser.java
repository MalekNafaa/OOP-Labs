package week10.q1;


@UserPermission("Admin")
public class AdminUser extends User {

    AdminUser(String username)
    {
        super(username);
    }

    @Override
    public String defaultPermissionLevel()
    {
    return "Admin";
    }

}
