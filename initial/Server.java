import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class Server extends UnicastRemoteObject implements AdminInterface {
	public Server() throws RemoteException {
		super();
	}

	public String register(ProjectMember m) throws RemoteException {

	}

	//adds new project
	public String addProject(Project p) throws RemoteException {

	}

	//view projects
	public void viewProjects() throws RemoteException {

	}

	//start or stop server
	public static void switchServer(String choice) throws RemoteException {
		if(choice.equalsIgnoreCase("start")) {
			AdminInterface a = new Server();
			System.out.println("Server is running...");
			Registry r = LocateRegistry.createRegistry(2000);
			r.rebind("admin", a);
		} else if (choice.equalsIgnoreCase("stop")) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		do {
			System.out.println("Hello admin, what do you want to do?");
			System.out.println("1. Start and stop the server.");
			System.out.println("2. Create project.");
			System.out.println("3. View projects.");

			Scanner kbd = new Scanner(System.in);
			System.out.println("Enter number of choice: ");
			String c = kbd.nextLine();

			switch(c) {
				case "1":
					System.out.println("Enter command(start or stop): ");
					String comm = kbd.nextLine();
					switchServer(comm);
					break;
				case "2":
					System.out.println("option 2");
					break;
				case "3":
					System.out.println("option 3");
					break;
				default:
					System.out.println("Please enter a choice");
			}
		} while(true);
	}
}