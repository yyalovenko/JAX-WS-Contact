package client.view;

import java.util.Scanner;

public class ContactCreateView {

    // Отримуємо вхідні дані
    public String[] getData() {
        System.out.println("\nCREATE FORM");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input name: ");
        String name =  scanner.nextLine().trim();
        System.out.print("Input phone in format XXXXXXXXXX: ");
        String phone = scanner.nextLine().trim();
        return new String[] {name, phone};
    }

    // Виведення результату роботи програми
    public void getOutput(String output) {
        System.out.println(output);
    }
}
