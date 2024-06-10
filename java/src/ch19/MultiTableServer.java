package ch19;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class MultiTableServer implements Runnable {// Runnable 을 통해 Thread 활용
	// 필드변수(프로퍼티변수) : 함수 밖에 선언, 클래스 전체에서 사용 가능
	private ServerSocket serverSocket;// 서비스제공 소켓
	private Socket socket;// 데이터통신용 소켓
	private DataInputStream dis;
	private DataOutputStream dos;

	public MultiTableServer() {// 생성자 실행
		try {
			// 서버소켓 - 서비스제공(포트번호);
			serverSocket = new ServerSocket(8080);
			System.out.println("Started...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		while (true) {// 무한반복
			try {
				// 클라이언트 접속 허가
				socket = serverSocket.accept();

				InetAddress ip = socket.getInetAddress();
				System.out.println("client's ip " + ip);
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
				Thread th = new Thread(this);// 동시작업을 위해 Thread 생성
				th.start();// 스레드 시작, run() 실행
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {// 메인
		new MultiTableServer(); // 인스턴스화, 생성자 호출
	}

	@Override
	public void run() {
		try {
			while (true) {// 무한반복
				int table = dis.readInt();// 클라이언트 입력값(정수로)
				System.out.println("계산결과 : " + table);
				// StringBuilder : String을 편집할 때 사용
				StringBuilder sb = new StringBuilder();
				for (int i = 1; i <= 9; i++) {
					sb.append(table + "x" + i + "=" + table * i + "\r\n");
				}
				// 클라이언트에 결과 전송
				dos.writeUTF(sb.toString());
				System.out.println(sb.toString());
			}
		} catch (SocketException e) {
			System.out.println("클라이언트의 연결이 끊어졌습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
