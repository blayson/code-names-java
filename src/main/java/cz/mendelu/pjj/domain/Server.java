package cz.mendelu.pjj.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    private ArrayList<BufferedReader> clientReaders;
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server server = new Server();
    }

    public Server() {
        try {
            this.serverSocket = new ServerSocket(25565);
            this.clientReaders = new ArrayList<BufferedReader>();
            this.listen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        // Accept thread
        Thread acceptThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Socket client = serverSocket.accept();
                        clientReaders.add(new BufferedReader(new InputStreamReader(client.getInputStream())));
                        System.out.println("Client connected.\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        acceptThread.start();
        // Main thread for text print
        while (true) {
            ArrayList<BufferedReader> tempClients = new ArrayList<BufferedReader>(this.clientReaders);
            for (BufferedReader in : tempClients) {
                try {
                    System.out.println(in.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
