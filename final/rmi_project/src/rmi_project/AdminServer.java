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
    
    //shows menu
    public static void showMenu() {
        System.out.println("1. Start server.");
        System.out.println("2. Add user.");
        System.out.println("3. Remove user.");
        System.out.println("4. Update user status.");
        System.out.println("5. Add new project.");
        System.out.println("6. View on-going projects.");
        System.out.println("7. View completed projects");
        System.out.println("8. Exit.");
    }

    //starts server
    public static String startServer() throws RemoteException {
        ProjectInterface s = new AdminServer();
        Registry r = LocateRegistry.createRegistry(2000);
        r.rebind("s",s);
        return "Server established...";
    }
    
    //connects to database
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
    
    //login
    public static boolean login(String username, String password) throws SQLException {
        String query = "SELECT username, password FROM users WHERE username = ? AND password = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet result = statement.executeQuery();
        if(result.next()){
            return true;
        } else {
            return false;
        }
    }
    
    //add user
    public static void addUser() throws SQLException {
        System.out.println("Please complete the following user credentials: \n");
        System.out.print("Enter username: ");
        String username = console.nextLine();
        System.out.print("Enter First Name: ");
        String fn = console.nextLine();
        System.out.print("Enter Last Name: ");
        String ln = console.nextLine();
        System.out.print("Enter password: ");
        String password = console.nextLine();
        
        String sql = "INSERT INTO users(username, first_name, last_name, password) VALUES(?,?,?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, fn);
        statement.setString(3, ln);
        statement.setString(4, password);
        
        int rowsInserted = statement.executeUpdate();
        System.out.println((rowsInserted > 0)
                            ? "A new customer was successfully added!"
                            : "Nothing was inserted...");
        System.out.println("Press any key to continue...");
        console.nextLine();
        
        statement.close();       
    }
    
    //remove user
    public static void removeUser() throws SQLException {
        System.out.println("Remove a user\n");
        System.out.print("Enter username of user to be removed: ");
        String username = console.nextLine();
        
        String sql = "DELETE FROM users WHERE username = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, username);
        
        int userDeleted = statement.executeUpdate();
        System.out.println((userDeleted > 0) ? "Successfully removed user"
                                             : "Delete failed!");
        statement.close();
        
        System.out.print("Press any key to continue...");
        console.nextLine();
    }
    
    //update user status
    public static void updateUserStatus() throws SQLException {
        System.out.print("Enter username of user you want to update: ");
        String username = console.nextLine();
        
        String sql = "UPDATE users SET status = ? WHERE username = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, "inactive");
        statement.setString(2, username);
        
        int rowUpdated = statement.executeUpdate();
        
        System.out.println((rowUpdated > 0) ? "User status successfully updated!"
                                             : "Failed to update user status");
        
        System.out.println("Press any key to continue...");
        console.nextLine();
    }
    
    //add new project
    public static void addNewProject() throws SQLException {
        System.out.println("New Project\n");
        System.out.print("Enter project name: ");
        String pName = console.nextLine();
        System.out.print("Enter project leader username: ");
        String leader = console.nextLine();
        
        String sql = "INSERT INTO projects(project_name, leader) VALUES(?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, pName);
        statement.setString(2, leader);
        
        int projectAdded = statement.executeUpdate();
        System.out.println((projectAdded > 0)
                            ? "A new project was successfully added!"
                            : "Nothing was inserted...");
        System.out.println("Press any key to continue...");
        console.nextLine();
        
        statement.close();
    }
    
    //view on-going projects
    public static void viewOnGoingProjects() throws SQLException {
        String query = "SELECT proj_id, project_name, leader FROM projects WHERE status = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, "on-going");
        ResultSet result = statement.executeQuery();
        
        System.out.println("On-going projects\n");
        System.out.printf("%-5s%-20s%-20s%n", "ID", "Project Name", "Project Leader");
        
        while(result.next()) {
            int pID = result.getInt("proj_id");
            String pName = result.getString("project_name");
            String pLeader = result.getString("leader");
            
            System.out.printf("%-5d%-20s%-20s%n", pID, pName, pLeader);
        }
        statement.close();
        result.close();
        System.out.print("\nPress any key to continue...");
        console.nextLine();
    }
    
    //view completed projects
    public static void viewCompletedProjects() throws SQLException {
        String query = "SELECT proj_id, project_name, leader FROM projects WHERE status = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, "completed");
        ResultSet result = statement.executeQuery();
        
        System.out.println("On-going projects\n");
        System.out.printf("%-5s%-20s%-20s%n", "ID", "Project Name", "Project Leader");
        
        while(result.next()) {
            int pID = result.getInt("proj_id");
            String pName = result.getString("project_name");
            String pLeader = result.getString("leader");
            
            System.out.printf("%-5d%-20s%-20s%n", pID, pName, pLeader);
        }
        statement.close();
        result.close();
        System.out.print("\nPress any key to continue...");
        console.nextLine();
    }

    //main method
    public static void main(String[] args) throws RemoteException, SQLException {
        connectToDB();
        System.out.print("Enter username: ");
        String username = console.nextLine();
        System.out.print("Enter password: ");
        String password = console.nextLine();
        
        boolean login = login(username, password);
        
        if(login) {
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
                        addUser();
                        break;
                    case 3:
                        removeUser();
                        break;
                    case 4:
                        updateUserStatus();
                        break;
                    case 5:
                        addNewProject();
                        break;
                    case 6:
                        viewOnGoingProjects();
                        break;
                    case 7:
                        viewCompletedProjects();
                        break;
                    case 8:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } while(choice != 8);
        }
        
    }

    //rmi tester method for client
    @Override
    public String test() throws RemoteException {
       return "It works!";
    }
}
