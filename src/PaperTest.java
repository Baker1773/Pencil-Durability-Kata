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

	@Test
	public void PaperGetsSentenceWrittenOnIt() {
		Pencil pencil = new Pencil(20, 5);
		assertEquals(20, pencil.GetDurability());

		Paper paper = new Paper();
		pencil.Write("This is a sentence", paper);

		assertEquals("This is a sentence", paper.GetText());

	}

	@Test
	public void PaperGetsSentenceWithNewLineWrittenOnIt() {
		Pencil pencil = new Pencil(20, 5);
		assertEquals(20, pencil.GetDurability());

		Paper paper = new Paper();
		pencil.Write("This is a sentence\n", paper);

		assertEquals("This is a sentence\n", paper.GetText());

	}
}
