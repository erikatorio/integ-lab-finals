package rmi_project;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

import java.sql.*;
import java.util.ArrayList;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    //login user
    @Override
    public boolean loginUser(String username, String password) throws RemoteException, SQLException {
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
    
    //validate user privileges
    @Override
    public boolean validateUserPrivileges(String username, String project_name) throws RemoteException, SQLException {
        String query = "SELECT project_name FROM projects WHERE leader = ? AND project_name = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, username);
        statement.setString(2, project_name);
        ResultSet result = statement.executeQuery();
        if(result.next()) {
            return true;
        } else {
            return false;
        }
    }
    
    //view projects as a leader
    @Override
    public ArrayList viewLeaderProjects(String username) throws RemoteException, SQLException {
        String query = "SELECT project_name FROM projects WHERE leader = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, username);
        ResultSet result = statement.executeQuery();
        ArrayList<String> projects = new ArrayList<>();
        while(result.next()) {
            String pName = result.getString("project_name");
            projects.add(pName);
        }
        return projects;
    }
    
    //view projects as normal member
    @Override
    public ArrayList viewProjects(String username) throws RemoteException, SQLException {
        String query = "SELECT project_name FROM projects JOIN project_members ON projects.proj_id = project_members.project_id JOIN users ON users.username = project_members.username WHERE users.username = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, username);
        ResultSet result = statement.executeQuery();
        ArrayList<String> projects = new ArrayList<>();
        while(result.next()) {
            String p = result.getString("project_name");
            projects.add(p);
        }
        return projects;
    }
    
    //add member to a project
    @Override
    public String addMember(String username, int project_id) throws RemoteException, SQLException {
        String insertMember = "INSERT INTO project_members(username, project_id) VALUES(?,?)";
        PreparedStatement statementToo = conn.prepareStatement(insertMember);
        statementToo.setString(1, username);
        statementToo.setInt(2, project_id);
        int memberAdded = statementToo.executeUpdate();
        if(memberAdded > 0) {
            return "Member added!";
        } else {
            return "Member not added";
        }
    }
    
    //remove member from a project
    @Override
    public String removeMember(String username, int project_id) throws RemoteException, SQLException {
        String sql = "DELETE FROM project_members WHERE username = ? AND project_id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, username);
        statement.setInt(2, project_id);     
        int memberDeleted = statement.executeUpdate();
        if(memberDeleted > 0) {
            return "Member successfully removed!";
        } else {
            return "Not Removed.";
        }
    }
    
    //gets project id
    @Override
    public int getProjectID(String project) throws RemoteException, SQLException {
        String query = "SELECT proj_id FROM projects WHERE project_name = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, project);
        ResultSet result = statement.executeQuery();
        if(result.next()) {
            return result.getInt("proj_id");
        } else {
            return -1;
        }
    }
    
    //make project status complete
    @Override
    public String completeProject(int project_id) throws RemoteException, SQLException {
        String sql = "UPDATE projects SET status = ? WHERE proj_id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, "completed");
        statement.setInt(2, project_id);
        int rowUpdated = statement.executeUpdate();
        if (rowUpdated > 0) {
            return "Project completed!";
        } else {
            return "Project still on-going.";
        }
    }
    
    //upload file
    @Override
    public String uploadFile(String file, String username, int project_id) throws RemoteException, SQLException, FileNotFoundException {
            String sql = "INSERT into files(file, user, p_id) VALUES(?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            InputStream in = new FileInputStream(new File(file));
            statement.setBlob(1, in);
            statement.setString(2, username);
            statement.setInt(3, project_id);
            int addedFile = statement.executeUpdate();
            if (addedFile > 0) {
                return "Successfully uploaded file!";
            } else {
                return "Upload Failed.";
            }
    }
}
