package ch19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = null;
		try {// 시도
				// 1. 서비스 개시
				// serverSocket : 서비스제공 소켓
			serverSocket = new ServerSocket(5555); // 포트번호
			System.out.println("Started...");
		} catch (Exception e) {// 예외발생
			e.printStackTrace();
			System.out.println("error...");
			System.exit(1);// 프로그램 비정상 종료
		}
		Socket clientSocket = null;
		try {// 시도
				// 3. 접속허가
				// 대기중 상태였다가 사용자가 접속하면 허가하여 통신회선 연결
			clientSocket = serverSocket.accept();
			System.out.println("client's ip " + clientSocket.getInetAddress().getHostAddress());
		} catch (Exception e) {// 예외발생
			e.printStackTrace();
		}
		// 서버에서 클라이언트로 보내는 출력기능
		PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
		// 클라이언트에서 서버로 읽어오기
		BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		String receive = "";
		String send = "Welcome!!!";
		writer.println(send);
		// 4. 환영메시지 보냄
		Scanner sc = new Scanner(System.in);
		while (true) {// 무한반복
			receive = reader.readLine();// 한줄읽기
			// 7. 클라이언트 메시지 수신
			if (receive == null || receive.equals("q")) {// null이거나 q이면
				break;// 종료
			}
			System.out.println("[client] " + receive);
			System.out.println("input(quir:q): ");
			send = sc.nextLine();// 서버에서 클라이언트로 보낼 메시지
			// 8. 서버에서 클라이언트로 발송
			writer.println(send);// 전송
			if (send.equals("q")) {// q이면
				break;// 종료
			}
		}
		// 종료
		sc.close();
		writer.close();
		reader.close();
		clientSocket.close();
		serverSocket.close();
	}
}
