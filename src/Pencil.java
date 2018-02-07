public class Pencil {

	int leadDurability;
	int leadDurabilityMax;

	public Pencil(int leadDurability) {
		this.leadDurability = leadDurability;
		this.leadDurabilityMax = leadDurability;
	}

	public int GetDurability() {
		return leadDurability;
	}

	public void Write(String stringToWrite, Paper paper) {
		for (int index = 0; index < stringToWrite.length(); index++) {
			char c = stringToWrite.charAt(index);
			if (leadDurability >= 1 && Character.isLowerCase(c))
				leadDurability--;
			else if (leadDurability >= 2 && Character.isUpperCase(c))
				leadDurability -= 2;
		}

	}

	public void Sharpen() {
		leadDurability = leadDurabilityMax;
	}

}
