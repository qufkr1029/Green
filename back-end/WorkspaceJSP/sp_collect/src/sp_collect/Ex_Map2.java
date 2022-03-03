package sp_collect;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Ex_Map2 {

	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();
		
		map.put("박길동", 86);
		map.put("이길동", 78);
		map.put("홍길동", 98);
		map.put("고길동", 87);
		map.put("김길동", 97);
		map.put("최길동", 69);
		
		// 전체 데이터를 조회하는 법 = 없다!!
		// 					=> Set으로 변환한 후 Set의 방법으로 전체 데이터 조회
		
		// 1. Key만 꺼내서 Set으로 변환
		System.out.println("Key만 꺼내서 Set으로 변환");
		Set<String> keySet = map.keySet();
		
		Iterator<String> keyItr = keySet.iterator();
		
		while(keyItr.hasNext()) {
			String key = keyItr.next();
			int value = map.get(key);
			
			System.out.println(key + " : " + value);
		}	
			
		// 2. Entry를 통째로 꺼내서 Set으로 변환
		System.out.println("Entry를 통째로 꺼내서 Set으로 변환");
		
		//엔트리[키:값] => 타입 : Map.Entry<String, Integer>
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		
		Iterator<Map.Entry<String, Integer>> entryItr = entrySet.iterator();
		
		while(entryItr.hasNext()) {
			Map.Entry<String, Integer> entry = entryItr.next();
			
			String key = entry.getKey();
			int value = entry.getValue();
			
			System.out.println(key + " : " + value);
		}

	}

}
