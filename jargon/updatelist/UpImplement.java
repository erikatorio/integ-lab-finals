import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class UpImplement extends UnicastRemoteObject implements Server {

	public ArrayList<String> text;
	protected UpImplement() throws RemoteException{
		super();
	}
	public ArrayList<String> gettext{
		return text;
	}
	public void setText(ArrayList<String> text){
		this.text = text;
	}
	
}