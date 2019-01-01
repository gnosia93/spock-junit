## 이클립스 Groovy 설정하기 ##

이클립스 마켓에서 아래의 플러그인을 다운 받아서 설치한다. 

 1) spock

 2) groovy develepement tools



spy() 를 사용할 경우 cglib가 필요한데, 

nodep 버전인 2.2 버전을 의존 관계로 추가하여야 한다. 

```
<!-- dependency>
    <groupId>cglib</groupId>
    <artifactId>cglib</artifactId>
    <version>3.2.9</version>
</dependency -->
<!-- https://mvnrepository.com/artifact/cglib/cglib-nodep -->
<dependency>
    <groupId>cglib</groupId>
    <artifactId>cglib-nodep</artifactId>
    <version>2.2</version>
</dependency>
```





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

spock 을 구동하기 위해서 spock-core, groovy-all 의존 관계가 필요하며, gmavenplus-plugin 플러그인 역시 . 


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


## Spock Junit 테스트 클래스 생성 ##

STS 프로젝트에서 New -> Other -> Groovy -> Groovy Test Case 를 선택하고, New JUnit Jupiter Test (JUnit 5) 를 선택한 후,

테스트 클래스를 만들어 주되, Specification 클래스를 상속 받도록 한다. 

이렇게 생성된 groovy 파일은 /src/test/java 디렉토리 밑에 생성된다. 별도로 groovy 용으로 디렉토리를 만들어 줄 

필요는 없는 듯 하다. 

또한 이클립스에서 단축시 Ctrl + X + T 를 사용하는 경우 테스트 할 수 있다. 



Spock addresses this problem with blocks. Blocks are a Spock native way of breaking up the phases of our test using labels. They give us labels for given when then and more:

Setup (Aliased by Given) – Here we perform any setup needed before a test is run. This is an implicit block, with code not in any block at all becoming part of it
When – This is where we provide a stimulus to what is under test. In other words, where we invoke our method under test
Then – This is where the assertions belong. In Spock, these are evaluated as plain boolean assertions, which will be covered later
Expect – This is a way of performing our stimulus and assertion within the same block. Depending on what we find more expressive, we may or may not choose to use this block
Cleanup – Here we tear down any test dependency resources which would otherwise be left behind. For example, we might want to remove any files from the file system or remove test data written to a database


```
package io.startup.spockjunit

import static org.junit.jupiter.api.Assertions.*
import spock.lang.Specification

class FirstTest extends Specification {

	def "one plus one should equal two" () {
		expect:
		1 + 1 == 2
		
	}
	

}

```

## JUNIT ##
https://github.com/gnosia93/spock-junit/blob/master/junit.md


## 레퍼런스 ##

### Spock ### 
https://www.baeldung.com/groovy-spock

https://thejavatar.com/testing-with-spock/

https://code.google.com/archive/p/spock/

### Groovy ###
http://groovy-lang.org/index.html

