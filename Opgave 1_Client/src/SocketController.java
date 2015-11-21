import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * Created by Vasco on 11/17/2015.
 */
public class SocketController
{
    private String url;
    private int portNr;
    private int timeout = 1000 * 10; // 10 seconds

    public SocketController(String url, int portNr)
    {
        this.url = url;
        this.portNr = portNr;

        try
        {
            Socket socket = new Socket(this.url, this.portNr);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            BufferedReader stdIn =
                    new BufferedReader(new InputStreamReader(System.in));

            String fromServer;
            String fromUser;

            while( (fromServer = in.readLine()) != null)
            {
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("Bye."))
                    break;

                fromUser = stdIn.readLine();
                if (fromUser != null)
                {
                    System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                }
            }
        }
        catch (UnknownHostException e)
        {
            System.err.println("Don't know about host " + this.url);
            System.exit(1);
        }
        catch (IOException e)
        {
            System.err.println("Couldn't get I/O for the connection to " +
                this.url);
            System.exit(1);
        }
    }
}
