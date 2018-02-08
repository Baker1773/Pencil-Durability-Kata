public class Pencil {

	int leadDurability;
	int leadDurabilityMax;
	int length;
	int eraserDurability;

	public Pencil(int leadDurability, int length, int eraserDurability) {
		this.leadDurability = leadDurability;
		this.leadDurabilityMax = leadDurability;

		this.length = length;

		this.eraserDurability = eraserDurability;
	}

	public int GetLeadDurability() {
		return leadDurability;
	}

	public int GetEraserDurability() {
		return eraserDurability;
	}

	public void Write(String stringToWrite, Paper paper) {
		for (int index = 0; index < stringToWrite.length(); index++) {
			Character c = stringToWrite.charAt(index);

			if (leadDurability >= 1 && Character.isLowerCase(c)) {
				leadDurability--;
				paper.Write(c.toString());

			}
			// This is assuming numbers and symbols degrade the durability by 2
			// points
			else if (leadDurability >= 2 && !Character.isWhitespace(c)) {
				leadDurability -= 2;
				paper.Write(c.toString());
			} else if (Character.isWhitespace(c))
				paper.Write(c.toString());
			else
				paper.Write(" ");
		}

	}

	public void Sharpen() {
		if (length > 0) {
			leadDurability = leadDurabilityMax;
			length--;
		}
	}

	public int GetLength() {
		return length;
	}

	public void Erase(String stringToErase, Paper paper) {
		String originalPaperText = paper.GetText();
		if (originalPaperText.indexOf(stringToErase) != -1) {
			int indexOfErasedText = originalPaperText
					.lastIndexOf(stringToErase);

			String newBlank = new String();
			for (int counter = 0; counter < stringToErase.length(); counter++) {
				newBlank += ' ';
				eraserDurability--;
			}

			String replacementText = originalPaperText.substring(0,
					indexOfErasedText);
			replacementText += newBlank;
			replacementText += originalPaperText.substring(indexOfErasedText
					+ stringToErase.length());
			paper.SetText(replacementText);
		}
	}

}
