package com.sellerportal.ism;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anm.jsf.utils.FacesUtils;

public class OctashopFrontController implements Filter {
	public static final long serialVersionUID = 2L;


	public void destroy() {
	}
	
	public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)srequest;
		HttpServletResponse response = (HttpServletResponse)sresponse;
		if(request.getRequestURI().endsWith(".jsp"))
		{
			processRequest(request,response);
			//dispatch(request,response,request.getRequestURI());
		}
	}
	
	public void init(FilterConfig arg0) throws ServletException {
		
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		if(request.getParameter("ajax")!= null){
			String[] beans = request.getParameterValues("beans"); 
			if(beans != null ){
				for (String bean : beans) {
					AutoPopulateBeanHelper.populate(request,FacesUtils.getManagedBean(bean));
				}
			}
		}
	}
	
	
}
