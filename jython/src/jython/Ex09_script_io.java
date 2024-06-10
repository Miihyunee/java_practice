package jython;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Ex09_script_io {
	public static void main(String[] args) throws Exception {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("python");
		engine.eval("import sys");
		engine.eval("print(sys)");
		engine.put("a", 153);
		engine.eval("print(a)");
		engine.eval("x=3+4");
		// Object c = engine.get("x");
		int x = Integer.parseInt(engine.get("x").toString());
		System.out.println("x : " + x);;
	}
}