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
    
    public AdminServer() throws RemoteException {
     super();   
    }
    
    @Override
    public void startServer() throws RemoteException {
        ProjectInterface s = new AdminServer();
        Registry r = LocateRegistry.createRegistry(5000);
        r.rebind("s",s);
        System.out.println("Server established...");
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
    public static void main(String[] args) {
        connectToDB();
    }
}
