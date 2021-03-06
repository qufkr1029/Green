package spring.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.calc.Calculator;

public class Main04 {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appCtx02.xml");
		
		Calculator impeCalc = ctx.getBean("impeCalc",Calculator.class);
		long tenFactorial1 = impeCalc.factorial(10);
		System.out.println("impeCalc.factorial(10) = " + tenFactorial1);
		
		
		Calculator recleCalc = ctx.getBean("receCalc",Calculator.class);
		long tenFactorial2 = recleCalc.factorial(10);
		System.out.println("recleCalc.factorial(10) = " + tenFactorial1);

	}

}
