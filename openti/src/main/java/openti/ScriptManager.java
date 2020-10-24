package openti;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JOptionPane;

public abstract class ScriptManager {

	public ScriptManager() {

	}
	
	public void test() {
		//ScriptManager es = new ScriptManager();
        // create a script engine manager
		ScriptManager sb = this;
        ScriptEngineManager factory = new ScriptEngineManager();
        // create a JavaScript engine
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        // evaluate JavaScript code from String
  //     engine.eval("println('Welcome to Java world')");

        // add the Java object into the engine.
        engine.put("sb",sb);

        ScriptEngineFactory sef = engine.getFactory();
        String s = sef.getMethodCallSyntax("sb", "request('AAAA')", new String[0]);
        // show the correct way to call the Java method
        System.out.println(s);
        try {
			engine.eval(s);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void test2() {
		File script = new File("C:\\Users\\miyak\\git\\openti\\openti\\target\\javascript.js");

		try {
			Reader reader = new FileReader(script);
			ScriptManager sb = this;
	        ScriptEngineManager factory = new ScriptEngineManager();
	        // create a JavaScript engine
	        ScriptEngine engine = factory.getEngineByName("JavaScript");
	        engine.put("sb",sb);
	        try {
				engine.eval(reader);
			} catch (ScriptException e) {
				e.printStackTrace();
			}
	        
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
    abstract public void write(String addr, String command);
    
    abstract public  String read(String addr, String query);
    
    public void sleep(int millisecond) {
    	try {
			Thread.sleep(millisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    abstract public   void log(String arg);
    
    public void request(String arg){
        System.out.println(arg);
    }
    
    abstract public void message(String message);
}
