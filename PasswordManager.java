import java.io.*;
import java.util.Scanner;

public class PasswordManager {

    private int numPass = 1;

    public void add(String password) throws FileNotFoundException {
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
            newPW.println(password);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }





    public void remove() {

    }

    public void clear() {

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
                System.out.println(numPass + ": " + scnr.nextLine());
                numPass++;
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

