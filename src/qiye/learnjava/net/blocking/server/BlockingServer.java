package qiye.learnjava.net.blocking.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import qiye.learnjava.net.Server;

public class BlockingServer extends Server {
	private int num;
	public BlockingServer(int port) {
		super(port);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() throws IOException {
		ServerSocket server = new ServerSocket(this.port);
		while (!this.stopped) {
			Socket client = server.accept();
			new Thread(new SocketHandler(client,num++)).start();
		}
		server.close();
		System.out.println("server exited");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		this.stopped = true;
	}
}

class SocketHandler implements Runnable {

	private Socket socket;
	private int num;

	public SocketHandler(Socket socket, int num) {
		this.socket = socket;
		this.num = num;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		BufferedReader in;
		BufferedWriter out;
		try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
			while (true) {
				String str = in.readLine();
				if ("exit".equals(str)) {
					break;
				}
				System.out.println("client" + this.num + " request:" + str);
				out.write("hello, this is the response to client " + this.num + "\n");
				out.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("handler for client " + this.num + " exit\n");
	}

}
