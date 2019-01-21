public class SubjectRecord {
	String ID; // Can't use privated variable in insert() of class trees ?
	String name;
	String unit;
	String grade;
	SubjectRecord leftchild;
	SubjectRecord rightchild;

	public SubjectRecord() {

	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getData(String ID, String name, String unit, String grade) {
		return getData(ID, name, unit, grade);

	}

	public void setData(String ID, String name, String unit, String grade) {
		this.ID = ID;
		this.name = name;
		this.unit = unit;
		this.grade = grade;

	}

	public void displayStudent() {
		System.out.println("Name : " + name);
		System.out.println("ID : " + ID);
		System.out.println("Unit : " + unit);
		System.out.println("Grade : " + grade);

	}

}