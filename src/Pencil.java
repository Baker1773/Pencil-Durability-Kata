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
			int ammountToErase = Math.min(eraserDurability,
					stringToErase.length());
			String newBlank = new String();
			for (int counter = 0; counter < stringToErase.length()
					&& eraserDurability > 0; counter++) {
				newBlank += ' ';
				eraserDurability--;
			}
			int indexOfLastLetterErased = indexOfErasedText
					+ stringToErase.length() - newBlank.length();
			String replacementText = originalPaperText.substring(0,
					indexOfLastLetterErased);
			replacementText += newBlank;
			replacementText += originalPaperText.substring(indexOfErasedText
					+ stringToErase.length());
			paper.SetText(replacementText);
		}
	}

	// This is assuming it will write into the left most viable white space
	public void Edit(String newEdit, Paper paper) {
		if (paper.GetText().indexOf("   ") != -1) {
			/**
			 * int indexOfSpace = paper.GetText().indexOf("   ") + 1; String
			 * replacementText = new String();
			 * 
			 * int replacementIndex = 0;
			 * 
			 * for (int index = 0; index < paper.GetText().length(); index++) {
			 * if (index >= indexOfSpace && index < indexOfSpace +
			 * newEdit.length()) { if
			 * (Character.isWhitespace(paper.GetText().charAt(index))) { if
			 * (Character.isLowerCase(newEdit .charAt(replacementIndex)))
			 * leadDurability--; // 1 durability is used for lower // case
			 * letters else if (!Character.isWhitespace(newEdit
			 * .charAt(replacementIndex))) leadDurability -= 2; // 2 durability
			 * is used for // upper case letters, // numbers, and symbols
			 * replacementText += newEdit.charAt(replacementIndex); } else if
			 * (!Character.isWhitespace(newEdit .charAt(replacementIndex))) { if
			 * (Character.isLowerCase(newEdit .charAt(replacementIndex)))
			 * leadDurability--; // 1 durability is used for lower // case
			 * letters else if (!Character.isWhitespace(newEdit
			 * .charAt(replacementIndex))) leadDurability -= 2; // 2 durability
			 * is used for // upper case letters, // numbers, and symbols
			 * replacementText += "@"; } else replacementText +=
			 * paper.GetText().charAt(index); replacementIndex++; } else
			 * replacementText += paper.GetText().charAt(index); }
			 * 
			 * for (; replacementIndex < newEdit.length(); replacementIndex++)
			 * replacementText += newEdit.charAt(replacementIndex);
			 **/

			String oldPaperText = paper.GetText();
			paper.Clear();
			int indexOfSpace = oldPaperText.indexOf("   ") + 1;
			int replacementIndex = 0;

			for (int index = 0; index < oldPaperText.length(); index++) {
				if (index >= indexOfSpace
						&& index < indexOfSpace + newEdit.length()) {
					if (Character.isWhitespace(oldPaperText.charAt(index))) {
						Write(newEdit.charAt(replacementIndex) + "", paper);
					} else if (!Character.isWhitespace(newEdit
							.charAt(replacementIndex))) {
						String nextChar = newEdit.charAt(replacementIndex) + "";
						Write(nextChar, paper);
						String collisionText = paper.GetText().substring(0,
								paper.GetText().length() - 1)
								+ "@";
						paper.SetText(collisionText);

					} else
						paper.Write(oldPaperText.charAt(index) + "");
					replacementIndex++;
				} else
					paper.Write(oldPaperText.charAt(index) + "");
			}

			for (; replacementIndex < newEdit.length(); replacementIndex++)
				paper.Write(newEdit.charAt(replacementIndex) + "");
		}
	}

}
