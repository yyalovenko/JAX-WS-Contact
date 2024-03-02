package client.utils;

import client.controller.ClientAppController;
import client.service.ClientAppService;
import client.view.ClientAppView;

public class ClientAppStarter {

    public static void startApp() {
        ClientAppService service = new ClientAppService();
        ClientAppView view = new ClientAppView();
        ClientAppController controller = new ClientAppController(view, service);
        controller.runApp();
    }

}
