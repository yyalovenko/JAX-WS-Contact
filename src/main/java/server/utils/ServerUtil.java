package server.utils;

import server.service.DataServicePublisher;

import java.util.Scanner;

public class ServerUtil {

    private static final Scanner scanner = new Scanner(System.in);
    private final static String STOP_SERVER_KEY = "quit";

    public void runServer() {
        onPublish();
        stopServer(startServer());
    }

    private void onPublish() {
        new DataServicePublisher().publish();
    }

    private String startServer() {
        System.out.print(">> Server has been started.\n" +
                "To stop the Server, input '" + STOP_SERVER_KEY + "': ");
        return scanner.nextLine().trim();
    }

    private void stopServer(String input) {
        while (!input.equals("quit")) {
            System.out.print(">> Server is working." +
                    "\nTo stop the Server, input '" + STOP_SERVER_KEY + "': ");
            input = scanner.nextLine().trim();
        }
        System.out.println(">> Server has been stopped.");
        scanner.close();
        System.exit(0);
    }

    public void getOutput(String output) {
        System.out.println(output);
    }

}
