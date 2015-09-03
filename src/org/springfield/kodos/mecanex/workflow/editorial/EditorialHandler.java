package org.springfield.kodos.mecanex.workflow.editorial;

public class EditorialHandler {
	
	public static String get(String[] cmds,String[] params) {
		String command = cmds[2];
		System.out.println("MECANEX EDITORIAL HANDLER="+cmds+" "+command+" params="+params);
		if (command.equals("list")) return doList(params);
		return null;
	}
	
	public static String doList(String[] params) {
		return "test list result";
	}
}
