package com.enset;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class serverMultiThreads {
    static public ArrayList<user> usersList = new ArrayList<>();
    static public int numberOfclients=0;
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(2080);
            System.out.println("server is started at");
            System.out.println("waiting for clients...");
            while (true){
                Socket cs = ss.accept();
                numberOfclients++;
                // adding new users to the list
                usersList.add(new user(numberOfclients,cs));

                // user Thread
                Thread thread1 = new Thread(new Runnable() {
                    @Override
                    public void run(){
                        System.out.println("@ :"+cs.getLocalSocketAddress().toString()+" CLient num "+numberOfclients);
                        try{
                            // Reading user value
                            InputStream is = cs.getInputStream();
                            InputStreamReader isr = new InputStreamReader(is);
                            BufferedReader br = new BufferedReader(isr);
                            // Sending Response to the client
                            OutputStream os = cs.getOutputStream();
                            PrintWriter pw = new PrintWriter(os,true);
                            pw.println("Number of clients connected : "+numberOfclients);
                            while (true){
                                String userInput = br.readLine();
                                if(userInput!=null){
                                    Broadcast(userInput,cs);
                                }
                            }

                        }catch (IOException e){
                            e.getStackTrace();
                        }

                    }
                });
                thread1.start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void Broadcast(String toSend,Socket from){
        usersList.forEach(user->{
            if(user.getUserSocket()!=from){
                try{
                    OutputStream os = user.getUserSocket().getOutputStream();
                    PrintWriter pw = new PrintWriter(os,true);
                    if (toSend.contains("=>")){
                        pw.println(toSend);
                    }else {
                        String withSender = "Message by client "+user.getUserId()+" => "+ toSend;
                        pw.println(withSender);
                    }

                }catch (IOException e){
                    e.getStackTrace();
                }
            }
        });
    }
    static public class user {
        private int userId;
        private Socket userSocket;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public user(int userId, Socket userSocket) {
            this.userId = userId;
            this.userSocket = userSocket;
        }

        public Socket getUserSocket() {
            return userSocket;
        }

        public void setUserSocket(Socket userSocket) {
            this.userSocket = userSocket;
        }
    }
}
