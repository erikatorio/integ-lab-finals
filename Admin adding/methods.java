import java.rmi.server.UnicastRemoteObject;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class methods extends UnicastRemoteObject implements Rmote {
	final static Scanner kbd = new Scanner(System.in);
	static LinkedList<String> ll = new LinkedList<String>();

	public methods() throws Exception {
		super();
	}
	public void createAccount(String name, String email, String username, String password) throws Exception {
		// separate regular user from the admin account 
		File database = new File("accounts.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter("account.txt",true));
		BufferedWriter bw1 = new BufferedWriter(new FileWriter("passuser.txt",true));
		Scanner scan = new Scanner(new File("passuser.txt"));
		String passuser = username+password;
		while(scan.hasNextLine()){
			ll.add(scan.nextLine());
		}
		if(ll.contains(passuser)){
			// try to make a code that will notify the client and will trigger a loop that keep saying this sms
			System.out.print("password or username has already taken"); 
		}else{
			bw.newLine();
			bw1.newLine();
			bw.write(name+email+passuser);
			bw1.write(passuser);
			bw.close();
			bw1.close();
			dir(username);
			//upLoad
		}
	}
	public void logIn(String username, String password) throws Exception {
		Scanner scan = new Scanner(new File("passuser.txt"));
		String passuser = ((username+" ")+(password+" "));
		while(scan.hasNextLine()){
			ll.add(scan.nextLine());
		}
		if(!(ll.contains(passuser))) {
			// also with this one 
			System.out.print("error");
		}else{
			// upLoad	
			System.out.print("successfull");
		}
	}
	public void upLoad(String username){
		// how to send a file? 
		File path = new File("C:\\Users\\Mig\\Desktop\\New folder (2)\\"+username);
		String fileName = kbd.nextLine();
		File files = new File(fileName);
		byte[] size = new byte[(int)files.length()];
		
	}
	public void dir(String name){
		File dir = new File(name);
		dir.mkdir();
	}
}