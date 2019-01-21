public class Vocab {

	public String key, value;

	public String type;

	public Vocab next;

	public Vocab prev;

	Vocab() {

	}

	public Vocab(String key, String value, String type) {

		this.key = key;

		this.value = value;

		this.type = type;

	}

	public void displayVocab() {

		System.out.println(key + "(" + type + ")" + value);

	}

	public String toString() {

		return (key + "(" + type + ")" + value);

	}

}