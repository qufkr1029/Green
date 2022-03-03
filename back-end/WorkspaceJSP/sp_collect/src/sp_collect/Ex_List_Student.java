package sp_collect;

import java.util.ArrayList;
import java.util.List;

public class Ex_List_Student {

	public static void main(String[] args) {
		
		Student[] stuList = new Student[100];
		
		stuList[5] = new Student(17,"최서희",new Teacher("파인만","양자물리학"));
		
		// 최서희 학생의 담당선생님이 담당하는 과목은 무엇인가요??
		String subject = stuList[5].getHomeroomTeacher().getSubject();
		// =======================================================================
		List<Student> students = new ArrayList<>();
		// Student 인스턴스를 보여주는 리스트
		students.add(new Student(28,"최치수",new Teacher("뉴턴","뉴턴물리학")));
		
		// 최치수 학생의 담임의 이름은 무엇인가요??
		students.get(0).getHomeroomTeacher().getName();
		
		// 최치수 학생의 담임이 담당하고 있는 과목이 뉴턴 물리학인가요??
		if(students.get(0).getHomeroomTeacher().getSubject().equals("뉴턴물리학")) {
			System.out.println("");
		}
		
		//////////////////////////////////////////////////////////////////////////
		// 리스트 0번째 학생의 이름을 출력하세요
		System.out.println("리스트 0번째 학생의 이름은 : " + students.get(0).getName());
	}

}
