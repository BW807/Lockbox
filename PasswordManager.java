import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class PasswordManager {

    public void add(String Password) {

    }

    public void remove() {

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

