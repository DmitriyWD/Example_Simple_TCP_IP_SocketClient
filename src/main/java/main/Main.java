package main;

import client.EchoClient;
import config.Config;

import java.io.IOException;

/**
 * Created by Admin on 26.03.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        Config cfg = new Config("localhost", 8080);
        EchoClient client = new EchoClient(cfg);

        client.run();
    }
}
