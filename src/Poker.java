import java.io.IOException;
import java.lang.reflect.Array;
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

	public Poker(int port) {
		super(port);
	}

	public Poker(){
		super(DEFAULT_PORT);
	}


	@Override
	protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
		String message = (String) msg;
		if (message.contains("fold")|| message.contains("Check") || message.contains("Raise") || message.contains("Call")){
			move[Arrays.asList(this.getClientConnections()).indexOf(client)] = message;
			
		}
			
		if (((String) msg).contains("New Round")){
			playing = true;
		}
		while (playing){
			Thread[] thread = this.getClientConnections();
			ConnectionToClient[] clientList = (ConnectionToClient[]) thread;
			Dealer dealer;
			Poker poker;

			dealer = new Dealer(this);
			dealer.createDeck();
			for (int j =0; j<2; j++){
				for (int i=0; i<clientList.length; i++){
					try {
						clientList[i].sendToClient(dealer.deal());
					} catch (IOException e) {
						// TODO Auto-generated catch block
					}
				}
			}
			
			for (int i =0 ; i<clientList.length; i++){
			{
				while(move[i]== null){	
			}
				if (move[i].contains("fold")){
					//TODO implement
				}
				
				if (move[i].contains("raise")){
					
					
				}
				
				if (move[i].contains("call")){
				}
				
				if (move[i].contains("check")){
					
				}
				}
			}
			
			playing = false;
		}

		System.out.println("Message received: " + msg + " from "
				+ client.getInfo("#login"));
		this.sendToAllClients("" + client.getInfo("#login") + '\t' + msg);
	}


	private void sendCardToPlayer(Card card){

	}
	public void sendToClient(Object msg, ConnectionToClient client){
		try {
			client.sendToClient(msg);
		} catch (Exception ex) {
		}
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
		Poker poker = new Poker();

		try {
			poker.listen(); // Start listening for connections
		} catch (Exception ex) {
			System.out.println("ERROR - Could not listen for clients!");
		}
		ServerConsole sc = new ServerConsole(poker);
		sc.accept();
	}

	@Override
	public void handleMessageFromServerUI(String message, ChatIF serverUI)
			throws IOException {
		// TODO Auto-generated method stub

	}
}

