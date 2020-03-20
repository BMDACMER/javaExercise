package java01;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Code_013_JavaScript {
    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine engine = scriptEngineManager.getEngineByName("JavaScript");
        System.out.println(engine.getClass().getName());  // jdk.nashorn.api.scripting.NashornScriptEngine
        System.out.println(engine.eval("function f() {return 'Hello ';};f()+'world!';"));  // Hello world!
    }
}
