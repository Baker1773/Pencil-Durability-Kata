import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PaperTest {
	@Test
	public void PaperGetsAppleWrittenOnIt() {
		Pencil pencil = new Pencil(20, 5);
		assertEquals(20, pencil.GetDurability());

		Paper paper = new Paper();
		pencil.Write("Apple", paper);

		assertEquals("Apple", paper.GetText());

	}

	@Test
	public void PaperGetsOnionWrittenOnIt() {
		Pencil pencil = new Pencil(20, 5);
		assertEquals(20, pencil.GetDurability());

		Paper paper = new Paper();
		pencil.Write("Onion", paper);

		assertEquals("Onion", paper.GetText());

	}
}
