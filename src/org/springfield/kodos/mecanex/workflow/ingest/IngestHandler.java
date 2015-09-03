package org.springfield.kodos.mecanex.workflow.ingest;

public class IngestHandler {
	
	public static String get(String[] cmds,String[] params) {
		String command = cmds[2];
		System.out.println("MECANEX INGEST HANDLER="+cmds+" "+command+" params="+params);
		if (command.equals("list")) return doList(params);
		return null;
	}
	
	public static String doList(String[] params) {
		return "test list result";
	}
}
