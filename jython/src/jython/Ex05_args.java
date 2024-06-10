package jython;

import java.io.StringWriter;

import org.python.util.PythonInterpreter;

public class Ex05_args {
	public static void main(String[] args) {
		String[] arguments = {"args.py", "11", "22"};
		PythonInterpreter.initialize(System.getProperties(), System.getProperties(), arguments);
		PythonInterpreter python = new PythonInterpreter();
		StringWriter out = new StringWriter();
		python.setOut(out);
		python.execfile("C:/work/args.py");
		
		String result = out.toString();
		System.out.println(result);
		python.close();
	}
}
