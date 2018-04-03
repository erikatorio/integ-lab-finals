import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class Client {
	final static Scanner kbd = new Scanner(System.in);
	static Registry reg;
	static Rmote lookFor;
	public static void main(String[] args) throws Exception {
	 	reg = LocateRegistry.getRegistry("localhost",1234);
		lookFor = (Rmote) reg.lookup("nyaa");
		Scanner answer = new Scanner(System.in);
		System.out.print("Enter your choice \n 1-ceate an account \n 2-ogin \nchoice: ");
		int numberAns = answer.nextInt();
		switch(numberAns){
			// createAccount how the hell i will notify a client, OutputStream? Or how will I go to its directory ?
			// login notify client? directory? System.setProperties() this method ask for string but dont want a string (go directly to the directory of an account) 
			case 1: create();
			// can I use another switch in creating an admin account ?
			// how to delete a userfile(admin level)
			// how to peek on others file(admin level)
			break;
			case 2: login();
			break;
			default: break;
		} 
	}
	public static void create() throws Exception {
		Scanner kbd = new Scanner(System.in);
		String name;
		String email;
		String username;
		String password;
		do{	
			System.out.print("enter your name: ");
			name = kbd.nextLine();
		}while(!(name.matches("[a-zA-Z]+")));
		System.out.print("\nEnter your email: ");
		email = kbd.nextLine();
		System.out.print("\nCreate your username: ");
		username = kbd.nextLine();
		do{
		System.out.print("\nCreate your password (greater than equal 8 character): ");
		password = kbd.nextLine();
		}while(password.length() < 8);
		lookFor.createAccount((name+" "),(email+" "),(username+" "),(password+" "));
		// goto upload method 
	}
	public static void login() throws Exception {
		Scanner kbd = new Scanner(System.in);
		String username;
		String password;
		System.out.print("enter your username: ");
		username = kbd.nextLine();
		System.out.print("enter your password: ");
		password = kbd.nextLine();
		lookFor.logIn(username,password);
		// this will go to the upload method
	}
}

