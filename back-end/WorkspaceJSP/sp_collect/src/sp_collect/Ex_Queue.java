package sp_collect;

import java.util.LinkedList;
import java.util.Queue;

public class Ex_Queue {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();  // FIFO
		// 큐는 인터페이스
		
		queue.offer("가길동");
		System.out.println(queue.peek());
		queue.offer("나길동");
		System.out.println(queue.peek());
		queue.offer("다길동");
		System.out.println(queue.peek());
		queue.offer("라길동");
		System.out.println(queue.peek());
		
		System.out.println("-------------------");
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}

	}

}
