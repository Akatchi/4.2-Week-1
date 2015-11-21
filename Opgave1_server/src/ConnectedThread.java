import com.sun.corba.se.spi.activation.Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Vasco on 11/21/2015.
 */
public class ConnectedThread implements Runnable
{
    private Socket clientSocket;

    public ConnectedThread(Socket socket)
    {
        clientSocket = socket;

        System.out.println("Client connected! " + socket.toString());
    }

    @Override
    public void run()
    {
        try
        {
            PrintWriter out =
                    new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            String inputLine, outputLine;

            // Initiate conversation with client
            Protocol protocol = new Protocol();
            outputLine = protocol.processInput(null);

            out.println(outputLine);

            while( (inputLine = in.readLine()) != null)
            {
                outputLine = protocol.processInput(inputLine);
                out.println(outputLine);

                if (outputLine.equals("Bye."))
                    break;
            }
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}
