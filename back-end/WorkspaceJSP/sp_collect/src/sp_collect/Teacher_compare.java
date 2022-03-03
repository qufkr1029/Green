package sp_collect;

import java.util.Comparator;

public class Teacher_compare implements Comparator<Student_Tree>{

	@Override // 앞이 더 크다면 양수, 뒤가 더 크다면 음수, 둘이 같다면 0
	public int compare(Student_Tree st1, Student_Tree st2) {
		if(st1.getRank() > st2.getRank()) {
			return 2;
		}else if(st1.getRank() < st2.getRank()) {
			return -2;
		}else {
			return 0;
		}
	}
	
}