package qiye.learnjava.net.nonblocking.nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import qiye.learnjava.net.Client;

public class NonBlockingClient extends Client implements Runnable {

	public NonBlockingClient(String host, int port, int num) {
		super(host, port, num);

	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		SocketChannel client = null;
		try {
			client = SocketChannel.open();
			System.out.println("========>" + this.num);
			client.connect(new InetSocketAddress(this.host, this.port));
			// client.bind(new InetSocketAddress(this.host, this.port));
			while (true) {
				ByteBuffer writeBuffer = ByteBuffer.wrap(("request from client " + this.num + "\n").getBytes());
				client.write(writeBuffer);
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);
				int num = 0;
				while ((num = client.read(readBuffer)) > 0) {
					readBuffer.flip();
					byte[] bytes = new byte[num];
					readBuffer.get(bytes);
					String str = new String(bytes, "UTF-8");
					// System.out.println(str);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.start();
	}

}
