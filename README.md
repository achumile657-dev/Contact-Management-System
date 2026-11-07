# Contact Management System

A collaborative Java-based Contact Management System developed using **Apache NetBeans IDE 29**. The application provides both a **Command-Line Interface (CLI)** and a **Graphical User Interface (GUI)**, allowing users to manage their contacts through different interaction methods.

## Project Overview

The Contact Management System is a collaborative software development project designed to demonstrate practical Java programming, Object-Oriented Programming (OOP), file handling and user interface development.

The application allows users to manage contact information through two interfaces:

- **CLI:** A menu-driven terminal interface for managing contacts using text-based input and output.
- **GUI:** A graphical interface designed to provide a more visual and user-friendly way of managing contacts.

Both interfaces support the core contact management functionality, with contact records stored using CSV file handling.

## Features

- **Add Contacts:** Register contacts with first name, last name, phone number and email address.
- **View Contacts:** Display saved contact information.
- **Search Contacts:** Find contacts using their first name, last name, phone number or email address.
- **Edit Contacts:** Update individual contact attributes without replacing the entire contact record.
- **Delete Contacts:** Remove existing contacts.
- **Input Validation:** Validate South African phone numbers and email addresses.
- **Data Persistence:** Save and retrieve contact information using CSV files.
- **Dual Interface Support:** Interact with the application through either CLI or GUI.

## Technologies Used

| Technology | Purpose |
|---|---|
| Java | Core application development |
| Apache NetBeans IDE 29 | Development environment |
| Java Collections | Managing contact records |
| Swing / GUI framework | Graphical user interface (if using Swing) |
| CSV | Contact data storage |
| Git | Version control |
| GitHub | Team collaboration and code hosting |

## Application Architecture

The application is organised into separate classes to promote modularity and separation of responsibilities.

| Component | Responsibility |
|---|---|
| Main.java | CLI application entry point and user interaction |
| Contact.java | Represents individual contact records |
| ContactManager.java | Handles contact management operations |
| FileHandler.java | Handles CSV reading and writing |
| GUI components | Provide graphical interaction with the application |

## Interfaces

### 1. Command-Line Interface (CLI)

The CLI provides a menu-driven interface through which users can perform contact management operations using the terminal.

### 2. Graphical User Interface (GUI)

The GUI provides a visual interface for users to interact with the contact management system.

*Screenshots of both interfaces can be added here.*

## Getting Started

### Prerequisites

- Java Development Kit (JDK)
- Apache NetBeans IDE
- Git
- GitHub account

### Installation

1. Clone the repository:

```bash
git clone YOUR_REPOSITORY_URL
```

2. Open Apache NetBeans IDE.
3. Select **File → Open Project**.
4. Navigate to the cloned repository.
5. Configure the appropriate JDK.
6. Run the desired application entry point (CLI or GUI).

## Collaborative Development

This project is developed collaboratively using Git and GitHub.

Team members contribute to different parts of the application, including application logic, interface development, testing and integration.

### Collaboration Workflow

1. Clone the shared repository.
2. Create a feature branch.
3. Implement and test changes.
4. Commit changes with descriptive messages.
5. Push the branch to GitHub.
6. Create a Pull Request for review and integration.

## Concepts and Skills Developed

- Object-Oriented Programming (OOP).
- Classes, objects, constructors and methods.
- Encapsulation and data management.
- Java Collections and ArrayLists.
- Searching and sorting algorithms.
- Exception handling.
- Regular expressions and input validation.
- File handling and data persistence.
- CLI and GUI development.
- Git and GitHub collaboration.
- Teamwork and software integration.

## Future Improvements

- Improved GUI design and user experience.
- Advanced contact searching and sorting.
- Duplicate contact detection.
- Enhanced error handling.
- Unit testing using JUnit.
- Improved data storage and backup functionality.

## Contributors

This is a collaborative project developed by a team of contributors.

See the GitHub Contributors section for individual contributions.

---

**Project Type:** Collaborative Software Development

**Programming Language:** Java

**Interfaces:** CLI and GUI

**IDE:** Apache NetBeans IDE 29

**Version Control:** Git and GitHub
