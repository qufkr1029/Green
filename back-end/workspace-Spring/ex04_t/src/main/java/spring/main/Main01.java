package spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.config.ConfigPart01;
import spring.config.ConfigPart02;
import spring.config.ConfigPartMain;
import spring.config.JavaMainConfig;
import spring.printer.MemberInfoPrinter;
import spring.service.MemberRegisterService;
import spring.vo.RegisterRequest;

public class Main01 {

	public static void main(String[] args) {
//		ApplicationContext ctx = 
//				new GenericXmlApplicationContext("classpath:appCtx.xml");
//		ApplicationContext ctx =
//				new AnnotationConfigApplicationContext(JavaConfig01.class);
		
		// 두개 이상의 자바 설정 파일을 읽어오는 방법  1. 두개 이상을 동시에 읽어드림 
//		ApplicationContext ctx =
//				new AnnotationConfigApplicationContext(ConfigPart01.class,ConfigPart02.class);
		
		// 두개 이상의 자바 설정 파일을 읽어오는 방법  1. 두개 이상을 하나로 합쳐서 읽어오는 방법 import()
//		ApplicationContext ctx =
//				new AnnotationConfigApplicationContext(ConfigPartMain.class);
		
		// 자바설정과 XML설정을 합쳐는 방법
		// 1. Java와 xml 서로 다른 설정 파일을 하나로 합쳐서 설정 불러오기(Java <=xml)
		//    JavaMainConfig.java    <=  sub-config.xml
//		ApplicationContext ctx =
//				new AnnotationConfigApplicationContext(JavaMainConfig.class);
		
		// 2. Java와 xml 서로 다른 설정 파일을 하나로 합쳐서 설정 불러오기(xml <=Java)
		//    main-config.xml   <=  JavaSubConfig.java
		ApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:main-config.xml");
		
		
		MemberRegisterService regSvc =
				ctx.getBean("memberRegSvc",MemberRegisterService.class);

		MemberInfoPrinter info = 
				ctx.getBean("infoPrinter",MemberInfoPrinter.class);
		
		RegisterRequest regReq = new RegisterRequest();
		regReq.setEmail("hong@naver.com");
		regReq.setName("홍길동");
		regReq.setPassword("1234");
		regReq.setConfirmPassword("1234");
		
		regSvc.regist(regReq); //회원 가입 기능 작동
		
		info.printMemberInfo("hong@naver.com"); //가입된 회원 정보 출력하기

	}

}
