/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;

/**
 *
 * @author thunv
 */
public class ClientTest {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket client = new Socket(InetAddress.getByName("localhost"), 2207);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        String hello = "hello server";
        out.write(hello);
        out.newLine();
        out.flush();
        System.out.println(in.readLine());
        out.close();
        in.close();
        client.close();
    }
}
