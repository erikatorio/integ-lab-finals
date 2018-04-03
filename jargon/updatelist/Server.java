import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
    public static void main(String args[]) throws Exception {

	Scanner kbd = new Scanner(System.in)
	ArrayList<String> name = new ArrayList<String>();


        try {
			Registry registry = LocateRegistry.createRegistry(Constants.RMI_PORT);
            		registry.bind(Constants.RMI_ID, arrayListToSend);
            		System.out.println("Server starts....");
			
			//while(true){
			//System.out.println("Enter a Name: ");
			//name.add(kbd.next());
			

			
		   
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
	



