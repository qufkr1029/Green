package sp_collect;

import java.util.LinkedList;
import java.util.List;

public class Ex_List {

	public static void main(String[] args) {
		//리스트(인터페이스) : 순서있고, 증복허용
		
		// ArrayList :
		
		// LinkedList :

		// List<Integer> names = new ArrayList<>();
		// List<String> names = new ArrayList<>();
		List<String> names = new LinkedList<>();
		
		names.add("박길동"); //0
		names.add("홍길동"); //1
		names.add("김길동"); //2
		names.add("이길동"); //3
		names.add("최길동"); //4
		names.add("고길동"); //5		 
		
		System.out.println("리스트 길이 : " + names.size()); // 배열 names.length
		
		System.out.println("2번째 사람 이름 : "+names.get(1)); // 배열 names[i]
		System.out.println("데이터 조회----------------------------");
		for(int i=0;i<names.size();i++) {
			System.out.println((i)+"번쩨 사람 이름:" + names.get(i));
		}
		System.out.println("데이터 추가3----------------------------");
		names.add(3,"장길동"); 								// 배열 names[3] = "장길동";
		for(int i=0;i<names.size();i++) {
			System.out.println((i)+"번쩨 사람 이름:" + names.get(i));
		}
		System.out.println("데이터변경1----------------------------");
		names.set(1,"임길동");							
		for(int i=0;i<names.size();i++) {
			System.out.println((i)+"번쩨 사람 이름:" + names.get(i));
		}
		System.out.println("데이터제거1----------------------------");
		names.remove(1);								// 배열 names[1]=null;
		for(int i=0;i<names.size();i++) {
			System.out.println((i)+"번쩨 사람 이름:" + names.get(i));
		}
		System.out.println("전체데이터제거----------------------------");
		names.clear();
		for(int i=0;i<names.size();i++) {
			System.out.println((i)+"번쩨 사람 이름:" + names.get(i));
		}
		
		
	}

}
