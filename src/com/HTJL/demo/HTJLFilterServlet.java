package com.HTJL.demo;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HTJLFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 private String message;

	  public void init() throws ServletException
	  {
	      // Do required initialization
	      message = "Hello World!!";
	  }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HTJLFilterServlet do get................");
		// Set response content type
	      response.setContentType("text/html");

	      // Actual logic goes here.
	      PrintWriter out = response.getWriter();
	      
	     String str=  "	      <html>"
	      + "	      <body>"
	      + "	      <h1>My First Heading</h1>"
	      + "	      <p>My first paragraph.</p>"
	      + "	      <a >This is a link</a>"
	      + "	      </body>"
	      + "	      </html>";
	    
	      out.println(  str );
	      System.out.println(response);
	}

}
