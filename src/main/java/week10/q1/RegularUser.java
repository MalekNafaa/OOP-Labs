package week10.q1;


@UserPermission("Regular")
public class RegularUser extends User {

    RegularUser(String username)
    {
        super(username);
    }

    @Override
    public String defaultPermissionLevel()
    {
        return "Regular";
    }

}
