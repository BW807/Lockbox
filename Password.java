
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
        FileInputStream fileInputStream = new FileInputStream("words.txt");
        Scanner filescnr = new Scanner(fileInputStream);

        while (filescnr.hasNextLine()) {
            this.wordlist.add(filescnr.nextLine());
        }

    }

    public void importChars() throws FileNotFoundException {
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

    public String wordPassword(int numWords) {
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

        return this.finalPass;
    }

    public String charPassword(int numChars, String charChoice) {
        Random random = new Random();

        if (charChoice == "y") {
            int i;
            for (i = 0; i < numChars; ++i) {
                int tempVal = random.nextInt(92);
                String tempChar = this.charlistSafe.get(tempVal);
                this.chosenCharList.add(tempChar);
            }

            for (i = 0; i < this.chosenCharList.size(); ++i) {
                String tempChar = this.chosenCharList.get(i);
                this.finalPass = tempChar + this.finalPass;
            }

            return this.finalPass;
        } else {
            int i;
            for (i = 0; i < numChars; ++i) {
                int tempVal = random.nextInt(92);
                String tempChar = this.charlistRisky.get(tempVal);
                this.chosenCharList.add(tempChar);
            }

            for (i = 0; i < this.chosenCharList.size(); ++i) {
                String tempChar = this.chosenCharList.get(i);
                this.finalPass = tempChar + this.finalPass;
            }

            return this.finalPass;
        }
    }
}
