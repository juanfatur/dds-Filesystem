import org.junit.*;


public class FileTests {

	File file;
	Bloque bloqueDefault;
	
	@Before
	public void setUp() {
		file = new FileWithMockSystem("This is a path");
		bloqueDefault = new Bloque();
		byte[] secuenciaBytes = {0,1,2,3,4,5,6,7,8,9,10};
		bloqueDefault.setBytes(secuenciaBytes, 11);
		file.syncWrite(bloqueDefault);
	}
	
	@Test
	public void setupWorks() {
		byte[] bytesRetrieved = bloqueDefault.getBytes();
		Assert.assertEquals(11,bloqueDefault.tamanio());
	}
	
	@Test
	public void syncReadFileBloquec0() {
		Bloque c0 = file.syncRead(4);
		Bloque c1 = file.syncRead(1);
		Bloque c2 = file.syncRead(5);
		Assert.assertEquals(1,c0.getBytes()[1]);
	}
	
	@Test
	public void syncReadFileBloquec1() {
		Bloque c0 = file.syncRead(4);
		Bloque c1 = file.syncRead(1);
		Bloque c2 = file.syncRead(5);
		Assert.assertEquals(4, c1.getBytes()[0]);
	}
	
	@Test
	public void syncReadFileBloquec2() {
		Bloque c0 = file.syncRead(4);
		Bloque c1 = file.syncRead(1);
		Bloque c2 = file.syncRead(5);
		Assert.assertEquals(7, c2.getBytes()[2]);
	}


	
	/*
	@Test
	public void leerArchivoEnteroYEscribirEnOtro() {
		File origen = new FileWithMockSystem("Origen path");
		File destino = new FileWithMockSystem("Destino path");
		
	}
	*/
}
