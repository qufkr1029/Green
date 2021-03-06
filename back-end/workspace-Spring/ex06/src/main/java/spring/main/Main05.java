package spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.calc.Calculator;
import spring.config.JavaConfig;

public class Main05 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(JavaConfig.class);
		
		Calculator impeCalc = ctx.getBean("impeCalc",Calculator.class);
		long tenFactorial1 = impeCalc.factorial(10);
		System.out.println("impeCalc.factorial(10) = " + tenFactorial1);
		
		
		Calculator recleCalc = ctx.getBean("receCalc",Calculator.class);
		long tenFactorial2 = recleCalc.factorial(10);
		System.out.println("recleCalc.factorial(10) = " + tenFactorial1);

	}
}
