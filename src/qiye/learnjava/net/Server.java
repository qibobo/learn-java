package qiye.learnjava.net;

import java.io.IOException;

public abstract class Server {

	protected int port;
	protected boolean stopped;

	public Server(int port) {
		this.port = port;
	}

	public abstract void start() throws IOException;
	public abstract void stop();
}
