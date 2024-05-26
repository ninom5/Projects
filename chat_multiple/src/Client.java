import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static final int SERVER_PORT = 12345;
    private static final String SERVER_IP = "192.168.1.66";

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);
        new ReadThread(socket).start();
        new WriteThread(socket).start();
    }

    public static class ReadThread extends Thread
    {
        private BufferedReader in;

        public ReadThread(Socket socket) throws IOException
        {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        public void run()
        {
            try
            {
                String message;
                while((message = in.readLine()) != null)
                {
                    System.out.println("Received" + message);
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    public static class WriteThread extends Thread
    {
        private PrintWriter out;
        private BufferedReader In;

        public WriteThread(Socket socket) throws IOException
        {
            out = new PrintWriter(socket.getOutputStream(), true);
            In = new BufferedReader(new InputStreamReader(System.in));
        }

        public void run()
        {
            try{
                String clientMessage;
                while((clientMessage = In.readLine()) != null)
                {
                    out.println(clientMessage);
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
