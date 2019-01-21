public class Trees {
	private SubjectRecord root;

	public SubjectRecord find(String key) {
		SubjectRecord current = root;
		while (current.getID() != key) {
			if (key.compareTo(current.getID()) < 0)//ใช้เปรียบเทียบ ค่าน้อยกว่าหรือมากกว่า น้อยซ้าย มากไปขวา
				current = current.leftchild;
			else
				current = current.rightchild;
			if (current == null)
				return null;
		}
		return current;
	}
	public void insert(String id, String name1, String unit1, String grade1) {
		SubjectRecord newSubjectRecord = new SubjectRecord(); // make new node
		newSubjectRecord.ID = id; // insert data
		newSubjectRecord.name = name1;
		newSubjectRecord.unit = unit1;
		newSubjectRecord.grade = grade1;
		if (root == null) // no node in root
			root = newSubjectRecord;
		else { // root occupied
			SubjectRecord current = root; // start at root
			SubjectRecord parent;
			while (true) { // (exits internally)
				parent = current;
				if (id.compareTo(current.getID()) < 0) { // go left?
					current = current.leftchild;
					if (current == null) { // if end of the line,insert on left
						parent.leftchild = newSubjectRecord;
						return;
					}//เหมือนลิ้งลิส แต่ tree ต้องมีโหนดซ้ายและขวาเราจะใช้ compareto เปรียบเทียบค่าระหว่าง string กับ string มีค่าน้อยกว่าหรือมากกว่า 0
				} // end if go left
				else {
					current = current.rightchild;
					if (current == null) { // if end of the line
						parent.rightchild = newSubjectRecord; // insert on right
						return;
					}
				} // end else go right
			} // end while
		} // end else not root
		System.out.println("Name : " + name1);
		System.out.println("ID : " + id);
		System.out.println("Unit : " + unit1);
		System.out.println("Grade : " + grade1);
	}// end insert()

	public void inOrder(SubjectRecord localRoot) {
		;
		if (localRoot != null) {
			inOrder(localRoot.leftchild);

			System.out.println("================================");
			System.out.println("Name :" + localRoot.name);
			System.out.println("ID " + localRoot.ID);
			System.out.println("Unit " + localRoot.unit);
			System.out.println("Grade " + localRoot.grade);
			System.out.println("================================");
			inOrder(localRoot.rightchild);
		}
	}

	public SubjectRecord minimum() {
		SubjectRecord current, last = null;
		current = root;
		while (current != null) {
			last = current;
			current = current.leftchild;
		}
		return last; // mistake if last
	}

	private SubjectRecord getSuccessor(SubjectRecord delNode) {
		SubjectRecord successorParent = delNode;
		SubjectRecord successor = delNode;
		SubjectRecord current = delNode.rightchild;
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftchild;
		}
		if (successor != delNode.leftchild) {
			successorParent.leftchild = successor.rightchild;
			successor.rightchild = delNode.rightchild;
		}
		return successor;

	}

	public boolean delete(String key) {// delete node with given key
										// (assumes non-empty list
		SubjectRecord current = root;
		SubjectRecord parent = root;
		boolean isLeftChild = true;

		while (current.getID() != key) {// search for node
			parent = current;
			if (key.compareTo(current.ID) > 0 || key.compareTo(current.ID) > 0) {// go left?
				isLeftChild = true;
				current = current.leftchild;
			} else {// or go right?
				isLeftChild = false;
				current = current.rightchild;
			}
			if (current == null) // end of the line
				return false; // didn't find it
		} // end while
			// found node to delete
			// continues
			// delete() continued
			// if no children, simply delete it
		if (current.leftchild == null && current.rightchild == null) {
			if (current == root) // if root,
				root = null; // tree is empty
			else if (isLeftChild)
				parent.leftchild = null; // disconnect
			else // disconnect from parent
				parent.rightchild = null;

		}
		// continues
		// delete() continued
		// if no right child, replace with left subtree
		else if (current.rightchild == null)
			if (current == root)
				root = current.leftchild;
			else if (isLeftChild)
				parent.rightchild = current.rightchild;
			else
				parent.rightchild = current.rightchild;
		else if (current.leftchild == null)
			if (current == root)
				root = current.rightchild;
			else if (isLeftChild)
				parent.leftchild = current.rightchild;
			else
				parent.rightchild = current.rightchild;
		// continues
		// delete() continued
		else {// two children , so replace with inorder successor
			SubjectRecord successor = getSuccessor(current); // connect parent of current to successor instead
			if (current == root)
				root = successor;
			else if (isLeftChild)
				parent.leftchild = successor;
			else {
				parent.rightchild = successor; // connect successor to current's left child
				successor.leftchild = current.leftchild;

			} // end else two children
				// (successor cannot have a left child)
		}
		return true;
	}

	public SubjectRecord getRoot() {
		return root;
	}

	public void displayTree() {
		System.out.println("Student Trees:  ");
		SubjectRecord current = root;
		while (current != null) {
			current.displayStudent();
			current = current.leftchild;
			System.out.println(current);
			current = current.rightchild;
			System.out.println(current);
		}
		System.out.println("------------------------------------------------");
	}

}