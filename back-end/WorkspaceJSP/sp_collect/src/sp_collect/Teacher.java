package sp_collect;

public class Teacher {
	private String name;
	private String subject;
	private String clazz;

	
	public Teacher(String name, String subject) {
		this.name = name;
		this.subject = subject;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	
}
