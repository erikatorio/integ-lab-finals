import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class Client {
	final static Scanner kbd = new Scanner(System.in);
	static Registry reg;
	static Rmote lookFor;
	public static void main(String[] args) throws Exception {
	 	reg = LocateRegistry.getRegistry("localhost",9999);
		lookFor = (Rmote) reg.lookup("nyaa");
		Scanner answer = new Scanner(System.in);
		System.out.print("Enter your choice \n 1-ceate an account \n 2-login \nchoice: ");
		int numberAns ;
		numberAns = answer.nextInt();
		switch(numberAns){
			case 1: create();
			break;
			case 2: login();
			break;
			default: System.out.println("invalid choice");
		}
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
	public static void clientWhatToDo() {
		System.out.println("1 -- check who's online");
		System.out.println("2 -- chat box");
		System.out.println("3 -- upload file");
		
	}
	public static void serverWhatTodo() {
		System.out.println("1 -- check who's online");
		System.out.println("2 -- hire a pleasant");
		System.out.println("3 -- fire a pleasant");
		System.out.println("4 -- delete pleasant's account");
	}
}

