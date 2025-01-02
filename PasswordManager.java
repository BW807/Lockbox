import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PasswordManager {

    private int numPass = 1;

    ArrayList<Combo> ComboList = new ArrayList<Combo>();

    public void add(Combo combopass) throws FileNotFoundException {
        File file = new File("list.txt");

        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("File created: " + file.getName());
            } catch (IOException e) {
                System.out.println("An error occurred while creating the file.");
                e.printStackTrace();
                return;
            }
        }

        // Use append mode to avoid overwriting the file's contents
        try (FileOutputStream fileOutputStream = new FileOutputStream(file, true);
             PrintWriter newPW = new PrintWriter(fileOutputStream)) {

            newPW.println("Combo " + numPass);
            newPW.println("Website : " + combopass.returnWebsite());
            newPW.println("Username : " + combopass.returnUsername());
            newPW.println("Email : " + combopass.returnEmail());
            newPW.println("Password : " + combopass.returnPassword() + "\n");

            numPass++;

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    public void remove() {

    }

    public void clear() {
        File file = new File("list.txt");

        if (!file.exists()) {
            System.out.println("File does not exist.");
            return;
        }

        try (PrintWriter writer = new PrintWriter(file)) {
            writer.print(""); // Overwrite the file with an empty string
            System.out.println("All passwords have been cleared.");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while clearing the file.");
            e.printStackTrace();
        }
    }


    public void open() {
        File file = new File("list.txt");

        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("File created: " + file.getName());
            } catch (IOException e) {
                System.out.println("An error occurred while creating the file.");
                e.printStackTrace();
                return;
            }
        }

        try (FileInputStream fileInputStream = new FileInputStream(file);
             Scanner scnr = new Scanner(fileInputStream)) {

            while (scnr.hasNextLine()) {
                    System.out.println(scnr.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getName());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

}

