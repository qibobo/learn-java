package qiye.learnjava.net.blocking.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import qiye.learnjava.net.Client;

public class BlockingClient extends Client implements Runnable {
	public BlockingClient(String host, int port, int num) {
		super(host, port, num);
	}

	@Override
	public void start() {
		Socket client = null;
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			client = new Socket(this.host, this.port);
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			while (true) {
				out.write("request from client\n");
				out.flush();
				String response = in.readLine();
				// System.out.println("server's response to client " + this.num + ":" +
				// response);
				if ("exit".equals(response)) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		System.out.println("client " + this.num + " exit");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.start();
	}
}
