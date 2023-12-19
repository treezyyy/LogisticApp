package com.example.logisticapp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.Socket;

import org.json.JSONException;
import org.json.JSONObject;

public class client {
    private static Socket clientSocket;
    private static BufferedWriter out;
    public static void Connect() throws IOException {
        clientSocket = new Socket("192.168.0.104", 8080);
    }
    public static void RegisterUser(User user) throws IOException, JSONException {
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        JSONObject mamavano = new JSONObject();
        mamavano.put("name", user.getName());
        mamavano.put("email", user.getEmail());
        mamavano.put("password", user.getPassword());
        out.write("register " + mamavano + "\n");
        out.flush();
    }

}
