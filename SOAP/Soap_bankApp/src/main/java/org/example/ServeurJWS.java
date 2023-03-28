package org.example;

import jakarta.xml.ws.Endpoint;
import org.example.ws.BanqueService;

public class ServeurJWS {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9191/",new BanqueService());
        System.out.println("server is running at http://localhost:9191/");
    }
}