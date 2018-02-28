package qiye.learnjava.singleton;
class OObject{
	static class Innter{
		public final static OObject instance = new OObject();
	}
	private OObject(){}
	public OObject getInstance(){
		return OObject.Innter.instance;
	}
}
public class Singleton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
