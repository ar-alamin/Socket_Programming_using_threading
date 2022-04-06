package using_threading_socket;
import java.io.*;
import java.net.*;
import java.util.*;


public class ClientThread {

	public static void main(String[] args) throws IOException {
		
		Socket s = new Socket("localhost", 4030);
		System.out.println("Connected");
		
		Scanner scn = new Scanner(System.in);
		
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		DataInputStream dis = new DataInputStream(s.getInputStream());
		
		while(true) {
			System.out.println(dis.readUTF());
			
			String tosend = scn.nextLine();//Date
			dos.writeUTF(tosend);
			
			if(tosend.equals("Exit")) {
				System.out.println("Closing the connection" +s);
				s.close();
				System.out.println("Connection closed");
				break;
			}
			
			String received = dis.readUTF();
			System.out.println(received);
		}
	}
}
