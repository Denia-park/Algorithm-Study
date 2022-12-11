package Socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {
    public static void main(String[] args) {
        try {
            new UdpClient().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();

        InetAddress serverAddress = InetAddress.getByName("127.0.0.1");

        //데이터가 저장될 공간으로 byte배열을 생성한다.
        byte[] msg = new byte[100];

        DatagramPacket outPacket = new DatagramPacket(msg, 1, serverAddress, 7777);
        DatagramPacket inPacket = new DatagramPacket(msg, msg.length);

        datagramSocket.send(outPacket); // DatagramPacket을 전송
        datagramSocket.receive(inPacket); // DatagramPacket을 수신

        System.out.println("current server time :" + new String(inPacket.getData()));

        datagramSocket.close();
    }
}
