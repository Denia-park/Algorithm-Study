소켓 프로그래밍은 소켓을 이용한 통신 프로그래밍을 뜻하는데, 소켓(socket)이란 프로세스간의 통신에 사용되는 양쪽 끝단(endpoint)을 의미한다.
서로 멀리 떨어진 두 사람이 통신하기 위해서 전화기가 필요한 것처럼, 프로세스간의 통신을 위해서는 그 무언가가 필요하고 그것이 바로 소켓이다.

자바에서는 java.net패키지를 통해 소켓 프로그래밍을 지원하는데, 소켓통신에 사용되는 프로토콜에 따라 다른 종류의 소켓을 구현하여 제공한다.
이 단원에서는 TCP 와 UDP를 이용한 소켓프로그래밍에 대해서 학습할 것이다.

TCP/IP 프로토콜은 이기종 시스템간의 통신을 위한 표준 프로토콜로 프로토콜의 집합이다.
TCP와 UDP 모두 TCP/IP 프로토콜(TCP/IP protocol suites)에 포함되어 있으며, OSI 7계층의 전송계층(transport layer)에 해당하는 프로토콜이다.
TCP 와 UDP는 전송 방식이 다르며, 각 방식에 따른 장단점이 있다.

# TCP

- 연결 기반 => 연결 후 통신 (전화기) , 1:1 통신방식
- 데이터의 경계를 구분안함 (byte-stream)
- 신뢰성 있는 데이터 전송
    - 데이터의 전송순서가 보장됨
    - 데이터의 수신여부를 확인함 (데이터가 손실되면 재전송됨)
    - 패킷을 관리할 필요가 없다.
- UDP보다 전송속도가 느림
- 관련 클래스 : Socket, ServerSocket

TCP는 데이터를 전송하기 전에 먼저 상대편과 연결을 한 후에 데이터를 전송하며 잘 전송되었는지 확인하고 전송에 실패했다면 해당 데이터를 재전송하기
때문에 신뢰 있는 데이터의 전송이 요구되는 통신에 적합 => 예를 들면 파일을 주고 받는데 적합

# UDP

- 비연결 기반 => 연결없이 통신 (소포) , 1:1, 1:n, n:n 통신방식
- 데이터의 경계를 구분함 (datagram)
- 신뢰성 없는 데이터 전송
    - 데이터의 전송순서가 바뀔 수 있음
    - 데이터의 수신여부를 확인안함 (데이터가 손실되어도 알 수 없음)
    - 패킷을 관리해주어야 함
- TCP보다 전송속도가 빠름
- 관련 클래스 : DatagramSocket, DatagramPacket, MulticastSocket

UDP는 상대편과 연결하지 않고 데이터를 전송하며, 데이터를 전송하지만 데이터가 바르게 수신되었는지 확인하지 않기
때문에 데이터가 전송되었는지 확인할 길이 없다. 또한 데이터를 보낸 순서대로 수신한다는 보장이 없다.
대신 이러한 확인과정이 없기 때문에 TCP에 비해 빠른 전송이 가능하다. => 게임, 동영상의 데이터를 전송하는 경우와 같이 데이터가 중간에 손실되어 좀 끊기더라도 빠른 전송이 필요할때 적합
이때 전송 순서가 바뀌어 늦게 도착한 데이터는 무시하면 된다.