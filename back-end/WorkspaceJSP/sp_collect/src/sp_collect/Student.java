package sp_collect;

public class Student {
	private int stuCode;
	private String name;
	private int[] jumsu;
	private int rank;
	private Teacher homeroomTeacher;
	
	


	public Student(int stuCode, String name, Teacher homeroomTeacher) { // 생성자
		this.stuCode = stuCode;
		this.name = name;
		this.homeroomTeacher = homeroomTeacher;
	}
	
	public Student(int stuCode, String name) { //생성자
		this.stuCode = stuCode;
		this.name = name;
	}	
	
	public Teacher getHomeroomTeacher() {
		return homeroomTeacher;
	}
	public void setHomeroomTeacher(Teacher homeroomTeacher) {
		this.homeroomTeacher = homeroomTeacher;
	}
	
	public int getStuCode() {
		return stuCode;
	}
	public void setStuCode(int stuCode) {
		this.stuCode = stuCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getJumsu() {
		return jumsu;
	}
	public void setJumsu(int[] jumsu) {
		this.jumsu = jumsu;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}

	
	
	
	// 학생 인스턴스가 같은지 다른지 정해주는 기준!
	// 1. hashCode();   학번이 같은 학생은 동일한 학생이다.
	// 2. equals();
	@Override
	public int hashCode() {
		return this.stuCode;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) { //입력받은 객체가 학생 객체인지 판단
			Student student = (Student)obj;
			return (student.getStuCode() == this.stuCode) //학번만 같으면 같은 학생으로 취급함
					&& student.getName().equals(this.name);
			// 힉번과 학생 이름이 일치해야만 같은 학생으로 판단하겠다.
		}else {
			return false;
		}
	}
}











































