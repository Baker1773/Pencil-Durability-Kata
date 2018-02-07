public class Pencil {

	int leadDurability;

	public Pencil(int leadDurability) {
		this.leadDurability = leadDurability;
	}

	public int GetDurability() {
		return leadDurability;
	}

	public void Write(String stringToWrite, Paper paper) {
		for (int index = 0; index < stringToWrite.length(); index++) {
			char c = stringToWrite.charAt(index);
			if (Character.isLowerCase(c))
				leadDurability--;
			else if (Character.isUpperCase(c))
				leadDurability -= 2;
		}

	}

}
