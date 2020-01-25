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
        server.listen();
    }

    public Server(Integer port) {
        if (port == null) {
            port = 25565;
            System.out.println("Set default port: 25565");
        }
        try {
            this.serverSocket = new ServerSocket(port);
            this.clientReaders = new ArrayList<BufferedReader>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Server() {
        this(25565);
        System.out.println("Set default port: 25565");
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
