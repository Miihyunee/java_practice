package jython;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class Ex02 {
	public static void main(String[] args) {
		PythonInterpreter python = new PythonInterpreter();
		// sys 라는 모듈 불러오기
		python.exec("import sys");
		// print 문장을 실행
		python.exec("print(sys)");
		python.set("a", 100);
		python.exec("print(a)");
		python.exec("x = 2+2");
		PyObject x = python.get("x");
		System.out.println("x : " + x);
		python.close();
	}
}
