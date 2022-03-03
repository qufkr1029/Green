package sp_collect;

import java.util.Stack;

public class Ex_Stack {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();  // FILO
		
		stack.push("노길동");
		System.out.println(stack.peek());
		stack.push("김길동");
		System.out.println(stack.peek());
		stack.push("홍길동");
		System.out.println(stack.peek());
		stack.push("로길동");
		System.out.println(stack.peek());
		
		System.out.println("---------------");
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
