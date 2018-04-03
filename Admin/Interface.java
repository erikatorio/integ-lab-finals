import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote {
	public void viewProject() throws RemoteException;
	public void createProject() throws RemoteException;
}