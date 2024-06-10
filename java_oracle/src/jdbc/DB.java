package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DB {
	public static Connection oraConn() {// static : 처음부터 실행(메모리에 올라감)
		Connection conn = null;
		try {
			// FileInputStream : 파일 내용을 1byte씩 읽어오는 클래스
			FileInputStream fis = new FileInputStream("c:/work/oracle.prop");
			// Properties : 파일의 내용을 가져와서 읽기, key=value 의 형식으로 읽어오기 가능
			Properties prop = new Properties();
			prop.load(fis);
			String url = prop.getProperty("url"); // key가 url인 값을 찾아오기
			String id = prop.getProperty("id");
			String password = prop.getProperty("password");
			conn = DriverManager.getConnection(url, id, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn; // 접속정보 리턴
	}
}
