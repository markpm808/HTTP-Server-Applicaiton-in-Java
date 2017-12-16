/* ICS 313 Program 1 (2/2)
 * Client server application that connects to a Java server
 * Sends the current Date/Time to the Java server
 * @author Mark McDermott
 * @Date 8/31/17
 * @name DaytimeClient.java
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;

public class DaytimeClient {

	public static void main(String args[]) throws IOException {
	//sets the port number equal to the port specified on the command line
   int port = Integer.parseInt(args[0]);  
   
   String host = "localhost";
		
   System.out.println("Connecting to " + host + " on port " + port + "....");
   //creates a new socket used to connect to the server socket
   Socket socket = new Socket(host, port);
			
   PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
   //prints the current date/time to the output stream
   out.println(LocalDateTime.now());
            
   System.out.println("Successfully Connected"); 
   
   System.out.println("Message successfully sent");        
			}
}
