
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private String filePath;

    // Constructor
    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    // Save all contacts to the CSV file
    public void saveContacts(List<Contact> contacts) {

        try (BufferedWriter writer =
                 new BufferedWriter(new FileWriter(filePath))) {

            for (Contact contact : contacts) {

                writer.write(
                    contact.getId() + "," +
                    contact.getFirstName() + "," +
                    contact.getLastName() + "," +
                    contact.getPhoneNumber() + "," +
                    contact.getEmail()
                );

                writer.newLine();
            }

            System.out.println("Contacts saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving contacts: "
                    + e.getMessage());
        }
    }

    // Load contacts from the CSV file
    public List<Contact> loadContacts() {

        List<Contact> contacts = new ArrayList<>();

        try (BufferedReader reader =
                 new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",", -1);

                if (data.length != 5) {
                    System.out.println("Invalid contact record.");
                    continue;
                }

                try {
                    int id = Integer.parseInt(data[0]);

                    Contact contact = new Contact(
                        id,
                        data[1],
                        data[2],
                        data[3],
                        data[4]
                    );

                    contacts.add(contact);

                } catch (NumberFormatException e) {
                    System.out.println(
                        "Invalid contact ID: " + data[0]);
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading contacts: "
                    + e.getMessage());
        }

        return contacts;
    }

    // Record application actions in a separate log file
    public void logAction(String action) {

        try (BufferedWriter writer =
                 new BufferedWriter(
                     new FileWriter("ContactLog.txt", true))) {

            writer.write(action);
            writer.newLine();

        } catch (IOException e) {
            System.out.println("Error logging action: "
                    + e.getMessage());
        }
    }
}
