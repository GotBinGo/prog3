import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


public class ToplistTest {

	@Test
	public void ToplistAdditionTest() {
		Toplist t = new Toplist();
		t.readList();
		int size = t.getArray().size();
		t.addRecord(new ScoreRecord("Name",1,213123));
		
		Assert.assertEquals(size+1,t.getArray().size());
	}
	
	@Test
	public void ToplistWriteTest() {
		Toplist t = new Toplist();
		t.readList();
		t.writeList();
	}

}
