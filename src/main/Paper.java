package main;
public class Paper {

	String text;

	public Paper() {
		text = new String();
	}

	public String GetText() {
		return text;
	}

	public void Write(String newText) {
		text += newText;
	}

	public void SetText(String replacementText) {
		text = replacementText;
	}

	public void Clear() {
		text = new String();
	}

}
