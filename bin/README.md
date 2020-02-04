# 실습 진행 가이드

# 선제과정 : Spring Boot 개념 학습
 - 기본적인 Spring Framework 개념과 Spring Annotation, Maven 설정(pom.xml 참조) 등을 Wrap-Up 합니다.
 - Spring Boot 는 최대한 자동화된 설정을 활용하여 빠르게 개발하기 위한 일종의 starting tool입니다.
 - 스스로 학습하기 버거운 경우 도움을 요청하세요.
 
# 첫 번째 Mission
 - 프로젝트를 pull 한 후 Maven 관련 오류를 해결합니다. 
 - DemoApplication 클래스의 main 메소드를 실행하면 Spring Boot 어플리케이션이 기동합니다.
 - 기동이 실패하면 로그를 확인해보고 적절한 조치를 취해서 성공적으로 어플리케이션을 구동하고 console에 "Hello Spring Boot!" 로그를 남겨보세요
 - (Hint) Spring Boot Data JDBC 가 maven dependency에 있으면 자동으로 DB 연결을 구성합니다.
 - (Hint) 적절한 DB 연결설정을 하거나 DB 자동연결설정을 해제해도 무방합니다.
 - (Hint) DB 연결을 구성한다면 MySQL같은 본격적인 DBMS를 설치할 필요 없습니다. 가급적 H2 를 사용하도록 합니다.
 - (Hint) application.yml 파일에 미리 약속되어 있는 형태로 설정값들을 기술하면 Spring Boot Application 기동 시 읽어서 사용합니다. 