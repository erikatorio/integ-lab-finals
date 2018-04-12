package rmi_project;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProjectInterface extends Remote {
    public void startServer() throws RemoteException;
    
}
