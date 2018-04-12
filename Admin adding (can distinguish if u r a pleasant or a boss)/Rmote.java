import java.rmi.Remote;

public interface Rmote extends Remote {
	public boolean createAccount(String name, String email, String username, String password, String typeOA) throws Exception ;
	public String logIn(String username , String password) throws Exception ;
	//public boolean checkAcountLogin(String ) throws Exception ;
}