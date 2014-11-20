package playPackage;
import java.io.*;
import java.util.ArrayList;

import ocsf.server.AbstractServer;
import client.*;
import common.*;

public class ServerConsole<E> implements ChatIF {

	private Poker poker;
	private ArrayList playerList;
	private AbstractServer as;
	public ServerConsole(AbstractServer as) {
		playerList = new ArrayList();
		this.as = as;
	}

	public void accept() {
		try {
			BufferedReader fromConsole = new BufferedReader(
					new InputStreamReader(System.in));
			String message;

			while (true) {
				message = fromConsole.readLine();
				as.handleMessageFromServerUI(message,this) ;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Unexpected error while reading from console!");
		}
	}

	/**
	 * This method overrides the method in the ChatIF interface. It displays a
	 * message onto the screen.
	 *
	 * @param message
	 *            The string to be displayed.
	 */
	public void display(String message) {
		System.out.println("SERVER MSG> " + message);
	}

}