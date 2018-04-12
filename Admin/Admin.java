import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;
import java.io.*;

public class Admin{
	private static Scanner in = new Scanner(System.in);
	private static Interface admin;
	private static Registry reg;
	private static BufferedReader br;

	public static boolean login() throws Exception {
		boolean counter = true;
		String line = "";
		String[] str = null;
		do {
			Console c = System.console();
			br = new BufferedReader(new FileReader("login.csv"));
			String uName = c.readLine("Username: ");
			char pwd[] = c.readPassword("Password: ");
			String upwd = new String(pwd);
			while ((line = br.readLine()) != null) {
				str = line.split(",");
			}
			if(uName.equalsIgnoreCase(str[0]) && upwd.equalsIgnoreCase(str[1])) {
				counter = false;
			}
			else {
				System.out.println("Invalid username or password.");
			}
		} while(counter);
		return true;
	}
	public static void main(String [] args) throws Exception{
		boolean bool = login();
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("                           "+ "Welcome Admin!"+ "                           " );
		while (bool) {
			admin = new Implementation();
			System.out.println("---------------------------------------------------------------------------");
			System.out.print("\n1) Start server.\n2) Stop server.\n3) Create project."
				+ "\n4) View projects.\n5) Exit. \nChoice: ");
			int choice = in.nextInt();
			verifyChoice(choice);
		}
	}
	public static void verifyChoice(int choice) throws RemoteException{
		try {
			switch(choice) {
			//case 1: admin.startServer(admin); break;
			//case 2: admin.stopServer(); break;
			case 3: admin.createProject(); break;
			case 4: admin.viewProject(); break;
			default: System.out.println("Admin Logged Out"); 
				     System.out.println("---------------------------------------------------------------------------");
				     System.exit(0);
			}
		} catch(Exception err) {
			System.out.println("Can't connect to server.");
		}
	}
}