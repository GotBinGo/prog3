import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class ScoreRecordTest {

	@Test
	public void ScoreRecordConstructorTest() {
		String name = "User";
		int score = 4;
		long time = 12321;
		ScoreRecord sr = new ScoreRecord(name, score, time);
		Assert.assertEquals(name, sr.getName());
		Assert.assertEquals(score, sr.getScore());
		Assert.assertEquals(time, sr.getTime());
		
	}
	@Test
	public void ScoreRecordModifyTest() {
		String name = "User";
		int score = 4;
		long time = 12321;
		ScoreRecord sr = new ScoreRecord("Valami", 2, 6);
		sr.setName(name);
		sr.setScore(score);
		sr.setTime(time);
		Assert.assertEquals(name, sr.getName());
		Assert.assertEquals(score, sr.getScore());
		Assert.assertEquals(time, sr.getTime());
	}

}
