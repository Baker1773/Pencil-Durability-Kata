import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PencilTest {
	@Test
	public void PencilRetainsLeadDurabilityAndLeadDurabilityIs5() {
		Pencil pencil = new Pencil(5, 5);
		assertEquals(5, pencil.GetDurability());
	}

	@Test
	public void PencilRetainsLeadDurabilityAndLeadDurabilityIs20() {
		Pencil pencil = new Pencil(20, 5);
		assertEquals(20, pencil.GetDurability());
	}

	@Test
	public void PencilLeadDurabilityIsLostAfterWritingTheLetterA() {

		Pencil pencil = new Pencil(20, 5);
		assertEquals(20, pencil.GetDurability());

		Paper paper = new Paper();
		pencil.Write("A", paper);

		assertEquals(18, pencil.GetDurability());

	}

	@Test
	public void PencilLeadDurabilityIsLostAfterWritingTheWordApple() {

		Pencil pencil = new Pencil(20, 5);
		assertEquals(20, pencil.GetDurability());

		Paper paper = new Paper();
		pencil.Write("Apple", paper);

		assertEquals(14, pencil.GetDurability());

	}

	@Test
	public void PencilLeadDurabilityIsLostAfterWritingTheWordAppleWillInsuffientDurability() {

		Pencil pencil = new Pencil(5, 5);
		assertEquals(5, pencil.GetDurability());

		Paper paper = new Paper();
		pencil.Write("Apple", paper);

		assertEquals(0, pencil.GetDurability());

	}

	@Test
	public void SharpenPencilToRegainLostDurability() {

		Pencil pencil = new Pencil(20, 5);
		assertEquals(20, pencil.GetDurability());

		Paper paper = new Paper();
		pencil.Write("Apple", paper);

		assertEquals(14, pencil.GetDurability());

		pencil.Sharpen();

		assertEquals(20, pencil.GetDurability());
	}

	@Test
	public void SharpeningPencilShortensPencil() {

		Pencil pencil = new Pencil(20, 5);

		assertEquals(5, pencil.GetLength());

		pencil.Sharpen();

		assertEquals(4, pencil.GetLength());
	}

	@Test
	public void PaperGetsAppleWrittenOnIt() {
		Pencil pencil = new Pencil(20, 5);

		Paper paper = new Paper();
		pencil.Write("Apple", paper);

		assertEquals("Apple", paper.GetText());

	}

	@Test
	public void PaperGetsOnionWrittenOnIt() {
		Pencil pencil = new Pencil(20, 5);

		Paper paper = new Paper();
		pencil.Write("Onion", paper);

		assertEquals("Onion", paper.GetText());

	}

	@Test
	public void PaperGetsSentenceWrittenOnIt() {
		Pencil pencil = new Pencil(20, 5);

		Paper paper = new Paper();
		pencil.Write("This is a sentence", paper);

		assertEquals("This is a sentence", paper.GetText());

	}

	@Test
	public void PaperGetsSentenceWithNewLineWrittenOnIt() {
		Pencil pencil = new Pencil(20, 5);

		Paper paper = new Paper();
		pencil.Write("This is a sentence\n", paper);

		assertEquals("This is a sentence\n", paper.GetText());

	}

	@Test
	public void InsufficientLeadAttemptsTextButWritesTex() {
		Pencil pencil = new Pencil(4, 5);

		Paper paper = new Paper();
		pencil.Write("Text", paper);

		assertEquals("Tex ", paper.GetText());

	}

	@Test
	public void ErasePartOfASentence() {
		Pencil pencil = new Pencil(20, 5);

		Paper paper = new Paper();
		pencil.Write("This is a sentence", paper);
		pencil.Erase("enc", paper);

		assertEquals("This is a sent   e", paper.GetText());
	}

	@Test
	public void ErasePartOfASentenceThenEraseAnotherPartOfASentence() {
		Pencil pencil = new Pencil(20, 5);

		Paper paper = new Paper();
		pencil.Write("This is a sentence", paper);
		pencil.Erase("enc", paper);
		pencil.Erase("sen", paper);
		assertEquals("This is a    t   e", paper.GetText());
	}

	@Test
	public void PaperGetsTheNumber1WrittenOnIt() {
		Pencil pencil = new Pencil(20, 5);

		Paper paper = new Paper();
		pencil.Write("One 1", paper);

		assertEquals("One 1", paper.GetText());
	}

	@Test
	public void WritingNumbersUsesLeadDurability() {
		Pencil pencil = new Pencil(20, 5);

		Paper paper = new Paper();
		pencil.Write("One 1", paper);

		assertEquals(14, pencil.GetDurability());
	}

	@Test
	public void AttemptToWriteANumberWithInsufficientLead() {
		Pencil pencil = new Pencil(4, 5);

		Paper paper = new Paper();
		pencil.Write("One 1", paper);
		assertEquals("One  ", paper.GetText());
	}

	@Test
	public void LeadDurabilityWillNotGoBelow0WhenWritingNumbers() {
		Pencil pencil = new Pencil(4, 5);

		Paper paper = new Paper();
		pencil.Write("123", paper);
		assertEquals(0, pencil.GetDurability());
	}

	@Test
	public void PaperGetsQuestionMarkWrittenOnIt() {
		Pencil pencil = new Pencil(20, 5);

		Paper paper = new Paper();
		pencil.Write("Question ?", paper);

		assertEquals("Question ?", paper.GetText());
	}

	@Test
	public void WritingQuestionMarkUsesLeadDurability() {
		Pencil pencil = new Pencil(20, 5);

		Paper paper = new Paper();
		pencil.Write("Question ?", paper);

		assertEquals(9, pencil.GetDurability());
	}

	@Test
	public void CannotWriteQuestionMarkWithInsufficientLead() {
		Pencil pencil = new Pencil(10, 5);

		Paper paper = new Paper();
		pencil.Write("Question ?", paper);

		assertEquals("Question  ", paper.GetText());
	}

	@Test
	public void PencilCanWriteTab() {
		Pencil pencil = new Pencil(10, 5);

		Paper paper = new Paper();
		pencil.Write("Tab\tTab", paper);

		assertEquals("Tab\tTab", paper.GetText());
	}

	@Test
	public void WritingATabDoesNotUseLeadDurability() {
		Pencil pencil = new Pencil(10, 5);

		Paper paper = new Paper();
		pencil.Write("Tab\tTab", paper);

		assertEquals(2, pencil.GetDurability());
	}
}