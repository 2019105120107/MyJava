package cn.lhz.jsj.dao;

import java.util.List;

import cn.lhz.jsj.javabean.TAdmin;
import cn.lhz.jsj.javabean.TBook;
import cn.lhz.jsj.javabean.TUser;

public interface IBookCityM {
	//顾客用户登录验证
	public boolean userVaild(TUser tuser);
	//管理员登录验证
	public boolean adminVaild(TAdmin tadmin);
	//顾客用户注册验证
	public boolean userRegister(TUser tuser);
	//隐含判断用户是否存在的逻辑
	public boolean isExsits_user(TUser tuser);
	public boolean isExsits_book(TBook tbook);
	//顾客用户修改密码
	public boolean userUpdatePwd(TUser tuser);
	//按照书的类型查找图书
	public List<TBook> bookTypeSel(TBook tbook);
	//按照书名查找图书
	public List<TBook> bookNameSel(TBook tbook);
	//管理员对图书的增加
	public boolean addBook(TBook tbook);
	//管理员对图书的删除
	public boolean delBook(TBook tbook);
	//管理员对图书的修改
	public boolean updateBook(TBook tbook);
	//管理员对图书的查询
	public List<TBook> queryBook(TBook tbook);
	//销售管理，下载销售数据
	public boolean downData();
	
}
