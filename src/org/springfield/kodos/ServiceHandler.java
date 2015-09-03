/* 
* ServiceHandler.java
* 
* Copyright (c) 2014 Noterik B.V.
* 
* This file is part of kodos, related to the Noterik Springfield project.
*
* Kodos is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* Kodos is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with Kodos.  If not, see <http://www.gnu.org/licenses/>.
*/
package org.springfield.kodos;


import java.util.Date;
import java.util.HashMap;
import java.math.BigInteger;
import java.security.SecureRandom;

import org.springfield.fs.Fs;
import org.springfield.fs.FsNode;
import org.springfield.kodos.homer.*;
import org.springfield.kodos.mecanex.workflow.MecanexHandler;
import org.springfield.mojo.interfaces.*;

public class ServiceHandler implements ServiceInterface {

	private static ServiceHandler instance;
	private static String spw = null;
	private static HashMap<String,String> spws = new HashMap<String,String>();
	
	public String getName() {
		return "kodos";
	}
	
	public ServiceHandler() {
		  System.out.println("KODOS SERVICE HANDLER STARTED");
	}
	
	public static ServiceHandler instance() {
		if (instance==null) {
			instance = new ServiceHandler();
			ServiceManager.setService(instance);
		}
		return instance;
	}
	
	public String get(String uri,String fsxml,String mimetype) {
		//System.out.println("KODOS GET="+uri);
		int pos = uri.indexOf("(");
		if (pos!=-1) {
			String command = uri.substring(0,pos);
			String values = uri.substring(pos+1);
			values = values.substring(0,values.length()-1);
			String[] params = values.split(",");
			//System.out.println("GET COMMAND="+command+" VALUES="+values);
			return handleGetCommand(command,params);
		}
		return null;
	}
	
	public String put(String uri,String value,String mimetype) {
		System.out.println("KODOS PUT="+uri);
		int pos = uri.indexOf("(");
		if (pos!=-1) {
			String command = uri.substring(0,pos);
			String values = uri.substring(pos+1);
			values = values.substring(0,values.length()-1);
			String[] params = values.split(",");
			System.out.println("PUT COMMAND="+command+" PARAMS="+values+" MIMETYPE="+mimetype+" VALUE="+value);
			return handlePutCommand(command,params,value);
		}
		return null;
	}
	
	private String handlePutCommand(String command,String[] params,String value) {
		String[] cmds = command.substring(1).split("/");
		String project = cmds[0];
		if (project.equals("mecanex")) return MecanexHandler.put(cmds,params,value);
		return null;
	}
	
	private String handleGetCommand(String command,String[] params) {
		//  /mecanex/home/list
		String[] cmds = command.substring(1).split("/");
		String project = cmds[0];
		if (project.equals("mecanex")) return MecanexHandler.get(cmds,params);
		return null;
	}
	

	public String delete(String uri,String fsxml,String mimetype) {
		return null;
	}
	
	public String post(String uri,String fsxml,String mimetype) {
		return null;
	}
	
	public void sendAuth() {
		LazyHomer.send("PAUTH",LazyHomer.myip+","+spw);
	}
	
	public void setServiceAuth(String a) {
		String[] params = a.split(",");
		spws.put(params[0],params[1]);
	}
	
	private String getServiceAuth(String ipnumber) {
		spws.remove(ipnumber); // zap the old one
		LazyHomer.send("AUTH", ipnumber);
		for (int i=0;i<20;i++) {
			try {
				Thread.sleep(100);
			} catch(Exception e) {
				e.printStackTrace();
			}
			String cpws = spws.get(ipnumber);
			if (cpws!=null) {
				return cpws;
			}
		}
		return null;
	}
 	
    
	
}
