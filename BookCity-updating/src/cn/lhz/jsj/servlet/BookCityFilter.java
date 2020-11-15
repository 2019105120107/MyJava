package cn.lhz.jsj.servlet;

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

/**
 * Servlet Filter implementation class BookCityFilter
 */
@WebFilter({"/BookCityFilter","/bookAdd.jsp","/bookDel.jsp","/bookM.jsp","/bookMessage.jsp","/bookMessage2.jsp",
	"/bookMessage3.jsp","/bookQuery.jsp","/bookUpdate.jsp","/cart.jsp","/downloadSell.jsp","/list.jsp","/selBook_type.jsp","/selBook_name.jsp",
	"/selBook.jsp","/sellM.jsp","/updatePwd.jsp","/welcomeC.jsp","/welcomeM.jsp"})
public class BookCityFilter implements Filter {

    /**
     * Default constructor. 
     */
    public BookCityFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//À¹½Ø
		HttpServletRequest  request2 = (HttpServletRequest)request;
		HttpSession session = request2.getSession();
		if(session.getAttribute("userinfo")!=null||session.getAttribute("admininfo")!=null){
			//·ÅÐÐ
			chain.doFilter(request, response);
		}else {
			((HttpServletResponse)response).sendRedirect("login.jsp");
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
