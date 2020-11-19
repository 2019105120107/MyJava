package cn.lhz.jsj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.lhz.jsj.dao.IBookCityM;
import cn.lhz.jsj.dao.IBookCityMImpl;
import cn.lhz.jsj.javabean.TAdmin;
import cn.lhz.jsj.javabean.TBook;
import cn.lhz.jsj.javabean.TUser;

/**
 * Servlet implementation class BookMServlet
 */
@WebServlet("/BookMServlet")
public class BookMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IBookCityM ibcm = new IBookCityMImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookMServlet() {
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
		}else if(type.equals("loginM")) {
			LoginM(request,response);
		}else if(type.equals("login")) {
			Login(request,response);
		}else if(type.equals("register")) {
			Register(request,response);
		}else if(type.equals("update")) {
			Update(request,response);
		}else if(type.equals("selBook_type")) {
			SelBook_type(request,response);
		}else if(type.equals("selBook_name")) {
			SelBook_name(request,response);
		}else if(type.equals("bookAdd")) {
			BookAdd(request,response);
		}else if(type.equals("bookDel")) {
			BookDel(request,response);
		}else if(type.equals("bookUpdate")) {
			BookUpdate(request,response);
		}else if(type.equals("bookQuery")) {
			BookQuery(request,response);
		}
	}

	private void LoginM(HttpServletRequest request, HttpServletResponse response) {
		String adAccount = request.getParameter("adaccount");
		String adPassword = request.getParameter("adpassword");
		TAdmin tadmin = new TAdmin();
		tadmin.setAdAccount(adAccount);
		tadmin.setAdPassword(adPassword);
		try {
			if(ibcm.adminVaild(tadmin)) {
				System.out.println("管理员登录成功");
				HttpSession session = request.getSession();
				session.setAttribute("admininfo",tadmin);
				response.sendRedirect("welcomeM.jsp");
			}else {
				response.getWriter().print("<script>alert('登录失败');"
						+ "window.location.href='loginM.jsp'</script>");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void BookQuery(HttpServletRequest request, HttpServletResponse response) {
		String bookid = request.getParameter("bookid");
		TBook tbook = new TBook();
		tbook.setBookId(bookid);
		try {
			if(ibcm.queryBook(tbook)!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("bookqueryinfo", tbook);
				response.sendRedirect("bookMessage.jsp");
			}else {
				response.getWriter().print("<script>alert('查询图书失败，请重新输入');"
						+ "window.location.href='bookQuery.jsp'</script>");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void BookUpdate(HttpServletRequest request, HttpServletResponse response) {
		String bookadd = request.getParameter("bookadd");
		String bookcut = request.getParameter("bookcut");
		String bookid = request.getParameter("bookid");
		TBook tbook = new TBook();
		if("请输入增加后图书的数量".equals(bookadd)) {
			if(!"请输入减少后图书的数量".equals(bookcut)) {
				tbook.setBookId(bookid);
				tbook.setBookStock(bookcut);
				try {
					if(ibcm.updateBook(tbook)) {
						response.getWriter().print("<script>alert('修改图书数量成功');"
								+ "window.location.href='welcomeM.jsp'</script>");
					}else {
						response.getWriter().print("<script>alert('修改图书数量失败，请重新输入');"
								+ "window.location.href='bookUpdate.jsp'</script>");
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}else {
			tbook.setBookId(bookid);
			tbook.setBookStock(bookadd);
			try {
				if(ibcm.updateBook(tbook)) {
					response.getWriter().print("<script>alert('修改图书数量成功');"
							+ "window.location.href='welcomeM.jsp'</script>");
				}else {
					response.getWriter().print("<script>alert('修改图书数量失败，请重新输入');"
							+ "window.location.href='bookUpdate.jsp'</script>");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}

	private void BookDel(HttpServletRequest request, HttpServletResponse response) {
		String bookid = request.getParameter("bookid");
		TBook tbook = new TBook();
		tbook.setBookId(bookid);
		try {
			if(ibcm.isExsits_book(tbook)) {
				if(ibcm.delBook(tbook)) {
					response.getWriter().print("<script>alert('删除图书成功');"
							+ "window.location.href='welcomeM.jsp'</script>");
				}
			}else {
				response.getWriter().print("<script>alert('该图书不存在');"
						+ "window.location.href='bookDel.jsp'</script>");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	private void BookAdd(HttpServletRequest request, HttpServletResponse response) {
		String bookId = request.getParameter("bookid");
		String bookname = request.getParameter("bookname");
		String booktype = request.getParameter("booktype");
		String bookstock = request.getParameter("bookstock");
		String bookprice = request.getParameter("bookprice");
		TBook tbook = new TBook();
		tbook.setBookId(bookId);
		tbook.setBookName(bookname);
		tbook.setBookPrice(bookprice);
		tbook.setBookType(booktype);
		tbook.setBookStock(bookstock);
		try {
			if(ibcm.isExsits_book(tbook)) {
				response.getWriter().print("<script>alert('图书已存在');"
						+ "window.location.href='bookAdd.jsp'</script>");
			}else {
				if(ibcm.addBook(tbook)) {
					response.getWriter().print("<script>alert('增加图书成功');"
							+ "window.location.href='welcomeM.jsp'</script>");
				}else {
					response.getWriter().print("<script>alert('增加图书失败，请重新输入');"
							+ "window.location.href='bookAdd.jsp'</script>");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void SelBook_name(HttpServletRequest request, HttpServletResponse response) {
		String searchfield = request.getParameter("textfield");
		TBook tbook = new TBook();
		tbook.setBookName(searchfield);
		try {
			if("请输入图书的名字".equals(searchfield)) {
				response.getWriter().print("<script>alert('亲，您还没输入图书的名字哦');"
					+ "window.location.href='selBook_name.jsp'</script>");
			}else {
				if(ibcm.bookNameSel(tbook)!=null) {
					HttpSession session = request.getSession();
					session.setAttribute("selBook_nameinfo", tbook);
					response.sendRedirect("bookMessage3.jsp");
				}else {
					response.getWriter().print("<script>alert('您所查找的图书不存在');"
							+ "window.location.href='selBook_name.jsp'</script>");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void SelBook_type(HttpServletRequest request, HttpServletResponse response) {
		String searchfield = request.getParameter("textfield");
		TBook tbook = new TBook();
		tbook.setBookType(searchfield);
		try {
			if("请输入图书的类型".equals(searchfield)) {
				response.getWriter().print("<script>alert('亲，您还没输入图书的类型哦');"
					+ "window.location.href='selBook_type.jsp'</script>");
			}else {
				if(ibcm.bookTypeSel(tbook)!=null) {
					HttpSession session = request.getSession();
					session.setAttribute("selBook_typeinfo", tbook);
					response.sendRedirect("bookMessage2.jsp");
				}else {
					response.getWriter().print("<script>alert('您所查找的图书不存在');"
							+ "window.location.href='selBook_type.jsp'</script>");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void Update(HttpServletRequest request, HttpServletResponse response) {
		String oldpwd = request.getParameter("oldpwd");
		String newpwd = request.getParameter("newpwd");
		HttpSession session = request.getSession();
		TUser tuser = (TUser) session.getAttribute("userinfo");
		try {
			if(!oldpwd.equals(tuser.getUserPassword())) {
				response.getWriter().print("<script>alert('原密码不正确，请重新输入');"
						+ "window.location.href='updatePwd.jsp'</script>");
			}else {
				tuser.setUserPassword(newpwd);
				if(ibcm.userUpdatePwd(tuser)) {
					response.getWriter().print("<script>alert('修改成功，请重新登录');"
							+ "window.location.href='login.jsp'</script>");
				}else {
					response.getWriter().print("<script>alert('修改失败，请重新输入');"
							+ "window.location.href='updatePwd.jsp'</script>");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void Register(HttpServletRequest request, HttpServletResponse response) {
		String userAccount = request.getParameter("useraccount");
		String userPwd = request.getParameter("userpassword");
		String userPhone = request.getParameter("phone");
		String userAddress = request.getParameter("address");
		TUser tuser = new TUser();
		tuser.setUserAccount(userAccount);
		tuser.setUserPassword(userPwd);
		tuser.setUserPhone(userPhone);
		tuser.setUserAddress(userAddress);
		try {
			if(ibcm.isExsits_user(tuser)) {
				response.getWriter().print("<script>alert('用户已存在');"
						+ "window.location.href='register.jsp'</script>");
			}else {
				if(ibcm.userRegister(tuser)) {
					response.getWriter().print("<script>alert('注册成功');"
							+ "window.location.href='login.jsp'</script>");
				}else {
					response.getWriter().print("<script>alert('注册失败');"
							+ "window.location.href='register.jsp'</script>");
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void Login(HttpServletRequest request, HttpServletResponse response) {
		String userAccount = request.getParameter("useraccount");
		String userPassword = request.getParameter("userpassword");
		TUser tuser = new TUser();
		tuser.setUserAccount(userAccount);
		tuser.setUserPassword(userPassword);
		try {
			if(ibcm.userVaild(tuser)) {
				System.out.println("普通用户登录成功");
				HttpSession session = request.getSession();
				session.setAttribute("userinfo",tuser);
				response.sendRedirect("welcomeC.jsp");
			}else {
				response.getWriter().print("<script>alert('登录失败');"
						+ "window.location.href='login.jsp'</script>");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
