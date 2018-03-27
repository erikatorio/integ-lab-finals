import java.rmi.*;
import java.util.*;

public interface ProjectLeaderInterface extends Remote{
	//method interface for showing the list of projects assigned to him/her both as leader and as member.
	public void showListOfProject(ArrayList member) throws Exception;
	//method interface for Assigning members of the project assigned to him/her as leader from the list of registered users.
	public ArrayList assignLeader(ArrayList member) throws Exception;
	//method interface for updating the list of members.
	public ArrayList addMember(ArrayList member) throws Exception;
	//method interface for setting the status of the project to completed once the project is already done.
	public String changeStatus(ArrayList member) throws Exception;
	//method interface for uploading file/s for modification by the members.
	public void uploading(ArrayList member) throws Exception;

}