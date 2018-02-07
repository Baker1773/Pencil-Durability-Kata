public class Pencil {

	int leadDurability;

	public Pencil(int leadDurability) {
		this.leadDurability = leadDurability;
	}

	public int GetDurability() {
		return leadDurability;
	}

	public void Write(String string, Paper paper) {
		leadDurability -= 2;

	}

}
