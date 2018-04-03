import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class Server{
	public static void main(String[] args) throws Exception {
		Scanner kbd = new Scanner(System.in);
		Rmote remote = new methods();
		Registry regis = LocateRegistry.createRegistry(1234);
		regis.rebind("nyaa",remote);
	}
}