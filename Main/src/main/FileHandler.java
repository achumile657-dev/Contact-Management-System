package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private final String filePath;

    // Constructor
    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    // Save all contacts to a file
    public void saveContacts(List<Contact> contacts) {
        try (BufferedWriter writer =
                 new BufferedWriter(new FileWriter(filePath))) {

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

    // Load contacts from a file
    public List<Contact> loadContacts() {
        List<Contact> contacts = new ArrayList<>();

        try (BufferedReader reader =
                 new BufferedReader(new FileReader(filePath))) {

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