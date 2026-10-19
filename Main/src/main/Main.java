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
    
    ContactManager cm = new ContactManager();
    
    System.out.println("CONTACT MANAGEMENT SYSTEM \n");
   
    System.out.println("Cntact list empty!! Add your first contact!!");
    
    System.out.print("Enter first name: ");
   String firstName = sc.nextLine();
 


   System.out.print("Enter last name: ");
   String lastName=sc.nextLine();
   
   System.out.print("Enter phone number: ");
   String phoneNumber = sc.nextLine();

   System.out.print("Enter email: ");
   String email = sc.nextLine();
   
   Contact contact = new Contact(firstName,lastName,phoneNumber, email);
    cm.addContact(contact);
    
    fileHandler.writeFile(firstName, lastName,phoneNumber, email);
    
    System.out.println("Contact added successfully!!");
    
    boolean running = true;

        while (running) {
        System.out.println("1. Add Contact");
        System.out.println("2. Search Contact");
        System.out.println("3. Edit Contact");
        System.out.println("4. Delete Contact");
        
        System.out.print("Choose an option: ");
        
        int option = sc.nextInt();
        
        switch (option) {
                case 1:
                    // Add Contact
                    System.out.print("Enter First Name: ");
                    firstName = sc.nextLine();
                    System.out.print("Enter Last Name: ");
                    lastName = sc.nextLine();
                    System.out.print("Enter Phone Number: ");
                    phoneNumber = sc.nextLine();
                    System.out.print("Enter Email: ");
                    email = sc.nextLine();

                    Contact newContact = new Contact(firstName, lastName, phoneNumber, email);
                    cm.addContact(newContact);
                    
                case 2:
                    // Search Contact
                    System.out.print("Enter a name, phone, or email to search: ");
                    String searchKeyword = sc.nextLine();
                    Contact found = cm.searchContact(searchKeyword);
                    
                    if (found != null) {
                        System.out.println("Contact Found: " + found.getFirstName() + " " + found.getLastName() + 
                                           " | Phone: " + found.getPhoneNumber() + " | Email: " + found.getEmail());
                    } else {
                        System.out.println("No contact found matching that keyword.");
                    }
                    
                    break;
                    
        
        }
        
    }}
}