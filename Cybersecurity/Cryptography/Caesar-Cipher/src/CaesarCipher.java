/* This program encrypts and decrypts a message using the Caesar Cipher
 * 
 * Credit: Daviyon Daniels (Ayliea)
*/

import java.util.Scanner;

public class CaesarCipher {
    @SuppressWarnings("unused")
    static

    int choice;

    public static void main(String[] args) throws InterruptedException {
        // Welcome message
        System.out.println("Welcome to the Caesar Cipher program!\n");
        // Calls the Menu function
        Menu();

        // Ask user for message to encrypt
    }

    // Function to call main menu
    public static void Menu() throws InterruptedException {
        int shift;

        Scanner input = new Scanner(System.in);
        // Ask user if they want to encrypt or decrypt a message
        System.out.println("Main Menu\n\n1. Encrypt\n2. Decrypt\n3. Exit\n\nMake a selection: ");
        // Get user input
        choice = input.next().charAt(0);

        if (choice == '1') {
            Encrypt();
        } else if (choice == '2') {
            Decrypt();
        } else if (choice == '3') {
            System.out.print("The program will now exit...");
            Thread.sleep(4000);
            System.exit(0);
        }
    }

    // Function to encrypt a message
    public static void Encrypt() throws InterruptedException {
        String message;
        int key;
        boolean active = true;

        Scanner input = new Scanner(System.in);

        // Prompt user to enter a message
        System.out.print("Enter a message to encrypt: ");
        message = input.nextLine();
        System.out.println();

        // Prompt user to enter a positive key
        System.out.print("Enter a key: ");
        key = input.nextInt();

        // Error proofing key to allow only positive values
        while (active == true) {
            if (key < 0) {
                System.out.print("ERROR: Key must be a positive value!\n\nEnter a key: ");
                key = input.nextInt();
            } else if (key == 0) {
                System.out.print("ERROR: Message not encrypted.\n\nEnter a key: ");
                key = input.nextInt();
            } else {
                active = false;
            }
        }
        // Reactivates the 'active' loop switch
        active = true;

        // Shifts the message based on key value
        StringBuilder encrypted_message = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (character != ' ') {
                int originalPosition = character - 'a';
                int newPosition = (originalPosition + key) % 26;
                char newCharacter = (char) ('a' + newPosition);
                encrypted_message.append(newCharacter);
            } else {
                encrypted_message.append(character);
            }
        }
        // Prints encrypted message
        System.out.println("Here's your encrypted message: " + encrypted_message + "\n");
        Thread.sleep(4000);

        // Prompts user to return to menu or exit program
        System.out.print("1. Return to main menu.\n2. Exit\n\nMake a selection: ");
        choice = input.nextInt();

        // Errorproofs user selection
        while (active == true) {
            if (choice == 1) {
                System.out.print("\nWelcome back!\n\n");
                Menu();
            } else if (choice == 2) {
                System.out.print("Program will now exit...");
                Thread.sleep(4000);
                System.exit(0);
            } else {
                System.out.print("ERROR: Not a valid option. Make a selection: ");
                choice = input.nextInt();
            }
        }
    }

    // Function to decrypt message
    public static void Decrypt() throws InterruptedException {
        String message;
        int key;
        boolean active = true;

        Scanner input = new Scanner(System.in);
        // Prompt user to enter a message
        System.out.print("Enter a message to decrypt: ");
        message = input.nextLine();
        System.out.println();

        // Prompt user to enter a positive key
        System.out.print("Enter a key: ");
        key = (26 - (input.nextInt() % 26));

        // Error proofing key to allow only positive values
        while (active == true) {
            if (key < 0) {
                System.out.print("ERROR: Key must be a positive value!\n\nEnter a key: ");
                key = input.nextInt();
            } else if (key == 26) {
                System.out.print("ERROR: Message not decrypted.\n\nEnter a key: ");
                key = input.nextInt();
            } else {
                active = false;
            }
        }
        // Reactivates the 'active' loop switch
        active = true;

        // Shifts the message based on key value
        StringBuilder decrypted_message = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (character != ' ') {
                int originalPosition = character - 'a';
                int newPosition = (originalPosition + key) % 26;
                char newCharacter = (char) ('a' + newPosition);
                decrypted_message.append(newCharacter);
            } else {
                decrypted_message.append(character);
            }
        }
        // Prints encrypted message
        System.out.println("Here's your decrypted message: " + decrypted_message + "\n");
        Thread.sleep(4000);

        // Prompts user to return to menu or exit program
        System.out.print("1. Return to main menu.\n2. Exit\n\nMake a selection: ");
        choice = input.nextInt();

        // Error proofs user selection
        while (active == true) {
            if (choice == 1) {
                System.out.print("\nWelcome back!\n\n");
                Menu();
            } else if (choice == 2) {
                System.out.print("Program will now exit...");
                Thread.sleep(4000);
                System.exit(0);
            } else {
                System.out.print("ERROR: Not a valid option. Make a selection: ");
                choice = input.nextInt();
            }
        }
    }
}