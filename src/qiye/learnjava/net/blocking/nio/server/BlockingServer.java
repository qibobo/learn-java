package qiye.learnjava.net.blocking.nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import qiye.learnjava.net.Server;

public class BlockingServer extends Server {
	private int num;

	public BlockingServer(int port) {
		super(port);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() throws IOException {
		// TODO Auto-generated method stub
		ServerSocketChannel server = ServerSocketChannel.open();
		server.bind(new InetSocketAddress(this.port));
		while (!this.stopped) {
			SocketChannel client = server.accept();
			new Thread(new SocketHandler(client,this.num++)).start();;
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
	private SocketChannel socket;
	private int num;

	public SocketHandler(SocketChannel socket, int num) {
		this.socket = socket;
		this.num = num;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		int num = 0;
		try {
			while ((num = this.socket.read(buffer)) > 0) {
				buffer.flip();
				byte[] bytes = new byte[num];
				buffer.get(bytes);
				String str = new String(bytes, "UTF-8");
				if ("exit".equals(str)) {
					break;
				}
//				System.out.println("client" + this.num + " request:" + str);
				ByteBuffer respBuffer = ByteBuffer.wrap(("response to client " + this.num).getBytes());
				this.socket.write(respBuffer);
				buffer.flip();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				this.socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
