import static org.junit.Assert.*;

import org.junit.Assert;

public class QuestionTest {

	@org.junit.Test
	public void ConstructorQuestionTest() {
		String qes = "q";
		Question q = new Question(qes,"a","b","c");
		Assert.assertEquals(qes, q.question);
	}

	@org.junit.Test
	public void ConstructorAnswer1Test() {
		String a = "a";
		Question q = new Question("ques", a, "b", "c");
		Assert.assertEquals(a, q.getAnswer(0));
	}
	
	@org.junit.Test
	public void ConstructorAnswer2Test() {
		String b = "b";
		Question q = new Question("ques", "a", b, "c");
		Assert.assertEquals(b, q.getAnswer(1));
	}
	@org.junit.Test
	public void ConstructorAnswer3Test() {
		String c = "c";
		Question q = new Question("ques", "a", "b", c);
		Assert.assertEquals(c, q.getAnswer(2));
	}
	
	
}
