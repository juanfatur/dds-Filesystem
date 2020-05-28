import org.junit.*;
import java.util.*;


public class FileTests {

	File file;
	Bloque bloqueDefault;
	Bloque c0;
	Bloque c1;
	Bloque c2;
	
	@Before
	public void setUp() {
		file = new FileWithMockSystem("This is a path");
		bloqueDefault = new Bloque();
		byte[] secuenciaBytes = {0,1,2,3,4,5,6,7,8,9,10};
		bloqueDefault.setBytes(secuenciaBytes, 11);
		file.syncWrite(bloqueDefault);
		c0 = file.syncRead(4);
		c1 = file.syncRead(1);
		c2 = file.syncRead(5);
	}
	
	
	@Test
	public void syncReadFileBloquec0() {
		Assert.assertEquals(1,c0.getBytes()[1]);
	}
	
	@Test
	public void syncReadFileBloquec1() {
		Assert.assertEquals(4, c1.getBytes()[0]);
	}
	
	@Test
	public void syncReadFileBloquec2() {
		Assert.assertEquals(7, c2.getBytes()[2]);
	}
	
	@Test
	public void asyncReadFileBloquec2() {
		Bloque c3 = file.asyncRead(1);
		Assert.assertEquals(10, c3.getBytes()[0]);
	}
	
	@Test
	public void escribirBloquesEnArchivo() {
		File nuevoArchivo = new FileWithMockSystem("Path archivo nuevo");
		nuevoArchivo.syncWrite(c0);
		Bloque nuevoBloque = new Bloque();
		byte[] nuevosBytes = {0x0,0x10,0x0};
		nuevoBloque.setBytes(nuevosBytes, 3);
		nuevoArchivo.syncWrite(nuevoBloque);
		nuevoArchivo.syncWrite(c1);
		nuevoArchivo.syncWrite(c2);
		byte[] bytesLeidos = nuevoArchivo.syncRead(13).getBytes();
		byte[] bytesEsperados = {0,1,2,3,0x0,0x10,0x0,4,5,6,7,8,9};
		Assert.assertArrayEquals(bytesEsperados, bytesLeidos);
		
	}

	

	@Test
	public void unBloqueDe14ElementosSeDivideEn3() {
		byte[] secuenciaContenido = {0x0,0x1,0x2,0x3,0x4,0x5,0x6,0x7,0x8,0x9,0x10,0x0,0x2,0x0};
		Bloque bloqueOriginal = new Bloque();
		bloqueOriginal.setBytes(secuenciaContenido, secuenciaContenido.length);
		List<Bloque> listaParticiones = bloqueOriginal.dividirEnBloques(5);
		byte[] bytesEsperados = {0x10,0x0,0x2,0x0};
		Assert.assertArrayEquals(bytesEsperados, listaParticiones.get(2).getBytes());
	}
	
//	@Test
//	public void leerArchivoEnteroYEscribirEnOtro() {
//		File origen = new FileWithMockSystem("Origen path");
//		Bloque contenidoOrigen = new Bloque();
//		byte[] secuenciaContenido = {0x0,0x1,0x2,0x3,0x4,0x5,0x6,0x7,0x8,0x9,0x10,0x0,0x2,0x0,0x1,0x4};
//		contenidoOrigen.setBytes(secuenciaContenido, secuenciaContenido.length);
//		origen.syncWrite(contenidoOrigen);
//		
//		File destino = new FileWithMockSystem("Destino path");
//		
//		contenidoOrigen = origen.syncRead(secuenciaContenido.length);
//		
//		
//
//		
//	}
	
}
