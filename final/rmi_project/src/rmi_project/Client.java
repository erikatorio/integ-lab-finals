/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
                               System.out.print("Enter filename to be uploaded: ");
                               String f = console.nextLine();
                               String u = stub.uploadFile(f, username, pIDToo);
                               System.out.println(u);
                               System.out.println("Press any key to continue...");
                               console.nextLine();
                               break;
                           case 7:
                               System.exit(0);
                               break;
                           default:
                               System.out.println("Invalid choice!");
                       }
                   } while (choice != 7);
                   
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
                               System.out.print("Enter filepath to be uploaded: ");
                               String fl = console.nextLine();
                               String v = stub.uploadFile(fl, username, pid);
                               System.out.println(v);
                               System.out.println("Press any key to continue...");
                               console.nextLine();
                               break;
                           case 3:
                               System.exit(0);
                               break;
                           default:
                               System.out.println("Invalid choice!");
                       }
                   } while (userChoice != 3);
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
        System.out.println("7. Exit");
    }
    
    public static void showUserMenu() {
        System.out.println("1. View projects.");
        System.out.println("2. File upload");
        System.out.println("3. Exit");
    }
}
