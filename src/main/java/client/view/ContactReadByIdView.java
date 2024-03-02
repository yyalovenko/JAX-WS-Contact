package client.view;

import java.util.Scanner;

public class ContactReadByIdView {

    // Отримуємо вхідні дані
    public String[] getData() {
        System.out.println("\nREAD BY ID FORM");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input id to read by id: ");
        String id = scanner.nextLine().trim();
        return new String[] {id};
    }

    // Виведення результату роботи програми
    public void getOutput(String output) {
        System.out.println("\nDATA BY ID:\n" + output);
    }
}
