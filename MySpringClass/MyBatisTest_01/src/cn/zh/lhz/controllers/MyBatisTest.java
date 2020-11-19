package cn.zh.lhz.controllers;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.zh.lhz.pojos.User;

@Controller
public class MyBatisTest {
	@RequestMapping("register")
	public String doReg() {
		return "register";
	}
	@RequestMapping("reg")
	public String regController(@RequestParam("name") String name,
			@RequestParam("sex") String sex,
			@RequestParam("age") String age) {
		Integer iAge = Integer.parseInt(age);
		SqlSession sqlSession = null;
		try {
			//��ȡmybatis-config.xml�ļ�
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			//��ʼ��mybatis������SqlSessionFactory���ʵ��
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			sqlSession = sqlSessionFactory.openSession();
			//����User����
			User user = new User(name,sex,iAge);
			//��������
			sqlSession.insert("cn.zh.lhz.pojos.UserMapper.save",user);
			//�ύ����
			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//�ع�����
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			try {
				//�ر�sqlSession
			if(sqlSession != null) sqlSession.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return "success";
	}
}
