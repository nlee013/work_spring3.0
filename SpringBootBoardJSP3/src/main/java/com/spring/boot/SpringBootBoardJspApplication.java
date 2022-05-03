package com.spring.boot;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/*src/main/java : 패키지와 클래스 파일
src/main/resource 
-static : css/js 파일
-templates : html파일(표준)
-application.properties : 환경설정파일
-pom.xml : Maven 라이브러리 설정파일
*/

@SpringBootApplication
public class SpringBootBoardJspApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBoardJspApplication.class, args);
	}
	

	//이 method를 객체 생성해줘야된다
	@Bean //@Bean->객체 생성
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);//DI 의존성 주입
		
		//하나로 받을 때는 배열로 받을 필요없고 여러개를 나중에 사용하기 때문에 여기서 배열로 만든다
		Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/*.xml");
		
		sessionFactory.setMapperLocations(res);
		
		return sessionFactory.getObject() ;
		//"classpath:mybatis/../*.xml"으로 써도 됌
	}

}
