import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Vasco on 11/21/2015.
 */
public class ServerController
{
    private int portNumber = 9876;
    private boolean running = true;

    public ServerController()
    {
        setupServer();
    }

    private void setupServer()
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(portNumber);

            while( running )
            {
                Thread thread = new Thread(new ConnectedThread(serverSocket.accept()));
                thread.start();
            }
        }
        catch (IOException e)
        {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
