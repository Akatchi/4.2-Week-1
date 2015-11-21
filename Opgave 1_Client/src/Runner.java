/**
 * Created by Vasco on 11/17/2015.
 */
public class Runner
{
    public static void main(String... args)
    {
        new SocketController("127.0.0.1", 9876);
        System.out.println("We are running");
    }
}
