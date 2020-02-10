import java.net.*;
import java.io.*;

public class Client {

	private Socket socket            	   = null; 
    private DataInputStream  inputStream   = null; 
    private DataOutputStream outStream     = null; 
    
	public Client(String address, int port) 
    { 
        // establish a connection 
        try
        { 
            socket = new Socket(address, port); 
            System.out.println("Connected");   
           
            inputStream  = new DataInputStream(System.in);   
       
            outStream    = new DataOutputStream(socket.getOutputStream()); 
        } 
        catch(UnknownHostException u) 
        { 
            System.out.println(u); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
  
        // string to read message from input 
        String lineOut = ""; 
        String lineIn = "";
  
        // keep reading until "Over" is input 
        while (!lineOut.equals("Over")) 
        { 
            try
            { 
            	lineOut = inputStream.readLine();
            	outStream.writeUTF(lineOut); 
                lineIn = inputStream.readUTF();
            } 
            catch(IOException i) 
            { 
                System.out.println(i); 
            } 
        } 
  
        // close the connection 
        try
        { 
        	inputStream.close(); 
        	outStream.close(); 
            socket.close(); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
    } 
  
    public static void main(String args[]) 
    { 
        Client client = new Client("127.0.0.1", 5000); 
    } 
}
