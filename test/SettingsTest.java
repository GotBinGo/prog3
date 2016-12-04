import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class SettingsTest {

	@Test
	public void SettingsTest() {
		Settings st = new Settings();
		st.readSettings();
		st.getMaxtime();
		st.setMaxtime(5);
		Assert.assertEquals(5,st.getMaxtime());
	}
	@Test
	public void SettingsSaveTest() {
		Settings st = new Settings();
		st.readSettings();
		st.getMaxtime();
		st.writeSettings();
		
	}
	@Test
	public void SettingsMaxvalrangeTest() {
		Settings st = new Settings();
		st.readSettings();
		assertTrue(3 <= st.getMaxtime() && st.getMaxtime() <= 10);
		
	}

}
