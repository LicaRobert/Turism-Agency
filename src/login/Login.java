package login;

public class Login
{
    public static boolean authenticate(String username, String password) 
    {
        if (username.equals("Lica") && password.equals("restante")) 
        {
            return true;
        }
        return false;
    }
}
