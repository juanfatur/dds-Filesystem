import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


public class FileTests {

	@Test
	public void syncReadFileBloquec0() {
		File file = new FileWithMockSystem("This is a path");
		Bloque c0 = file.syncRead(4);
		Bloque c1 = file.syncRead(1);
		Bloque c2 = file.syncRead(5);
		Assert.assertEquals(1,c0.getBytes()[1]);
	}
	
	@Test
	public void syncReadFileBloquec1() {
		File file = new FileWithMockSystem("This is a path");
		Bloque c0 = file.syncRead(4);
		Bloque c1 = file.syncRead(1);
		Bloque c2 = file.syncRead(5);
		Assert.assertEquals(4, c1.getBytes()[0]);
	}

}
