/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author USER
 */
import java.util.List;
import java.util.ArrayList;

public class ContactManager {
    
    
    private final List<Contact> contacts = new ArrayList<>();
    
     public void addContact(Contact contact) {
     contacts.add(contact);
     }
     
     public List<Contact> getAllContacts(){  //returns the entire list of contacts added
         return contacts;
     }

    //Helper method to check if list is empty
     public boolean isEmpty(){      //checks if the list is empty.
         return contacts.isEmpty();  // Does not allow options such as view or delete if no contacts were added yet
     }
     
    //searches the contact list for a contact that matches the keyword 
    public Contact searchContact(String keyword) {
        for (Contact contact : contacts) {
            // Check if the keyword matches ANY of the fields to be able to search the contact
            if (contact.getFirstName().equalsIgnoreCase(keyword) ||
                contact.getLastName().equalsIgnoreCase(keyword) ||
                contact.getPhoneNumber().equals(keyword) || 
                contact.getEmail().equalsIgnoreCase(keyword)) {
                
                return contact; 
            }
        }
        return null; 
    }
      
         
    // edits the details of the contact 
    public boolean editContact(String keyword, String newFirstName, String newLastName,
                           String newPhoneNumber, String newEmail) {
    Contact contact = searchContact(keyword);

    if (contact == null) {
        return false;
    }

    contact.setFirstName(newFirstName);
    contact.setLastName(newLastName);
    contact.setPhoneNumber(newPhoneNumber);
    contact.setEmail(newEmail);
    return true;
     }
      

      //Mehod to delete a contact through the searchContact
    public boolean deleteContact(String keyword){
        Contact contact =  searchContact(keyword);
        
        if (contact == null){
         return false;       
        }
     contacts.remove(contact);
     return true;
        
    }
    
    
}