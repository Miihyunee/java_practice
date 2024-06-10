package jython;

import java.io.FileReader;
import java.io.StringWriter;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleScriptContext;

public class Ex08_script_sum {
	public static void main(String[] args) throws Exception{
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptContext context = new SimpleScriptContext();
		
		// 출력 방향 설정
		StringWriter writer = new StringWriter();
		context.setWriter(writer);
		ScriptEngine engine = manager.getEngineByName("python");
		engine.eval(new FileReader("C:/work/sum.py"), context);
		System.out.println(writer.toString());
	}
}
