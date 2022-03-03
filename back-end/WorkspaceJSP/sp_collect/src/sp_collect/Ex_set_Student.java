package sp_collect;

import java.util.HashSet;
import java.util.Set;

public class Ex_set_Student {

	public static void main(String[] args) {
		
		Set<Student> stuSet = new HashSet<>();
		
		stuSet.add(new Student(25,"홍길동"));
		stuSet.add(new Student(25,"임꺽정"));
		stuSet.add(new Student(35,"임꺽정"));
		
		System.out.println("학생 수 : " + stuSet.size());

	}

}
