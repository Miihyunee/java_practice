package jython;

import org.python.core.PyList;
import org.python.util.PythonInterpreter;

public class Ex03_list {
	public static void main(String[] args) {
		PythonInterpreter python = new PythonInterpreter();
		python.exec("numbers=list(range(1,6))");
		PyList x = (PyList) python.get("numbers");
		System.out.println("list : " + x);
		System.out.println("size : " + x.size());
		for (int i = 0; i < x.size(); i++) {
			System.out.println(x.get(i));
		}
		python.close();
	}
}
