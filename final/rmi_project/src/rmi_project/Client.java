/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_project;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Client {
    public static void main(String[] args) {
        try {
           Registry reg = LocateRegistry.getRegistry("127.0.0.1", 2000);
           ProjectInterface stub = (ProjectInterface) reg.lookup("s");
           System.out.println(stub.test());
        } catch (Exception e) {
            
        }
    }
}
