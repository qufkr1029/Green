package spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.bean.Client2;
import spring.bean.Client3;
import spring.config.JavaConfig;

public class Main05 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(JavaConfig.class);
		
		// 사용할 빈 객체를 불러와야 함
		
		Client3 client3_1 = ctx.getBean("client3",Client3.class);
		Client3 client3_2 = ctx.getBean("client3",Client3.class);
		// 프로토타입으로 설정해두엇 이전의 객체와 이후의 객체는 다르게 생성된다.
		System.out.println("(client3_1 == client3_2) => "+(client3_1 == client3_2));

	}

}
