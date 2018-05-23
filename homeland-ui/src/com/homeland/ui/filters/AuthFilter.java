package com.homeland.ui.filters;

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
import javax.servlet.http.HttpSession;

import com.homeland.ui.beans.LoginBean;


@WebFilter(filterName = "AuthFilter", urlPatterns = {"/*"})
public class AuthFilter implements Filter 
{



    public AuthFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {

            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            HttpSession ses = req.getSession(false);

            String loginURL = req.getContextPath() + "/login";
            String landingURL = req.getContextPath() + "/landing";
            boolean ajaxRequest = "partial/ajax".equals(req.getHeader("Faces-Request"));

            String reqURI = req.getRequestURI();
            if ( reqURI.equals(loginURL)
            		|| isValidUserToken(ses)
                    || reqURI.contains("/public/")
                    || reqURI.contains("javax.faces.resource")
                    || reqURI.equals(landingURL)) {
                chain.doFilter(request, response);
            } else if (ajaxRequest) {
                response.setContentType("text/xml");
                response.setCharacterEncoding("UTF-8");
                response.getWriter()
                        .append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
                        .append("<partial-response>")
                        .printf("<redirect url=\"%s\"></redirect>", loginURL)
                        .append("</partial-response>");
            } else {
                res.sendRedirect(loginURL);
            }

        } catch (Throwable t) {
            System.out.println("ERROR FILTER " + t.getMessage());
        }
    } //doFilter

    private boolean isValidUserToken(HttpSession ses) {
        if (ses != null) 
        {
        		LoginBean login = (LoginBean) ses.getAttribute("loginBean");
        		return (login != null && login.getUserToken() != null && login.getUserToken().getToken() != null);       	
        }
        return false;
    }

    @Override
    public void destroy() {

    }
}