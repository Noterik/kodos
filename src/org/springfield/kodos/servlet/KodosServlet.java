/* 
* LazyHomer.java
* 
* Copyright (c) 2012 Noterik B.V.
* 
* This file is part of kodos, related to the Noterik Springfield project.
*
* kodos is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* kodos is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with Lou.  If not, see <http://www.gnu.org/licenses/>.
*/
package org.springfield.kodos.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import org.springfield.kodos.*;
import org.springfield.kodos.homer.*;
import org.apache.log4j.Logger;


/**
 * Servlet implementation class ServletResource
 * 
 * @author Daniel Ockeloen
 * @copyright Copyright: Noterik B.V. 2012
 * @package org.springfield.lou.servlet
 */
//@WebServlet("/KodosServlet")
public class KodosServlet extends HttpServlet {
	
	private static final Logger logger = Logger.getLogger(KodosServlet.class);


    /**
     * @see HttpServlet#HttpServlet()
     */
    public KodosServlet() {
        super();
        System.out.println("kodos servlet object created 2");
		LazyHomer lh = new LazyHomer();
        System.out.println("kodos servlet object created 3 = "+lh);  
        lh.init("/");
        System.out.println("kodos servlet object created 4");
    }
    

}
