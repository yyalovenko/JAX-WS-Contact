package server.service;

import jakarta.xml.ws.Endpoint;
import server.utils.Constants;

public class DataServicePublisher {
    public void publish() {
        Endpoint.publish(Constants.BASE_URL, new DataServiceImpl());
    }
}
