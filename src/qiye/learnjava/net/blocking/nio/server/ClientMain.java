package qiye.learnjava.net.blocking.nio.server;

public class ClientMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 2500; i++) {
			BlockingClient client = new BlockingClient("localhost", 8888, i);
			new Thread(client).start();
			System.out.println("starting " + i + " client");
		}

	}

}
