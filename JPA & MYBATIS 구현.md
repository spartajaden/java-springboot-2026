#### JPA 프로젝트 구현

1. 프로젝트 생성

- Spring Initializr 이전 내용 동일
- Choose dependencies 선택할 의존성 - [소스](./day05/webboard/build.gradle)
  - Spring Boot DevTools : 개발 필요 툴 기능 포함
  - Lombok : Getter/Setter 자동 만들어주는 라이브러리
  - Spring web : 웹사이트 관련 작업
  - Thymeleaf : HTML 템플릿 엔진
  - Spring Data JPA : DB와 DRM연동 라이브러리
  - H2 Database : 개발동안 사용하는 파일 DB
  - Oracle Driver : 실제 운영할 DB

2. H2 DB 설정

- application.properties.DB설정 추가 - [소스](./day05/webboard/src/main/resources/application.properties)

```groovy
## H2 DB Settings
spring.h2.console.enabled=true
# 콘솔 URL
spring.h2.console.path=/h2-console
# H2 DB 파일 위치
spring.datasource.url=jdbc:h2:./local
# H2 DB 접속용 드라이버
spring.datasource.driver-class-name=org.h2.Driver
# H2 DB 접속계정
spring.datasource.username=sa
spring.datasource.password=12345
```

3. JPA 설정

- Java Persistence API : 자바 관계형 데이터베이스 핸들링 방식 ORM 기술 사용라이브러리
- ORM : 쿼리를 실행하지 않고 DB와 Java간에 데이터 자동 매핑하는 기술

- application.properties JPA 설정 추가 - [소스](./day05/webboard/src/main/resources/application.properties)

```properties
## JPA DB Settings
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
# create 또는 update
spring.jpa.hibernate.ddl-auto=create
# 로그 쿼리 출력
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.show_sql=true
```

4. controller, entity, repository, serivce 폴더(패키지) 생성 - [폴더](./day05/webboard/src/main/java/com/pknu26/webboard/)

5. controller/HomeController.java 작성 - [소스](./day05/webboard/src/main/java/com/pknu26/webboard/controller/HomeController.java)

6. resources/templates/home.html 작성 - [소스](./day05/webboard/src/main/resources/templates/home.html)

7. entity/Board.java 작성 - [소스](./day05/webboard/src/main/java/com/pknu26/webboard/entity/Board.java)

   - 어노테이션 주의할 것
     - JPA 어노테이션
     - Lombok 어노테이션

8. 웹서버 실행 후 /h2-console 확인

![alt text](image-23.png)

9. 테스트는 웹서버 중지상태에서 실행할 것 - [소스](./day05/webboard/src/main/java/com/pknu26/webboard/WebboardApplication.java)

#### MYBATIS 구현 

  - Spring Initializr: Create a Gradle Project...
  - Artifact ID : `kimjava`
  - Choose dependencies
    - Spring Boot DevTools
    - Lombok
    - Spring web
    - Oracle Driver
    - thymeleaf
    - SpringDoc Openai - swagger ui
    - MyBatis Framework
