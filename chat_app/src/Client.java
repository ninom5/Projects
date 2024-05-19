import java.io.*;
import java.net.Socket;
import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

public class Client
{
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String clientName;

    public Client(Socket socket, String clientName)
    {
        try
        {
            this.socket = socket;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.clientName = clientName;
        }catch (IOException e)
        {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    public void sendMessage()
    {
        try
        {
            bufferedWriter.write(clientName);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            Scanner scanner = new Scanner(System.in);
            while(socket.isConnected())
            {
                String message = scanner.nextLine();
                bufferedWriter.write(clientName + ": " + message);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }catch (IOException e)
        {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    public void listener()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String message;

                while(socket.isConnected())
                {
                    try
                    {
                    message = bufferedReader.readLine();
                    System.out.println(message);
                    }catch (IOException e)
                    {
                        closeEverything(socket, bufferedReader, bufferedWriter);
                    }
                }
            }
        }).start();
    }

    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter)
    {
        try
        {
            if(bufferedReader != null)
            {
                bufferedReader.close();
            }
            if(bufferedWriter != null)
            {
                bufferedWriter.close();
            }
            if(socket != null)
            {
                socket.close();
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Client Name: ");
        String clientName = scanner.nextLine();
        Socket socket = new Socket("localhost", 1234);
        Client client = new Client(socket, clientName);
        client.listener();
        client.sendMessage();
    }
}