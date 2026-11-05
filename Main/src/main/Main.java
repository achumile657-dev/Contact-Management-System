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
   public static boolean isValidName(String name) {
    return name != null && name.matches("^(?=.*[A-Za-z])[A-Za-z0-9\\s'-]+$");
}
   // Makes the first letter of each word a capital and the rest small
   public static String capitalFirstLetter(String name) {
    StringBuilder result = new StringBuilder();
    boolean newWord = true;

    for (char ch : name.trim().toCharArray()) {
        if (newWord && Character.isLetter(ch)) {
            result.append(Character.toUpperCase(ch));
            newWord = false;
        } else {
            result.append(Character.toLowerCase(ch));
        }
        if (ch == ' ' || ch == '-' || ch == '\'') {
            newWord = true;
        }
    }
    return result.toString();
}
   //Email validation
    public static boolean isValidEmail(String email) {
    return email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
}
   
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
    
         // Load the saved contacts 
    FileHandler fileHandler = new FileHandler("Contacts.csv");
    ContactManager cm = new ContactManager();
    
     for (Contact c : fileHandler.loadContacts()) {
            cm.addContact(c);
        }
     
    ContactGui gui = new ContactGui();
    gui.setVisible(true);
    
    
    System.out.println("---------------CONTACT MANAGEMENT SYSTEM--------------------");
   
    System.out.println("Contact list empty! Add your first contact!");
    /*
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
    */
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
                    String firstName = sc.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = sc.nextLine();
                    //validate phone number
                    String phoneNumber;
                    do {
                        System.out.print("Enter Phone Number: ");
                       phoneNumber = sc.nextLine();

                        if (!isValidPhoneNumber(phoneNumber)) {
                            System.out.println("Invalid South African phone number.");
                        }

                    } while (!isValidPhoneNumber(phoneNumber));
                    
                    //Validate email
                    String email;
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

    System.out.print("Enter the keyword of the contact you want to edit: ");
    String editKeyword = sc.nextLine();

    Contact found = cm.searchContact(editKeyword);

    if (found == null) {
        System.out.println("Contact not found.");
        break;
    }

    boolean editing = true;
    boolean updated = false;

    while (editing) {

        System.out.println("\n========== EDIT CONTACT ==========");
        System.out.println("Current contact details:");
        System.out.println("1. First Name: " + found.getFirstName());
        System.out.println("2. Last Name: " + found.getLastName());
        System.out.println("3. Phone Number: " + found.getPhoneNumber());
        System.out.println("4. Email: " + found.getEmail());
        System.out.println("5. Finish Editing");

        System.out.print("\nChoose the field you want to edit: ");

        int editOption;

        try {
            editOption = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            continue;
        }

        switch (editOption) {

            case 1 -> {
                System.out.print("Enter new first name: ");
                String newFirst = sc.nextLine().trim();

                if (newFirst.isEmpty()) {
                    System.out.println("First name cannot be empty.");
                } else {
                    found.setFirstName(newFirst);
                    updated = true;
                    System.out.println("First name updated!");
                    // Edit Contact
                   // System.out.println("Contact list: ");
                   // cm.viewContact();
                    //cm.viewContact();

                    
                    System.out.print("Enter the keyword of the contact you want to edit: ");
                   // String editKeyword = sc.nextLine();
                    
                
                    if (cm.searchContact(editKeyword) == null) {
                        System.out.println("Contact not found.");
                        break;
                    }
                    
                    System.out.println("Choose field to edit: ");
                    System.out.println("1.First Name");
                    System.out.println("2.Last Name");
                    System.out.println("3.Phone Number");
                    System.out.println("4.Email ");
                    System.out.print("Choose from (1-4):");
                    
                     String choiceText = sc.nextLine().trim();
                     if (!choiceText.matches("[1-4]")) {
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
                    break;
                       }
                     
                 int fieldChoice = Integer.parseInt(choiceText);
                 String newValue;
                 
               switch(fieldChoice){
 
               case 1->System.out.println("Enter new first name:");
               case 2-> System.out.println("Enter new last name:");
               case 3->System.out.println("Enter new phone number:");
               case 4->System.out.println("Enter new email:");
   }
            newValue = sc.nextLine().trim();
                    
                    if(fieldChoice == 3){
                        while(!isValidPhoneNumber(newValue)){
                        System.out.print("Enter New phone number:");
                        newValue=sc.nextLine().trim();
                      System.out.println("Invalid South African phone number.");
                        }
                        
                    }
                        
                 
                else if(fieldChoice == 4){
              while(!isValidEmail(newValue)){
                        System.out.print("Enter New Email:");
                        newValue=sc.nextLine().trim();
                        System.out.println("Invalid email address.");
                        }
                    }
        
       if (cm.editContact(editKeyword, fieldChoice, newValue)) {
                        fileHandler.saveContacts(cm.getAllContacts());
                        System.out.println("Contact updated successfully!");
                    } else {
                        System.out.println("Contact could not be updated.");
                    }

                }
            }

            case 2 -> {
                System.out.print("Enter new last name: ");
                String newLast = sc.nextLine().trim();

                if (newLast.isEmpty()) {
                    System.out.println("Last name cannot be empty.");
                } else {
                    found.setLastName(newLast);
                    updated = true;
                    System.out.println("Last name updated!");
                }
            }

            case 3 -> {
                String newPhone;

                do {
                    System.out.print("Enter new phone number: ");
                    newPhone = sc.nextLine().trim();

                    if (!isValidPhoneNumber(newPhone)) {
                        System.out.println("Invalid South African phone number.");
                    }

                } while (!isValidPhoneNumber(newPhone));

                found.setPhoneNumber(newPhone);
                updated = true;
                System.out.println("Phone number updated!");
            }

            case 4 -> {
                String newEmail;

                do {
                    System.out.print("Enter new email: ");
                    newEmail = sc.nextLine().trim();

                    if (!isValidEmail(newEmail)) {
                        System.out.println("Invalid email address.");
                    }

                } while (!isValidEmail(newEmail));

                found.setEmail(newEmail);
                updated = true;
                System.out.println("Email updated!");
            }

            case 5 -> {
                editing = false;
                System.out.println("Finished editing contact.");
            }

            default -> System.out.println("Invalid option. Choose 1-5.");
        }
    }

    // Save changes to CSV
    if (updated) {
        fileHandler.saveContacts(cm.getAllContacts());
        System.out.println("Contact changes saved successfully!");
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