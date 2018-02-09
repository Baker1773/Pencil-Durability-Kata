import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PaperTest {

	@Test
	public void WhenPaperIsCreatedItIsBlank() {
		Paper paper = new Paper();
		assertEquals("", paper.text);
	}

	@Test
	public void WritingOnPaperRetainsNewText() {
		Paper paper = new Paper();
		paper.Write("Test text");
		assertEquals("Test text", paper.text);
	}

	@Test
	public void WritingTwiceOnAPaperCombinesText() {
		Paper paper = new Paper();
		paper.Write("Test");
		assertEquals("Test", paper.text);
		paper.Write(" text");
		assertEquals("Test text", paper.text);
	}

	@Test
	public void ReplaceWillReassignTextValue() {
		Paper paper = new Paper();
		paper.Write("Test text");
		assertEquals("Test text", paper.text);
		paper.SetText("New text");
		assertEquals("New text", paper.text);
	}

	@Test
	public void GetTextWillReturnTextValue() {
		Paper paper = new Paper();
		paper.Write("Test text");
		assertEquals("Test text", paper.text);
		assertEquals("Test text", paper.GetText());
	}

	@Test
	public void ClearWillResetTextValue() {
		Paper paper = new Paper();
		paper.SetText("This is a test");
		assertEquals("This is a test", paper.text);
		paper.Clear();
		assertEquals("", paper.text);
	}

}
