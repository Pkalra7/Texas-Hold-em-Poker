package playPackage;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import common.ChatIF;
import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;


public class Poker extends AbstractServer {

	boolean playing = false;
	private static int DEFAULT_PORT = 5555;
	private String[] move;
	private ArrayList playerList;
	private Round round;
	public Poker(int port) {
		super(port);
		playerList = new ArrayList();

	}

	public Poker(){
		super(DEFAULT_PORT);
		playerList = new ArrayList();
	}


	@Override
	protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
		String message = (String) msg;
		if ((message.contains("fold")|| message.contains("Check") || message.contains("Raise") || message.contains("Call"))&& playing){
			move[Arrays.asList(this.getClientConnections()).indexOf(client)] = message;
			System.out.println(message);

		}

		System.out.println("Message received: " + msg + " from "
				+ client.getInfo("#login"));
		this.sendToAllClients("" + client.getInfo("#login") + '\t' + msg);
	}




	public void sendToClient(Object msg, ConnectionToClient client){
		try {
			client.sendToClient(msg);
		} catch (Exception ex) {
		}
	}

	protected void clientConnected(ConnectionToClient client) {

		System.out.println("Client connected");
		playerList.add(client);
		System.out.println(client.getClass());
	}

	@Override 
	synchronized protected void clientException(ConnectionToClient client,
			Throwable exception) {
		System.out.println(""+client.getInfo("#login") +'\t'+ "Disconnected");
	}


	public static void main(String []args){
		Poker poker = new Poker();

		try {
			poker.listen(); // Start listening for connections
		} catch (Exception ex) {
			System.out.println("ERROR - Could not listen for clients!");
		}
		Round round = new Round(poker);
		round.play();
		ServerConsole sc = new ServerConsole(poker);
		sc.accept();



	}

	@Override
	public void handleMessageFromServerUI(String message, ChatIF serverUI)
			throws IOException {
		// TODO Auto-generated method stub

	}
}

