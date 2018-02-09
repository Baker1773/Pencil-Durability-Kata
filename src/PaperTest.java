import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PaperTest {

	@Test
	public void WhenPaperIsCreatedItIsBlank() {
		Paper paper = new Paper();
		assertEquals("", paper.text);
	}
}
