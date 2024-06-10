package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DB {
	// static : 프로그램 시작할 때부터 메모리에 올라감(new 없이 사용 가능)
	public static Connection dbConn() {
		Connection conn = null;// DB 접속
		try {
			// 파일을 1byte씩 읽어오기
			FileInputStream fis = new FileInputStream("c:/work/db.prop");
			// 파일의 데이터를 key = value 형식으로 읽어오기
			Properties prop = new Properties();
			prop.load(fis);
			String url = prop.getProperty("url");
			String id = prop.getProperty("id");
			String password = prop.getProperty("password");
			conn = DriverManager.getConnection(url, id, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
