import java.io.IOException;

import common.ChatIF;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;


public class Round extends Poker {

	private static int DEFAULT_PORT = 5555;

	public Round(int port) {
		super(port);
	}

	public Round(){
		super(DEFAULT_PORT);
	}


	@Override
	protected void handleMessageFromClient(Object msg, ConnectionToClient client) {


	}

	protected void clientConnected(ConnectionToClient client) {
		System.out.println("Client connected");
	}

	@Override
	synchronized protected void clientException(ConnectionToClient client,
			Throwable exception) {
		System.out.println(""+client.getInfo("#login") +'\t'+ "Disconnected");
	}


	public static void main(String []args){
		Round round = new Round();

		try {
			round.listen(); // Start listening for connections
		} catch (Exception ex) {
			System.out.println("ERROR - Could not listen for clients!");
		}
		ServerConsole sc = new ServerConsole(round);
		sc.accept();
	}

	@Override
	public void handleMessageFromServerUI(String message, ChatIF serverUI)
			throws IOException {
		// TODO Auto-generated method stub
		
	}
}

