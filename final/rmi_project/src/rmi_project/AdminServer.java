package rmi_project;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

import java.sql.*;
import java.text.DateFormat;
import java.util.ArrayList;
//import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.logging.Level;
//import java.util.logging.Logger;

public class AdminServer extends UnicastRemoteObject implements ProjectInterface {
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
    public static void connectToDB(String port, String user, String pass) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost:"+port+"/rmi_project?user="+user+"&password="+pass;
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
        
        System.out.println("Completed projects\n");
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
        System.out.print("Enter mysql port number: ");
        String port = console.nextLine();
        System.out.print("Enter mysql username: ");
        String user = console.nextLine();
        System.out.print("Enter mysql password: ");
        String pass = console.nextLine();
        connectToDB(port, user, pass);
        
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
    public String uploadFile(String filepath, String filename, String username, int project_id) throws RemoteException, SQLException, FileNotFoundException {
        String query = "SELECT file_id FROM files WHERE filename = ? AND pr_id = ?";
        PreparedStatement qStatement = conn.prepareStatement(query);
        qStatement.setString(1, filename);
        qStatement.setInt(2, project_id);
        ResultSet result = qStatement.executeQuery();
        String file = filepath+filename;
        int addedFile = 0;
        int addedLog = 0;
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        if(result.next()) {
            String s = "UPDATE files SET file = ?, user = ? WHERE file_id = ?";
            PreparedStatement update = conn.prepareStatement(s);
            InputStream input = new FileInputStream(new File(file));
            update.setBlob(1, input);
            update.setString(2, username);
            update.setInt(3, result.getInt("file_id"));
            addedFile = update.executeUpdate();
            
           String sToo = "INSERT into file_log(filename, user_r, pr_id, date_r) VALUE(?,?,?,?)";
           PreparedStatement updateToo = conn.prepareStatement(sToo);
           updateToo.setString(1, filename);
           updateToo.setString(2, username);
           updateToo.setInt(3, project_id);
           updateToo.setTimestamp(4, timestamp);
           addedLog = updateToo.executeUpdate();
        } else {
           String sql = "INSERT into files(file, user, p_id, filename) VALUES(?,?,?,?)";
           PreparedStatement statement = conn.prepareStatement(sql);
           InputStream in = new FileInputStream(new File(file));
           statement.setBlob(1, in);
           statement.setString(2, username);
           statement.setInt(3, project_id);
           statement.setString(4, filename);
           addedFile = statement.executeUpdate();
           
           String sqlToo = "INSERT into file_log(filename, user_r, pr_id, date_r) VALUE(?,?,?,?)";
           PreparedStatement statementToo = conn.prepareStatement(sqlToo);
           statementToo.setString(1, filename);
           statementToo.setString(2, username);
           statementToo.setInt(3, project_id);
           statementToo.setTimestamp(4, timestamp);
           addedLog = statementToo.executeUpdate();
        }
        
        
        if (addedFile > 0 && addedLog > 0) {
            return "Successfully uploaded file!";
        } else {
            return "Upload Failed.";
        }
    }
    
    //displays file revisions
    @Override
    public ArrayList viewFileRevisions(String filename, int project_id) throws RemoteException, SQLException {
        String query = "SELECT user_r, date_r FROM file_log WHERE filename = ? AND pr_id = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, filename);
        statement.setInt(2, project_id);
        ResultSet result = statement.executeQuery();
        ArrayList<String> revisions = new ArrayList<>();
        DateFormat revisionDateForm = new SimpleDateFormat("MM-dd-yyyy HH:MM");
        while(result.next()) {
            String username = result.getString("user_r");
            String timestamp = revisionDateForm.format(result.getTimestamp("date_r"));
            revisions.add(username+"    "+timestamp);
        }
        return revisions;
    }
    
    //displays all files uploaded to a project
    @Override
    public ArrayList viewFiles(int project_id) throws RemoteException, SQLException {
        String query = "SELECT filename FROM files WHERE p_id = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, project_id);
        ResultSet result = statement.executeQuery();
        ArrayList<String> uploads = new ArrayList<>();
        while(result.next()) {
            String file = result.getString("filename");
            uploads.add(file);
        }
        return uploads;
    }
    
    //download files
    @Override
    public String downloadFile(String filename, int project_id) throws RemoteException, SQLException, IOException {
        String query = "SELECT file FROM files WHERE filename = ? AND p_id = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, filename);
        statement.setInt(2, project_id);
        ResultSet result = statement.executeQuery();
        
        if(result.next()) {
            Blob b = result.getBlob("file");
            InputStream input = b.getBinaryStream();
            File f = new File("./downloads/"+filename);
            OutputStream output = new FileOutputStream(f);
            
            int read = -1;
            byte[] buffer = new byte[10000];
            while((read = input.read(buffer)) != -1) {
                output.write(buffer, 0, read);
            }
            input.close();
            output.close();
            return "Sucessfully downloaded file!";
        } else {
            return "Download failed.";
        }
    }
    
    //views all projects
    @Override
    public ArrayList viewAllProjects() throws RemoteException, SQLException {
        String query = "SELECT project_name FROM projects";
        PreparedStatement statement = conn.prepareStatement(query);
        ResultSet result = statement.executeQuery();
        ArrayList<String> projects = new ArrayList<>();
        while(result.next()) {
            String project = result.getString("project_name");
            projects.add(project);
        }
        return projects;
    }
    
    //view all normal user projects
    @Override
    public ArrayList viewUserProjects(String username) throws RemoteException, SQLException {
        String query = "SELECT project_name FROM projects JOIN project_members ON projects.proj_id = project_members.project_id JOIN users ON users.username = project_members.username WHERE users.username = ? AND projects.status = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, username);
        statement.setString(2, "on-going");
        ResultSet result = statement.executeQuery();
        ArrayList<String> projects = new ArrayList<>();
        while(result.next()) {
            String p = result.getString("project_name");
            projects.add(p);
        }
        return projects;
    }
    
    //send and store messages in a project
    @Override
    public String sendMessage(String message, String username, int project_id) throws RemoteException, SQLException {
        String send = "INSERT INTO messages(message, sender, pj_id) VALUES(?,?,?)";
        PreparedStatement statement = conn.prepareStatement(send);
        statement.setString(1, message);
        statement.setString(2, username);
        statement.setInt(3, project_id);
        int messageSent = statement.executeUpdate();
        if(messageSent > 0) {
            return "Message sent!";
        } else {
            return "Message sending failure.";
        }
    }
    
    //view messages
    @Override
    public ArrayList viewMessages(int project_id) throws RemoteException, SQLException {
        String query = "SELECT message, sender FROM messages WHERE pj_id = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, project_id);
        ResultSet result = statement.executeQuery();
        ArrayList<String> messages = new ArrayList<>();
        while(result.next()) {
            String message = result.getString("message");
            String sender = result.getString("sender");
            messages.add("["+sender+"] : "+message);
        }
        return messages;
    }
}
