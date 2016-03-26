package client;

import config.Config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class EchoClient {
    private Config cfg;

    public EchoClient(Config cfg) {
        this.cfg = cfg;
    }

    public void run() throws IOException {

        try (
                Socket echoSocket = new Socket(cfg.getHostName(), cfg.getPortNumber());
                PrintWriter out =
                        new PrintWriter(echoSocket.getOutputStream(), true);
                BufferedReader in =
                        new BufferedReader(
                                new InputStreamReader(echoSocket.getInputStream()));
                BufferedReader stdIn =
                        new BufferedReader(
                                new InputStreamReader(System.in))
        ) {

            System.out.println("The server waits for messages from the client");
            System.out.println("Write a message and wait for a server response");

            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("echo: " + in.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + cfg.getHostName());
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    cfg.getHostName());
            System.exit(1);
        }
    }
}
