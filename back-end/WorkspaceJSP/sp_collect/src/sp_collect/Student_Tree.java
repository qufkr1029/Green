package sp_collect;

public class Student_Tree{// implements Comparable<Student_Tree>{
	private String name;
	private int rank;
	
	public Student_Tree(String name, int rank) {
		this.name = name;
		this.rank = rank;
	};
	
	public int getRank() {
		return rank;
	}

	public void prt() {
		System.out.println(name+"학생 성적은 "+rank+"등");
	}

//	@Override   // 나.compareTo(너)
//	public int compareTo(Student_Tree st) {// 비교기준
//		// 나보다 크면 양수, 내가 작으면 음수, 같으면 0
//		if(this.rank > st.rank) {
//			return 100;
//		}else if(this.rank < st.rank) {
//			return -2000;
//		}else {
//			return 0;
//		}
//	
//	}
	
	
}
