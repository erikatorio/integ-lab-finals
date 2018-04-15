package rmi_project;

import java.io.FileNotFoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.*;
import java.util.ArrayList;

public interface ProjectInterface extends Remote {
    public boolean loginUser(String username, String password) throws RemoteException, SQLException;
    public boolean validateUserPrivileges(String username, String project_name) throws RemoteException, SQLException;
    public ArrayList viewLeaderProjects(String username) throws RemoteException, SQLException;
    public String addMember(String username, int project_id) throws RemoteException, SQLException;
    public int getProjectID(String project) throws RemoteException, SQLException;
    public ArrayList viewProjects(String username) throws RemoteException, SQLException;
    public String removeMember(String username, int project_id) throws RemoteException, SQLException;
    public String completeProject(int project_id) throws RemoteException, SQLException;
    public String uploadFile(String file, String username, int project_id) throws RemoteException, SQLException, FileNotFoundException;
    public ArrayList viewAllProjects() throws RemoteException, SQLException;
    public ArrayList viewUserProjects(String username) throws RemoteException, SQLException;
}
