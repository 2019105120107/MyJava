package cn.lhz.jsj.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.lhz.jsj.helper.DBHelper;
import cn.lhz.jsj.javabean.TAdmin;
import cn.lhz.jsj.javabean.TBook;
import cn.lhz.jsj.javabean.TUser;

public class IBookCityMImpl implements IBookCityM {

	@Override
	public boolean userVaild(TUser tuser) {
		boolean isExist=false;
		DBHelper db = new DBHelper();
		if(db.createConn()) {
			String sql = "select * from t_user where userAccount='"+tuser.getUserAccount()+"' and userPassword='"+tuser.getUserPassword()+"'";
			db.query(sql);
			if(db.next()) {
				isExist = true;
			}
			
			db.closeRs();
			db.closeStmt();
			db.closeConn();
		}
		return isExist;	
	}
		

	@Override
	public boolean adminVaild(TAdmin tadmin) {
		boolean isExist=false;
		DBHelper db = new DBHelper();
		if(db.createConn()) {
			String sql = "select * from t_admin where adAccount='"+tadmin.getAdAccount()+"' and adPassword='"+tadmin.getAdPassword()+"'";
			db.query(sql);
			if(db.next()) {
				isExist = true;
				System.out.println("管理员登录成功");
			}
			db.closeRs();
			db.closeStmt();
			db.closeConn();
		}
		return isExist;	
	}

	@Override
	public boolean userRegister(TUser tuser) {
		boolean isExist=false;
		DBHelper db =new DBHelper();
		if(db.createConn()) {
			String sql="insert into t_user values('"+tuser.getUserAccount()+"','"+tuser.getUserPassword()+"','"+tuser.getUserPhone()+"','"+tuser.getUserAddress()+"')";
			System.out.println("***********");
			if(db.update(sql)) {
				isExist=true;
			}
			db.closeRs();
			db.closeStmt();
			db.closeConn();
		}
		return isExist;
	}

	@Override
	public boolean userUpdatePwd(TUser tuser) {
		boolean isExist=false;
		DBHelper db = new DBHelper();
		if(db.createConn()) {
			String sql = "update t_user set userPassword='"+tuser.getUserPassword()+"' where userAccount='"+tuser.getUserAccount()+"'";
			if(db.update(sql)) {
				isExist = true;
			}
			db.closeRs();
			db.closeStmt();
			db.closeConn();
		}
		return isExist;
	}

	@Override
	public List<TBook> bookTypeSel(TBook tbook) {
		List<TBook> booklist = new ArrayList<TBook>();
		DBHelper db = new DBHelper();
		if(db.createConn()) {
			try {
				String sql="select * from t_book where bookType='"+tbook.getBookType()+"'";
				db.query(sql);
				while(db.next()) {
					tbook = new TBook();
					tbook.setBookId(db.getRs().getString("bookId"));
					tbook.setBookName(db.getRs().getString("bookName"));
					tbook.setBookType(db.getRs().getString("bookType"));
					tbook.setBookStock(db.getRs().getString("bookStock"));
					tbook.setBookPrice(db.getRs().getString("bookPrice"));
					booklist.add(tbook);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			db.closeRs();
			db.closeStmt();
			db.closeConn();
		}	
		return booklist;
			
		}
		

	@Override
	public List<TBook> bookNameSel(TBook tbook) {
		List<TBook> booklist = new ArrayList<TBook>();
		DBHelper db = new DBHelper();
		if(db.createConn()) {
			try {
				String sql="select * from t_book where bookName='"+tbook.getBookName()+"'";
				db.query(sql);
				while(db.next()) {
					tbook = new TBook();
					tbook.setBookId(db.getRs().getString("bookId"));
					tbook.setBookName(db.getRs().getString("bookName"));
					tbook.setBookType(db.getRs().getString("bookType"));
					tbook.setBookStock(db.getRs().getString("bookStock"));
					tbook.setBookPrice(db.getRs().getString("bookPrice"));
					booklist.add(tbook);				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			db.closeRs();
			db.closeStmt();
			db.closeConn();
		}
		return booklist;
			
	}
		
	

	

	@Override
	public boolean addBook(TBook tbook) {
		boolean isExist=false;
		DBHelper db =new DBHelper();
		if(db.createConn()) {
			String sql="insert into t_book values('"+tbook.getBookId()+"','"+tbook.getBookName()+"','"+tbook.getBookType()+"','"+tbook.getBookStock()+"','"+tbook.getBookPrice()+"')";
			if(db.update(sql)) {
				isExist=true;
			}
			db.closeRs();
			db.closeStmt();
			db.closeConn();
		}
		return isExist;
	}

	@Override
	public boolean delBook(TBook tbook) {
		boolean isExist = false;
		DBHelper db = new DBHelper();
		if(db.createConn()) {
			String sql="delete from t_book where bookId='"+tbook.getBookId()+"'";
			if(db.update(sql)) {
				isExist = true;
			}
			db.closeRs();
			db.closeStmt();
			db.closeConn();
		}
		return isExist;
	}

	@Override
	public boolean updateBook(TBook tbook) {
		boolean isExist=false;
		DBHelper db = new DBHelper();
		if(db.createConn()) {
			String sql = "update t_book set bookStock='"+tbook.getBookStock()+"' where bookId='"+tbook.getBookId()+"'";
			if(db.update(sql)) {
				isExist = true;
			}
			db.closeRs();
			db.closeStmt();
			db.closeConn();
		}
		return isExist;
	}

	@Override
	public List<TBook> queryBook(TBook tbook) {
		List<TBook> booklist = new ArrayList<TBook>();
		DBHelper db = new DBHelper();
		if(db.createConn()) {
			try {
				String sql="select * from t_book where bookId='"+tbook.getBookId()+"'";
				db.query(sql);
				while(db.next()) {
					tbook = new TBook();
					tbook.setBookId(db.getRs().getString("bookId"));
					tbook.setBookName(db.getRs().getString("bookName"));
					
					tbook.setBookType(db.getRs().getString("bookType"));
					tbook.setBookStock(db.getRs().getString("bookStock"));
					tbook.setBookPrice(db.getRs().getString("bookPrice"));
					booklist.add(tbook);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			db.closeRs();
			db.closeStmt();
			db.closeConn();
		}
		
		return booklist;
	}
		
	

	public boolean isExsits_user(TUser tuser) {
		boolean isExist=false;
		DBHelper db =new DBHelper();
		if(db.createConn()) {
			String sql="select * from t_user where userAccount='"+tuser.getUserAccount()+"'";
			db.query(sql);
			if(db.next()) {
				isExist=true;
			}
			db.closeRs();
			db.closeStmt();
			db.closeConn();
		}
		return isExist;
	}
	

	@Override
	public boolean downData() {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean isExsits_book(TBook tbook) {
		boolean isExist=false;
		DBHelper db =new DBHelper();
		if(db.createConn()) {
			String sql="select * from t_book where bookId='"+tbook.getBookId()+"'";
			db.query(sql);
			if(db.next()) {
				isExist=true;
			}
			db.closeRs();
			db.closeStmt();
			db.closeConn();
		}
		return isExist;
	}


}
