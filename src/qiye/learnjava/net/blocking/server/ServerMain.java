package qiye.learnjava.net.blocking.server;

import java.io.IOException;

import qiye.learnjava.net.Server;

public class ServerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = new BlockingServer(8888);
		try {
			server.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
