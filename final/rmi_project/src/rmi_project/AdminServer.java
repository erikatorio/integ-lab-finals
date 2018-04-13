package rmi_project;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

import java.sql.*;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.Scanner;
//import java.util.logging.Level;
//import java.util.logging.Logger;

public class AdminServer extends UnicastRemoteObject implements ProjectInterface {
    private static String connectionUrl = "jdbc:mysql://localhost:8889/rmi_project?user=root&password=root";
    private static Connection conn;
    private static Scanner console = new Scanner(System.in);
    private Registry registry;
    
    public AdminServer() throws RemoteException {
     super();   
    }
    
    public static void showMenu() {
        System.out.println("1. Start server.");
        System.out.println("2. Add user.");
        System.out.println("3. Add project.");
        System.out.println("4. Exit.");
    }

    public static String startServer() throws RemoteException {
        ProjectInterface s = new AdminServer();
        Registry r = LocateRegistry.createRegistry(2000);
        r.rebind("s",s);
        return "Server established...";
    }
    public static void connectToDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connectionUrl);
            System.out.println("Connection successful!");
            System.out.print("Press any key to continue...");
            console.nextLine();
            System.out.println("");
        } catch (ClassNotFoundException cne) {
            cne.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException, RemoteException {
        connectToDB();
        System.out.print("Enter username: ");
        String username = console.nextLine();
        System.out.print("Enter password: ");
        String password = console.nextLine();
        
        String query = "SELECT username, password FROM users WHERE username = ? AND password = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet result = statement.executeQuery();
        if(result.next()) {
            System.out.println("Hi admin! What do you want to do today?");
            int choice;
            do {
                showMenu();
                System.out.print("Enter choice: ");
                choice = Integer.parseInt(console.nextLine());
                switch(choice) {
                    case 1:
                        System.out.println(startServer());
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } while(choice != 4);
        }
        
    }

    @Override
    public String test() throws RemoteException {
       return "It works!";
    }
}
