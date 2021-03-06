package usecabeca25;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleChatClientA {
    
    JTextField outgoing;
    PrintWriter writer;
    Socket sock;
    
    
    public void go(){
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        JPanel mainPanel = new JPanel();
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        setUpNetWorking();
        frame.setSize(400,500);
        frame.setVisible(true);
    } //end go
    
    private void setUpNetWorking(){
        try {
            sock = new Socket("127.0.0.1",5000);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("networking established");
        } catch (Exception ex) { ex.printStackTrace();}
    } // fecha setUpNetWorking
    
    public class SendButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            try {
                writer.println(outgoing.getText());
                writer.flush();
            } catch (Exception ex) { ex.printStackTrace(); }
            outgoing.setText("");
            outgoing.requestFocus();
        }
    }
    public static void main(String[] args) {
        new SimpleChatClientA().go();
    }
}
