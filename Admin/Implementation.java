import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.NotBoundException;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;
import java.util.*;

public class Implementation extends UnicastRemoteObject implements Interface {
	private Registry reg;
	private Scanner in = new Scanner(System.in);

	public Implementation () throws RemoteException {
		super();
	}
	public void createProject() throws RemoteException {
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("                           "+"Create Project"+"                           ");
		System.out.println("---------------------------------------------------------------------------");
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("projects.csv", true));
			System.out.print("Project Name: ");
			String projectName = in.nextLine();
			System.out.print("Project Leader: ");
			String projectLeader = in.nextLine();
			System.out.print("Project Status: ");
			String projectStatus = in.nextLine();
			pw.println(projectName + "," + projectLeader + "," +projectStatus);
			pw.close();
		} catch(Exception err) {}
	}
	public void viewProject() throws RemoteException {
		try {
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("                          "+"List of Projects"+"                           ");
			System.out.println("---------------------------------------------------------------------------");
			BufferedReader br = new BufferedReader(new FileReader("projects.csv"));
			List<String> list = new ArrayList<String>();
			String[] str = null;
			String line = "";
			while ((line = br.readLine()) != null) {
				list.add(line);
			}
			System.out.format("%-30s%-30s%-10s", "Project Name", "ProjectLeader", "ProjectStatus");
			System.out.println();
			for(int i = 0; i < list.size(); i++){
				str = list.get(i).split(",");
				System.out.printf("%-30s%-30s%-10s", str[0], str[1], str[2]);
				System.out.println();
			}
			br.close();
		} catch (Exception err) {}
	}


	

}
