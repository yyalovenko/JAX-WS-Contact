package client.api;

import client.utils.Constants;
import jakarta.xml.ws.Service;
import server.service.DataService;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class DataApi {

    public String create(String[] data) throws Exception {
        URL url = URI.create(Constants.WSDL_URL).toURL();
        QName qname = new QName(Constants.SERVICE_URI, Constants.SERVICE_IMPL);
        Service service = Service.create(url, qname);
        DataService dataService = service.getPort(DataService.class);
        return dataService.create(data);
    }

    public String read() throws Exception {
        URL url = URI.create(Constants.WSDL_URL).toURL();
        QName qname = new QName(Constants.SERVICE_URI, Constants.SERVICE_IMPL);
        Service service = Service.create(url, qname);
        DataService dataService = service.getPort(DataService.class);
        return dataService.read();
    }

    public String update(String[] data) throws Exception {
        URL url = URI.create(Constants.WSDL_URL).toURL();
        QName qname = new QName(Constants.SERVICE_URI, Constants.SERVICE_IMPL);
        Service service = Service.create(url, qname);
        DataService dataService = service.getPort(DataService.class);
        return dataService.update(data);
    }

    public String delete(String[] data) throws Exception {
        URL url = URI.create(Constants.WSDL_URL).toURL();
        QName qname = new QName(Constants.SERVICE_URI, Constants.SERVICE_IMPL);
        Service service = Service.create(url, qname);
        DataService dataService = service.getPort(DataService.class);
        return dataService.delete(data);
    }

    public String readById(String[] data) throws MalformedURLException {
        URL url = URI.create(Constants.WSDL_URL).toURL();
        QName qname = new QName(Constants.SERVICE_URI, Constants.SERVICE_IMPL);
        Service service = Service.create(url, qname);
        DataService dataService = service.getPort(DataService.class);
        return dataService.readById(data);
    }

}
