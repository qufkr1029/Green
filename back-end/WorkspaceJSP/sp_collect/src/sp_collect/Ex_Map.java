package sp_collect;

import java.util.HashMap;
import java.util.Map;

public class Ex_Map {

	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();
		
		map.put("박길동", 86);
		map.put("이길동", 78);
		map.put("홍길동", 98);
		map.put("고길동", 87);
		map.put("박길동", 97);
		map.put("홍길동", 69);
		
		System.out.println("맵의 개수 : " + map.size());
		
		// 특정 데이터의 값을 보고 싶다면
		System.out.println("홍길동의 점수 : " + map.get("홍길동"));
		
		// 특정 데이터를 삭제하고 싶다면 
		map.remove("박길동");
		System.out.println("박길동 삭제후 맵의 개수 : " + map.size());
		
		// 전체 데이터 삭제
		map.clear();
		System.out.println("전체 데이터 삭제후 맵의 개수 : " + map.size());
	}

}
