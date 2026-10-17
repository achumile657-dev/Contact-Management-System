/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;


/**
 *
 * @author USER
 */
 import java.util.Scanner;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
    
    FileHandler fileHandler = new FileHandler();
    fileHandler.createFile();
    System.out.print("Enter name: ");
String name = sc.nextLine();
    
   System.out.print("Enter first name(s): ");
   String firstName = sc.nextLine();

   System.out.print("Enter last name: ");
   String lastName=sc.nextLine();
   
   System.out.print("Enter phone number: ");
   String phoneNumber = sc.nextLine();

   System.out.print("Enter email: ");
   String email = sc.nextLine();
   
   Contact contact = new Contact(firstName,lastName,phoneNumber, email);
   ContactManager manager = new ContactManager();
    manager.addContact(contact);
    
    fileHandler.writeFile(firstName, lastName,phoneNumber, email);
    
    System.out.println("Contact added successfully");
    }}