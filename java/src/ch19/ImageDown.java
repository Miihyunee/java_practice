package ch19;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class ImageDown {
	public static void main(String[] args) throws Exception {
		String img = "https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__340.jpg";
		URL url = new URL(img);
		// 바이트 배열 				버퍼사이즈
		byte[] buffer = new byte[4096];
		// 읽어올 때
		InputStream in = url.openStream();
		// 저장할 때
		OutputStream out = new FileOutputStream("c:/data/pic.jpg");
		int length = 0;// 바이트 수
		while ((length = in.read(buffer)) != -1) {// 조건식이 참이면 무한 반복
			System.out.println(length + " byte 읽음");
			out.write(buffer, 0, length);// 파일에 저장(버퍼, offset, 사이즈);
		}
		System.out.println("완료되었습니다.");
	}
}
