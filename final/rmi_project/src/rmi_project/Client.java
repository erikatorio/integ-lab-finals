package rmi_project;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private static Scanner console = new Scanner(System.in);
    public static void main(String[] args) {
        try {
           System.out.println("Login\n");
           System.out.print("Enter username: ");
           String username = console.nextLine();
           System.out.print("Enter password: ");
           String password = console.nextLine();
           System.out.print("Enter server IP Address: ");
           String ip = console.nextLine();
           System.out.print("Enter port number: ");
           int port = Integer.parseInt(console.nextLine());
           
           Registry reg = LocateRegistry.getRegistry(ip, port);
           ProjectInterface stub = (ProjectInterface) reg.lookup("s");
           
           boolean login = stub.loginUser(username, password);
           
           if(login) {
               ArrayList<String> projList = new ArrayList<>();
               projList = stub.viewAllProjects();
               System.out.println("Current Projects: ");
               for (int h = 0; h < projList.size(); h++) {
                   System.out.println(projList.get(h));
               }
               System.out.print("Enter project name: ");
               String project = console.nextLine();
               boolean leader = stub.validateUserPrivileges(username, project);
               
               if(leader) {
                   System.out.println("Hi leader! What do you want to do today?");
                   int choice;
                   do {
                       showLeaderMenu();
                       System.out.print("Enter choice: ");
                       choice = Integer.parseInt(console.nextLine());
                       switch(choice) {
                           case 1:
                               ArrayList<String> projects = new ArrayList<>();
                               projects = stub.viewLeaderProjects(username);
                               System.out.println("Your projects as Leader:");
                               for(int i = 0; i < projects.size(); i++) {
                                   System.out.println(projects.get(i));
                               }
                               System.out.println("Press any key to continue...");
                               console.nextLine();
                               break;
                           case 2:
                               ArrayList<String> projectsToo = new ArrayList<>();
                               projectsToo = stub.viewProjects(username);
                               System.out.println("Your projects:");
                               for(int j = 0; j < projectsToo.size(); j++) {
                                   System.out.println(projectsToo.get(j));
                               }
                               System.out.println("Press any key to continue...");
                               console.nextLine();
                               break;
                           case 3:
                               int project_id = stub.getProjectID(project);
                               //System.out.println(project_id);
                               System.out.print("Enter username of member to be added to this project: ");
                               String member = console.nextLine();
                               String r = stub.addMember(member, project_id);
                               System.out.println(r);
                               System.out.println("Press any key to continue...");
                               console.nextLine();
                               break;
                           case 4:
                               int project_idToo = stub.getProjectID(project);
                               System.out.print("Enter username of member to be removed from this project: ");
                               String dMember = console.nextLine();
                               String s = stub.removeMember(dMember, project_idToo);
                               System.out.println(s);
                               System.out.println("Press any key to continue...");
                               console.nextLine();
                               break;
                           case 5:
                               int pID = stub.getProjectID(project);
                               String t = stub.completeProject(pID);
                               System.out.println(t);
                               System.out.println("Press any key to continue...");
                               console.nextLine();
                               break;
                           case 6:
                               int pIDToo = stub.getProjectID(project);
                               System.out.print("Enter file path of file to be uploaded: ");
                               String f = console.nextLine();
                               System.out.print("Enter file name: ");
                               String fn = console.nextLine();
                               String u = stub.uploadFile(f, fn, username, pIDToo);
                               System.out.println(u);
                               System.out.println("Press any key to continue...");
                               console.nextLine();
                               break;
                           case 7:
                               int pjID = stub.getProjectID(project);
                               ArrayList<String> uploads = new ArrayList<>();
                               uploads = stub.viewFiles(pjID);
                               System.out.println("--------------------------------Project Files-------------------------------");
                               for (int m = 0; m < uploads.size(); m++) {
                                   System.out.println(uploads.get(m));
                               }
                               System.out.println();
                               ArrayList<String> revisions = new ArrayList<>();
                               System.out.print("Enter file name to see its revisions: ");
                               String filname = console.nextLine();
                               revisions = stub.viewFileRevisions(filname, pjID);
                               System.out.println("---------------------------------"+filname+"---------------------------------");
                               for(int l = 0; l < revisions.size(); l++) {
                                   System.out.println(revisions.get(l));
                               }
                               System.out.println("Press any key to continue...");
                               console.nextLine();
                               break;
                           case 8:
                               /**int prjtID = stub.getProjectID(project);
                               ArrayList<String> fs = new ArrayList<>();
                               fs = stub.viewFiles(prjtID);
                               System.out.println("--------------------------------Project Files-------------------------------");
                               for (int q = 0; q < fs.size(); q++) {
                                   System.out.println(fs.get(q));
                               }
                               System.out.println("Enter file name you want to download");
                               String dl = console.nextLine();
                               String d = stub.downloadFile(dl, prjtID);
                               System.out.println(d);**/
                               break;
                           case 9:
                               int projID = stub.getProjectID(project);
                               ArrayList<String> msgs = new ArrayList<>();
                               msgs = stub.viewMessages(projID);
                               System.out.println(project+" messages");
                               for (int y = 0; y < msgs.size(); y++) {
                                   System.out.println(msgs.get(y));
                               }
                               System.out.println("Press any key to send your own message...");
                               console.nextLine();
                               
                               System.out.print("Enter your message: ");
                               String mess = console.nextLine();
                               String status = stub.sendMessage(mess, username, projID);
                               System.out.println(status);
                               System.out.println("Press any key to continue...");
                               console.nextLine();
                               break;
                           case 10: 
                               System.exit(0);
                               break;
                           default:
                               System.out.println("Invalid choice!");
                       }
                   } while (choice != 10);
                   
               } else {
                   System.out.println("Hi user! What do you want to do today?");
                   int userChoice;
                   do {
                       showUserMenu();
                       System.out.print("Enter choice: ");
                       userChoice = Integer.parseInt(console.nextLine());
                       switch(userChoice) {
                           case 1:
                               ArrayList<String> userprojects = new ArrayList<>();
                               userprojects = stub.viewUserProjects(username);
                               System.out.println("Your projects:");
                               for(int k = 0; k < userprojects.size(); k++) {
                                   System.out.println(userprojects.get(k));
                               }
                               System.out.println("Press any key to continue...");
                               console.nextLine();
                               break;
                           case 2:
                               int pid = stub.getProjectID(project);
                               System.out.print("Enter file path of file to be uploaded: ");
                               String fl = console.nextLine();
                               System.out.print("Enter file name: ");
                               String fln = console.nextLine();
                               String v = stub.uploadFile(fl, fln, username, pid);
                               System.out.println(v);
                               System.out.println("Press any key to continue...");
                               console.nextLine();
                               break;
                           case 3:
                               int pjsID = stub.getProjectID(project);
                               ArrayList<String> upload = new ArrayList<>();
                               upload = stub.viewFiles(pjsID);
                               System.out.println("--------------------------------Project Files-------------------------------");
                               for (int n = 0; n < upload.size(); n++) {
                                   System.out.println(upload.get(n));
                               }
                               System.out.println();
                               ArrayList<String> revision = new ArrayList<>();
                               System.out.print("Enter file name to see its revisions: ");
                               String flname = console.nextLine();
                               revision = stub.viewFileRevisions(flname, pjsID);
                               System.out.println("---------------------------------"+flname+"---------------------------------");
                               for(int o = 0; o < revision.size(); o++) {
                                   System.out.println(revision.get(o));
                               }
                               System.out.println("Press any key to continue...");
                               console.nextLine();
                               break;
                           case 4:
                               break;
                           case 5:
                               int p_id = stub.getProjectID(project);
                               ArrayList<String> messages = new ArrayList<>();
                               messages = stub.viewMessages(p_id);
                               System.out.println(project+" messages");
                               for (int z = 0; z < messages.size(); z++) {
                                   System.out.println(messages.get(z));
                               }
                               System.out.println("Press any key to send your own message...");
                               console.nextLine();
                               
                               System.out.print("Enter your message: ");
                               String ms = console.nextLine();
                               String st = stub.sendMessage(ms, username, p_id);
                               System.out.println(st);
                               System.out.println("Press any key to continue...");
                               console.nextLine();
                               break;
                           case 6:
                               System.exit(0);
                               break;
                           default:
                               System.out.println("Invalid choice!");
                       }
                   } while (userChoice != 6);
               }
           } else {
               System.out.println("You are not a registered user.");
           }
           //String test = stub.test();
           //System.out.println(test);
        } catch (Exception e) {
            
        }
    }
    
    public static void showLeaderMenu() {
        System.out.println("1. View projects as leader.");
        System.out.println("2. View projects as normal user.");
        System.out.println("3. Add members to project.");
        System.out.println("4. Remove user from project.");
        System.out.println("5. Make project status complete.");
        System.out.println("6. File upload.");
        System.out.println("7. View file revisions.");
        System.out.println("8. Download file");
        System.out.println("9. Project Chat");
        System.out.println("10. Exit");
    }
    
    public static void showUserMenu() {
        System.out.println("1. View projects.");
        System.out.println("2. File upload");
        System.out.println("3. View file revisions.");
        System.out.println("4. Download file");
        System.out.println("5. Project Chat");
        System.out.println("6. Exit");
    }
}
