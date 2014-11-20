package playPackage;
import java.io.IOException;
import java.net.Socket;
import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class Player extends ConnectionToClient{

	Hand hand;
	public Player(ThreadGroup group, Socket clientSocket, AbstractServer server)
			throws IOException {
		super(group, clientSocket, server);
		hand = new Hand(this);
	}

	public Player getPlayer(){
		return this;
	}


	public Hand getHand(){
		return hand;
	}
	
		
	
	
	

}





