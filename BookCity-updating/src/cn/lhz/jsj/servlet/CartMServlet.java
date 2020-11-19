package cn.lhz.jsj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.lhz.jsj.dao.IBookCityM;
import cn.lhz.jsj.dao.IBookCityMImpl;
import cn.lhz.jsj.javabean.Cart;
import cn.lhz.jsj.javabean.TBook;

/**
 * Servlet implementation class CartMServlet
 */
@WebServlet("/CartMServlet")
public class CartMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IBookCityM ibcm = new IBookCityMImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartMServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String type = request.getParameter("type");
		
		if(type==null) {
			PrintWriter out = response.getWriter();
			out.println("无效访问！");
		}else if(type.equals("bookMCart")) {
			BookMCart(request,response);
		}else if(type.equals("choose")) {
			ChooseBook(request,response);
		}
	}

	private void ChooseBook(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String bookId = request.getParameter("choosebookid");
		String bookNum = request.getParameter("choosebooknum");
		TBook tbook = new TBook();
		Cart tcart = new Cart();
		HttpSession session = request.getSession();
		tbook.setBookId(bookId);
		List<TBook> chosenBook = new ArrayList<TBook>();
		try {
			if(ibcm.queryBook(tbook)!=null) {
				chosenBook = ibcm.queryBook(tbook);
				tcart.setBookId(chosenBook.get(0).getBookId());
				//System.out.println(tcart.getBookId());
				tcart.setBookName(chosenBook.get(0).getBookName());
				//System.out.println(tcart.getBookName());
				tcart.setBookPrice(chosenBook.get(0).getBookPrice());
				tcart.setBookStock(bookNum);
				tcart.setBookType(chosenBook.get(0).getBookType());
				session.setAttribute("cart", tcart);
				response.sendRedirect("cart.jsp");
			}else {
				response.getWriter().print("<script>alert('您所选的图书不存在，请重新选择');"
						+ "window.location.href='chooseBook.jsp'</script>");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	private void BookMCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String[] bookId = request.getParameterValues("buybook");
		HttpSession session = request.getSession();
		TBook tbook = new TBook();
		if(bookId!=null) {
			List<TBook> cart = new ArrayList<TBook>();
			for(int i = 0;i<bookId.length;i++) {
				tbook.setBookId(bookId[i]);
				if(ibcm.queryBook(tbook)!=null) {
					cart = ibcm.queryBook(tbook);
					System.out.println("cart不为空");	
					
				}
				else {
					System.out.println("图书为空");
				}
				
			}
			session.setAttribute("cart", cart);
			response.sendRedirect(request.getContextPath()+"/cart.jsp");
		}else {
			session.setAttribute("cart", "您还没有选购图书");
			try {
				response.sendRedirect("cart.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
