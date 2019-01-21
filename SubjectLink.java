public class SubjectLink {
	public String ID;
	public String name;
	public String unit;
	public String grade;
	public SubjectLink next;

	public SubjectLink(String id, String name1, String unit1, String grade1) {
		ID = id;
		name = name1;
		unit = unit1;
		grade = grade1;
	}

	public void displaySubjectLink() {
		System.out.println("ID : " + ID);
		System.out.println("Name : " + name);
		System.out.println("Unit : " + unit);
		System.out.println("Grade : " + grade);
	}

}
