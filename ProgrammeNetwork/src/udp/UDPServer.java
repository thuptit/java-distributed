package udp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author thunv
 */
public class UDPServer {
    public static void main(String[] args) throws SocketException, IOException, ClassNotFoundException {
        
        byte[] receivedData = new byte[1024];
        byte[] sendData = new byte[1024];
        
        DatagramSocket ds = new DatagramSocket(2207);
        
        while(true){
            
            DatagramPacket receivedDp = new DatagramPacket(receivedData, receivedData.length);
            ds.receive(receivedDp);
            String masv = new String(receivedDp.getData());
            System.out.println(masv);
            
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream wObj = new ObjectOutputStream(out);
            Customer839 cus = new Customer839("123", "abc123", "nguyen van thu", "14-10-2000", "nguyen van thu");
            wObj.writeObject(cus);
            out.flush();
            
            byte[] cusByte = out.toByteArray();
            
            DatagramPacket sendDp = new DatagramPacket(cusByte, cusByte.length, receivedDp.getSocketAddress());
            ds.send(sendDp);
            
            receivedDp = new DatagramPacket(receivedData, receivedData.length);
            ds.receive(receivedDp);
            
            ByteArrayInputStream in = new ByteArrayInputStream(receivedDp.getData());
            ObjectInputStream rObj = new ObjectInputStream(in);
            Customer839 cusR = (Customer839) rObj.readObject();
            
            System.out.println(cusR.name + "\n" + cusR.userName + "\n" + cusR.dayOfBirth);
        }
    }
}
