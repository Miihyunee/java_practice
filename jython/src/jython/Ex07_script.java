package jython;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Ex07_script {
	public static void main(String[] args) {
		// ScriptEngine : python, javascript, ruby, groovy 등의 다양한 언어 호출 가능
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("python");
		try {
			engine.eval("print('Python - Hello world')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
