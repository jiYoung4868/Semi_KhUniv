package kh.semi.khuniv.common.mybatis;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisTemplate {
	public static SqlSession getSqlSession() {
		// String resource = "mybatis/mybatis-config.xml";
		SqlSession session = null;
		try {
			SqlSessionFactory factory = new SqlSessionFactoryBuilder()
					.build(Resources.getResourceAsStream("mybatis-config.xml"));
			session = factory.openSession(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}

}
