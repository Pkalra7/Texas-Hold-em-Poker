package playPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import common.ChatIF;
import client.ChatClient;


public class ClientConsole  implements ChatIF {

	ChatClient client;
	private static int DEFAULT_PORT = 5555;
	Hand hand;

	public ClientConsole(String host, int port){
		try {
			client = new ChatClient(host,port,this);
		} catch (IOException e) {
			System.out.println("Unable to Create ClientConsole");
			System.exit(1);
		}
	


	}

	public ClientConsole getClientConsole(){
		return this;
	}

	public ChatClient getClient(){
		return client;
	}

	public void setClient(ChatClient aClient){
		this.client = aClient;

	}

	public Hand getHand(){
		return hand;
	}
	@Override
	public void display(String message) {
		System.out.println("> " + message);
	}
	
	public void play(){
		String response;
		BufferedReader fromConsole = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			
			
		}
		
	}
	public void accept() 
	{
		try
		{
			BufferedReader fromConsole = new BufferedReader(new InputStreamReader(System.in));
			String message;

			while (true) 
			{
				message = fromConsole.readLine();
				
				client.handleMessageFromClientUI(message);
			}
		} 
		catch (Exception ex) 
		{
			System.out.println
			("Unexpected error while reading from console!");
		}
	}

	public static void main(String[] args) {

		String host = "";
		int port = 0; // The port number

		try {
			host = args[0];
		} catch (ArrayIndexOutOfBoundsException e) {
			host = "localhost";
		}
		// Modified by David and Pritish
		try {
			String userPort = args[1];
			port = Integer.parseInt(userPort);
		} catch (ArrayIndexOutOfBoundsException e) {
			port = DEFAULT_PORT;
		}
		// Done modifications
		ClientConsole clientConsole = new ClientConsole(host, port);
		clientConsole.accept(); // Wait for console data
	}


}
