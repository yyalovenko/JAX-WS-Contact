package client.controller;

import client.service.ClientAppService;
import client.view.ClientAppView;

public class ClientAppController {

    ClientAppView view;
    ClientAppService service;

    public ClientAppController(ClientAppView view, ClientAppService service) {
        this.view = view;
        this.service = service;
    }

    public void runApp() {
        service.handleOption(view.getOption());
    }

}
