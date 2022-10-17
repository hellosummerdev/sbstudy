package com.sbstudy.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 *  웹 어플리케이션이 실행됨과 동시에 연동할 데이터베이스와의 연결을 미리 설정하고,
 *  필요할 때마다 미리 연결해 놓은 상태를 이용해 빠르게 데이터베이스와 연동하여 작동.
 *  미리 데이터베이스와 연결시킨 상태를 유지하는 기술을 커넥션 풀(CP)라고 함.
 *
 *  자바에서는 기본적으로 DataSource 인터페이스를 사용하여 커넥션풀을 관리
 *
 *  Spring에서는 사용자가 직접 커넥션을 관리할 필요없이 자동화된 기법들을 제공
 *  SpringBoot2.0 이후부터는 HikariCP를 기본 옵션으로 채택
 */

@Configuration
public class DatabaseConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }


    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }

    /**
     * SqlSession를 생성하기 위해 SqlSessionFactory를 사용
     * SqlSessionFactory는 데이터베이스와의 연결과 SQL의 실행에 대한 모든 것을 가진 가장 중요한 객체
     *
     * SqlSessionFactory를 생성해주는 특별한 객체를 먼저 설정해주어야하는데,
     * 이때 스프링-마이바티스에서는 SqlSessionFactoryBean이라는 클래스를 사용
     * SqlSessionFactory에서 mapper 파일 로드, mybatis-config 로드
     * (**은 하위 폴더를 모두 뜻하고, *.xml은 xml 파일 전체를 뜻함)
     */

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{ //sql 세션을 만드는 공장
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setTypeAliasesPackage("com.sbstudy");
        sessionFactory.setMapperLocations(resolver.getResources("classpath:mybatis/mapper/**/**.xml"));    //mapper 파일 로드
        sessionFactory.setConfigLocation(resolver.getResource("classpath:mybatis/mybatis-config.xml"));         //mybatis-config 로드
        return sessionFactory.getObject();
    }

    /**
     * SqlSessionTemplate은 마이바티스 스프링 연동모듈의 핵심
     * SqlSessionTemplate 역할은 SqlSession을 구현하고 코드에서 SqlSession를 대체
     *
     * SqlSessionTemplate 은 쓰레드에 안전하고 여러개의 DAO나 매퍼에서 공유할수 있음
     *
     * getMapper()에 의해 리턴된 매퍼가 가진 메서드를 포함해서 SQL을 처리하는 마이바티스 메서드를 호출할때
     * SqlSessionTemplate은 SqlSession이 현재의 스프링 트랜잭션에서 사용될수 있도록 보장
     *
     * SqlSessionTemplate은 필요한 시점에 세션을 닫고, 커밋하거나 롤백하는 것을 포함한 세션의 생명주기를 관리
     * 마이바티스 예외를 스프링의 DataAccessException로 변환하는 작업도 처리
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception{
        final SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }
}
