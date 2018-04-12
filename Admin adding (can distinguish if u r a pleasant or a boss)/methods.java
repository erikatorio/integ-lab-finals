import java.rmi.server.UnicastRemoteObject;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class methods extends UnicastRemoteObject implements Rmote {
	public methods() throws Exception {
		super();
	}
	public boolean createAccount(String name, String email, String username, String password, String typeOA) throws Exception {
		LinkedList<String> ll = new LinkedList<String>();
		File database = new File("accounts.csv");	
		BufferedReader br = new BufferedReader(new FileReader("passuser.csv"));
		BufferedWriter bw1 = new BufferedWriter(new FileWriter("passuser.csv",true));
		BufferedWriter bw = new BufferedWriter(new FileWriter("account.csv",true));
		Scanner scan = new Scanner(new File("passuser.csv"));
		String line = "" ;	
		String passuser = username+password+typeOA;
		while((line = br.readLine()) != null){
			ll.add(line);
		}
		if(ll.contains(passuser)){
			return false;
		}
			bw.newLine();
			bw1.newLine();
			bw.write(name+email+passuser+typeOA);
			bw1.write(passuser+typeOA);
			bw.close();
			bw1.close();
			//dir(username);
			return true;
	}
	public String logIn(String username, String password) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("passuser.csv"));
		LinkedList<String> ll = new LinkedList<String>();
		LinkedList<String> desuKa = new LinkedList<String>();
		LinkedList<String> koshka = new LinkedList<String>();
		String passuser = username+password ;
		String[] idkException = null ;
		String line = "" ;
		String cutThis = "" ;
		String t1 = "";
		while((line = br.readLine()) != null) {
			ll.add(line);
		}
		for(int i = 0; i<ll.size();i++) { 
				cutThis = ll.get(i);
				idkException = cutThis.split(",");
				desuKa.add(idkException[0]+idkException[1]+idkException[2]);
				koshka.add(idkException[2]);
		}
		for(int i = 0; i < desuKa.size() ;i++){
			if(desuKa.contains(passuser+koshka.get(i))&&(koshka.get(i).equalsIgnoreCase("rr"))){
				System.out.print((desuKa.contains(passuser+koshka.get(i)+"")));
				t1 = "regular";
				break;
			}else if(desuKa.contains(passuser+koshka.get(i))&&(koshka.get(i).equalsIgnoreCase("AA"))){
				System.out.print((desuKa.contains(passuser+koshka.get(i)+"")));
				t1 = "boss";
				break;
			}
		}
			//idkException = cutThis.split(",");
		/*desuKa.add(idkException[0]+idkException[1]);
		if(desuKa.contains(passuser) && (idkException[2].equalsIgnoreCase("RR"))){
			return "regular" ;
		}else if(desuKa.contains(passuser) && (idkException[2].equalsIgnoreCase("AA"))){
			return " Boss ";
		}*/
		if(t1.equals("regular")){
			return "regular";
		}else if(t1.equals("boss")){
			return "boss";
		}else{
			return "intruder";
		}	
		//return passuser +" "+koshka+" "+ desuKa;

	}
	public void dir(String name) {
		File dir = new File(name);
		dir.mkdir();
	}
}