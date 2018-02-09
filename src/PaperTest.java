import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PaperTest {

	Paper paper;

	@Before
	public void setUp() {
		paper = new Paper();
	}

	@Test
	public void WhenPaperIsCreatedItIsBlank() {
		Paper paper = new Paper();
		assertEquals("", paper.text);
	}

	@Test
	public void WritingOnPaperRetainsNewText() {
		paper.Write("Test text");
		assertEquals("Test text", paper.text);
	}

	@Test
	public void WritingTwiceOnAPaperCombinesText() {
		paper.Write("Test");
		assertEquals("Test", paper.text);
		paper.Write(" text");
		assertEquals("Test text", paper.text);
	}

	@Test
	public void ReplaceWillReassignTextValue() {
		paper.Write("Test text");
		assertEquals("Test text", paper.text);
		paper.SetText("New text");
		assertEquals("New text", paper.text);
	}

	@Test
	public void GetTextWillReturnTextValue() {
		paper.Write("Test text");
		assertEquals("Test text", paper.text);
		assertEquals("Test text", paper.GetText());
	}

	@Test
	public void ClearWillResetTextValue() {
		paper.SetText("This is a test");
		assertEquals("This is a test", paper.text);
		paper.Clear();
		assertEquals("", paper.text);
	}

}
