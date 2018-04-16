import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.File;
import java.io.Console;

public class Client {
	final static Scanner kbd = new Scanner(System.in);
	static Registry reg;
	static Rmote lookFor;
	static Console c = System.console();
	public static void main(String[] args) throws Exception {	
		Scanner answer = new Scanner(System.in);
		String numberAns = "" ;	
		try {
			reg = LocateRegistry.getRegistry("localhost",9999);
			lookFor = (Rmote) reg.lookup("nyaa");
		}catch(Exception e) {
			try {
				System.out.print("Trying to Communicate to the Server...");
				Runtime.getRuntime().exec("cmd /c start \"\" Server.bat");
				System.out.println("Server is working Connecting to the Server...");
				reg = LocateRegistry.getRegistry("localhost",9999);
				lookFor = (Rmote) reg.lookup("nyaa");
				System.out.print("Connected To the Server");
			}catch(Exception ex){
			}
		}
		System.out.print("Enter your choice \n 1-ceate an account \n 2-login \nchoice: ");
		do{
			numberAns = answer.nextLine();
			switch(numberAns){
				case "1": create();
				break;
				case "2": login();
				break;
				default: System.out.println("invalid choice");
			}
			break;
		}while(!numberAns.equals("1") || !numberAns.equals("2"));
	}
	public static void create() throws Exception {
		Scanner kbd = new Scanner(System.in);
		String name;
		String email;
		String username;
		String password;
		String type;
		boolean check;
		do{
			do{
				System.out.print("enter your name: ");
				name = kbd.nextLine();
			}while(!(name.matches("[a-zA-Z .,]+")));
				System.out.print("Enter your email: ");
				email = kbd.nextLine();
				System.out.print("Create your username: ");
				username = kbd.nextLine();
			do{
				System.out.print("Create your password (greater than equal 8 character): ");
				password = kbd.nextLine();
			}while(password.length() < 8);
			do{
				System.out.print("type of Account: (A-admin | R-regular user): ");
				type = kbd.nextLine();
			}while(!type.matches("[arAR]"));
			check = lookFor.createAccount((name+","),(email+","),(username+","),(password+","),(type)) ? true: false;
			if(check == false){
				System.out.println("Sorry username,password or email has already taken ");
			}else{
				System.out.println("You created an account successfully!!");
			}
		}while(check == false);
		if(type.equalsIgnoreCase("R")){
			clientWhatToDo();
		}else if(type.equalsIgnoreCase("A")){
			serverWhatTodo();
		}
	}
	public static void login() throws Exception {
		Scanner kbd = new Scanner(System.in);
		String username;
		String password;
		String type = "";
		do{
			System.out.print("enter your username: ");
			username = kbd.nextLine();
			System.out.print("enter your password: ");
			password = kbd.nextLine();
			type = lookFor.logIn(username,password);
			if(type.equalsIgnoreCase("regular")){
				clientWhatToDo();
			}else if(type.equalsIgnoreCase("boss")){
				serverWhatTodo();
			}else if(type.equalsIgnoreCase("intruder")){
				System.out.println("invalid password");
			}
		}while(type.equals("intruder"));
	}
	public static void clientWhatToDo() throws Exception {
		System.out.println("1 -- check who's online");
		System.out.println("2 -- chat box");
		System.out.println("3 -- upload file");
		/*File f = new File("Zyra_2.jpg");
		FileInputStream fos = new FileInputStream(f);
		byte[] size = new byte[1024*1024];
		int length = fos.read(size);
		while(length > 0){
			lookFor.upLoad("Zyra_2.jpg",size,length);
			length = fos.read(size);
		}*/
	}
	public static void serverWhatTodo() {
		String answer = "" ;
		System.out.println("1 -- check who's online");
		System.out.println("2 -- hire a pleasant");
		System.out.println("3 -- fire a pleasant");
		System.out.println("4 -- delete pleasant's account");
		System.out.println("5 -- Stop Server");
	}
}

