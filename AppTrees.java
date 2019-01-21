public class AppTrees {
	public static void main(String args[]) {
		Trees example = new Trees();
		example.insert("1010", "R", "Mathmetics", "A");
		example.insert("1011", "E", "Mathmetics", "C+");
		example.insert("1012", "A", "Mathmetics", "B+");
		example.inOrder(example.getRoot());
	}

}