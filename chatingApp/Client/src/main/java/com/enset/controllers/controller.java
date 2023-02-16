package com.enset.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class controller {
    public TextField userName;
    public TextField userInputMessage;
    public AnchorPane container;
    public TextArea messagesArea;
    public Label wLabel;
    static public Socket clientSocket;
    public void join(ActionEvent actionEvent) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/roomUi.fxml"));
        Label WAlert = (Label) root.getChildren().get(3);
        this.messagesArea = (TextArea) root.getChildren().get(0);
        WAlert.setText("Welcome "+userName.getText());
        // before losing userName save it to onther variable
        if (connect()){
            container.getChildren().setAll(root);
            updateMessages();
        }
    }
    public Boolean connect(){
        try{
            controller.clientSocket
             = new Socket("localhost",2080);
            return clientSocket.isConnected();
        }catch (IOException  e){
            e.getStackTrace();
        }
        return false;
    }

    public void send(ActionEvent actionEvent) {
        String userName = wLabel.getText().split(" ")[1];
        // sending message to the server
        try {
            OutputStream os = clientSocket.getOutputStream();
            PrintWriter pw = new PrintWriter(os,true);
            if(userInputMessage.getText()!=null){
                pw.println("Message by "+userName+" => "+userInputMessage.getText());
            }
        }catch (IOException e){
            e.getStackTrace();
        }
        // add message to the UI
        messagesArea.appendText("Message by "+userName+" => "+userInputMessage.getText()+"\n");
        // clear textField
        userInputMessage.clear();

    }
    public void updateMessages(){
            updateMessagesThread updateThread = new updateMessagesThread();
            updateThread.start();
    }
    class updateMessagesThread extends Thread{
        @Override
        public void run() {
            try{
                InputStream is = clientSocket.getInputStream();
                InputStreamReader insr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(insr);
                while (true){
                    String ReceivedMessage = br.readLine();
                    if (ReceivedMessage!=null){
                        messagesArea.appendText(ReceivedMessage+"\n");
                    }
                }
            }catch (IOException e){
                e.getStackTrace();
            }
        }
    }
}
