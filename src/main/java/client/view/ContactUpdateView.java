package client.view;

import java.util.Scanner;

public class ContactUpdateView {

    // Отримуємо вхідні дані
    public String[] getData() {
        System.out.println("\nUPDATE FORM");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input id: ");
        String id = scanner.nextLine().trim();
        System.out.print("Input name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Input phone in format XXXXXXXXXX: ");
        String phone = scanner.nextLine().trim();
        return new String[] {id, name, phone};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
