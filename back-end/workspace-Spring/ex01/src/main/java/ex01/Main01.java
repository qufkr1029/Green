package ex01;

public class Main01 {

	public static void main(String[] args) {
		// 기존 자바 코드 => 객체(인스턴스) 사용하는 방법
		Greeter gt = new Greeter();  // 객체 생성
		
		gt.setFormat("%s님 안녕하세요"); // 변수명.함수(매개변수) format에 %s님 안녕하세요 저장
		String msg = gt.greet("홍길동"); // 위처럼 함수가 실행됨
		
		System.out.println(msg);
		
	}

}
