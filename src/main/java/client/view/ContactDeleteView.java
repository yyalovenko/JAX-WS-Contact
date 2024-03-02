package client.view;

import java.util.Scanner;

public class ContactDeleteView {

    // Отримуємо вхідні дані
    public String[] getData() {
        System.out.println("\nDELETE FORM");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input id to delete: ");
        String id = scanner.nextLine().trim();
        return new String[] {id};
    }

    // Виведення результату роботи програми
    public void getOutput(String output) {
        System.out.println(output);
    }
}
