package server.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

    @WebService
    @SOAPBinding(style = SOAPBinding.Style.RPC)
    public interface DataService {

        @WebMethod
        String create(String[] data);

        @WebMethod
        String read();

        @WebMethod
        String update(String[] data);

        @WebMethod
        String delete(String[] data);

        @WebMethod
        String readById(String[] data);

    }
