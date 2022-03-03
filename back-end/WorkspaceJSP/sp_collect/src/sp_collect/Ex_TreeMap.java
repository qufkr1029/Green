package sp_collect;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Ex_TreeMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<Integer, String> map = new TreeMap<>();
		
		map.put(5, "고길동");
		map.put(8, "신길동");
		map.put(4, "배길동");
		map.put(2, "이길동");
		map.put(7, "김길동");
		map.put(1, "홍길동");
		
		// 키에 해당하는 번호를 기준으로 정렬
		// TreeMap 전용 메서드
		
		System.out.println("첫번째 번호 : "+ map.firstEntry().getKey() 
				+", 이름 : "+map.firstEntry().getValue());
		
		System.out.println("마지막 번호 : "+ map.lastEntry().getKey() 
				+", 이름 : "+map.lastEntry().getValue());
		
		System.out.println("6번 이전 번호 : "+ map.lowerEntry(6).getKey() 
				+", 이름 : "+map.lowerEntry(6).getValue());
		
		System.out.println("6번 이후 번호 : "+ map.higherEntry(6).getKey() 
				+", 이름 : "+map.higherEntry(6).getValue());
		
		System.out.println("7번이거나 이전 번호 : "+ map.floorEntry(7).getKey() 
				+", 이름 : "+map.floorEntry(7).getValue());
		
		System.out.println("3번이거나 이후 번호 : "+ map.ceilingEntry(3).getKey() 
				+", 이름 : "+map.ceilingEntry(3).getValue());
		
		// 전체 데이터 출력
		// 1. keySet
		Set<Integer> keySet = map.keySet();
		
		Iterator<Integer> keyItr = keySet.iterator();
		
		while(keyItr.hasNext()) {
			int key = keyItr.next();
			String value = map.get(key);
			
			System.out.println(key+":"+value);
		}
		
		// 2. entrySet
		Set<Map.Entry<Integer,String>> entrySet = map.entrySet();
		
		Iterator<Map.Entry<Integer,String>> entryItr = entrySet.iterator();
		
		while(entryItr.hasNext()) {
			Map.Entry<Integer,String> entry = entryItr.next();
			System.out.println("번호:"+entry.getKey()+", 이름:"+entry.getValue());
		}
	}

}
