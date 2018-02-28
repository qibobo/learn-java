package qiye.learnjava.net.nonblocking.nio.server;

public class ClientMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 2000; i++) {
			NonBlockingClient client = new NonBlockingClient("127.0.0.1", 8888, i);
			new Thread(client).start();
			System.out.println("starting " + i + " client");
		}

	}

}
