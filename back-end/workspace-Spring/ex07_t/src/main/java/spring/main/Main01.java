package spring.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.printer.MemberListPrinter;


public class Main01 {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appCTX.xml");

		MemberListPrinter prt = ctx.getBean("listPrinter",MemberListPrinter.class);
		
		prt.printAll();
	}

}
