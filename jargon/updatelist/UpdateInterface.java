import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface UpdateList extends Remote{
	public ArrayList<String> getText() throws RemoteException;
	public void setText(ArrayList<String> text) throws RemoteException;

}