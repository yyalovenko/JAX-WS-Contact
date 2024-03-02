package client.view;


import client.utils.ClientAppStarter;
import client.utils.Constants;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ClientAppView {

    Scanner scanner;
    int option;

    public int getOption() {
        scanner = new Scanner(System.in);
        getMenu();
        try {
            option = scanner.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println(Constants.INCORRECT_OPTION_MSG);
            ClientAppStarter.startApp();
        }
        return option;
    }

    private void getMenu() {
        System.out.print("""                
                
                OPTIONS:
                1 - Create contact.
                2 - Read contacts.
                3 - Update contact.
                4 - Delete contact.
                5 - Read contact by id.
                0 - Close the App.
                """);
        System.out.print("Input option: ");
    }

    public void getOutput(String output) {
        if (output.equals("0")) {
            System.out.println(Constants.APP_CLOSE_MSG);
            System.exit(0);
        } else System.out.println(output);
    }
}
