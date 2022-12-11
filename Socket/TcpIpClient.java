package Socket;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

// TCP/IP서버(TcpIpServer.java) 와 통신하기 위한 클라이언트 프로그램
// 연결하고자 하는 서버의 IP와 포트번호를 가지고 소켓을 생성하면 자동적으로 서버에 연결요청을 하게 된다.

// 서버프로그램이 실행되고 있지 않거나 서버의 전원이 꺼져있어서 서버와 연결을 실패하면 ConnectException이 발생한다.

// 서버와 연결되면 소켓의 입력스트림을 얻어서 서버가 전송한 데이터를 읽을 수 있다.

public class TcpIpClient {
    public static void main(String[] args) {
        try {
            String serverIp = "127.0.0.1";

            System.out.println("서버에 연결중입니다. 서버 IP : " + serverIp);

            //소켓을 생성하여 연결을 요청한다.
            Socket socket = new Socket(serverIp, 7777);

            //소켓의 입력스트림을 얻는다.
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);

            //소켓으로부터 받은 데이터를 출력한다.
            System.out.println("서버로부터 받은 메시지 : " + dis.readUTF());
            System.out.println("연결을 종료합니다.");

            //스트림과 소켓을 닫는다.
            dis.close();
            socket.close();
            System.out.println("연결이 종료되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
