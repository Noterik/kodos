package org.springfield.kodos.mecanex.workflow.annotations;

public class AnnotationHandler {
	public static String get(String[] cmds,String[] params) {
		String command = cmds[2];
		//System.out.println("MECANEX ANNOTATION HANDLER="+cmds+" "+command+" params="+params);
		if (command.equals("list")) return doList(params);
		return null;
	}
	
	public static String put(String[] cmds,String[] params,String value) {
		String command = cmds[2];
		//System.out.println("MECANEX ANNOTATION HANDLER="+cmds+" "+command+" params="+params);
		if (command.equals("start")) return doStart(params,value);
		return null;
	}
	
	public static String doList(String[] params) {
		return "test list result";
	}
	
	public static String doStart(String[] params,String value) {
		System.out.println("MECANEX ANNOTATION PUT START CALLED "+value);
		return null;
	}
	
}
