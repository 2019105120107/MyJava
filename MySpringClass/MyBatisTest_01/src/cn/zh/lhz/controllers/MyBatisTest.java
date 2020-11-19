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
			//读取mybatis-config.xml文件
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			//初始化mybatis，创建SqlSessionFactory类的实例
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			sqlSession = sqlSessionFactory.openSession();
			//创建User对象
			User user = new User(name,sex,iAge);
			//插入数据
			sqlSession.insert("cn.zh.lhz.pojos.UserMapper.save",user);
			//提交事务
			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//回滚事务
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			try {
				//关闭sqlSession
			if(sqlSession != null) sqlSession.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return "success";
	}
}
