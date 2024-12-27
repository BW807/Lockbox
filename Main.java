import java.io.IOException;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws IOException {
        System.out.println("                                                                                                                     \n88888888ba                                 88      a8P  88                                88              ,a8888a,   \n88      \"8b                                88    ,88'   \"\"                              ,d88            ,8P\"'  `\"Y8, \n88      ,8P                                88  ,88\"                                   888888           ,8P        Y8,\n88aaaaaa8P' ,adPPYYba, ,adPPYba, ,adPPYba, 88,d88'      88 8b,dPPYba,   ,adPPYb,d8        88           88          88\n88\"\"\"\"\"\"'   \"\"     `Y8 I8[    \"\" I8[    \"\" 8888\"88,     88 88P'   `\"8a a8\"    `Y88        88           88          88\n88          ,adPPPPP88  `\"Y8ba,   `\"Y8ba,  88P   Y8b    88 88       88 8b       88        88           `8b        d8'\n88          88,    ,88 aa    ]8I aa    ]8I 88     \"88,  88 88       88 \"8a,   ,d88        88    888     `8ba,  ,ad8' \n88          `\"8bbdP\"Y8 `\"YbbdP\"' `\"YbbdP\"' 88       Y8b 88 88       88  `\"YbbdP\"Y8        88    888       \"Y8888P\"   \n                                                                        aa,    ,88                                   \n                                                                         \"Y8bbdP\"                                    ");
        Menu menu = new Menu();
        menu.open();

        for(int currChoice = menu.returnChoice(); currChoice != 5; menu.open()) {
            if (currChoice < 1 || currChoice > 5) {
                System.out.println("invalid choice, please try again.\n");
                menu.open();
            }

            if (currChoice == 1) {
            }

            if (currChoice == 3) {
                System.out.println("Generated : " + menu.generatePassword());
                System.out.println();
            }
        }
    }
}
