package qiye.learnjava.net.nonblocking.nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import qiye.learnjava.net.Server;

public class SelectorServer extends Server implements Runnable {

	public SelectorServer(int port) {
		super(port);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void start() throws IOException {
		// TODO Auto-generated method stub
		Selector selector = Selector.open();
		ServerSocketChannel server = ServerSocketChannel.open();
		server.setOption(StandardSocketOptions.SO_RCVBUF, 50000);
		server.bind(new InetSocketAddress(this.port));
		server.configureBlocking(false);
		server.register(selector, SelectionKey.OP_ACCEPT);
		while (!this.stopped) {
			int readyChannels = selector.select();
			if (readyChannels == 0) {
				continue;
			}
			Set<SelectionKey> readyKeys = selector.selectedKeys();
			Iterator<SelectionKey> keyIterator = readyKeys.iterator();
			while (keyIterator.hasNext()) {
				SelectionKey key = keyIterator.next();
				keyIterator.remove();
				if (key.isAcceptable()) {
					SocketChannel socketChannel = server.accept();
					socketChannel.configureBlocking(false);
					socketChannel.register(selector, SelectionKey.OP_READ);
				} else if (key.isReadable()) {
					SocketChannel socketChannel = (SocketChannel) key.channel();
					ByteBuffer readBuffer = ByteBuffer.allocate(1024);
					int num = socketChannel.read(readBuffer);
					if (num > 0) {
						System.out.println("request from client:" + new String(readBuffer.array()));
						socketChannel.register(selector, SelectionKey.OP_WRITE);
					} else if (num == -1) {
						socketChannel.close();
					}

				} else if (key.isWritable()) {
					SocketChannel socketChannel = (SocketChannel) key.channel();
					socketChannel.write(ByteBuffer.wrap("hello, this is the response to client ".getBytes()));
					socketChannel.register(selector, SelectionKey.OP_READ);
				}
			}
		}
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

}
