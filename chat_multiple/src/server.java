import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class server
{
    private static Set<PrintWriter> clientWriters = new HashSet<>();
    public static void main(String[] args) throws IOException
    {
        System.out.println("Server started");
        ServerSocket listener = new ServerSocket(12345);
        try
        {
            while(true)
            {
                new ClientHandler(listener.accept()).start();
            }
        }finally {
            listener.close();
        }
    }

    private static class ClientHandler extends Thread
    {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public ClientHandler(Socket socket)
        {
            this.socket = socket;
        }

        public void run()
        {
            try{
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                synchronized (clientWriters)
                {
                    clientWriters.add(out);
                }
                String message;
                while((message = in.readLine()) != null)
                {
                    System.out.println("Received: " + message);
                    synchronized (clientWriters)
                    {
                        for(PrintWriter clientWriter : clientWriters)
                        {
                            clientWriter.println(message);
                        }
                    }
                }
            }catch (IOException e) {
                e.printStackTrace();
            }finally {
                try{
                    socket.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                synchronized (clientWriters)
                {
                    clientWriters.remove(out);
                }
            }
        }
    }
}
