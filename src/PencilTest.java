import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PencilTest {
	@Test
	public void PencilRetainsLeadDurabilityAndLeadDurabilityIs5() {
		Pencil pencil = new Pencil(5);
		assertEquals(5, pencil.GetDurability());
	}

	@Test
	public void PencilRetainsLeadDurabilityAndLeadDurabilityIs20() {
		Pencil pencil = new Pencil(20);
		assertEquals(20, pencil.GetDurability());
	}

	@Test
	public void PencilLeadDurabilityIsLostAfterWrittingTheLetterA() {

		Pencil pencil = new Pencil(20);
		assertEquals(20, pencil.GetDurability());

		Paper paper = new Paper();
		pencil.Write("A", paper);

		assertEquals(18, pencil.GetDurability());

	}

	@Test
	public void PencilLeadDurabilityIsLostAfterWrittingTheWordApple() {

		Pencil pencil = new Pencil(20);
		assertEquals(20, pencil.GetDurability());

		Paper paper = new Paper();
		pencil.Write("Apple", paper);

		assertEquals(14, pencil.GetDurability());

	}
}
