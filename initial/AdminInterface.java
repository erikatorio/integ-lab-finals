import java.rmi.*;

public interface AdminInterface extends Remote {
	//registers users
	public String register(ProjectMember m) throws RemoteException;

	//adds new project
	public String addProject(Project p) throws RemoteException;

	//view projects
	public void viewProjects() throws RemoteException;

	//start or stop server
	public static void switchServer(String choice) throws RemoteException;
}