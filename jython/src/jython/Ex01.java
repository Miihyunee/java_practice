package jython;

import org.python.core.PyInteger;
import org.python.util.PythonInterpreter;

public class Ex01 {
	public static void main(String[] args) {
		PythonInterpreter python = new PythonInterpreter();
		python.set("a", 12);
		python.exec("square = a*a");
		PyInteger square = (PyInteger) python.get("square");
		System.out.println("square : " + square.asInt());
		python.close();
	}
}
