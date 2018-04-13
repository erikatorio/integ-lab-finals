package rmi_project;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProjectInterface extends Remote {
    public String test() throws RemoteException;
}
