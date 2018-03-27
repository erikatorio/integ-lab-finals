/**
 * @(#)PLIImplement.java
 *
 *
 * @author
 * @version 1.00 2018/3/27
 */
import java.rmi.*;
import java.util.*;

public class PLIImplement extends UnicastRemoteObject implements ProjectLeaderInterface{
	protected PLIImplement() throws Exception{
		super();
	}

    public void showListOfProject(ArrayList member) throws Exception{
    	for(Members members: member){
    		member.toString();
    	}

    }
}