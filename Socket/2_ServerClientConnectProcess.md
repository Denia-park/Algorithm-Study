# 서버와 클라이언트의 연결과정

1. 서버프로그램을 실행한다. (TcpIpServer.java)
2. 서버 소켓을 생성한다. (serverSocket = new serverSocket(7777)); // TcpIpServer.java
3. 서버소켓이 클라이언트 프로그램의 연결요청을 처리할 수 있도록 대기상태로 만든다.
   클라이언트 프로그램의 연결요청이 오면 새로운 소켓을 생성해서 클라이언트 프로그램의 소켓과 연결한다.
   (Socket socket = serverSocket.accept();)
4. 클라이언트 프로그램 (TcpIpClient.java)에서 소켓을 생성하여 서버소켓에 연결을 요청한다.
   (Socket socket = new Socket("Ip",Port);)
5. 서버소켓은 클라이언트 프로그램의 연결요청을 받아 새로운 소켓을 생성하여 클라이언트 프로그램의 소켓과 연결한다.
   (Socket socket = serverSocket.accept();)
