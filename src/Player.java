// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 



import ocsf.client.*;
import common.*;

import java.io.*;

/**
 * This class overrides some of the methods defined in the abstract superclass
 * in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */
public class Player extends AbstractClient {
	// Instance variables **********************************************

	/**
	 * The interface type variable. It allows the implementation of the display
	 * method in the client.
	 */
	ChatIF clientUI;
	String loginID;
	int money = 1000;

	// Constructors ****************************************************

	/**
	 * Constructs an instance of the chat client.
	 *
	 * @param host
	 *            The server to connect to.
	 * @param port
	 *            The port number to connect on.
	 * @param clientUI
	 *            The interface type variable.
	 * @param loginID
	 */

	public Player(String host, int port, ChatIF clientUI, String loginID, String money)
			throws IOException {

		super(host, port); // Call the superclass constructor
		if (loginID == null) {
			System.exit(0);
		}
		this.loginID = loginID;
		this.clientUI = clientUI;
		this.money = Integer.parseInt(money);
		

		openConnection();
	}
	
	

	// Instance methods ************************************************

	/**
	 * This method handles all data that comes in from the server.
	 *
	 * @param msg
	 *            The message from the server.
	 */
	public void handleMessageFromServer(Object msg) {
		clientUI.display(msg.toString());

	}

	/**
	 * This method handles all data coming from the UI
	 *
	 * @param message
	 *            The message from the UI.
	 */
	public void handleMessageFromClientUI(String message) {

		if (message.charAt(0) == '#') {
			message = message.substring(1);
			// Method calls the Quit method
			if (message.equalsIgnoreCase("quit"))
				quit();

			// Method calls the logoff method
			else if (message.equalsIgnoreCase("logoff")) {
				try {
					closeConnection();
					System.out.println("Connection Closed");
				} catch (IOException e) {
				}
			}

			// Method sets the host of the server
			else if (message.contains("sethost")) {
				if (isConnected() == true) {
					System.out
							.println("Already connected to server. Cannot Set Host.");
					return;
				}
				setHost(Player.getSubstring(message));
			}

			// Sets the Port number of the Client
			else if (message.contains("setPort")) {
				if (isConnected() == true) {
					System.out
							.println("Already connected to server. Cannot Set Port.");
					return;
				}
				setPort(Integer.parseInt(Player.getSubstring(message)));
			}

			else if (message.contains("login")) {
				try {
					if (message.contains("<") && message.contains(">")) {
						openConnection();
						sendToServer(message);
					}

					else if (isConnected() == true) {
						System.out.println("Already logged in");
					} else {
						openConnection();
					}
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("Unable to connect to server");
				}
			}

			else if (message.equalsIgnoreCase("gethost")) {
				System.out.println(getHost());
			}

			else if (message.equals("getport")) {
				System.out.println(getPort());
			} else {
				System.out.println("Command not recognized");
				System.out.println(message);
			}
		}

		else {
			try {
				sendToServer(message);
			} catch (IOException e) {
				clientUI.display("Could not send message to server.  Terminating client.");
				quit();
			}
		}
	}

	// Created by David to get Substring of #setHost and #setPort between <>
	private static String getSubstring(String s) {
		int hostStart = 0;
		int hostEnd = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '<')
				hostStart = i;
			else if (s.charAt(i) == '>')
				hostEnd = i;
		}
		return (s.substring(hostStart + 1, hostEnd));
	}

	// End of creation
	/**
	 * This method terminates the client.
	 */
	public void quit() {
		try {
			closeConnection();
		} catch (IOException e) {
		}
		System.exit(0);
	}

	/**
	 * The following has been implemented by David and Pritish To do : implement
	 * connection closed based on exception
	 * 
	 */
	protected void connectionException(Exception exception) {
		System.out.println("SERVER SHUTTING DOWN! DISCONNECTING!" + '\n' + "Abnormal termination of connection.");
		quit();
	}

	protected void closedConnection() {
		System.out.println("Server has been shut down");
	}

	protected void connectionEstablished() {
		System.out.println("connecting...");

		String login = ("#login <" + this.loginID + ">");
		try {
			sendToServer(login);
		} catch (IOException e) {
			System.out.println("Cannot send ID to server");
		}

		System.out.println("You have succesffuly connected");

	}
	// Finished modification by Pritish and David


}

// End of Player class
