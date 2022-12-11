# UDP

TCP는 Socket 과 ServerSocket 을 사용하지만, UDP소켓 프로그래밍에서는 DatagramSocket 과 DatagramPacket을 사용한다.

앞서 살펴본 바와 같이 UDP는 연결지향적인 프로토콜이 아니다 => ServerSocket이 필요하지 않다.

UDP통신에서 사용하는 소켓은 DatagramSocket이며 데이터를 DatagramPacket에 담아서 전송한다.

DatagramPacket은 헤더와 데이터로 구성되어 있으며, 헤더에는 DatagramPacket을 수신할 호스트의 정보(호스트의 주소와 포트)가 저장되어 있다. 소포(packet)에 수신할 상대편의 주소를 적어서
보내는 것과 같다고 이해.

그래서 DatagramPacket을 전송하면 DatagramPacket에 지정된 주소(호스트의 포트)의 DatagramSocket에 도착
