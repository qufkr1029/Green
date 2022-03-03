package sp_collect;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex_TreeSet {

	public static void main(String[] args) {
		//Set<String> set = new TreeSet<>();  // => (x)
		
		// set 인터페이스가 알고 있는 메서드
		// add(), remove(), clear(), isEmpty()
		// => 크기를 알려주는 메서드는 없다.
		
		TreeSet<String> set = new TreeSet<>();
		// TreeSet 전용 메서드 
		// first(), last(), lower(), higher(), floor(), ceiling()
		
		set.add("박길동");
		set.add("고길동");
		set.add("홍길동");
		set.add("송길동");
		set.add("이길동");
		set.add("최길동");
		
		// 고, 박, (배) 송, (신), 이, 최, 홍     순서로 정렬
		
		System.out.println(set.size());
		System.out.println("첫번째 위치한 이름 : " + set.first());
		System.out.println("마지막 위치한 이름 : " + set.last());
		System.out.println("신길동 이전에 위치한 이름 : " + set.lower("신길동")); // 송길동   <
		System.out.println("신길동 다음에 위치한 이름 : " + set.higher("신길동")); // 이길동  >
		System.out.println("최길동이거나 바로 이전에 위치한 이름 : " + set.floor("최길동")); // <=
		System.out.println("배길동이거나 바로 다음에 위치한 이름 : " + set.ceiling("배길동")); // <=
		System.out.println(set.size());
		
		// 전체 데이터 출력
		Iterator<String> itr = set.iterator();
		
		while(itr.hasNext()) {
			String name = itr.next();
			System.out.println(name);
		}
		

	}

}
