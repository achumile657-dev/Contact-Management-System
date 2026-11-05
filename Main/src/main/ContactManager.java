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
     
 //Search contact method using base case and recursive method 
   public Contact searchContact(String keyword) {
    return searchRecursive(keyword, 0);
}

// Recursive method
private Contact searchRecursive(String keyword, int index) {

    // Base case 1: no more contacts to check
    if (index >= contacts.size()) {
        return null;
    }

    Contact contact = contacts.get(index);

    // Base case 2: the contact matches ANY of the fields
    if (contact.getFirstName().equalsIgnoreCase(keyword) ||
        contact.getLastName().equalsIgnoreCase(keyword) ||
        contact.getPhoneNumber().equals(keyword) ||
        contact.getEmail().equalsIgnoreCase(keyword)) {
        return contact;
    }

    // Recursive call: check the next contact
    return searchRecursive(keyword, index + 1);
}

   // sorts the contacts by first name (A to Z)
    // Time complexity: O(n²), Space complexity: O(1)
    public void sortContacts() {
    for (int i = 1; i < contacts.size(); i++) {
        Contact key = contacts.get(i);
        int j = i - 1;

        // Shift bigger first names to the right
        while (j >= 0 && contacts.get(j).getFirstName()
                .compareToIgnoreCase(key.getFirstName()) > 0) {
            contacts.set(j + 1, contacts.get(j));
            j--;
        }
        // Drop key in the gap
        contacts.set(j + 1, key);
    }
      
    }
    
    // Finds all contacts that contain the text in any field (uses a stream)
     public List<Contact> filterContacts(String query) {
    String q = query.toLowerCase();
    return contacts.stream()
        .filter(c -> c.getFirstName().toLowerCase().contains(q)
                  || c.getLastName().toLowerCase().contains(q)
                  || c.getPhoneNumber().contains(q)
                  || c.getEmail().toLowerCase().contains(q))
        .toList();
     }
    // Checks if a phone number already exists in the list
// Time complexity: O(n), it may check every contact
public boolean isDuplicate(String phoneNumber) {
    for (Contact c : contacts) {
        if (c.getPhoneNumber().equals(phoneNumber)) {
            return true;
        }
    }
    return false;
}
    // edits the details of the contact 
    public boolean editContact(String keyword,int fieldChoice, String newValue){
   Contact contact = searchContact(keyword);

    if (contact == null) {
        return false;
    }
       
 switch(fieldChoice){
 
     case 1-> contact.setFirstName(newValue);
     case 2-> contact.setLastName(newValue);
     case 3->contact.setPhoneNumber(newValue);
     case 4->contact.setEmail(newValue);
 default->{
 return false; //invalid field choice
 }
 }
    
    
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