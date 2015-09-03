package org.springfield.kodos.mecanex.workflow;

import org.springfield.kodos.mecanex.workflow.annotations.AnnotationHandler;
import org.springfield.kodos.mecanex.workflow.editorial.EditorialHandler;
import org.springfield.kodos.mecanex.workflow.enrichments.EnrichmentsHandler;
import org.springfield.kodos.mecanex.workflow.home.Homehandler;
import org.springfield.kodos.mecanex.workflow.ingest.IngestHandler;

public class MecanexHandler {
	
	public static String get(String[] cmds,String[] params) {
		String flowstep = cmds[1];
		//System.out.println("MECANEX GET HANDLER="+cmds+" "+flowstep+" params="+params);
		if (flowstep.equals("home")) return Homehandler.get(cmds,params);
		if (flowstep.equals("ingest")) return IngestHandler.get(cmds,params);
		if (flowstep.equals("editorial")) return EditorialHandler.get(cmds,params);
		if (flowstep.equals("enrichments")) return EnrichmentsHandler.get(cmds,params);
		if (flowstep.equals("annotation")) return AnnotationHandler.get(cmds,params);
		return null;
	}
	
	public static String put(String[] cmds,String[] params,String value) {
		String flowstep = cmds[1];
		//System.out.println("MECANEX PUT HANDLER="+cmds+" "+flowstep+" params="+params);
		if (flowstep.equals("home")) return Homehandler.put(cmds,params,value);
		if (flowstep.equals("ingest")) return IngestHandler.put(cmds,params,value);
		if (flowstep.equals("editorial")) return EditorialHandler.put(cmds,params,value);
		if (flowstep.equals("enrichments")) return EnrichmentsHandler.put(cmds,params,value);
		if (flowstep.equals("annotation")) return AnnotationHandler.put(cmds,params,value);
		return null;
	}
}
