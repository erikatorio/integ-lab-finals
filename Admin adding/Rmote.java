import java.rmi.Remote;

public interface Rmote extends Remote {
		public void createAccount(String name, String email, String username, String password) throws Exception ;
		public void logIn(String username , String password) throws Exception ;
}