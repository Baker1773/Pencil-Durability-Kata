public class Pencil {

	int leadDurability;
	int leadDurabilityMax;

	int length;

	public Pencil(int leadDurability, int length) {
		this.leadDurability = leadDurability;
		this.leadDurabilityMax = leadDurability;

		this.length = length;
	}

	public int GetDurability() {
		return leadDurability;
	}

	public void Write(String stringToWrite, Paper paper) {
		for (int index = 0; index < stringToWrite.length(); index++) {
			Character c = stringToWrite.charAt(index);
			if (leadDurability >= 1 && Character.isLowerCase(c)) {
				leadDurability--;
				paper.Write(c.toString());

			} else if (leadDurability >= 2 && Character.isUpperCase(c)) {
				leadDurability -= 2;
				paper.Write(c.toString());
			} else
				paper.Write(" ");
		}

	}

	public void Sharpen() {
		leadDurability = leadDurabilityMax;
		length--;
	}

	public int GetLength() {
		return length;
	}

}
