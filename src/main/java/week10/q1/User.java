package week10.q1;

abstract class User {

    private String username;

    User(String username)
    {
        this.username=username;
    }
    void setUserName(String username){ this.username=username;}
    String getUserName(){return username;}
    public String defaultPermissionLevel()
    {
        return "User";
    }
}

