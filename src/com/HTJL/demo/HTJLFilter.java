package com.HTJL.demo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.json.XML;

import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;
 



/**
 * Servlet Filter implementation class HTJLFilter
 */
@WebFilter("/HTJLFilter")
public class HTJLFilter implements Filter {
	

	protected FilterConfig config;
	  public void init(FilterConfig config) throws ServletException {
	    this.config = config;
	  }

	  public void destroy() {
	  }

	  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	      throws ServletException, IOException {
	    ServletResponse newResponse = response;

	    if (request instanceof HttpServletRequest) {
	      newResponse = new CharResponseWrapper((HttpServletResponse) response);
	    }

	    chain.doFilter(request, newResponse);

	    if (newResponse instanceof CharResponseWrapper) {
	      String text = newResponse.toString();
	      if (text != null) {
	        text = text.toUpperCase();
	       // response.getWriter().write(text);
	        XML XMl = new XML();
	        System.out.println("==============================");
	        JSONObject htmlStr = XMl.toJSONObject(text);
	        System.out.println( htmlStr);
	        System.out.println("==============================");
	        response.getWriter().write(htmlStr.toString());
	        XMLSerializer xmlSerializer = new XMLSerializer();
	        JSON json = xmlSerializer.read( text );
	        System.out.println( json.toString(2) );
	      }
	    }
	  }
	}