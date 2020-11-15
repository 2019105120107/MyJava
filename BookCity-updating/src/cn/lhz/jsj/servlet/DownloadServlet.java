package cn.lhz.jsj.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=utf-8");
	     //��ȡ�ļ���
	     String filename = request.getParameter("filename");
	     //�ļ����ڵ��ļ���
	     String folder="/download/";
	     //֪ͨ����������صķ�ʽ��
	     response.addHeader("Content-Type","application/octet-stream");
	     response.addHeader("Content-Disposition","attachment;filename="+filename);
	     //ͨ���ļ���������ȡ�ļ�
	     InputStream in=getServletContext().getResourceAsStream(folder+filename);
	     OutputStream out=response.getOutputStream();
	     byte[] bytes=new byte[1024];
	     int len=0;
	     while ((len=in.read(bytes))!=-1){
	         out.write(bytes,0,len);
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
