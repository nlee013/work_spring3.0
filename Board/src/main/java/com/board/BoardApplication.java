package com.board;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@SpringBootApplication
public class BoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}
	
	//�� method�� ��ü ��������ߵȴ�
			@Bean //@Bean->��ü ����
			public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
				
				SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
				sessionFactory.setDataSource(dataSource);//DI ������ ����
				
				//�ϳ��� ���� ���� �迭�� ���� �ʿ���� �������� ���߿� ����ϱ� ������ ���⼭ �迭�� �����
				Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/**/*.xml");
				
				sessionFactory.setMapperLocations(res);
				
				return sessionFactory.getObject() ;
				//"classpath:mybatis/../*.xml"���� �ᵵ ��
			}

}
