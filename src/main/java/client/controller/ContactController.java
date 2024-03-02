package client.controller;

import client.api.DataApi;
import client.utils.ClientAppStarter;
import client.view.*;

public class ContactController {

    DataApi dataApi = new DataApi();

    public void create() {
        ContactCreateView view = new ContactCreateView();
        try {
            view.getOutput(dataApi.create(view.getData()));
        } catch (Exception e) {
            view.getOutput(e.getMessage());
        }
        ClientAppStarter.startApp();
    }

    public void read() {
        ContactReadView view = new ContactReadView();
        try {
            view.getOutput(dataApi.read());
        } catch (Exception e) {
            view.getOutput(e.getMessage());
        }
        ClientAppStarter.startApp();
    }

    public void update() {
        ContactUpdateView view = new ContactUpdateView();
        try {
            view.getOutput(dataApi.update(view.getData()));
        } catch (Exception e) {
            view.getOutput(e.getMessage());
        }
        ClientAppStarter.startApp();
    }

    public void delete() {
        ContactDeleteView view = new ContactDeleteView();
        try {
            view.getOutput(dataApi.delete(view.getData()));
        } catch (Exception e) {
            view.getOutput(e.getMessage());
        }
        ClientAppStarter.startApp();
    }

    public void readById() {
        ContactReadByIdView view = new ContactReadByIdView();
        try {
            view.getOutput(dataApi.readById(view.getData()));
        } catch (Exception e) {
            view.getOutput(e.getMessage());
        }
        ClientAppStarter.startApp();
    }

}
