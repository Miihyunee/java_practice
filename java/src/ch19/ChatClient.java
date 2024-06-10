package ch19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	public static void main(String[] args) throws Exception {
		Socket socket = null;
		PrintWriter writer = null;
		BufferedReader reader = null;
		try {
			// 2. 접속
			socket = new Socket("192.168.0.31", 5555);// (ip, port);, 서버에 접속
			// 클라이언트가 서버로 보내기
			writer = new PrintWriter(socket.getOutputStream(), true);
			// 서버에서 클라이언트로 보내기
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String receive = "";
		String send;
		Scanner sc = new Scanner(System.in);
		while (true) {
			receive = reader.readLine();// 서버에서 보낸 내용 읽기
			// 5. 서버의 환영메시지 수신
			System.out.println("[server] " + receive);
			if (receive.equals("q"))// q이면
				break;// 종료
			System.out.println("input(quit:q): ");
			send = sc.nextLine();// 키보드 입력
			// 6. 클라이언트에서 서버로 답신
			if (send.equals("q")) {// q이면
				break;// 종료
			}
			if (send != null) {// null이 아니면
				writer.println(send);// 클라이언트에서 서버로 전송
			}
		}
		sc.close();
		writer.close();
		reader.close();
		socket.close();
	}
}
