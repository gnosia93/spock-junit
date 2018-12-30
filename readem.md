

## appliction.yml ##

어플리케이션 프로퍼터 yml 설정 파일에 아래와 같이 h2 데이터 베이스의 설정 정보를 추가한다. 


```
spring:
  datasource:
    driver-class-name: org.h2.Driver
    url: jdbc:h2:mem:localhost;DB_CLOSE_ON_EXIT=FALSE
    username: admin
    password:
```

## POM ##

h2 메모리 DBMS 를 이용하여 JPA 를 테스트 한다. 

이때 Maven POM 에 h2 의존 관계 설정시 scope 설정시 아래와 같이 주석 처리한다.

spock 을 구동하기 위해서 spock-core, groovy-all 의존 관계를 아래와 같이 추가하고, 

gmavenplus-plugin 플러그인 을 등록한다. 


```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.1.1.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>io.startup.spockjunit</groupId>
	<artifactId>spockjunit</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>spock-junit</name>
	<description>Demo project for Spring Boot</description>

	<properties>
		<java.version>1.8</java.version>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.h2database/h2 -->
		<dependency>
		    <groupId>com.h2database</groupId>
		    <artifactId>h2</artifactId>
		</dependency>
		
		
		<!--  spock test configuration  -->
		<dependency>
    		<groupId>org.spockframework</groupId>
		    <artifactId>spock-core</artifactId>
		    <version>1.0-groovy-2.4</version>
		    <scope>test</scope>
		</dependency>
		<dependency>
		    <groupId>org.codehaus.groovy</groupId>
		    <artifactId>groovy-all</artifactId>
		    <version>2.4.7</version>
		    <scope>test</scope>
		</dependency>
		<!--  spock test configuration  -->
		
		
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
			
			<!--  spock test configuration  -->
			<plugin>
			    <groupId>org.codehaus.gmavenplus</groupId>
			    <artifactId>gmavenplus-plugin</artifactId>
			    <version>1.5</version>
			    <executions>
			        <execution>
			            <goals>
			                <goal>compile</goal>
			                <goal>testCompile</goal>
			            </goals>
			        </execution>
			     </executions>
			</plugin>
			<!--  spock test configuration  -->
			
		</plugins>
	</build>
</project>


```

