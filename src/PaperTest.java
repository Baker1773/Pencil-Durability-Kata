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

}
