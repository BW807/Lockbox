
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Password {
    ArrayList<String> wordlist = new ArrayList<>();
    ArrayList<String> charlistSafe = new ArrayList<>();
    ArrayList<String> charlistRisky = new ArrayList<>();
    ArrayList<String> chosenWordList = new ArrayList<>();
    ArrayList<String> chosenCharList = new ArrayList<>();
    private String finalPass = "";

    public Password() {
    }

    public void importWords() throws FileNotFoundException {

        chosenWordList.clear();

        FileInputStream fileInputStream = new FileInputStream("words.txt");
        Scanner filescnr = new Scanner(fileInputStream);

        while (filescnr.hasNextLine()) {
            this.wordlist.add(filescnr.nextLine());
        }

    }

    public void importChars() throws FileNotFoundException {

        chosenCharList.clear();

        FileInputStream fileInputStreamSafe = new FileInputStream("safechars.txt");
        Scanner filescnrsafe = new Scanner(fileInputStreamSafe);

        while (filescnrsafe.hasNextLine()) {
            this.charlistSafe.add(filescnrsafe.nextLine());
        }

        FileInputStream fileInputStreamRisky = new FileInputStream("riskychars.txt");
        Scanner filescnrrisky = new Scanner(fileInputStreamRisky);

        while (filescnrrisky.hasNextLine()) {
            this.charlistRisky.add(filescnrrisky.nextLine());
        }

    }

    public Combo wordPassword(int numWords) {
        Random random = new Random();

        int i;
        for (i = 0; i < numWords; ++i) {
            int tempVal = random.nextInt(100);
            String tempWord = this.wordlist.get(tempVal);
            this.chosenWordList.add(tempWord);
        }

        for (i = 0; i < this.chosenWordList.size(); ++i) {
            String tempWord = this.chosenWordList.get(i);
            this.finalPass = tempWord + " " + this.finalPass;
        }

        Combo temp = new Combo(this.finalPass);

        return temp;
    }

    public Combo charPassword(int numChars, String charChoice) {
        Random random = new Random();

        if (!Objects.equals(charChoice, "y")) {
            int i;
            for (i = 0; i < numChars; ++i) {
                int tempVal = random.nextInt(55);
                String tempChar = this.charlistSafe.get(tempVal);
                this.chosenCharList.add(tempChar);
            }

            for (i = 0; i < this.chosenCharList.size(); ++i) {
                String tempChar = this.chosenCharList.get(i);
                this.finalPass = tempChar + this.finalPass;
            }

        } else {
            int i;
            for (i = 0; i < numChars; ++i) {
                int tempVal = random.nextInt(83);
                String tempChar = this.charlistRisky.get(tempVal);
                this.chosenCharList.add(tempChar);
            }

            for (i = 0; i < this.chosenCharList.size(); ++i) {
                String tempChar = this.chosenCharList.get(i);
                this.finalPass = tempChar + this.finalPass;
            }

        }

        Combo temp = new Combo(this.finalPass);

        return temp;
    }
}
