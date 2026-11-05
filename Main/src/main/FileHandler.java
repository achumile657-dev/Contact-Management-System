package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;                      
import java.io.FileInputStream;           
import java.io.FileOutputStream; 
import java.io.ObjectInputStream;         
import java.io.ObjectOutputStream;        
import java.time.LocalDateTime; 

public class FileHandler {

    private final String filePath;
private static final String SERIAL_FILE = "Contacts.dat";

    // Constructor
    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    // Save all contacts to a file
    public synchronized void saveContacts(List<Contact> contacts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            for (Contact contact : contacts) {
                writer.write(
                    contact.getFirstName() + "," +
                    contact.getLastName() + "," +
                    contact.getPhoneNumber() + "," +
                    contact.getEmail()
                );

                writer.newLine();
            }

            System.out.println("Contacts saved successfully.");

        } catch (IOException e) {
            System.out.println(
                "Error saving contacts: " + e.getMessage()
            );
        }
    }
    //
     public void saveContactsAsync(List<Contact> contacts) {
        List<Contact> copy = new ArrayList<>(contacts);   // copy, so the list cannot change while saving
        Thread saveThread = new Thread(() -> saveContacts(copy));
        saveThread.start();
    }

    // Load contacts from a file
    public List<Contact> loadContacts() {
        List<Contact> contacts = new ArrayList<>();
        
         File file = new File(filePath);
        if (!file.exists()) {
            return contacts;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", -1);

                // Check that the record has four fields
                if (data.length != 4) {
                    System.out.println("Invalid contact record.");
                    continue;
                }

                Contact contact = new Contact(
                    data[0],
                    data[1],
                    data[2],
                    data[3]
                );

                contacts.add(contact);
            }

        } catch (IOException e) {
            System.out.println(
                "Error loading contacts: " + e.getMessage()
            );
        }

        return contacts;
    }
         // Serialization: saves the list of Contact objects to Contacts.dat
    // Time complexity: O(n)
    public void saveContactsSerialized(List<Contact> contacts) {
        try (ObjectOutputStream out =
                 new ObjectOutputStream(new FileOutputStream(SERIAL_FILE))) {

            out.writeObject(new ArrayList<>(contacts));
            System.out.println("Contacts serialized successfully.");

        } catch (IOException e) {
            System.out.println("Error serializing contacts: " + e.getMessage());
        }
    }

    // Serialization: loads the list of Contact objects from Contacts.dat
    public List<Contact> loadContactsSerialized() {
        File file = new File(SERIAL_FILE);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream in =
                 new ObjectInputStream(new FileInputStream(SERIAL_FILE))) {

            return (List<Contact>) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading serialized contacts: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Log an action to a separate file
    public void logAction(String action) {
        try (BufferedWriter writer =
                 new BufferedWriter(
                     new FileWriter("ContactLog.txt", true))) {

            writer.write(action);
            writer.newLine();

        } catch (IOException e) {
            System.out.println(
                "Error logging action: " + e.getMessage()
            );
        }
    }
}