package org.springfield.kodos.mecanex.workflow.home;

public class Homehandler {
	
	
	public static String get(String[] cmds,String[] params) {
		String command = cmds[2];
		System.out.println("MECANEX HOME HANDLER="+cmds+" "+command+" params="+params);
		if (command.equals("list")) return doList(params);
		return null;
	}
	
	public static String doList(String[] params) {
		return "test list result";
	}
}
