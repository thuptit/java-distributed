/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import UDP.Product937;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author thunv
 */
public class udp {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException, ClassNotFoundException {
        String masv = "B18DCCN655;839";
        byte[] dataSend = masv.getBytes();
        byte[] dataReceived = new byte[1024];
        
        DatagramSocket socket = new DatagramSocket();
        
        DatagramPacket sendPk = new DatagramPacket(dataSend, dataSend.length, InetAddress.getByName("localhost"), 2209);
        socket.send(sendPk);
        
        DatagramPacket receivedPk = new DatagramPacket(dataReceived, dataReceived.length); 
        socket.receive(receivedPk);
        
        ByteArrayInputStream in = new ByteArrayInputStream(receivedPk.getData());
        ObjectInputStream rObj = new ObjectInputStream(in);
        Product937 pro = (Product937) rObj.readObject();
        
        String[] listName = pro.getName().split(" ");
//        String[] dateOfCus = cus.dayOfBirth.split("-");
//        String[] listUsername = cus.userName.split(" ");
//        StringBuilder results = new StringBuilder();
//        
//        //xu ly y a
//        results.append(listName[listName.length-1].toUpperCase()+", ");
//        for(int i = 0 ; i < listName.length ; i++){
//            results.append(listName[i].substring(0,1).toUpperCase() + listName[i].substring(1) + " ");
//        }
//        cus.name = results.deleteCharAt(results.length()-1).toString();
//        results = new StringBuilder();
//        
//        //xu ly y b
//        for(String str: dateOfCus){
//            results.append(str+"/");
//        }
//        cus.dayOfBirth = results.deleteCharAt(results.length()-1).toString();
//        results = new StringBuilder();
//        
//        //xu ly y c
//        for(int i = 0; i < listUsername.length - 1; i++){
//            results.append(listUsername[i].charAt(0)+"");
//        }
//        results.append(listUsername[listUsername.length - 1]);
//        cus.userName = results.toString();
//        
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        ObjectOutputStream wObj = new ObjectOutputStream(out);
//        wObj.writeObject(cus);
//        
//        sendPk = new DatagramPacket(out.toByteArray(), out.toByteArray().length, InetAddress.getByName("localhost"), 2207);
//        socket.send(sendPk);
        
        //in.close();
        //rObj.close();
        socket.close();
    }
}
