/* ICS 313 Program 1 (1/2)
 * http server application in java that prints the
 * contents it receives from clients that connect to it.
 * @author Mark McDermott
 * @Date 8/31/17
 * @name httpServer.java
 */
 
import java.net.Socket;
import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class httpServer {
	
	public static void main(String[] args) throws Exception {
   //sets the port number equal to the port specified on the command line
   int port = Integer.parseInt(args[0]);
   
	try{
	   //creates a new server on the specified port
      ServerSocket DaytimeServer = new ServerSocket(port);
        
      System.out.println("Listening for connection on port " + port +"....");
      //accepts incoming servers that initiate connection
      Socket DaytimeClient = DaytimeServer.accept();
      
      InputStreamReader input =  new InputStreamReader(DaytimeClient.getInputStream());
            
      BufferedReader buffer = new BufferedReader(input);
      //reads each line of data that is sent to the server over the established connection
      String message = buffer.readLine();            
            
      while (!message.isEmpty()) {
      
         System.out.println(message);
                
         message = buffer.readLine();           
         }
         //ends the http server connection 
         DaytimeServer.close();
         
      }catch (java.net.SocketException e){
         
         System.out.println("Client has disconnected from the server");
         
         }     
    }
}
