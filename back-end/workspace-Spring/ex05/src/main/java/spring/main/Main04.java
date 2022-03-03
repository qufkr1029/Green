package spring.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.bean.Client3;

public class Main04 {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:appCtx.xml");
		// 스프링 설정파일을 읽어와서
		// 	스프링 컨테이너 초기화
		// 		빈 객체 생성 => 빈 객체간의 의존 주입 => 빈 객체 초기화
		
		// 사용할 빈 객체를 불러와야 함
		Client3 client3_1 = ctx.getBean("client3",Client3.class);
		Client3 client3_2 = ctx.getBean("client3",Client3.class);
		// 프로토타입으로 설정해두엇 이전의 객체와 이후의 객체는 다르게 생성된다.
		System.out.println("(client3_1 == client3_2) => "+(client3_1 == client3_2));
	}

}
