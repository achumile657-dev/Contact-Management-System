/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;


/**
 *
 * @author USER
 */
import java.util.List;
 import java.util.Scanner;

public class Main {
    //Phone number validation
   public static boolean isValidPhoneNumber(String phoneNumber) {
    return phoneNumber.matches("0[6-8][0-9]{8}");
}
   //Email validation
    public static boolean isValidEmail(String email) {
    return email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
}
   
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
    
    FileHandler fileHandler = new FileHandler("Contacts.csv");
    
    ContactManager cm = new ContactManager();
    
    System.out.println("---------------CONTACT MANAGEMENT SYSTEM--------------------");
   
    System.out.println("Contact list empty! Add your first contact!");
    
   System.out.print("Enter first name: ");
   String firstName = sc.nextLine();
 
   System.out.print("Enter last name: ");
   String lastName=sc.nextLine();
   
   String phoneNumber;
   String email;

   //Number validation
 do {
    System.out.print("Enter phone number: ");
    phoneNumber = sc.nextLine();

    if (!isValidPhoneNumber(phoneNumber)) {
        System.out.println("Invalid South African phone number.");
    }

} while (!isValidPhoneNumber(phoneNumber));
 
//Email validation
do {
    System.out.print("Enter email: ");
    email = sc.nextLine();

    if (!isValidEmail(email)) {
        System.out.println("Invalid email address.");
    }

} while (!isValidEmail(email));
   
   Contact contact = new Contact(firstName,lastName,phoneNumber, email);
   cm.addContact(contact);
    
   List<Contact> contacts = fileHandler.loadContacts();
   fileHandler.saveContacts(contacts);
    
    System.out.println("Contact added successfully!");
    
    boolean running = true;

        while (running) {
        System.out.println("1. Add Contact");
        System.out.println("2. Search Contact");
        System.out.println("3. View and Edit Contact");
        System.out.println("4. Delete Contact");
        System.out.println("5. Exit App");
        
        System.out.print("Choose an option(1-5): ");
        
        int option;
        
        try {
                option = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5!");
                continue;
            }
        
        
        switch (option) {
                case 1 -> {
                    // Add Contact
                    System.out.print("Enter First Name: ");
                    firstName = sc.nextLine();
                    System.out.print("Enter Last Name: ");
                    lastName = sc.nextLine();
                    //validate phone number 
                    do {
                        System.out.print("Enter Phone Number: ");
                        phoneNumber = sc.nextLine();

                        if (!isValidPhoneNumber(phoneNumber)) {
                            System.out.println("Invalid South African phone number.");
                        }

                    } while (!isValidPhoneNumber(phoneNumber));
                    
                    //Validate email
                    do {
                        System.out.print("Enter Email: ");
                        email = sc.nextLine();

                        if (!isValidEmail(email)) {
                            System.out.println(
                                    "Invalid email address."
                            );
                        }

                    } while (!isValidEmail(email));

                    Contact newContact = new Contact(firstName, lastName, phoneNumber, email);
                    cm.addContact(newContact);
                    
                    fileHandler.saveContacts(cm.getAllContacts());
                    System.out.println("Contact added successfully!");
                }
                    
                     case 2 -> {
                         // Search Contact
                         System.out.print("Enter a name, phone number, or an email to search: ");
                         String searchKeyword = sc.nextLine();
                         Contact found = cm.searchContact(searchKeyword);
                         
                         if (found != null) {
                             System.out.println("Contact Found: " + found.getFirstName() + " " + found.getLastName() +
                                     " Phone number: " + found.getPhoneNumber() + " Email: " + found.getEmail());
                         } else {
                             System.out.println("No contact found matching the keyword.");
                         }
                }
                    
                case 3 -> {
                     
                    

                    // Edit Contact
                    System.out.println("Contact list: ");
                   // cm.viewContact();
                    //cm.viewContact();

                    
                    System.out.print("Enter the keyword of the contact you want to edit: ");
                    String editKeyword = sc.nextLine();
                    
                
                    if (cm.searchContact(editKeyword) == null) {
                        System.out.println("Contact not found.");
                        
                        break;
                    }
                    
                    System.out.print("Enter New First Name: ");
                    String newFirst = sc.nextLine();
                    System.out.print("Enter New Last Name: ");
                    String newLast = sc.nextLine();
                    
                    String newPhoneNumber;
                    do{
                        System.out.println("Enter New phone number:");
                        newPhoneNumber=sc.nextLine();
                        if(!isValidPhoneNumber(newPhoneNumber)){
                            System.out.println("Invalid South African phone number.");
                        }
                        
                    }while(!isValidPhoneNumber(newPhoneNumber));
                    
                    
                    String newEmail;
                    do{
                        System.out.println("Enter New Email:");
                        newEmail=sc.nextLine();
                        if(!isValidEmail(newEmail)){
                            System.out.println("Invalid email address.");
                        }
                    }while(!isValidEmail(newEmail));

                    if (cm.editContact(editKeyword, newFirst, newLast, newPhoneNumber, newEmail)) {
                        System.out.println("Contact updated successfully!");
                    }
                }
                    
                 case 4 -> {
                     // Delete Contact
                     System.out.print("Enter the keyword of the contact you want to delete: ");
                     String deleteKeyword = sc.nextLine();
                     
                     if (cm.deleteContact(deleteKeyword)) {
                         System.out.println("Contact deleted successfully!");
                     } else {
                         System.out.println("Contact not found.");
                     }
                }
                    
                 case 5 -> {
                     // Exiting
                     System.out.println("\n=========================FINAL CONTACT LIST===================");
                    if (cm.isEmpty()) {
                        System.out.println("Empty contact list.");
                    } else {
                        int count= 1;
                        
                        for(Contact c : cm.getAllContacts()){
                            System.out.println("\nContact: "+count);
                            System.out.println("First name: "+c.getFirstName());
                            System.out.println("Last name: "+c.getLastName());
                            System.out.println("Phone number: "+c.getPhoneNumber());
                            System.out.println("Email: "+c.getEmail());
                            
                            count++;
                        }
                        System.out.println("\n================GOOD BYE!===================");
                        System.out.println("Thank you for using Contact Manager!");
                        running = false;
                    }
                }
        
    }
     
    }
           sc.close();
    }
}