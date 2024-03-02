package client.service;

import client.controller.ContactController;
import client.exceptions.OptionException;
import client.utils.ClientAppStarter;
import client.utils.Constants;
import client.view.ClientAppView;

public class ClientAppService {

    ContactController controller = new ContactController();

    public void handleOption(int option) {
        switch (option) {
            case 1 -> controller.create();
            case 2 -> controller.read();
            case 3 -> controller.update();
            case 4 -> controller.delete();
            case 5 -> controller.readById();
            case 0 -> new ClientAppView().getOutput(Integer.toString(option));
            default -> {
                try {
                    throw new OptionException(Constants.INCORRECT_OPTION_MSG);
                } catch (OptionException e) {
                    new ClientAppView().getOutput(e.getMessage());
                    ClientAppStarter.startApp();
                }
            }
        }
    }

}
