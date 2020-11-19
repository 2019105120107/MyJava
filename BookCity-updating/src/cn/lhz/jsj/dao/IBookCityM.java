package cn.lhz.jsj.dao;

import java.util.List;

import cn.lhz.jsj.javabean.TAdmin;
import cn.lhz.jsj.javabean.TBook;
import cn.lhz.jsj.javabean.TUser;

public interface IBookCityM {
	//�˿��û���¼��֤
	public boolean userVaild(TUser tuser);
	//����Ա��¼��֤
	public boolean adminVaild(TAdmin tadmin);
	//�˿��û�ע����֤
	public boolean userRegister(TUser tuser);
	//�����ж��û��Ƿ���ڵ��߼�
	public boolean isExsits_user(TUser tuser);
	public boolean isExsits_book(TBook tbook);
	//�˿��û��޸�����
	public boolean userUpdatePwd(TUser tuser);
	//����������Ͳ���ͼ��
	public List<TBook> bookTypeSel(TBook tbook);
	//������������ͼ��
	public List<TBook> bookNameSel(TBook tbook);
	//����Ա��ͼ�������
	public boolean addBook(TBook tbook);
	//����Ա��ͼ���ɾ��
	public boolean delBook(TBook tbook);
	//����Ա��ͼ����޸�
	public boolean updateBook(TBook tbook);
	//����Ա��ͼ��Ĳ�ѯ
	public List<TBook> queryBook(TBook tbook);
	//���۹���������������
	public boolean downData();
	
}
