
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner scnr;
    private int currChoice;
    private String charChoice;
    ArrayList<String> wordlist;

    public Menu() {
        this.scnr = new Scanner(System.in);
        this.currChoice = -1;
        this.wordlist = new ArrayList();
    }

    public void open() {
        System.out.println("\nWelcome to PassKing passwork manager!\n Please choose an option below: \n");
        System.out.println("1. View current passwords");
        System.out.println("2. Generate new password");
        System.out.println("3. More");
        System.out.println("4. Exit");
        this.currChoice = this.scnr.nextInt();
    }

    public void additionalOpen() {
        System.out.println("Additional Options: \n");
        System.out.println("1. Clear saved combos");
        System.out.println("2. Save custom password combo");
        System.out.println("3. Delete a saved password combo");
        System.out.println("4. Exit");
        this.currChoice = this.scnr.nextInt();
    }

    public int returnChoice() {
        return this.currChoice;
    }

    public String returnSpecialChars() {
        return this.charChoice;
    }

    public Combo generatePassword() throws FileNotFoundException {
        System.out.println("Choose a password generation style: ");
        System.out.println("1. Random Words");
        System.out.println("2. Random Characters");
        this.currChoice = this.scnr.nextInt();
        Password password;
        int choice;
        if (this.currChoice == 1) {
            password = new Password();
            password.importWords();
            System.out.println("How many words would you like in your password? : ");
            choice = this.scnr.nextInt();
            return password.wordPassword(choice);
        } else if (this.currChoice == 2) {
            password = new Password();
            password.importChars();
            System.out.println("(y/n) Would you like to use special characters? : ");
            charChoice = scnr.next();
            System.out.println("How many characters would you like in your password? : ");
            choice = this.scnr.nextInt();
            return password.charPassword(choice, charChoice);
        } else {
            System.out.println("Something went wrong, Please try again.");
            return new Combo(null);
        }
    }
}
