package sp_collect;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Ex_Iterator {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		set.add("가길동");
		set.add("나길동");
		set.add("다길동");
		set.add("라길동");
		set.add("마길동");
		
		Iterator<String> setItr = set.iterator();
		while(setItr.hasNext()) {
			System.out.println(setItr.next().toString());
		}
		System.out.println("-----------------");
		
		List<String> list = new ArrayList<>(); // 반복자를 사용할 수 있다.
		
		list.add("가길동");
		list.add("나길동");
		list.add("다길동");
		list.add("라길동");
		list.add("마길동");
		
		Iterator<String> listItr = list.iterator();
		
		while(listItr.hasNext()) {
			System.out.println(listItr.next().toString());
		}
		System.out.println("-----------------");
		String[] names = new String[] {"가길동","나길동","다길동","라길동","마길동"};
		
		// 반복자를 활용한 기능 => 향상된 for문
		for(String name:names) {
			System.out.println(name);
		}
		System.out.println("-----------------");
		System.out.println("향상된 for문 = set");
		for(String name:set) {
			System.out.println(name);
		}
		System.out.println("-----------------");
		System.out.println("향상된 for문 = list");
		for(String name:list) {
			System.out.println(name);
		}
	}

}
