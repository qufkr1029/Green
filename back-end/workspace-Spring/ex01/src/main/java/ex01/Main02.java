package ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main02 {

	public static void main(String[] args) {
		// 스프링에서의 객체 사용하는 방법
		// 스프링 컨테이너가 객체를 알아서 만들어서
		// 개발자가 필요한 경우 꺼내서 사용할 수 있다. IoC 제어 역전
		
		// 1. 스프링 빈 설정파일이 어디있는가?? => 읽어 오세요.
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
													// 스프링 XML 설정 파일을 읽어온다.
		// 2. 스프링 컨테이너에 생성된 객체를 얻어온다.
		Greeter gt = ctx.getBean("greeter",Greeter.class);
		
		// 3. 가져온 객체 사용
		//gt.setFormat("%s님 안녕하세요");		스프링 설정 파일에 property가 만들어져 있는 경우 
		String msg = gt.greet("박준범");
		
		System.out.println(msg);
		
	}

}
