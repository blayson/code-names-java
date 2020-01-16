package cz.mendelu.pjj.domain;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

    private Socket clientSocket;

    public static void main(String[] args) {
        Client client = new Client();
    }

    Client() {
        try {
            this.clientSocket = new Socket("localhost", 25565);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(this.clientSocket.getOutputStream()));
            int counter = 1;
            while (true) {
                String temp = "This is " + counter + " message..";
                System.out.println(temp);
                out.write(temp + "\r\n");
                out.flush();
                counter++;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
