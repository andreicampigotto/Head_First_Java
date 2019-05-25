package usecabeca31;

import java.io.*;
import java.net.*;
import java.util.*;
import usecabeca26.VerySimpleChatServer;

public class MusicServer {

    ArrayList<ObjectOutputStream> clientOutputStream;

    public static void main(String[] args) {
        new MusicServer().go();
    }

    public class ClientHandler implements Runnable {

        ObjectInputStream in;
        Socket cliSocket;

        public ClientHandler(Socket socket) {
            try {
                cliSocket = socket;
                in = new ObjectInputStream(cliSocket.getInputStream());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        public void run() {
            Object o2 = null;
            Object o1 = null;
            try {

                while ((o1 = in.readObject()) != null) {
                    o2 = in.readObject();
                    System.out.println("read two objects");
                    tellEveryone(o1, o2);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }// fecha run
    }

    public void go() {
        clientOutputStream = new ArrayList<ObjectOutputStream>();
        try {
            ServerSocket serverSock = new ServerSocket(4242);

            while (true) {
                Socket clientSocket = serverSock.accept();
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                clientOutputStream.add(out);

                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();
                System.out.println("got a connection");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } // fecha go

    public void tellEveryone(Object one, Object two) {
        Iterator it = clientOutputStream.iterator();

        while (it.hasNext()) {
            try {
                ObjectOutputStream out = (ObjectOutputStream) it.next();
                out.writeObject(one);
                out.writeObject(two);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
}
