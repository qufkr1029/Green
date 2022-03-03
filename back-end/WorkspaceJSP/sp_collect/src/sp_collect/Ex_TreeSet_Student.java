package sp_collect;

import java.util.Iterator;
import java.util.TreeSet;

public class Ex_TreeSet_Student {

	public static void main(String[] args) {
		//TreeSet<Student_Tree> students = new TreeSet<>();
		
		TreeSet<Student_Tree> students = new TreeSet<>(new Teacher_compare());
		
		students.add(new Student_Tree("배길동",26));
		students.add(new Student_Tree("홍길동",22));
		students.add(new Student_Tree("장길동",17));
		students.add(new Student_Tree("유길동",31));
		students.add(new Student_Tree("소길동",8));
		students.add(new Student_Tree("마길동",42));
		
		Iterator<Student_Tree> itr = students.iterator();
		
		while(itr.hasNext()) {
			itr.next().prt();
		}
		

	}

}
