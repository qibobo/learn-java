package qiye.learnjava.net;

public abstract class Client {
	protected String host;
	protected int port;
	protected int num;

	public Client(String host, int port, int num) {
		super();
		this.host = host;
		this.port = port;
		this.num = num;
	}

	public abstract void start();
}
