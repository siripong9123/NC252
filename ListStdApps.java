
public class ListStdApps {
	public static void main(String[] args) {
		Linklist example = new Linklist();
		example.insertFirst("1010", "See", "Calculus I", "B");
		example.insertFirst("1011", "Peach", "Physics I", "C");
		example.insertFirst("1012", "Juk", "English", "A");
		example.insertFirst("1013", "Aun", "Thai", "A");
		example.displayList();
		SubjectLink ant = example.find("1011");
		if (ant != null)
			System.out.println("Found link with ID " + ant.ID);
		else
			System.out.println("Finding Link it's not found");
		SubjectLink Jack = example.delete("1013");

		if (Jack != null)
			System.out.println(Jack.ID + " is Deleted ");

		else
			System.out.println("The  deleted list isn't match with the other");
		System.out.println("------------------------------------------------");

		SubjectLink Hook = example.insertFirst("1014", "Hook", "Calculus II", "B+");
		if (Hook != null)
			System.out.println(Hook.name + " is new student");
		else
			System.out.println("New Student isn't found");
		example.displayList();

	}

}