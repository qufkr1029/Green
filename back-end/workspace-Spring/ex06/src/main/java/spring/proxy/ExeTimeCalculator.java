package spring.proxy;

import spring.calc.Calculator;

public class ExeTimeCalculator implements Calculator{

	private Calculator calc;
	
	public ExeTimeCalculator(Calculator calc) {
		this.calc = calc;
	}
	
	
	@Override
	public long factorial(long num) {
		long start = System.nanoTime();
		//---------------------------------------
		// 각 클래스의(Calculator를 구현받은 객체) 핵심 기능
		long result = calc.factorial(num);
		//---------------------------------------
		long end = System.nanoTime();
		System.out.printf("factorial(%d)의 실행시간 : %d \n",num,(end-start));
		return result;
	}
	
}
