public class Linklist {
	private SubjectLink first; // ref to first link on list
	// -----------------------------------------------------
	public Linklist() { // constructor
		first = null; // no links on list yet

	}
	// --------------------------------------------------------
	public SubjectLink insertFirst(String id, String name1, String unit1, String grade1) { // make new link
		SubjectLink newSubjectLink = new SubjectLink(id, name1, unit1, grade1);
		newSubjectLink.next = first; // it points to old first link
		first = newSubjectLink; // now first points to this
		first.displaySubjectLink();
		return first;
	}
	// ----------------------------------------------------------------
	public SubjectLink find(String key) { // find link with given key and assume non.empty list
		SubjectLink current = first; // start at first
		while (key.compareTo(current.ID) > 0 || key.compareTo(current.ID) < 0) { // while no match
			if (current.next == null)// if end of list
				return null; // didn't find it
			else // not end of list
				current = current.next; // go to next link
		}
		return current;
	}
	// ------------------------------------------------------------------
	public SubjectLink delete(String key) { // delete link with given key and assumes non-empty list
		SubjectLink current = first; // search for link
		SubjectLink previous = first;
		while (key.compareTo(current.ID) > 0 || key.compareTo(current.ID) < 0) {
			if (current.next == null)
				return null; // didn't find it
			else {
				previous = current; // go to next link
				current = current.next;
			}
		} // found it
		if (current == first) // if first link
			first = first.next; // change first
		else // otherwise
			previous.next = current.next; // by pass it
		return current;
	}

	public void displayList() {
		System.out.println("Student List (First to Last):  ");
		SubjectLink current = first;
		while (current != null) {
			current.displaySubjectLink();
			current = current.next;
		}
		System.out.println("------------------------------------------------");
	}

}
