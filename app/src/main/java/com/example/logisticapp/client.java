package com.example.logisticapp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.Socket;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class client {
    private static Socket clientSocket;
    private static BufferedReader in;
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

    public static boolean SignUser(User user) throws IOException, JSONException {
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        JSONObject mamavano = new JSONObject();
        mamavano.put("email", user.getEmail());
        mamavano.put("password", user.getPassword());
        out.write("sign " + mamavano + "\n");
        out.flush();
        String backresult = in.readLine();
        JSONTokener js = new JSONTokener(backresult);
        JSONObject root = new JSONObject(js);
        System.out.println(backresult);
        return root.getBoolean("bool");
    }


}
